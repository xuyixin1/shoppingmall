package com.vicmob.shoppingmall.web.goods.controller;

import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.ResultData;
import com.vicmob.shoppingmall.web.goods.entity.Notification;
import com.vicmob.shoppingmall.web.goods.service.NotificationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Api(tags="商家信息相关接口")
@Validated
@RestController
@RequestMapping(value = "/onlineShop/notification")
public class NotificationController {
    private final Logger log = LoggerFactory.getLogger(NotificationController.class);

    @Autowired
    private NotificationService notificationService;


    @PostMapping("save")
    @ApiOperation(value="添加商家信息")
    public ResultData saveNotifications(@Valid @RequestBody  Notification notification){
        ResultData result;
        try{
            result = notificationService.saveNotifications(notification);
        }catch(Exception e){
            log.error("保存商家信息列表失败,notification ==>{}",notification);
            log.error(e.getMessage(), e);
            result =  new ResultData("保存商家信息列表失败", ResponseStatus.FAIL.getValue());
        }
        return result;
    }

    private Boolean checkNotificationsMinaId(List<Notification> notifications){
        Integer minaId = notifications.get(0).getMinaId();
        for (Notification no : notifications){
           if (!minaId.equals(no.getMinaId())){
               return false;
           }
        }
        return true;
    }
}
