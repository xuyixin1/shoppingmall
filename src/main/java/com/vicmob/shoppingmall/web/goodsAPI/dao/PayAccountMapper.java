package com.vicmob.shoppingmall.web.goodsAPI.dao;

import com.vicmob.shoppingmall.web.goodsAPI.model.PayAccount;
import org.apache.ibatis.annotations.Param;

public interface PayAccountMapper {
    PayAccount getPayAccount(@Param("minaId") Integer minaId);

    PayAccount getPayAccountByAppId (@Param("appId")String appId,@Param("mchId")String mchId);
}
