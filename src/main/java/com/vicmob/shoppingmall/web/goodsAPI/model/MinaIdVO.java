package com.vicmob.shoppingmall.web.goodsAPI.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class MinaIdVO implements Serializable {
    @ApiModelProperty(name = "minaStr",value = "小程序id")
    private String minaStr;
    @ApiModelProperty(name = "appId",value = "appId")
    private String appId;
    @ApiModelProperty(name = "customerId",value = "粉丝id")
    private Integer customerId;
    @ApiModelProperty(value="page",name="分页参数")
    private PageRecord page;
    @ApiModelProperty(name = "goodsName",value = "商品名称")
    private String goodsName;

}