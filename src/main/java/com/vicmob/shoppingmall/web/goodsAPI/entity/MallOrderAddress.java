package com.vicmob.shoppingmall.web.goodsAPI.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class MallOrderAddress implements Serializable {
    @ApiModelProperty(name= "addressid",value ="收货地址id")
    private Integer addressid;
    @ApiModelProperty(name= "minaid",value ="平台id")
    private Integer minaid;
    @ApiModelProperty(name= "customerid",value ="粉丝id")
    private Integer customerid;
    @ApiModelProperty(name= "name",value ="收货人姓名")
    private String name;
    @ApiModelProperty(name= "mobilephone",value ="收货人手机")
    private String mobilephone;
    @ApiModelProperty(name= "isdefault",value ="是否是默认地址(0:不是;1:是)")
    private Integer isdefault;
    @ApiModelProperty(name= "provinces",value ="省市区街道")
    private String provinces;
    @ApiModelProperty(name= "address",value ="详细地址")
    private String address;
    @ApiModelProperty(name= "createdate",value ="创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createdate;
    @ApiModelProperty(name= "deleteflag",value ="删除标识(0:不删除;1:删除)")
    private Integer deleteflag;

}