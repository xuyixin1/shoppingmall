package com.vicmob.shoppingmall.web.goodsAPI.dao;

import com.vicmob.shoppingmall.web.goodsAPI.entity.MallGoodsSecondClassify;
import com.vicmob.shoppingmall.web.goodsAPI.entity.MallGoodsSecondClassifyExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import java.util.List;

public interface MallGoodsSecondClassifyMapper {
    int countByExample(MallGoodsSecondClassifyExample example);

    int deleteByExample(MallGoodsSecondClassifyExample example);

    List<MallGoodsSecondClassify> selectByExample(MallGoodsSecondClassifyExample example);

    int updateByExampleSelective(@Param("record") MallGoodsSecondClassify record, @Param("example") MallGoodsSecondClassifyExample example);

    int updateByExample(@Param("record") MallGoodsSecondClassify record, @Param("example") MallGoodsSecondClassifyExample example);

    List<MallGoodsSecondClassify> selectByExampleAndPage(MallGoodsSecondClassifyExample example, RowBounds rowBound);

    int deleteByPrimaryKey(Integer secondclassifyid);

    int insert(MallGoodsSecondClassify record);

    int insertSelective(MallGoodsSecondClassify record);

    MallGoodsSecondClassify selectByPrimaryKey(Integer secondclassifyid);

    int updateByPrimaryKeySelective(MallGoodsSecondClassify record);

    int updateByPrimaryKey(MallGoodsSecondClassify record);

    List<MallGoodsSecondClassify> getAllSecondClassifyByClassifyId(@Param("minaId")Integer minaId, @Param("classifyId")Integer classifyId);

    List<MallGoodsSecondClassify> getAllSecondClassifyByEdit(@Param("minaId")Integer minaId, @Param("classifyId")Integer classifyId);
}