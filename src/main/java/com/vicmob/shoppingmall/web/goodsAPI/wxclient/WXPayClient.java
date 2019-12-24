package com.vicmob.shoppingmall.web.goodsAPI.wxclient;

import com.alibaba.fastjson.JSONObject;
import com.github.wxpay.sdk.WXPay;
import com.github.wxpay.sdk.WXPayConstants;
import com.github.wxpay.sdk.WXPayUtil;
import com.vicmob.shoppingmall.constant.Constant;
import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.AesEncrypt;
import com.vicmob.shoppingmall.utils.DeepCopyUtils;
import com.vicmob.shoppingmall.utils.ListToMapUtil;
import com.vicmob.shoppingmall.utils.ResultData;
import com.vicmob.shoppingmall.web.distribution.service.CommissionRecordService;
import com.vicmob.shoppingmall.web.goods.entity.GoodsDetail;
import com.vicmob.shoppingmall.web.goods.entity.Order;
import com.vicmob.shoppingmall.web.goods.service.GoodsService;
import com.vicmob.shoppingmall.web.goods.service.OrderService;
import com.vicmob.shoppingmall.web.goodsAPI.entity.MallGoodsCollage;
import com.vicmob.shoppingmall.web.goodsAPI.model.PayAccount;
import com.vicmob.shoppingmall.web.goodsAPI.model.WXConfig;
import com.vicmob.shoppingmall.web.goodsAPI.service.GoodsCollageService;
import com.vicmob.shoppingmall.web.goodsAPI.service.GoodsOrderService;
import com.vicmob.shoppingmall.web.goodsAPI.service.PayAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WXPayClient {
    private final Logger log = LoggerFactory.getLogger( WXPayClient.class);

    @Value("${wx.pay.notifyUrl}")
    private String notifyUrl;
    @Value("${wx.pay.body}")
    private String body;

    @Value("${wx.pay.useSandBox}")
    private Boolean useSandBox;

    @Autowired
    private OrderService orderService;
    @Autowired
    private WXInfoClient WXInfoClient;
    @Autowired
    private WXMessageClient wxMessageClient;
    @Autowired
    private PayAccountService payAccountService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private CommissionRecordService commissionRecordService;
    @Autowired
    private GoodsCollageService goodsCollageService;

    public ResultData prepay(Integer minaId, Integer orderId, Integer customerId, String ip)throws Exception{
        ResultData result = orderService.getByOrderId(orderId);
        if(result.getData() == null){
            return new ResultData("订单预支付失败", ResponseStatus.FAIL.getValue());
        }
        Order order = (Order)result.getData();
        if (order.getOrderStatus() != Constant.OrderType.ORDER){
            log.error("订单状态为: " + order.getOrderStatus().getName() +" 无法预下单 order ==>{}",order);
            return new ResultData("订单状态为"+order.getOrderStatus().getName()+",无法支付",ResponseStatus.FAIL.getValue());
        }
        if(order.getTotalMoney().compareTo(BigDecimal.ZERO)==0){
            orderService.updatPayedStatus(order.getOrderNumber(),Constant.OrderType.ORDER_PAY);
            String service = order.getGoodsDetails();
            List<GoodsDetail> list = JSONObject.parseArray(service, GoodsDetail.class);
            //更新销量
            Map<Integer, List<GoodsDetail>>  map = ListToMapUtil.toMapServiceDetailByGoodsId(list);
            for(Integer goodsId :map.keySet()){
                Integer num = 0;
                for (GoodsDetail sd : map.get(goodsId)){
                    num += sd.getNum();
                }
                if (goodsService.updateSailed(goodsId,num)!= 1){
                    return new ResultData("更新销量失败",ResponseStatus.FAIL.getValue());
                }
            }
            Map<String,String> params = new HashMap<>();
            params.put("orderId",String.valueOf(orderId));
            Order order1 =(Order) DeepCopyUtils.deepCopyByJson(order);
            order1.setOrderStatus(Constant.OrderType.ORDER_PAY);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date = simpleDateFormat.format(new Date());
            order1.setOrderPayTime(date);
            commissionRecordService.addCommissionRecord(order1);
            return new ResultData("支付金额为零元", ResponseStatus.SUCCESS.getValue(),params);
        }
        BigDecimal money = order.getTotalMoney().add(order.getDeliveryMoney());
        String totalFee = (money.multiply(new BigDecimal("100"))).intValue() + "";
        String openId =  WXInfoClient.getOpenId(minaId,customerId);
        if ( StringUtils.isEmpty(openId)){
            log.error("openId获取失败 order ==>{}" ,order);
            return new ResultData("openId不存在", ResponseStatus.FAIL.getValue());
        }

        WXPay wxpay = getWXPay(minaId,Constant.WXOperation.PREPAY);
        if (wxpay == null){
            return new ResultData("商户信息查找失败", ResponseStatus.FAIL.getValue());
        }

        Map<String, String> data = new HashMap<>();
        data.put("body", body);
        data.put("out_trade_no", order.getOrderNumber());
        data.put("total_fee",totalFee);
        data.put("spbill_create_ip", ip);
        data.put("trade_type", Constant.TRADE_TYPE);
        data.put("openid",openId);
        Map<String, String> response = wxpay.unifiedOrder(data);
        String returnCode = response.get("return_code");
        String resultCode = response.get("result_code");
        if (Constant.FAIL.equals(returnCode)){
            log.error("统一下单接口返回失败,msg ==>{}",response.get("return_msg"));
            return new ResultData("下单失败", ResponseStatus.FAIL.getValue());
        }
        if(Constant.FAIL.equals(resultCode)){
            log.error("统一下单接口返回失败，msg ==>{}",response.get("err_code_des"));
            return new ResultData("下单失败", ResponseStatus.FAIL.getValue());
        }
        String prepayId = response.get("prepay_id");
        if (StringUtils.isEmpty(prepayId)){
            return new ResultData("prepayId为空", ResponseStatus.FAIL.getValue());
        }
        Map<String,String> params = getParams(minaId,prepayId);
        if (params == null){
            return new ResultData("返回参数为空", ResponseStatus.FAIL.getValue());
        }
        params.put("orderId",String.valueOf(orderId));
        return new ResultData("sucess", ResponseStatus.SUCCESS.getValue(),params);

    }

    private Map<String,String> getParams(Integer minaId,String prepayId) throws Exception{
        PayAccount payAccount = payAccountService.getPayAccount(minaId);
        if (payAccount == null || StringUtils.isEmpty(payAccount.getApiKey()) || StringUtils.isEmpty(payAccount.getMchId()) || StringUtils.isEmpty(payAccount.getAppId())){
            log.error("payAccount获取失败或者apikey和mchId不存在, minaId ==>{}" ,minaId);
            return null;
        }
        Map<String,String> params = new HashMap<>();
        params.put("timeStamp", System.currentTimeMillis()/ 1000 + "");
        params.put("nonceStr", WXPayUtil.generateNonceStr());
        params.put("package", "prepay_id=" + prepayId);
        params.put("signType", "HMAC-SHA256");
        params.put("appId", payAccount.getAppId());
        String paySign = WXPayUtil.generateSignature(params, payAccount.getApiKey(), WXPayConstants.SignType.HMACSHA256);
        params.put("paySign", paySign);
        return params;
    }

    public WXPay getWXPay(Integer minaId,Constant.WXOperation operation)throws Exception{
        PayAccount payAccount = payAccountService.getPayAccount(minaId);
        if (payAccount == null || StringUtils.isEmpty(payAccount.getApiKey()) || StringUtils.isEmpty(payAccount.getMchId()) || StringUtils.isEmpty(payAccount.getAppId())){
            log.error("payAccount获取失败或者apikey和mchId不存在, minaId ==>{}" ,minaId);
            return null;
        }
        WXConfig config = null;
        if(operation == Constant.WXOperation.REFUND){
            if (StringUtils.isEmpty(payAccount.getCertificatePath())){
                log.error("证书路径不存在,minaId ==>{}" ,minaId);
                return null;
            }
            config = new WXConfig(payAccount.getCertificatePath());
        }else{
            config = new WXConfig();
        }
        config.setAppID(payAccount.getAppId());
        config.setKey(payAccount.getApiKey());
        config.setMerchID(payAccount.getMchId());
        WXPay wxpay = new WXPay(config,notifyUrl,false,useSandBox);
        return wxpay;
    }

    public ResultData notify(Map<String ,String> map)throws Exception{
        if (Constant.FAIL.equals(map.get("return_code"))) {
            log.error("微信回调通知返回失败，msg ==>{}", map.get("return_msg"));
            return new ResultData("微信回调通知返回失败", ResponseStatus.SUCCESS.getValue());
        }
        String reqInfo = map.get("req_info");
        if (StringUtils.isEmpty(reqInfo)){
            return payNotify(map);
        }else{
            return refundNotify(map);
        }
    }

    public ResultData payNotify (Map<String ,String> map) throws Exception {
        String orderNumber = map.get("out_trade_no");
        ResultData result =  orderService.getByOrderNo(orderNumber);
        if(result.getData() == null){
            log.error("该支付订单不存在 orderNumber==>{}",orderNumber);
            return null;
        }
        Order order = (Order)result.getData();
        log.info("order========{}",order);
        if (StringUtils.isEmpty(order.getMinaId())){
            log.error("minaId 不存在==>{}",orderNumber);
            return null;
        }
        WXPay wxPay = getWXPay(order.getMinaId(),Constant.WXOperation.PAY_QUERY);
        if (wxPay == null ){
            return null;
        }
        WXConfig config  = new WXConfig();
        PayAccount payAccount = payAccountService.getPayAccount(order.getMinaId());
        config.setKey(payAccount.getApiKey());
        if (!WXPayUtil.isSignatureValid(map,config.getKey(),WXPayConstants.SignType.HMACSHA256)){
            return null;
        }
        result = payedOrderQuery(wxPay,orderNumber,order);
        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    public ResultData payedOrderQuery(WXPay wxPay,String orderNumber,Order order) {
        try{
            Map<String, String> data = new HashMap();
            data.put("out_trade_no", orderNumber);
            Map<String, String> resp = wxPay.orderQuery(data);
            if (Constant.FAIL.equals(resp.get("return_code"))){
                log.error("查询微信下单失败 msg==>{}",resp.get("return_msg"));
                return null;
            }
            if (Constant.FAIL.equals(resp.get("result_code"))){
                log.error("查询微信下单失败 msg==>{}",resp.get("err_code_des"));
                return null;
            }
            if(!(Constant.SUCCESS.equals(resp.get("trade_state")))){
                log.error("微信支付失败 tradState ==>{}",resp.get("trade_state"));
            }
            //更新订单状态
            if (order.getOrderStatus() == Constant.OrderType.ORDER){
                if (orderService.updatPayedStatus(orderNumber,Constant.OrderType.ORDER_PAY) != 1){
                    throw new Exception("更新订单状态失败");
                }
                //拼团订单
                if(!StringUtils.isEmpty(order.getCollageNo())){
                    MallGoodsCollage mallGoodsCollage = goodsCollageService.getMallGoodsCollageByNo(order.getCollageNo());
                    goodsCollageService.updateGoodsCollage(mallGoodsCollage,order);
                    goodsCollageService.addCustomerLimit(mallGoodsCollage,order);
                }
                String service = order.getGoodsDetails();
                List<GoodsDetail> list = JSONObject.parseArray(service,GoodsDetail.class);
                //更新销量
                Map<Integer, List<GoodsDetail>>  map = ListToMapUtil.toMapServiceDetailByGoodsId(list);
                for(Integer goodsId :map.keySet()){
                    Integer num = 0;
                    for (GoodsDetail sd : map.get(goodsId)){
                        num += sd.getNum();
                    }
                    if (goodsService.updateSailed(goodsId,num)!= 1){
                        log.error("更新销量失败 goodsId ==>{},num ==>{}",goodsId,num);
                        throw new Exception("更新销量失败");
                    }
                }
                ResultData result =  orderService.getByOrderNo(orderNumber);
                if(result.getData() == null){
                    log.error("该支付订单不存在 orderNumber==>{}",orderNumber);
                    return null;
                }
                wxMessageClient.sendMessage((Order)result.getData());
                order.setOrderStatus(Constant.OrderType.ORDER_PAY);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String date = simpleDateFormat.format(new Date());
                order.setOrderPayTime(date);
                commissionRecordService.addCommissionRecord(order);
            }
            return new ResultData("sucess", ResponseStatus.SUCCESS.getValue());

        }catch (Exception e){
            log.error("微信查询订单失败");
            log.error(e.getMessage(), e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return new ResultData(e.getMessage(), ResponseStatus.FAIL.getValue());
        }
    }


    public ResultData refund(Order order) throws Exception{
        if (order == null){
            return new ResultData("订单为空", ResponseStatus.FAIL.getValue());
        }
        WXPay wxpay = getWXPay(order.getMinaId(), Constant.WXOperation.REFUND);
        if (wxpay == null ){
            return new ResultData("商户信息查找失败", ResponseStatus.FAIL.getValue());
        }
        BigDecimal money = order.getTotalMoney().add(order.getDeliveryMoney());
        String totalFee = (money.multiply(new BigDecimal("100"))).intValue() + "";
        Map<String,String> param = new HashMap<>();
        param.put("out_trade_no",order.getOrderNumber());
        param.put("out_refund_no",order.getOrderNumber());
        param.put("total_fee",totalFee);
        param.put("refund_fee",totalFee);
        Map<String, String> response = wxpay.refund(param);
        String returnCode = response.get("return_code");
        String resultCode = response.get("result_code");
        if (Constant.FAIL.equals( returnCode)){
            log.error("微信退款接口返回失败，msg ==>{}",response.get("return_msg"));
            return new ResultData("退款失败", ResponseStatus.FAIL.getValue());
        }
        if(Constant.FAIL.equals(resultCode)){
            log.error("微信退款接口返回失败，msg ==>{}",response.get("err_code_des"));
            return new ResultData("退款失败", ResponseStatus.WXFAIL.getValue());
        }
        return new ResultData("sucess", ResponseStatus.SUCCESS.getValue());
    }

    public ResultData refundNotify (Map<String ,String> map) {
        ResultData result = null;
        Map<String ,String> response = getRefundResponse(map);
        if (response == null){
           return new ResultData("微信退款回调解析失败", ResponseStatus.FAIL.getValue());
        }
        String refundStatus = response.get("refund_status");
        String orderNumber = response.get("out_trade_no");
        if (Constant.SUCCESS .equals(refundStatus)){
            result = orderService.updatOrderStatus(orderNumber,Constant.OrderType.REFUND_SUCCESS);
        }else{
            result = orderService.updatOrderStatus(orderNumber,Constant.OrderType.REFUND_FAILURE);
        }
        if (result.getStatus() ==  ResponseStatus.FAIL.value){
            return result;
        }
        ResultData result1 =  orderService.getByOrderNo(orderNumber);
        if(result1.getData() == null){
            log.error("订单不存在 orderNumber==>{}",orderNumber);
            return result;
        }
        wxMessageClient.sendMessage((Order)result.getData());
        return result;
    }

    public Map<String ,String> getRefundResponse(Map<String ,String> map){
        try{
            String reqInfo = map.get("req_info");
            String appId = map.get("appid");
            String mchId = map.get("mch_id");
            PayAccount payAccount = payAccountService.getPayAccountByAppId(appId,mchId);
            if (payAccount == null || StringUtils.isEmpty(payAccount.getApiKey())){
                log.error("商户信息不存在，appId ==》{},mchId ==》{}",appId,mchId);
                return null;
            }
            String data = AesEncrypt.decryptData(reqInfo,payAccount.getApiKey());
            return WXPayUtil.xmlToMap(data);
        }catch (Exception e){
           log.error("微信退款回调req_info 解析失败 map ==>{}",map);
           log.error(e.getMessage(),e);
           return null;
        }
    }



}
