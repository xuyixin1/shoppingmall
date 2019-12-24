package com.vicmob.shoppingmall.web.goodsAPI.dao;

import com.vicmob.shoppingmall.web.goodsAPI.entity.MallSlide;
import com.vicmob.shoppingmall.web.goodsAPI.entity.MallSlideExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface MallSlideMapper {
    int countByExample(MallSlideExample example);

    int deleteByExample(MallSlideExample example);

    List<MallSlide> selectByExample(MallSlideExample example);

    int updateByExampleSelective(@Param("record") MallSlide record, @Param("example") MallSlideExample example);

    int updateByExample(@Param("record") MallSlide record, @Param("example") MallSlideExample example);

    List<MallSlide> selectByExampleAndPage(MallSlideExample example, RowBounds rowBound);

    int deleteByPrimaryKey(Integer slideid);

    int insert(MallSlide record);

    int insertSelective(MallSlide record);

    MallSlide selectByPrimaryKey(Integer slideid);

    int updateByPrimaryKeySelective(MallSlide record);

    int updateByPrimaryKey(MallSlide record);
}