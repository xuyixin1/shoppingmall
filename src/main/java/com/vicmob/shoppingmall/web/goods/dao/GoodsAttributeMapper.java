package com.vicmob.shoppingmall.web.goods.dao;

import com.vicmob.shoppingmall.web.goods.entity.GoodsAttribute;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsAttributeMapper {
   public List<GoodsAttribute> getAttributeList(@Param("secondClassifyId")Integer secondClassifyId);

   public GoodsAttribute getByAttributeId(@Param("attributeId")Integer attributeId);

   public List<GoodsAttribute> getGoodsAttributeByName(@Param("g") GoodsAttribute goodsAttribute);

   public Integer addGoodsAttribute(@Param("g") GoodsAttribute goodsAttribute);

   public Integer updateGoodsAttribute(@Param("g") GoodsAttribute goodsAttribute);

   public Integer deleteGoodsAttribute(@Param("attributeId")Integer attributeId);
}
