package com.vicmob.shoppingmall.web.goods.dao;

import com.vicmob.shoppingmall.web.goods.entity.Notification;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface  NotificationMapper {

    public List<Notification> getNotificationList(@Param("minaId") Integer minaId);

    public Integer deleteNotification(@Param("minaId") Integer minaId);

    public Integer deleteNotificationByMinaId(@Param("minaId")Integer minaId);

    public Integer addNotification(@Param("n")Notification notification);

    public Integer updateNotification(@Param("n")Notification notification);
}
