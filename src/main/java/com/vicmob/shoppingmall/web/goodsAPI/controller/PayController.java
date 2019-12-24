package com.vicmob.shoppingmall.web.goodsAPI.controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.wxpay.sdk.WXPayUtil;
import com.vicmob.shoppingmall.constant.RedisLockVO;
import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.*;
import com.vicmob.shoppingmall.web.goods.entity.GoodsDetail;
import com.vicmob.shoppingmall.web.goodsAPI.model.MallOrderVO;
import com.vicmob.shoppingmall.web.goodsAPI.model.PayOrderVO;
import com.vicmob.shoppingmall.web.goodsAPI.service.GoodsCollageService;
import com.vicmob.shoppingmall.web.goodsAPI.service.GoodsOrderService;
import com.vicmob.shoppingmall.web.goodsAPI.service.PersonCenterService;
import com.vicmob.shoppingmall.web.goodsAPI.wxclient.WXMessageClient;
import com.vicmob.shoppingmall.web.goodsAPI.wxclient.WXPayClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.*;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.*;

@RestController
@RequestMapping(value = "minaAPI/onlineShop/pay")
@Slf4j
@Api(value="/minaAPI/onlineShop/pay", tags="订单支付")
public class PayController {

    @Autowired
    private WXPayClient wxPayClient;
    @Autowired
    private GoodsOrderService goodsOrderService;
    @Autowired
    private PersonCenterService personCenterService;
    @Autowired
    private WXMessageClient wxMessageClient;
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private GoodsCollageService goodsCollageService;

    @PostMapping("/prepay")
    @ApiOperation(value = "订单支付", notes = "订单支付", httpMethod = "POST")
    public ResultData prepay(@RequestBody PayOrderVO vo, HttpServletRequest request) {
        if (StringUtils.isEmpty(vo.getOrderNumber())) {
            vo.setOrderNumber(getOrderIdByUUId());
        }
        Integer orderId = vo.getOrderId();
        try {
            RedisLockVO redisLockVO = new RedisLockVO("lock:pay_" + vo.getOrderNumber(), 30, 5);
            redisUtils.getLock(redisLockVO);
            if (!StringUtils.isEmpty(vo.getCollageNo())) {
                Integer n = goodsCollageService.checkCollageEnd(vo.getCollageNo(),vo.getOrderNumber());
                if (n == 1) {
                    return new ResultData("此团已成,请重新发起拼团!", ResponseStatus.FAIL.getValue());
                }
                if (n == 2) {
                    return new ResultData("此团已失效！", ResponseStatus.FAIL.getValue());
                }
            }
            if (orderId == null) {
                List<GoodsDetail> goodsDetailList = goodsOrderService.checkMallGoodsStock(vo);
                if (goodsDetailList != null && !goodsDetailList.isEmpty()) {
                    StringBuffer buf = new StringBuffer();
                    for (GoodsDetail goodsDetail : goodsDetailList) {
                        buf.append("、" + goodsDetail.getGoodsName());
                    }
                    buf.append("库存不足,无法支付");
                    return new ResultData(buf.toString().substring(1), ResponseStatus.FAIL.getValue());
                }
                orderId = goodsOrderService.CreateOrder(vo);
                wxMessageClient.sendMessage(personCenterService.getMallOrderDetail(orderId));
            }else{
                MallOrderVO mallOrderVO = personCenterService.getOrderDetail(vo.getOrderId());
                List<GoodsDetail> list = JSONObject.parseArray(mallOrderVO.getGoodsdetails(),GoodsDetail.class);
                int result = goodsOrderService.checkCollageUsed(list.get(0).getGoodsId(),mallOrderVO.getCustomerid());
                if(result>0){
                    return new ResultData("您已有进行的拼团!", ResponseStatus.FAIL.getValue());
                }
                boolean flag = goodsCollageService.checkCustomerLimit(mallOrderVO.getCollageno(),list.get(0).getGoodsId(),mallOrderVO.getCustomerid(),mallOrderVO.getMinaid(),list.get(0).getNum());
                if(!flag){
                    return new ResultData("已超过限购数,无法再购买!", ResponseStatus.FAIL.getValue());
                }
                Integer n = goodsCollageService.checkCollageEnd(mallOrderVO.getCollageno(),mallOrderVO.getOrdernumber());
                if (n == 1) {
                    return new ResultData("此团已成,请重新发起拼团!", ResponseStatus.FAIL.getValue());
                }
                if (n == 2) {
                    return new ResultData("此团已失效!", ResponseStatus.FAIL.getValue());
                }
            }
            redisUtils.unlock(redisLockVO);
            String ip = IPUtils.getIpAddress(request);
            if (StringUtils.isEmpty(ip)) {
                return new ResultData("ip获取失败", ResponseStatus.FAIL.getValue());
            }
            return wxPayClient.prepay(Integer.valueOf(DecryptUtils.getMinaId(vo.getAppId(), vo.getMinaStr())), orderId, vo.getCustomerId(), ip);
        } catch (Exception e) {
            log.error("订单预支付失败，minaId ==> {},orderId ==> {},customerId ==> {}", Integer.valueOf(DecryptUtils.getMinaId(vo.getAppId(), vo.getMinaStr())), orderId, vo.getCustomerId());
            log.error(e.getMessage(), e);
            return new ResultData("订单预支付失败", ResponseStatus.FAIL.getValue());
        }
    }

    @PostMapping("/payNotify")
    @ApiOperation(value = "支付结果通知,修改订单状态", notes = "支付结果通知,修改订单状态", httpMethod = "POST")
    public void payNotify(HttpServletRequest request, HttpServletResponse response) {
        try {
            InputStream inStream = request.getInputStream();
            ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inStream.read(buffer)) != -1) {
                outSteam.write(buffer, 0, len);
            }
            outSteam.close();
            inStream.close();
            String result = new String(outSteam.toByteArray(), "utf-8");
            Map<String, String> map = WXPayUtil.xmlToMap(result);
            log.info("异步通知：{}", JSON.toJSONString(map));
            ResultData resultData = wxPayClient.notify(map);
            if (resultData.getStatus() == ResponseStatus.SUCCESS.value) {
                Map<String, String> res = new HashMap<>();
                res.put("return_code", "SUCCESS");
                res.put("return_msg", "OK");
                response.getWriter().write(WXPayUtil.mapToXml(res));
            }
        } catch (Exception e) {
            log.error("微信回调失败");
            log.error(e.getMessage(), e);
        }
    }

    private static String getOrderIdByUUId() {
        int first = new Random(10).nextInt(8) + 1;
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {
            hashCodeV = -hashCodeV;
        }
        return first + String.format("%015d", hashCodeV);
    }

}
