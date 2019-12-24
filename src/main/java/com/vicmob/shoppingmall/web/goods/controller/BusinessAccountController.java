package com.vicmob.shoppingmall.web.goods.controller;

import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.ResultData;
import com.vicmob.shoppingmall.web.goods.entity.BusinessAccount;
import com.vicmob.shoppingmall.web.goods.service.BusinessAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("businessAccount")
public class BusinessAccountController {
    @Autowired
    private BusinessAccountService businessAccountService;

    @GetMapping("qrcode")
    public ResultData getQrcode(){
        try{
            BusinessAccount businessAccount = businessAccountService.getBusinessAccount();
            if(businessAccount == null || StringUtils.isEmpty(businessAccount.getWxQrcodeUrl())){
                return new ResultData("公众号账号不存在", ResponseStatus.FAIL.getValue());
            }
            BusinessAccount businessAccount1 = new BusinessAccount();
            businessAccount1.setWxQrcodeUrl(businessAccount.getWxQrcodeUrl());
            businessAccount1.setAppId(businessAccount.getAppId());
            return new ResultData("success", ResponseStatus.SUCCESS.getValue(),businessAccount1);
        }catch (Exception e){
            log.error("获取二维码失败");
            log.error(e.getMessage(), e);
            return new ResultData("获取二维码失败", ResponseStatus.FAIL.getValue());
        }
    }

}
