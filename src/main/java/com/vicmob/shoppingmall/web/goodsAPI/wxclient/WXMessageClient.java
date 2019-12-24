package com.vicmob.shoppingmall.web.goodsAPI.wxclient;

import com.vicmob.shoppingmall.constant.Constant;
import com.vicmob.shoppingmall.utils.JacksonUtil;
import com.vicmob.shoppingmall.utils.RestTemplateUtil;
import com.vicmob.shoppingmall.web.goods.entity.Order;
import com.vicmob.shoppingmall.web.goods.entity.Template;
import com.vicmob.shoppingmall.web.goods.service.TemplateService;
import com.vicmob.shoppingmall.web.goodsAPI.model.*;
import com.vicmob.shoppingmall.web.goodsAPI.service.FormService;
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


@Service
public class WXMessageClient {
    private final Logger log = LoggerFactory.getLogger(WXMessageClient.class);
    @Value("${wx.weapp.sendMessage.url}")
    private String wxSendMessageUrl;

    @Value("${wx.token.url}")
    private String wxTokenUrl;

    @Value("${wx.weapp.page}")
    private String wxPage;

    @Autowired
    private WXInfoClient wxInfoClient;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TemplateService templateService;

    @Autowired
    private FormService formService;

    @Async("taskExecutor")
    public void sendMessage(Order order){
        log.info("order ==>",order);
        WXMessage message = new WXMessage();
        WeappTemplateMsg weappTemplateMsg = new WeappTemplateMsg();
        String openId = null;
        Template template = null;
        WXData data = new WXData();
        try{
            openId = wxInfoClient.getOpenId(order.getMinaId(),order.getCustomerId());
            if ( StringUtils.isEmpty(openId)){
                log.error("openId获取失败 order ==>{}" ,order);
                return;
            }
            message.setTouser(openId);
            template = templateService.getTemplateByType(order.getMinaId(), Constant.InformType.getEnumInformType(order.getOrderStatus()));
            if (template == null||StringUtils.isEmpty(template.getInformId())){
                log.error("template获取失败 order ==>{}" ,order);
                return;
            }
            weappTemplateMsg.setTemplatId(template.getInformId());
            weappTemplateMsg.setPage(wxPage);
            if(order.getOrderStatus() == Constant.OrderType.ORDER_PAY){
                weappTemplateMsg.setFormId(order.getPrepayId());
            }if(order.getOrderStatus() == Constant.OrderType.ORDER){
                weappTemplateMsg.setFormId(order.getFormId());
            }else{
                String formId = formService.getFormId(order.getCustomerId());
                if (StringUtils.isEmpty(formId)){
                    log.error("formId 获取失败");
                    return;
                }
                weappTemplateMsg.setFormId(formId);
            }
            getData(order,data);
            weappTemplateMsg.setData(data);
            message.setWeappTemplateMsg(weappTemplateMsg);
            String accessToken = wxInfoClient.getAccessToken(order.getMinaId());
            if (accessToken == null){
                return ;
            }
            String wxSendMessageUrl1 = wxSendMessageUrl + "?access_token=" + accessToken;
            WXBaseResponse wxBaseResponse = RestTemplateUtil.postResult(JacksonUtil.objToJson(message),wxSendMessageUrl1,WXBaseResponse.class, restTemplate);
            if (wxBaseResponse.getErrcode() != 0){
                log.error("调用微信发送接口失败  wxBaseResponse ==>{}", JacksonUtil.objToJson(wxBaseResponse));
                return;
            }
        }catch(Exception e){
            log.error("发送小程序消息通知失败，order ==>{}" ,order);
            log.error(e.getMessage(), e);
        }
    }

    public void getData(Order order,WXData data){
        Constant.OrderType type = order.getOrderStatus();
        String status = order.getOrderStatus().getName();
        String totalMoney = order.getTotalMoney().toString();
        String payMoney =  (order.getTotalMoney().add(order.getDeliveryMoney())).toString() ;
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String currentTime = dateFormat.format(date);
        Keyword keyword = null;
        List<String> list = new ArrayList<>();
        list.add(order.getOrderNumber());

        if (type == Constant.OrderType.ORDER){
            list.add(payMoney);
            list.add(status);
            list.add(order.getOrderStartTime());
       }
       if (type == Constant.OrderType.ORDER_PAY){
           list.add(payMoney);
           list.add(status);
           list.add(order.getOrderStartTime());
           list.add(currentTime);
       }
        if (type == Constant.OrderType.ORDER_FINISH){
            list.add(status);
            list.add(currentTime);
        }
       if (type == Constant.OrderType.ORDER_CANCEL){
           list.add(status);
           list.add(order.getOrderStartTime());
           list.add(currentTime);
       }
        if (type == Constant.OrderType.ORDER_OVERTIME){
            list.add(status);
            list.add(order.getOrderStartTime());
        }
        if (type == Constant.OrderType.REFUND_APPLY){
            list.add(totalMoney);
            list.add(status);
            list.add(currentTime);
        }
        if (type == Constant.OrderType.REFUND_SUCCESS){
            list.add(totalMoney);
            list.add(status);
            list.add(order.getOrderRefundTime());
            list.add(currentTime);
        }
        if (type == Constant.OrderType.REFUND_FAILURE){
            list.add(totalMoney);
            list.add(status);

        }
        if(type == Constant.OrderType.REFUND_REFUSE){
            list.add(status);
            list.add(order.getRefuseReason());
        }
        if(type == Constant.OrderType.ORDER_FINISH){
            list.add(status);
            list.add(order.getOrderEndTime());
        }

        for (int i=0 ;i<list.size();i++){
            keyword = new Keyword();
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
            } if (i == 3){
                keyword.setValue(list.get(i));
                data.setKeyword4(keyword);
            } if (i == 4 ){
                keyword.setValue(list.get(i));
                data.setKeyword5(keyword);
            } if (i == 5 ){
                keyword.setValue(list.get(i));
                data.setKeyword6(keyword);
            }
        }
    }

}
