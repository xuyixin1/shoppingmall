package com.vicmob.shoppingmall.web.goodsAPI.dao;

import com.github.pagehelper.Page;
import com.vicmob.shoppingmall.web.goodsAPI.entity.MallEvaluate;
import com.vicmob.shoppingmall.web.goodsAPI.entity.MallGoods;
import com.vicmob.shoppingmall.web.goodsAPI.entity.MallGoodsExample;
import com.vicmob.shoppingmall.web.goodsAPI.entity.MallSpecification;
import com.vicmob.shoppingmall.web.goodsAPI.model.MallGoodsVO;
import com.vicmob.shoppingmall.web.goodsAPI.model.MoreGoodsCollageVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface MallGoodsMapper {
    int countByExample(MallGoodsExample example);

    int deleteByExample(MallGoodsExample example);

    List<MallGoods> selectByExampleWithBLOBs(MallGoodsExample example);

    List<MallGoods> selectByExample(MallGoodsExample example);

    int updateByExampleSelective(@Param("record") MallGoods record, @Param("example") MallGoodsExample example);

    int updateByExampleWithBLOBs(@Param("record") MallGoods record, @Param("example") MallGoodsExample example);

    int updateByExample(@Param("record") MallGoods record, @Param("example") MallGoodsExample example);

    List<MallGoods> selectByExampleWithBLOBsAndPage(MallGoodsExample example, RowBounds rowBound);

    List<MallGoods> selectByExampleAndPage(MallGoodsExample example, RowBounds rowBound);

    int deleteByPrimaryKey(Integer goodsid);

    int insert(MallGoods record);

    int insertSelective(MallGoods record);

    MallGoods selectByPrimaryKey(Integer goodsid);

    int updateByPrimaryKeySelective(MallGoods record);

    int updateByPrimaryKeyWithBLOBs(MallGoods record);

    int updateByPrimaryKey(MallGoods record);

    MallEvaluate getgoodsInfoByOrerId(Integer goodsId);

    MallGoodsVO queryGoodsByKey(@Param("goodsId")Integer goodsId,@Param("customerId")Integer customerId);

    List<MallSpecification> getAllSpecificationByGoodsId(@Param("minaId")Integer minaId, @Param("goodsId")Integer goodsId);

    int updateCollageFlag(Integer goodsId);

    Page<MoreGoodsCollageVO> getMoreCollageGoods(@Param("minaId")Integer minaId, @Param("goodsName")String goodsName);

    List<MallGoods> getAllGoodsList(@Param("minaId")Integer minaId, @Param("secondClassifyId")Integer secondClassifyId);

    List<MallGoods> getAllGoodsListByEdit(@Param("minaId")Integer minaId, @Param("secondClassifyId")Integer secondClassifyId);

    Page<MallGoods> getGoodsList(@Param("minaId")Integer minaId,@Param("secondClassifyId")Integer secondClassifyId,@Param("goodsName")String goodsName);

    int updateCollageSailed(@Param("goodsId")Integer goodsId,@Param("num")Integer num);

    int checkCollageUsed(@Param("goodsId")Integer goodsId,@Param("customerId")Integer customerId);

    int updateSailed(@Param("goodsId")Integer goodsId,@Param("num")Integer num);

    int updateCollageFlagUnStart(@Param("goodsId")Integer goodsId);

}