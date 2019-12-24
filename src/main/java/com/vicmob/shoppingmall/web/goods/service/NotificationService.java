package com.vicmob.shoppingmall.web.goods.service;

import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.ResultData;
import com.vicmob.shoppingmall.web.goods.dao.NotificationMapper;
import com.vicmob.shoppingmall.web.goods.entity.Notification;
import com.vicmob.shoppingmall.web.goodsAPI.wxclient.WXInfoClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class NotificationService {
    private final Logger log = LoggerFactory.getLogger(NotificationService.class);

    @Autowired
    private NotificationMapper notificationMapper;

    @Autowired
    private WXInfoClient wxInfoClient;

    public ResultData getNotificationList(Integer minaId){
       List<Notification> list = notificationMapper.getNotificationList(minaId);
       return new ResultData("success", ResponseStatus.SUCCESS.getValue(),list);
    }


    @Transactional(rollbackFor = Exception.class)
    public ResultData saveNotifications(Notification notification) {
        ResultData result = null;
        try {
            notificationMapper.deleteNotification(notification.getMinaId());
            String openId = wxInfoClient.getOpenIdByWX(notification.getCode());
            if (StringUtils.isEmpty(openId)) {
                throw new Exception("openId获取失败");
            }
            notification.setOpenId(openId);
            if (notificationMapper.addNotification(notification) != 1) {
                throw new Exception("添加商家信息失败");
            }
            result = new ResultData("success", ResponseStatus.SUCCESS.getValue());
        } catch (Exception e) {
            log.error("添加商家信息失败，notification ==>{}", notification);
            log.error(e.getMessage(), e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            result = new ResultData(e.getMessage(), ResponseStatus.FAIL.getValue());
        }
        return result;
    }
}
