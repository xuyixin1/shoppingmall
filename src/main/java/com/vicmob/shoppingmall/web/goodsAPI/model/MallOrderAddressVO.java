package com.vicmob.shoppingmall.web.goodsAPI.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MallOrderAddressVO implements Serializable {
    @ApiModelProperty(name = "addressid",value = "订单地址id")
    private Integer addressid;
    @ApiModelProperty(name = "customerid",value = "粉丝id")
    private Integer customerid;
    @ApiModelProperty(name = "name",value = "姓名")
    private String name;
    @ApiModelProperty(name = "mobilephone",value = "手机号")
    private String mobilephone;
    @ApiModelProperty(name = "isdefault",value = "是否是默认地址(0:不是;1:是)")
    private Integer isdefault;
    @ApiModelProperty(name = "provinces",value = "省市区街道")
    private String provinces;
    @ApiModelProperty(name = "address",value = "详细地址")
    private String address;
    @ApiModelProperty(name = "minaStr",value = "小程序id")
    private String minaStr;
    @ApiModelProperty(name = "appId",value = "appId")
    private String appId;

}