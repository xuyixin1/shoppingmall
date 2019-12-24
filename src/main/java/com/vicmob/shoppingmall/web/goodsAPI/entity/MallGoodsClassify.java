package com.vicmob.shoppingmall.web.goodsAPI.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class MallGoodsClassify implements Serializable {
    @ApiModelProperty(name= "classifyid",value ="分类id")
    private Integer classifyid;
    @ApiModelProperty(name= "minaid",value ="平台id")
    private Integer minaid;
    @ApiModelProperty(name= "classifyname",value ="分类名称")
    private String classifyname;
    @ApiModelProperty(name= "sort",value ="分类排序")
    private Integer sort;

}