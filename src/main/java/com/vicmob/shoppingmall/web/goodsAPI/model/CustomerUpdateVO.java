package com.vicmob.shoppingmall.web.goodsAPI.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class CustomerUpdateVO implements Serializable {
    @ApiModelProperty(value="地址Id",name="addressId")
    @NotNull(message="地址Id不能为空")
    private Integer addressId;
    @ApiModelProperty(value="粉丝Id",name="customerId")
    private Integer customerId;
    @ApiModelProperty(value="小程序id",name="minaStr")
    private String minaStr;
    @ApiModelProperty(value="appId",name="appId")
    private String appId;
    @ApiModelProperty(value="是否是默认地址(0:不是;1:是)",name="isDefault")
    private Integer isDefault;
    @ApiModelProperty(value="是否是默认地址",name="minaId",hidden = true)
    private Integer minaId;
}