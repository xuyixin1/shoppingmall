package com.vicmob.shoppingmall.web.goods.service;

import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.ResultData;
import com.vicmob.shoppingmall.web.goods.dao.BusinessAccountMapper;
import com.vicmob.shoppingmall.web.goods.entity.BusinessAccount;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BusinessAccountService {

    @Autowired
    private  BusinessAccountMapper businessAccountMapper;

    public BusinessAccount getBusinessAccount(){
        return businessAccountMapper.getBusinessAccount();
    }

    public ResultData updateAcessToken(String accessToken, Long endTime){
        if (businessAccountMapper.updateAcessToken(accessToken,endTime)!=1){
            log.error("更新公众号token 失败 ,acessToken ==>{}",accessToken);
            return new ResultData("更新公众号token 失败", ResponseStatus.FAIL.getValue());
        }
        return new ResultData("success", ResponseStatus.SUCCESS.getValue());
    }
}
