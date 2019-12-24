package com.vicmob.shoppingmall.web.goodsAPI.dao;

import com.github.pagehelper.Page;
import com.vicmob.shoppingmall.web.goodsAPI.entity.MallGoodsCollageActivity;
import com.vicmob.shoppingmall.web.goodsAPI.entity.MallGoodsCollageActivityExample;
import com.vicmob.shoppingmall.web.goodsAPI.model.CollageActivityIdVO;
import com.vicmob.shoppingmall.web.goodsAPI.model.MallGoodsCollageActivityDetailVO;
import com.vicmob.shoppingmall.web.goodsAPI.model.MallGoodsCollageActivityQueryVO;
import com.vicmob.shoppingmall.web.goodsAPI.model.MallGoodsCollageActivityVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface MallGoodsCollageActivityMapper {
    int countByExample(MallGoodsCollageActivityExample example);

    int deleteByExample(MallGoodsCollageActivityExample example);

    List<MallGoodsCollageActivity> selectByExample(MallGoodsCollageActivityExample example);

    int updateByExampleSelective(@Param("record") MallGoodsCollageActivity record, @Param("example") MallGoodsCollageActivityExample example);

    int updateByExample(@Param("record") MallGoodsCollageActivity record, @Param("example") MallGoodsCollageActivityExample example);

    List<MallGoodsCollageActivity> selectByExampleAndPage(MallGoodsCollageActivityExample example, RowBounds rowBound);

    int deleteByPrimaryKey(String collageactivityid);

    int insert(MallGoodsCollageActivity record);

    int insertSelective(MallGoodsCollageActivity record);

    MallGoodsCollageActivity selectByPrimaryKey(String collageactivityid);

    int updateByPrimaryKeySelective(MallGoodsCollageActivity record);

    int updateByPrimaryKey(MallGoodsCollageActivity record);

    Page<MallGoodsCollageActivityVO> getCollageActivityList(@Param("record") MallGoodsCollageActivityQueryVO vo);

    MallGoodsCollageActivityDetailVO getCollageActivityDetail(String collageActivityId);

    List<MallGoodsCollageActivity> selectCollageActivityOvertime();

    int updateCollageActivityUnStart(@Param("goodsId")Integer goodsId,@Param("minaId")Integer minaId);

    List<MallGoodsCollageActivity> selectAllUnStart();
}