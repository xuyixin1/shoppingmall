package com.vicmob.shoppingmall.web.goods.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description= "商品一级分类")
@Data
public class GoodsClassify {
    @NotNull(message ="小程序id不能为空")
    @ApiModelProperty(value = "小程序id",required = true)
    private Integer minaId;
    @ApiModelProperty(value = "一级分类id,更新时必填")
    private Integer classifyId;
    @ApiModelProperty(value = "商品一级分类名称",required = true)
    @NotBlank(message ="商品一级分类名称不能为空")
    private String classifyName;
    @ApiModelProperty(value = "排序",required = true)
    @NotNull(message ="排序不能为空")
    @Min(value = 1,message ="排序不能小于1")
    private Integer sort;
    private Integer secondClassifyCount;
    private Integer goodsCount;

}
