package com.vicmob.shoppingmall.web.goods.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description= "商品属性")
public class GoodsAttribute {
    @ApiModelProperty(value = "小程序id",required = true)
    @NotNull(message ="小程序id不能为空")
    private Integer minaId;
    @ApiModelProperty(value = "二级分类id",required = true)
    @NotNull(message ="二级分类id不能为空")
    @Min(value = 1,message ="二级分类id不能小于1")
    private Integer secondClassifyId;
    @ApiModelProperty(value = "商品属性id，更新时必填")
    private Integer attributeId;
    @ApiModelProperty(value = "商品属性名称",required = true)
    @NotBlank(message ="商品属性名称不能为空")
    private String attributeName;
    @ApiModelProperty(value = "商品属性值",required = true)
    @NotEmpty(message ="商品属性值不能为空")
    private String attributeValues;

    public Integer getMinaId() {
        return minaId;
    }

    public void setMinaId(Integer minaId) {
        this.minaId = minaId;
    }

    public Integer getSecondClassifyId() {
        return secondClassifyId;
    }

    public void setSecondClassifyId(Integer secondClassifyId) {
        this.secondClassifyId = secondClassifyId;
    }

    public Integer getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(Integer attributeId) {
        this.attributeId = attributeId;
    }


    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeValues() {
        return attributeValues;
    }

    public void setAttributeValues(String attributeValues) {
        this.attributeValues = attributeValues;
    }

    @Override
    public String toString() {
        return "GoodsAttribute{" +
                "minaId=" + minaId +
                ", secondClassifyId=" + secondClassifyId +
                ", attributeId=" + attributeId +
                ", attributeName='" + attributeName + '\'' +
                ", attributeValues='" + attributeValues + '\'' +
                '}';
    }
}
