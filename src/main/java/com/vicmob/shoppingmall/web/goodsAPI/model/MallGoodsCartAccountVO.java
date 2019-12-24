package com.vicmob.shoppingmall.web.goodsAPI.model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Data
public class MallGoodsCartAccountVO implements Serializable {
    @ApiModelProperty(value = "小程序id", name = "minaStr")
    private String minaStr;
    @ApiModelProperty(value = "appId", name = "appId")
    private String appId;
    @ApiModelProperty(value = "粉丝id", name = "customerid")
    private Integer customerid;
    @ApiModelProperty(value = "下单商品详情", name = "goodsdetails")
    private String goodsdetails;
    @ApiModelProperty(value = "总价", name = "totalmoney")
    private String totalmoney;
    @ApiModelProperty(value = "员工id", name = "employeeid")
    private Integer employeeid;
    @ApiModelProperty(value = "购物车id集合", name = "cartIds")
    private List<Integer> cartIds;

}