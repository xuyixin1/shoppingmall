package com.vicmob.shoppingmall.web.goodsAPI.model;

import com.vicmob.shoppingmall.web.goodsAPI.entity.MallGoods;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.math.BigDecimal;

@Data
public class MoreGoodsCollageVO extends MallGoods {
    @ApiModelProperty(name= "partsnumber",value ="已拼件数")
    private Integer partsnumber;
    @ApiModelProperty(name= "collageactivityprice",value ="拼团价格")
    private BigDecimal collageactivityprice;



}