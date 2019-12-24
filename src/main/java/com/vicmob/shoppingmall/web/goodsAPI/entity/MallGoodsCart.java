package com.vicmob.shoppingmall.web.goodsAPI.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class MallGoodsCart implements Serializable {
    @ApiModelProperty(name = "cartid",value = "购物车id")
    private Integer cartid;
    @ApiModelProperty(name = "customerid",value = "粉丝id")
    private Integer customerid;
    @ApiModelProperty(name = "minaid",value = "小程序id")
    private Integer minaid;
    @ApiModelProperty(name = "goodsid",value = "商品id")
    private Integer goodsid;
    @ApiModelProperty(name = "goodsname",value = "商品名称")
    private String goodsname;
    @ApiModelProperty(name = "picurl",value = "商品图片")
    private String picurl;
    @ApiModelProperty(name = "specid",value = "规格id")
    private Integer specid;
    @ApiModelProperty(name = "goodsnum",value = "商品数量")
    private Integer goodsnum;
    @ApiModelProperty(name = "goodsprice",value = "商品价格")
    private BigDecimal goodsprice;
    @ApiModelProperty(name = "deleteflag",value = "删除标识(0:不删除;1:删除)")
    private Integer deleteflag;
    @ApiModelProperty(name = "createdate",value = "加入购物车时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createdate;

}