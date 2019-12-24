package com.vicmob.shoppingmall.web.goodsAPI.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class MallGoodsCollageActivityParamVO implements Serializable {
    @ApiModelProperty(value="商品规格id",name="specId")
    private Integer specId;
    @ApiModelProperty(value="属性值1",name="attributeValueName1")
    private String attributeValueName1;
    @ApiModelProperty(value="属性值2",name="attributeValueName2")
    private String attributeValueName2;
    @ApiModelProperty(name= "price",value ="价格")
    private BigDecimal price;
    @ApiModelProperty(name= "stock",value ="库存")
    private Integer stock;
    @ApiModelProperty(value="拼团价格",name="collageActivityPrice")
    private BigDecimal collageActivityPrice;


}