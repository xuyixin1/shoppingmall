package com.vicmob.shoppingmall.web.goods.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class GoodsDetail {
    private Integer goodsId;
    private Integer num;
    private String goodsName;
    private String picture;
    private BigDecimal price ;
    private Integer specId;
}
