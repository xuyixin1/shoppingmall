package com.vicmob.shoppingmall.web.goodsAPI.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerLimitVO implements Serializable {
    @ApiModelProperty(value="商品id",name="goodsId")
    private Integer goodsId;
    @ApiModelProperty(value="小程序id",name="minaStr")
    private String minaStr;
    @ApiModelProperty(value="appId",name="appId")
    private String appId;
    @ApiModelProperty(value="粉丝Id",name="customerId")
    private Integer customerId;
    @ApiModelProperty(value="活动id",name="collageActivityId")
    private String collageActivityId;
}