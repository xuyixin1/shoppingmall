package com.vicmob.shoppingmall.web.goodsAPI.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class MallGoodsSecondClassify implements Serializable {
    @ApiModelProperty(value="二级分类id",name="secondclassifyid")
    private Integer secondclassifyid;
    @ApiModelProperty(value="小程序id",name="minaid")
    private Integer minaid;
    @ApiModelProperty(value="一级分类id",name="classifyid")
    private Integer classifyid;
    @ApiModelProperty(value="二级分类名称",name="secondclassifyname")
    private String secondclassifyname;
    @ApiModelProperty(value="二级分类图片",name="classifypictureurl")
    private String classifypictureurl;
    @ApiModelProperty(value="排序",name="sort")
    private Integer sort;
}