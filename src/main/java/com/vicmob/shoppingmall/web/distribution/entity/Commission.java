package com.vicmob.shoppingmall.web.distribution.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.vicmob.shoppingmall.constant.CommissionConstant;
import com.vicmob.shoppingmall.annotation.Number;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
 * @author  xuyx
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description="佣金基础设置表")
@Data
public class Commission {
    @ApiModelProperty(value = "主键id,更新时必填")
    private Integer commissionId;
    @NotNull
    @Min(value = 1)
    @ApiModelProperty(value = "minaId",required = true)
    private Integer minaId;
    @NotNull
    @Number(min="1")
    @ApiModelProperty(value = "最低提现金额",required = true)
    private BigDecimal minLimit;
    @NotNull
    @Number(min="1")
    @ApiModelProperty(value = "最高提现金额",required = true)
    private BigDecimal maxLimit;
    @NotNull
    @Range(min=1,max=5)
    @ApiModelProperty(value = "每日提现次数",required = true)
    private Integer numberLimit;
    @NotNull
    @Number
    @ApiModelProperty(value = "分销最低佣金",required = true)
    private BigDecimal minAmount;
    @NotNull
    @ApiModelProperty(value = "佣金计算方式",required = true)
    private CommissionConstant.CalculateMode calculateMode;
    @NotNull
    @Number(min = "0",max="99.99")
    @ApiModelProperty(value = "佣金提现手续费",required = true)
    private BigDecimal serviceCharge;
    @NotNull
    @Number(min = "0",message = "freeCommissionAmount error")
    @ApiModelProperty(value = "免手续费提现佣金金额",required = true)
    private BigDecimal freeAmount;
    @NotNull
    @Range(min=0, max=15)
    @ApiModelProperty(value = "结算天数")
    private Integer clearingDays;

    //验证参数
    public String check(){
        if (this.maxLimit.compareTo(this.minLimit) == -1){
            return "最高提现金额不能小于最低提现金额";
        }
        return null;
    }

    public String updateCheck(){
        if (this.commissionId == null || this.commissionId < 1 ){
            return "commissionId不能为空或小于1";
        }
        return check();
    }
}


