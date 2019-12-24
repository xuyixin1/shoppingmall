package com.vicmob.shoppingmall.web.goodsAPI.dao;

import com.vicmob.shoppingmall.web.goodsAPI.entity.MallOrderAddress;
import com.vicmob.shoppingmall.web.goodsAPI.entity.MallOrderAddressExample;
import com.vicmob.shoppingmall.web.goodsAPI.model.CustomerUpdateVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface MallOrderAddressMapper {
    int countByExample(MallOrderAddressExample example);

    int deleteByExample(MallOrderAddressExample example);

    List<MallOrderAddress> selectByExample(MallOrderAddressExample example);

    int updateByExampleSelective(@Param("record") MallOrderAddress record, @Param("example") MallOrderAddressExample example);

    int updateByExample(@Param("record") MallOrderAddress record, @Param("example") MallOrderAddressExample example);

    List<MallOrderAddress> selectByExampleAndPage(MallOrderAddressExample example, RowBounds rowBound);

    int deleteByPrimaryKey(Integer addressid);

    int insert(MallOrderAddress record);

    int insertSelective(MallOrderAddress record);

    MallOrderAddress selectByPrimaryKey(Integer addressid);

    int updateByPrimaryKeySelective(MallOrderAddress record);

    int updateByPrimaryKey(MallOrderAddress record);

    int setDefaultAddress(CustomerUpdateVO record);

    MallOrderAddress getOrderAddressDetail(Integer addressid);
}