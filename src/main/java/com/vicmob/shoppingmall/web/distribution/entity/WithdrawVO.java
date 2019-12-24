package com.vicmob.shoppingmall.web.distribution.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.vicmob.shoppingmall.annotation.Number;
import com.vicmob.shoppingmall.annotation.Phone;
import com.vicmob.shoppingmall.constant.CommissionConstant;
import com.vicmob.shoppingmall.web.goodsAPI.model.PageRecord;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author  xuyx
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description="提现vo")
@Data
public class WithdrawVO {
    @NotEmpty
    @ApiModelProperty(value="小程序id",name="minaStr")
    private String minaStr;
    @NotEmpty
    @ApiModelProperty(value="appId",name="appId")
    private String appId;
    @NotEmpty
    @ApiModelProperty(value = "openId")
    private String distributionUser;
    @NotEmpty
    @ApiModelProperty(value = "用户名")
    private String userName;
    @NotNull
    @Phone
    @ApiModelProperty(value = "电话号码")
    private String phone;
    @NotNull
    @Number(min = "1")
    @ApiModelProperty(value = "提现申请金额")
    private BigDecimal cashApply;
}
