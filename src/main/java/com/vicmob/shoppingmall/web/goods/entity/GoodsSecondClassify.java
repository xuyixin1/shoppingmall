package com.vicmob.shoppingmall.web.goods.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description= "商品二级分类")
@Data
public class GoodsSecondClassify {
    @NotNull(message ="小程序id不能为空")
    @ApiModelProperty(value = "小程序id",required = true)
    private Integer minaId;
    @NotNull(message ="一级分类id不能为空")
    @Min(value = 1,message ="一级分类id不能小于1")
    @ApiModelProperty(value = "一级分类id",required = true)
    private Integer classifyId;
    @ApiModelProperty(value = "二级分类id ,更新必填")
    private Integer secondClassifyId;
    @NotBlank(message ="商品二级分类名称不能为空")
    @ApiModelProperty(value = "商品二级分类",required = true)
    private String  secondClassifyName;
    @NotBlank(message ="商品图片url不能为空")
    @ApiModelProperty(value = "商品图片url",required = true)
    private String  classifyPictureUrl;
    private List<GoodsAttribute> goodsAttribute;
    @NotNull(message ="排序不能为空")
    @Min(value = 1,message ="排序不能小于1")
    @ApiModelProperty(value = "排序",required = true)
    private Integer sort;
    @ApiModelProperty(value = "商品数量")
    private Integer goodsCount;

}
