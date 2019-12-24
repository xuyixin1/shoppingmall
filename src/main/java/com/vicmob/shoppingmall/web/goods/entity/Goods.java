package com.vicmob.shoppingmall.web.goods.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.vicmob.shoppingmall.constant.Constant;
import com.vicmob.shoppingmall.web.distribution.entity.Distribution;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description= "商品")
@Data
public class Goods  {
	// 商品主键
	@ApiModelProperty(value = "商品id，更新时必填")
	private Integer goodsId;
	@ApiModelProperty(value = "小程序id",required = true)
	@NotNull(message ="小程序id不能为空")
	private Integer minaId;
	@ApiModelProperty(value = "一级分类id",required = true)
	@NotNull(message ="一级分类id不能为空")
	@Min(value = 1,message ="一级分类id不能小于1")
	private Integer classifyId;
	@ApiModelProperty(value = "一级分类名称（后台字段）")
	private String  classifyName;
	@ApiModelProperty(value = "二级分类id",required = true)
	@NotNull(message ="二级分类id不能为空")
	@Min(value = 1,message ="二级分类id不能小于1")
	private Integer secondClassifyId;
	@ApiModelProperty(value = "二级分类名称（后台字段）")
	private String secondClassifyName;
	@ApiModelProperty(value = "展示价格",required = true)
	@NotNull(message ="展示价格不能为空")
	@DecimalMin(value="0",message = "展示价格不能低于0")
	private BigDecimal showPrice;
	@ApiModelProperty(value = "商品名称",required = true)
	@NotBlank(message ="商品名称不能为空")
	private String goodsName;
	@ApiModelProperty(value = "商品图片url",required = true)
	@NotBlank(message ="商品图片不能为空")
	private String picUrl;
    @NotBlank(message ="商品详情图片不能为空")
	@ApiModelProperty(value = "商品详情图片url")
	private String detailPicUrl;
	@ApiModelProperty(value = "已卖出数量")
	private Integer sailed;
	@ApiModelProperty(value = "标签（热卖）")
	private String label;
	@ApiModelProperty(value = "商品上下架状态",required = true)
	@NotNull(message ="商品上下架状态不能为空")
	private Constant.SaleFlag saleFlag;
	@ApiModelProperty(value = "排序",required = true)
	@NotNull(message ="排序不能为空")
	@Min(value = 1,message ="排序不能小于1")
	private Integer sort;
	@ApiModelProperty(value = "商品描述")
	private String description;
	@ApiModelProperty(value = "删除标记（后台字段）")
	private Constant.DeleteFlag deleteFlag;
    @Valid
	@NotNull(message ="商品规格不能为空")
	@Size(min = 1,message ="商品规格不能小于1")
	private List<Specification> specifications;
	@ApiModelProperty(value = "参数（json）")
	private String parameters;
    @ApiModelProperty(value = "是否首页展示")
    private Constant.Flag showFlag;
    @NotNull
    @ApiModelProperty(value = "是否参与分销")
    private Constant.Flag distributionFlag;
    @Valid
    @ApiModelProperty(value = "分销设置")
    private Distribution distribution;
    @ApiModelProperty(value = "拼团已售")
    private Integer collageSailed;
    @ApiModelProperty(value = "拼团标志")
    private Integer collageFlag;
    @ApiModelProperty(value = "佣金")
    private BigDecimal commission;


    public void fillDistribution(){
        this.distribution.setGoodsId(this.goodsId);
        this.distribution.setMinaId(this.minaId);
    }
}
