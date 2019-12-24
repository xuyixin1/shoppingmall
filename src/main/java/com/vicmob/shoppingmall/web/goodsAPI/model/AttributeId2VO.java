package com.vicmob.shoppingmall.web.goodsAPI.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class AttributeId2VO implements Serializable {
    @ApiModelProperty(value="商品属性id2",name="attributeid2")
    private Integer attributeid2;
    @ApiModelProperty(value="商品属性名称2",name="attributeidname2")
    private String attributeidname2;
    @ApiModelProperty(value="商品属性值2",name="attributevaluename2")
    private String attributevaluename2;
}