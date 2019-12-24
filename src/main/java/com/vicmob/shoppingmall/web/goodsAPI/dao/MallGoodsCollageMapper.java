package com.vicmob.shoppingmall.web.goodsAPI.dao;

import com.github.pagehelper.Page;
import com.vicmob.shoppingmall.web.goodsAPI.entity.MallGoodsCollage;
import com.vicmob.shoppingmall.web.goodsAPI.entity.MallGoodsCollageExample;
import com.vicmob.shoppingmall.web.goodsAPI.model.*;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface MallGoodsCollageMapper {
    int countByExample(MallGoodsCollageExample example);

    int deleteByExample(MallGoodsCollageExample example);

    List<MallGoodsCollage> selectByExample(MallGoodsCollageExample example);

    int updateByExampleSelective(@Param("record") MallGoodsCollage record, @Param("example") MallGoodsCollageExample example);

    int updateByExample(@Param("record") MallGoodsCollage record, @Param("example") MallGoodsCollageExample example);

    List<MallGoodsCollage> selectByExampleAndPage(MallGoodsCollageExample example, RowBounds rowBound);

    int deleteByPrimaryKey(Integer collageid);

    int insert(MallGoodsCollage record);

    int insertSelective(MallGoodsCollage record);

    int updateByPrimaryKeySelective(MallGoodsCollage record);

    int updateByPrimaryKey(MallGoodsCollage record);

    Page<MallGoodsCollageVO> getCollageList(@Param("record") MallGoodsCollageQueryVO vo);

    List<MallGoodsCollageParamVO> getCollageByGoodsId(@Param("goodsId") Integer goodsId, @Param("minaId") Integer minaId);

    MallGoodsCollage getMallGoodsCollageByNo(String collageNo);

    int updateCollageStatus(@Param("minaId") Integer minaId,@Param("goodsId") Integer goodsId);

    List<MallGoodsCollage> selectCollageOvertime();

    MallGoodsCollageDetailVO getGoodsCollageDetail(Integer collageId);

   int checkCollageComplete(String collageNo);

   int checkCollageLose(String collageNo);

   int updateCollageStatusByCustomerId(@Param("collageNo")String collageNo,@Param("customerId") Integer customerId);

}