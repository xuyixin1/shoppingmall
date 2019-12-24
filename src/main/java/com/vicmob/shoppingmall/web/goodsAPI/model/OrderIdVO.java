package com.vicmob.shoppingmall.web.goodsAPI.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OrderIdVO implements Serializable {
    @ApiModelProperty(name = "orderId",value = "订单id")
    private Integer orderId;
    @ApiModelProperty(name = "minaStr",value = "小程序id")
    private String minaStr;
    @ApiModelProperty(name = "appId",value = "appId")
    private String appId;

}