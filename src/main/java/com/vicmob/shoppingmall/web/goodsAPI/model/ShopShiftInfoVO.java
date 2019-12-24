package com.vicmob.shoppingmall.web.goodsAPI.model;

import com.vicmob.shoppingmall.web.goodsAPI.entity.MallGoods;
import com.vicmob.shoppingmall.web.goodsAPI.entity.MallGoodsClassify;
import com.vicmob.shoppingmall.web.goodsAPI.entity.MallSlide;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Data
public class ShopShiftInfoVO implements Serializable {
    @ApiModelProperty(value="一级分类列表",name="mallGoodsClassifyList")
    private List<MallGoodsClassify> mallGoodsClassifyList;
    @ApiModelProperty(value="首页热门商品列表(最多展示12个)",name="mallGoodsList")
    private List<MallGoods> mallGoodsList;
    @ApiModelProperty(value="商品幻灯片列表",name="mallSlideList")
    private List<MallSlide> mallSlideList;
    @ApiModelProperty(value="全名拼团商品列表(最多展示2个)",name="moreGoodsCollageVOList")
    private List<MoreGoodsCollageVO> moreGoodsCollageVOList;
}