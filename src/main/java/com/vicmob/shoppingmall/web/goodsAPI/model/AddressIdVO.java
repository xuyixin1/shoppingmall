package com.vicmob.shoppingmall.web.goodsAPI.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AddressIdVO implements Serializable {
    @ApiModelProperty(value="地址Id",name="addressId")
    private Integer addressId;

}