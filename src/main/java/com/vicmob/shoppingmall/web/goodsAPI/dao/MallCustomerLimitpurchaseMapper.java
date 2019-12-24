package com.vicmob.shoppingmall.web.goodsAPI.dao;

import com.vicmob.shoppingmall.web.goodsAPI.entity.MallCustomerLimitpurchase;
import org.apache.ibatis.annotations.Param;

public interface MallCustomerLimitpurchaseMapper {
    int deleteByPrimaryKey(Integer limitid);

    int insert(MallCustomerLimitpurchase record);

    int insertSelective(MallCustomerLimitpurchase record);

    MallCustomerLimitpurchase selectByPrimaryKey(Integer limitid);

    int updateByPrimaryKeySelective(MallCustomerLimitpurchase record);

    int updateByPrimaryKey(MallCustomerLimitpurchase record);

    MallCustomerLimitpurchase selectCustomerLimit(@Param("collageNo")String collageNo,@Param("minaId")Integer minaId,@Param("goodsId")Integer goodsId,@Param("customerId")Integer customerId);

    int updateSurplusNum(@Param("minaId")Integer minaId,@Param("goodsId")Integer goodsId,@Param("collageActivityId")String collageActivityId,@Param("customerId")Integer customerId,@Param("num")Integer num);

}