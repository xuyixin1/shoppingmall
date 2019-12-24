package com.vicmob.shoppingmall.web.goodsAPI.dao;

import com.vicmob.shoppingmall.web.goodsAPI.model.Customer;
import com.vicmob.shoppingmall.web.goodsAPI.model.MinaAuthorization;
import org.apache.ibatis.annotations.Param;

public interface WXMapper {

    Customer getOpenId(@Param("minaId") Integer minaId, @Param("customerId") Integer customerId);

    MinaAuthorization getMinaAuthorization(@Param("minaId") Integer minaId);

    Integer updateAcessToken(@Param("minaId") Integer minaId, @Param("accessToken") String accessToken, @Param("endTime") Long endTime);
}
