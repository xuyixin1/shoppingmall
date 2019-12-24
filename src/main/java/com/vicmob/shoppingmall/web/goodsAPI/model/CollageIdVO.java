package com.vicmob.shoppingmall.web.goodsAPI.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class CollageIdVO implements Serializable {
    @ApiModelProperty(value="collageId",name="拼团id")
    private Integer collageId;
}