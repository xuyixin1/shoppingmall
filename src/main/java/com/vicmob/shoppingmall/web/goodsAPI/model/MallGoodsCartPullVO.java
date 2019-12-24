package com.vicmob.shoppingmall.web.goodsAPI.model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;

@Data
public class MallGoodsCartPullVO implements Serializable {
    @ApiModelProperty(value="商品id",name="goodsid")
    private Integer goodsid;
    @ApiModelProperty(value="商品名称",name="goodsname")
    private String goodsname;
    @ApiModelProperty(value="商品图片",name="picurl")
    private String picurl;
    @ApiModelProperty(value="商品价格",name="goodspirce")
    private Double goodsprice;
    @ApiModelProperty(value="小程序id",name="minaStr")
    private String minaStr;
    @ApiModelProperty(value="appId",name="appId")
    private String appId;
    @ApiModelProperty(value="粉丝id",name="customerid")
    private Integer customerid;
    @ApiModelProperty(value="商品规格id",name="specid")
    private Integer specid;
    @ApiModelProperty(value="商品数量",name="goodsnum")
    private Integer goodsnum;
}