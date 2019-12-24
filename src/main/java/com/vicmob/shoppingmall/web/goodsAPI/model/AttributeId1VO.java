package com.vicmob.shoppingmall.web.goodsAPI.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class AttributeId1VO implements Serializable {
    @ApiModelProperty(value="商品属性id1",name="attributeid1")
    private Integer attributeid1;
    @ApiModelProperty(value="商品属性名称1",name="attributeidname1")
    private String attributeidname1;
    @ApiModelProperty(value="商品属性值1",name="attributevaluename1")
    private String attributevaluename1;
}