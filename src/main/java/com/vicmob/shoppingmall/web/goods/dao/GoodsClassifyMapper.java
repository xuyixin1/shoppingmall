package com.vicmob.shoppingmall.web.goods.dao;

import com.vicmob.shoppingmall.web.goods.entity.GoodsClassify;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsClassifyMapper {
    public List<GoodsClassify> getGoodsClassifyList(@Param("minaId")Integer minaId, @Param("g") GoodsClassify goodsClassify);

    public GoodsClassify getByClassifyId(@Param("classifyId")Integer classifyId);

    public List<GoodsClassify> getByClassifyName(@Param("minaId")Integer minaId,@Param("classifyName")String classifyName);

    public Integer addGoodsClassify(@Param("g") GoodsClassify goodsClassify);

    public Integer updateGoodsClassify(@Param("g") GoodsClassify goodsClassify);

    public Integer deleteGoodsClassify(@Param("classifyId")Integer classifyId);
}
