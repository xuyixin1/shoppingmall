package com.vicmob.shoppingmall.web.goodsAPI.wxclient;

import com.alibaba.fastjson.JSONObject;
import com.vicmob.shoppingmall.constant.BusinessMessageConstatnt;
import com.vicmob.shoppingmall.constant.Constant;
import com.vicmob.shoppingmall.utils.JacksonUtil;
import com.vicmob.shoppingmall.utils.ListToMapUtil;
import com.vicmob.shoppingmall.utils.RestTemplateUtil;
import com.vicmob.shoppingmall.utils.ResultData;
import com.vicmob.shoppingmall.web.goods.entity.BusinessTemplate;
import com.vicmob.shoppingmall.web.goods.entity.GoodsDetail;
import com.vicmob.shoppingmall.web.goods.entity.Notification;
import com.vicmob.shoppingmall.web.goods.entity.Order;
import com.vicmob.shoppingmall.web.goods.service.BusinessTemplateService;
import com.vicmob.shoppingmall.web.goods.service.NotificationService;
import com.vicmob.shoppingmall.web.goodsAPI.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class BusinessMessageClient {
    private final Logger log = LoggerFactory.getLogger(BusinessMessageClient.class);

    @Autowired
    private NotificationService notificationService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private BusinessTemplateService businessTemplateService;

    @Value("${wx.business.sendMessage.url}")
    private String sendMessageUrl;
    @Autowired
    private WXInfoClient wxInfoClient;

    @Async("taskExecutor")
    public void sendMessage(Order order){
        log.info("order ==>",order);
        BusinessMessage businessMessage = getBussinessMessage(order);
        if (businessMessage == null){
            return;
        }
        String accessToken =  wxInfoClient.getAccessToken();
        if (accessToken == null){
            return ;
        }
        String sendMessageUrl1 = sendMessageUrl + "?access_token=" + accessToken;
        BusinessMessageResponse bms = RestTemplateUtil.postResult(JacksonUtil.objToJson(businessMessage),sendMessageUrl1, BusinessMessageResponse.class, restTemplate);
        if (bms.getErrcode() != 0){
            log.error("调用微信发送接口失败  wxBaseResponse ==>{}", JacksonUtil.objToJson(bms));
            return;
        }
        log.info("sendMessage result ==>{},order ==>{}",JacksonUtil.objToJson(bms),order);
    }

    public List<String> getOpenIds(Integer minaId){
        List<String> openIds = new ArrayList<>();
        ResultData result = notificationService.getNotificationList(minaId);
        List<Notification>  notificationList = (List<Notification>)result.get("data");
        if (notificationList == null ||notificationList.size() == 0){
            log.info("该小程序没有相关通知人,minaId ==> {}",minaId);
            return null;
        }
        for (int i = 0; i < notificationList.size(); i++) {
            openIds.add(notificationList.get(i).getOpenId());
        }
        return openIds;
    }

    private BusinessMessage getBussinessMessage(Order order){
        //默认openId一个
        BusinessMessage businessMessgae = new BusinessMessage();
        List<String> openIds = getOpenIds(order.getMinaId());
        if (openIds == null || openIds.size() == 0){
            return null;
        }
        businessMessgae.setOpenId(openIds.get(0));
        BusinessTemplate template = businessTemplateService.getTemplateByType(Constant.InformType.getEnumInformType(order.getOrderStatus()));
        if (template == null|| StringUtils.isEmpty(template.getInformId())){
            log.error("template获取失败 order ==>{}" ,order);
            return null;
        }
        businessMessgae.setTemplateId(template.getInformId());
        getData(order,businessMessgae);
        return businessMessgae;
    }

    private void getData(Order order,BusinessMessage businessMessage){
        BusinessData data = new BusinessData();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String date = simpleDateFormat.format(new Date());
        List<String> list = new ArrayList<>();
        Keyword first = new Keyword();
        Keyword keyword = null;
        Keyword remark = new Keyword();
        String orderNumber = order.getOrderNumber();
        String status = order.getOrderStatus().getName();
        String payMoney =  order.getTotalMoney().add(order.getDeliveryMoney()).toString() ;
        if (order.getOrderStatus() == Constant.OrderType.ORDER_CANCEL){
            first.setColor(BusinessMessageConstatnt.Msg.ORDER_CANCEL.color);
            first.setValue(BusinessMessageConstatnt.Msg.ORDER_CANCEL.message);
            list.add("用户取消订单");
            list.add(orderNumber);
            list.add(status);
            list.add(date);
        }
        if(order.getOrderStatus() == Constant.OrderType.ORDER){
            first.setColor(BusinessMessageConstatnt.Msg.ORDER.color);
            first.setValue(BusinessMessageConstatnt.Msg.ORDER.message);
            list.add(orderNumber);
            list.add(payMoney);
            list.add(date);
        }
        if (order.getOrderStatus() == Constant.OrderType.ORDER_PAY){
            first.setColor(BusinessMessageConstatnt.Msg.ORDER_PAY.color);
            first.setValue(BusinessMessageConstatnt.Msg.ORDER_PAY.message);
            list.add(orderNumber);
            list.add(getItems(order));
            list.add(payMoney);
            list.add(date);
        }

        if (order.getOrderStatus() == Constant.OrderType.REFUND_APPLY){
            first.setColor(BusinessMessageConstatnt.Msg.REFUND_APPLY.color);
            first.setValue(BusinessMessageConstatnt.Msg.REFUND_APPLY.message);
            list.add(orderNumber);
            list.add(payMoney);
            list.add(order.getRefuseReason());
        }
        if (order.getOrderStatus() == Constant.OrderType.ORDER_FINISH){
            first.setColor(BusinessMessageConstatnt.Msg.ORDER_FINISH.color);
            first.setValue(BusinessMessageConstatnt.Msg.ORDER_FINISH.message);
            list.add(orderNumber);
            list.add(date);
        }

        remark.setColor(BusinessMessageConstatnt.COMMON_COLOR);
        remark.setValue(BusinessMessageConstatnt.REMARK);

        for (int i=0 ;i<list.size();i++){
            keyword = new Keyword();
            keyword.setColor(BusinessMessageConstatnt.COMMON_COLOR);
            if (i == 0 ){
                keyword.setValue(list.get(i));
                data.setKeyword1(keyword);
            }
            if (i == 1 ){
                keyword.setValue(list.get(i));
                data.setKeyword2(keyword);
            } if (i == 2 ){
                keyword.setValue(list.get(i));
                data.setKeyword3(keyword);
            } if (i == 3) {
                keyword.setValue(list.get(i));
                data.setKeyword4(keyword);
            }
        }
        data.setFirst(first);
        data.setRemark(remark);
        businessMessage.setData(data);
    }

    /**
     * 查询商品详情
     * @param order
     */
    private String getItems(Order order){
        String items = "";
        String service = order.getGoodsDetails();
        List<GoodsDetail> list = JSONObject.parseArray(service, GoodsDetail.class);
        Map<Integer, List<GoodsDetail>> map = ListToMapUtil.toMapServiceDetailByGoodsId(list);
        for(Integer goodsId :map.keySet()){
            Integer num = 0;
            String name = "";
            for (GoodsDetail sd : map.get(goodsId)){
                num += sd.getNum();
                name = sd.getGoodsName();
            }
            items += name + " x " + num + " ,";
        }
        if (items.length() <=1){
            return "";
        }
        return items.substring(0,items.length()-1);
    }
}