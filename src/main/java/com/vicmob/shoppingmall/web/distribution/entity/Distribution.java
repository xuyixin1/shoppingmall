package com.vicmob.shoppingmall.web.distribution.entity;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.vicmob.shoppingmall.annotation.Number;
import com.vicmob.shoppingmall.constant.CommissionConstant;
import com.vicmob.shoppingmall.constant.Constant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @author  xuyx
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description="分销设置表")
@Data
public class Distribution {
    @ApiModelProperty(value = "主键id,更新时必填")
    private Integer distributionId;
    @ApiModelProperty(value = "商品id")
    private Integer goodsId;
    @ApiModelProperty(value = "小程序id")
    private Integer minaId;
    @NotNull
    @ApiModelProperty(value = "分销模式")
    private CommissionConstant.CommissionMode commissionMode;
    @Number
    @ApiModelProperty(value = "固定值")
    private BigDecimal fixedCommission;
    @Number(max="99.99")
    @ApiModelProperty(value = "百分比")
    private BigDecimal percentageCommission;

    public String check(){
        if(commissionMode == CommissionConstant.CommissionMode.FIXED){
            if (fixedCommission == null || percentageCommission != null){
                return "佣金模式不匹配";
            }
        }
        if(commissionMode == CommissionConstant.CommissionMode.PERCENTAGE){
            if (fixedCommission != null || percentageCommission == null){
                return "佣金模式不匹配";
            }
        }
        return null;
    }
}
