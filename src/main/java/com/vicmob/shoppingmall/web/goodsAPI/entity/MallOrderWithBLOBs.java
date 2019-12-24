package com.vicmob.shoppingmall.web.goodsAPI.entity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MallOrderWithBLOBs extends MallOrder {
    @ApiModelProperty(name= "addressdetails",value ="收货地址详情")
    private String addressdetails;
    @ApiModelProperty(name= "goodsdetails",value ="下单商品详情")
    private String goodsdetails;

}