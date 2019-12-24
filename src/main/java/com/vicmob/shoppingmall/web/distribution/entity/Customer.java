package com.vicmob.shoppingmall.web.distribution.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author  xuyx
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description="分销用户表")
@Data
public class Customer {
    private Integer customerId;
    private Integer minaId;
    private String openId;
    private String nickName;
    private String avatar;
    @ApiModelProperty(value = "总计佣金（注：==可提现佣金+已提现的+申请中")
    private BigDecimal totalCommission;
    @ApiModelProperty(value = "可提现佣金")
    private BigDecimal canWithdraw;
    @ApiModelProperty(value = "已提现的")
    private BigDecimal withdrawed;
    @ApiModelProperty(value = "申请中")
    private BigDecimal apply;
    @ApiModelProperty(value = "申请提现次数")
    private Integer applyNumber;
    @ApiModelProperty(value = "未入账金额")
    private BigDecimal unBookCommission;

}
