package com.vicmob.shoppingmall.web.goods.dao;

import com.vicmob.shoppingmall.web.goods.entity.BusinessAccount;
import org.apache.ibatis.annotations.Param;

public interface BusinessAccountMapper {

   public BusinessAccount getBusinessAccount();

   public Integer updateAcessToken(@Param("accessToken") String accessToken, @Param("endTime") Long endTime);

}
