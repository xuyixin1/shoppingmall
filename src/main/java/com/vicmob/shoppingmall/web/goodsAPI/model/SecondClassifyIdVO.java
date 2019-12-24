package com.vicmob.shoppingmall.web.goodsAPI.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SecondClassifyIdVO implements Serializable {
    @ApiModelProperty(name = "secondClassifyId",value = "二级分类id")
    private Integer secondClassifyId;
    @ApiModelProperty(name = "minaStr",value = "小程序id")
    private String minaStr;
    @ApiModelProperty(name = "appId",value = "appId")
    private String appId;
    @ApiModelProperty(name = "goodsName",value = "商品名称")
    private String goodsName;
    @ApiModelProperty(value="page",name="分页参数")
    private PageRecord page;

}