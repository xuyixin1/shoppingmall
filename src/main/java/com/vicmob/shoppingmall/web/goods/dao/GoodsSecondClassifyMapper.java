package com.vicmob.shoppingmall.web.goods.dao;

import com.vicmob.shoppingmall.web.goods.entity.GoodsClassify;
import com.vicmob.shoppingmall.web.goods.entity.GoodsSecondClassify;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsSecondClassifyMapper {
    public List<GoodsSecondClassify> getGoodsSecondClassifyList(@Param("g") GoodsSecondClassify goodsSecondClassify);

    public GoodsSecondClassify getBySecondClassifyId(@Param("secondClassifyId") Integer secondClassifyId);

    public List<GoodsSecondClassify> getBySecondClassifyName(@Param("classifyId") Integer classifyId, @Param("secondClassifyName") String secondClassifyName);

    public Integer addGoodsSecondClassify(@Param("g") GoodsSecondClassify goodsSecondClassify);

    public  List<GoodsSecondClassify> getByClassifyId(@Param("classifyId") Integer classifyId);

    public Integer updateGoodsSecondClassify(@Param("g") GoodsSecondClassify goodsSecondClassify);

    public Integer deleteGoodsSecondClassify(@Param("secondClassifyId") Integer secondClassifyId);
}
