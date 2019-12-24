package com.vicmob.shoppingmall.web.goods.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.vicmob.shoppingmall.constant.Constant;
import lombok.Data;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Specification  {
	// 主键ID
	private Integer specId;
	// 小程序平台ID
	@NotNull(message ="小程序id不能为空")
	private Integer minaId;
	// 商品Id
	private Integer goodsId;
	@NotNull(message = "属性id不能为空")
	@Min(value=1,message = "属性id不能低于1")
	private Integer attributeId1;
	@NotEmpty(message = "属性名不能为空")
	private String  attributeIdName1;
	@NotEmpty(message = "属性值不能为空")
	private String  attributeValueName1;
	private Integer  attributeId2;
	private String  attributeIdName2;
	//属性值名字2
	private String  attributeValueName2;
	@NotNull(message = "价格不能为空")
	@DecimalMin(value="0",message = "商品价格不能低于0")
	// 价格
	private BigDecimal price;
	@NotNull(message = "商品库存不能为空")
	@Min(value=-1,message = "商品库存不能低于-1")
	// 库存
	private Integer stock;
	@JsonIgnore
    private Constant.DeleteFlag deleteFlag;

}
