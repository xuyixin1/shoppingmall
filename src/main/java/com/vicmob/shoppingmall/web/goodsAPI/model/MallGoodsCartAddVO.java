package com.vicmob.shoppingmall.web.goodsAPI.model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
@Data
public class MallGoodsCartAddVO implements Serializable {
    @ApiModelProperty(value="购物车id",name="cartid")
    private Integer cartid;
    @ApiModelProperty(value="商品数量",name="goodsnum")
    private Integer goodsnum;
    @ApiModelProperty(value="商品价格",name="goodspirce")
    private double goodsprice;


}