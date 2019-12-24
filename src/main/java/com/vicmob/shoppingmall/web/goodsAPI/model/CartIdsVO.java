package com.vicmob.shoppingmall.web.goodsAPI.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class CartIdsVO implements Serializable {
    @ApiModelProperty(value="购物车id的list集合",name="cartIds")
    private List<Integer> cartIds;

}