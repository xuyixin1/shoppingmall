package com.vicmob.shoppingmall.web.goodsAPI.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ClassifyIdVO implements Serializable {
    @ApiModelProperty(value="一级分类id",name="一级分类id")
    private Integer classifyId;
    @ApiModelProperty(value="小程序id",name="minaStr")
    private String minaStr;
    @ApiModelProperty(value="appId",name="appId")
    private String appId;

}