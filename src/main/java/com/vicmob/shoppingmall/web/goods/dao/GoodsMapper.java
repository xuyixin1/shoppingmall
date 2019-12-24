package com.vicmob.shoppingmall.web.goods.dao;

import com.vicmob.shoppingmall.constant.Constant;
import com.vicmob.shoppingmall.web.goods.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {

   public List<Goods> getGoodList(@Param("minaId") Integer minaId,@Param("g") Goods goods);

   public Goods getByGoodsId(@Param("goodsId") Integer goodsId);

   public Integer deleteByGoodsId(@Param("goodsId") Integer goodsId);

   public Integer updateSaleFlag(@Param("goodsId") Integer goodsId, @Param("saleFlag")Constant.SaleFlag saleFlag);

   public Integer addGoods(@Param("g") Goods goods);

   public List<Goods> getByGoodsName(@Param("minaId")Integer minaId,@Param("goodsName")String goodsName);

   public Integer updateGoods(@Param("g") Goods goods);

   public List<Goods> getGoodListBySecondClassifyId(@Param("secondClassifyId") Integer secondClassifyId);

   public Integer updateSailed(@Param("goodsId")Integer goodsId,@Param("num")Integer num);

    public Integer reduceSailed(@Param("goodsId")Integer goodsId,@Param("num")Integer num);

    Integer updateDistributionFlag(@Param("goodsId") Integer goodsId, @Param("distributionFlag")Constant.Flag distributionFlag);

    /**
     * 是否有正在使用分销的商品
     */
    List<Goods> getGoodsWithDistributionFlag(@Param("minaId")Integer minaId,@Param("flag")Constant.Flag falg);
}
