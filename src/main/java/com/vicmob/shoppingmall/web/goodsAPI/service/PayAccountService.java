package com.vicmob.shoppingmall.web.goodsAPI.service;

import com.vicmob.shoppingmall.web.goodsAPI.dao.PayAccountMapper;
import com.vicmob.shoppingmall.web.goodsAPI.model.PayAccount;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PayAccountService {
    private final Logger log = LoggerFactory.getLogger(PayAccountService.class);

    @Autowired
    PayAccountMapper payAccountMapper;

    public PayAccount getPayAccount (Integer minaId) {
        return payAccountMapper.getPayAccount(minaId);
    }

    public PayAccount getPayAccountByAppId (String appId,String mchId) {
        return payAccountMapper.getPayAccountByAppId(appId,mchId);
    }

}
