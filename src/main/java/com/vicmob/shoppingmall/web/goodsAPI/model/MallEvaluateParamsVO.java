package com.vicmob.shoppingmall.web.goodsAPI.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class MallEvaluateParamsVO implements Serializable {
    @ApiModelProperty(value="商品id",name="goodsid")
    private Integer goodsid;
    @ApiModelProperty(value="商品规格id",name="specid")
    private Integer specId;
    @ApiModelProperty(value="是否匿名（0为不匿名，1为匿名）",name="isanonymous")
    private Integer isanonymous;
    @ApiModelProperty(value="评论星级（1-5,分别为1星-5星: 1星:非常差;2星:差;3星;一般;4星:好;5星:非常好)",name="evallevel")
    private Integer evallevel;
    @ApiModelProperty(value="评论内容",name="evalcontent")
    private String evalcontent;
    @ApiModelProperty(value="评论图片",name="evalpic")
    private String evalpic;
}