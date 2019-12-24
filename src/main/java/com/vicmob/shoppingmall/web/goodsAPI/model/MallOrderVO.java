package com.vicmob.shoppingmall.web.goodsAPI.model;

import com.vicmob.shoppingmall.web.goodsAPI.entity.MallOrderWithBLOBs;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MallOrderVO extends MallOrderWithBLOBs {
    @ApiModelProperty(value="成团状态",name="collagestatus")
    private Integer collagestatus;
}