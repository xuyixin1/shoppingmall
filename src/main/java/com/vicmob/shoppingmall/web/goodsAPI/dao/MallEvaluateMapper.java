package com.vicmob.shoppingmall.web.goodsAPI.dao;

import com.github.pagehelper.Page;
import com.vicmob.shoppingmall.web.goodsAPI.entity.MallEvaluate;
import com.vicmob.shoppingmall.web.goodsAPI.entity.MallEvaluateExample;
import com.vicmob.shoppingmall.web.goodsAPI.model.MallEvaluateNumVO;
import com.vicmob.shoppingmall.web.goodsAPI.model.MallEvaluateVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface MallEvaluateMapper {
    int countByExample(MallEvaluateExample example);

    int deleteByExample(MallEvaluateExample example);

    List<MallEvaluate> selectByExample(MallEvaluateExample example);

    int updateByExampleSelective(@Param("record") MallEvaluate record, @Param("example") MallEvaluateExample example);

    int updateByExample(@Param("record") MallEvaluate record, @Param("example") MallEvaluateExample example);

    List<MallEvaluate> selectByExampleAndPage(MallEvaluateExample example, RowBounds rowBound);

    int deleteByPrimaryKey(Integer evaluateid);

    int insert(MallEvaluate record);

    int insertSelective(MallEvaluate record);

    MallEvaluate selectByPrimaryKey(Integer evaluateid);

    int updateByPrimaryKeySelective(MallEvaluate record);

    int updateByPrimaryKey(MallEvaluate record);

    MallEvaluateNumVO selectEvaluateNum(@Param("goodsId") Integer goodsId,@Param("minaId") Integer minaId,@Param("customerId") Integer customerId);

    List<MallEvaluateVO> selectMallEvaluateList(@Param("goodsId") Integer goodsId,@Param("minaId") Integer minaId,@Param("customerId") Integer customerId);

    Page<MallEvaluateVO> selectMallEvaluateListByType(@Param("goodsId") Integer goodsId, @Param("minaId") Integer minaId, @Param("evaluateType")String evaluateType,@Param("customerId") Integer customerId);
}