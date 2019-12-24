package com.vicmob.shoppingmall.web.goodsAPI.dao;

import com.vicmob.shoppingmall.web.goodsAPI.entity.MallSpecification;
import com.vicmob.shoppingmall.web.goodsAPI.entity.MallSpecificationExample;
import com.vicmob.shoppingmall.web.goodsAPI.model.AttributeId1VO;
import com.vicmob.shoppingmall.web.goodsAPI.model.AttributeId2VO;
import com.vicmob.shoppingmall.web.goodsAPI.model.GoodsSpecsVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface MallSpecificationMapper {
    int countByExample(MallSpecificationExample example);

    int deleteByExample(MallSpecificationExample example);

    List<MallSpecification> selectByExample(MallSpecificationExample example);

    int updateByExampleSelective(@Param("record") MallSpecification record, @Param("example") MallSpecificationExample example);

    int updateByExample(@Param("record") MallSpecification record, @Param("example") MallSpecificationExample example);

    List<MallSpecification> selectByExampleAndPage(MallSpecificationExample example, RowBounds rowBound);

    int deleteByPrimaryKey(Integer specid);

    int insert(MallSpecification record);

    int insertSelective(MallSpecification record);

    MallSpecification selectByPrimaryKey(Integer specid);

    int updateByPrimaryKeySelective(MallSpecification record);

    int updateByPrimaryKey(MallSpecification record);

    List<AttributeId1VO> selectGoodsSpecs1(@Param("goodsId")Integer goodsId, @Param("minaId")Integer minaId);

    List<AttributeId2VO> selectGoodsSpecs2(@Param("goodsId")Integer goodsId, @Param("minaId")Integer minaId);

    int queryTotalStock(@Param("goodsId")Integer goodsId, @Param("minaId")Integer minaId);

    GoodsSpecsVO getGoodsSpecs(@Param("goodsId")Integer goodsId,@Param("minaId")Integer minaId,@Param("attributeValueName1")String attributeValueName1,@Param("attributeValueName2")String attributeValueName2,@Param("collageFlag")Integer collageFlag);
}