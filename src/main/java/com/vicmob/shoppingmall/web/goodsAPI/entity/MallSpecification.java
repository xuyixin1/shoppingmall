package com.vicmob.shoppingmall.web.goodsAPI.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
@Data
public class MallSpecification implements Serializable {
    @ApiModelProperty(name= "specid",value ="商品属性id")
    private Integer specid;
    @ApiModelProperty(name= "minaid",value ="平台id")
    private Integer minaid;
    @ApiModelProperty(name= "goodsid",value ="商品id")
    private Integer goodsid;
    @ApiModelProperty(name= "attributeid1",value ="属性1")
    private Integer attributeid1;
    @ApiModelProperty(name= "attributeidname1",value ="属性1名称")
    private String attributeidname1;
    @ApiModelProperty(name= "attributevaluename1",value ="属性1值")
    private String attributevaluename1;
    @ApiModelProperty(name= "attributeid2",value ="属性2")
    private Integer attributeid2;
    @ApiModelProperty(name= "attributeidname2",value ="属性2名称")
    private String attributeidname2;
    @ApiModelProperty(name= "attributevaluename2",value ="属性2值")
    private String attributevaluename2;
    @ApiModelProperty(name= "price",value ="价格")
    private BigDecimal price;
    @ApiModelProperty(name= "stock",value ="库存")
    private Integer stock;

}