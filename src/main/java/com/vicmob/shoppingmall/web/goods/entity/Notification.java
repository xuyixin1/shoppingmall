package com.vicmob.shoppingmall.web.goods.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.vicmob.shoppingmall.constant.Constant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description= "商家信息")
@Data
public class Notification {

    private Integer notificationId;
    @ApiModelProperty(value = "小程序id",required = true)
    @NotNull(message ="小程序id不能为空")
    private Integer minaId;
    @ApiModelProperty(value = "code",required = true)
    @NotEmpty(message ="code不能为空")
    private String code;
    @ApiModelProperty(value = "openId")
    private String openId;
    //  状态
    private Constant.SendFlag sendFlag;

}
