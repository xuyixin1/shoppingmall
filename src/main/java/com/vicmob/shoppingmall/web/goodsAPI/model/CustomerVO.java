package com.vicmob.shoppingmall.web.goodsAPI.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomerVO {
    @ApiModelProperty(value="客户id",name="customerId")
    private Integer customerId;
    @ApiModelProperty(value="微信昵称",name="nickName")
    private String nickName;
    @ApiModelProperty(value="微信头像",name="avatar")
    private String avatar;
}
