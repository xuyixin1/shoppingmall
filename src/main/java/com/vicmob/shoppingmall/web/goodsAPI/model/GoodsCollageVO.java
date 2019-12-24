package com.vicmob.shoppingmall.web.goodsAPI.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsCollageVO implements Serializable {
    @ApiModelProperty(value="商品id",name="goodsId")
    private Integer goodsId;
    @ApiModelProperty(value="平台id",name="minaId")
    private Integer minaId;

}