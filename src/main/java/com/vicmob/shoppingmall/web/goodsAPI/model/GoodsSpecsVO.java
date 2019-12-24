package com.vicmob.shoppingmall.web.goodsAPI.model;

import com.vicmob.shoppingmall.web.goodsAPI.entity.MallSpecification;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class GoodsSpecsVO implements Serializable {
    @ApiModelProperty(name= "highPrice",value ="商品最高价格")
    private BigDecimal highPrice;
    @ApiModelProperty(name= "lowPrice",value ="商品最低价格")
    private BigDecimal lowPrice;
    @ApiModelProperty(name= "totalStock",value ="商品库存")
    private Integer totalStock;
    @ApiModelProperty(name= "MallSpecificationList",value ="规格列表")
    private List<MallSpecification> MallSpecificationList;
}