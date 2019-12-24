package com.vicmob.shoppingmall.web.goodsAPI.dao;
import com.vicmob.shoppingmall.web.goodsAPI.entity.MallGoodsClassify;
import com.vicmob.shoppingmall.web.goodsAPI.entity.MallGoodsClassifyExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface MallGoodsClassifyMapper {
    int countByExample(MallGoodsClassifyExample example);

    int deleteByExample(MallGoodsClassifyExample example);

    List<MallGoodsClassify> selectByExample(MallGoodsClassifyExample example);

    int updateByExampleSelective(@Param("record") MallGoodsClassify record, @Param("example") MallGoodsClassifyExample example);

    int updateByExample(@Param("record") MallGoodsClassify record, @Param("example") MallGoodsClassifyExample example);

    List<MallGoodsClassify> selectByExampleAndPage(MallGoodsClassifyExample example, RowBounds rowBound);

    int deleteByPrimaryKey(Integer classifyid);

    int insert(MallGoodsClassify record);

    int insertSelective(MallGoodsClassify record);

    MallGoodsClassify selectByPrimaryKey(Integer classifyid);

    int updateByPrimaryKeySelective(MallGoodsClassify record);

    int updateByPrimaryKey(MallGoodsClassify record);

    List<MallGoodsClassify> getAllClassify(Integer minaId);

    List<MallGoodsClassify> getAllClassifyByEdit(Integer minaId);
}