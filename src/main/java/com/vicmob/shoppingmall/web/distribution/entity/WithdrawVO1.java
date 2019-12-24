package com.vicmob.shoppingmall.web.distribution.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.vicmob.shoppingmall.annotation.NotNullMin;
import com.vicmob.shoppingmall.constant.CommissionConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.util.StringUtils;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description="提现更改状态vo1")
@Data
public class WithdrawVO1 {
    @NotNullMin
    @ApiModelProperty(value = "minaId")
    private Integer minaId;
    @NotEmpty
    @ApiModelProperty(value = "主键")
    private String withdrawNo;
    @NotNull
    @ApiModelProperty(value = "状态")
    private CommissionConstant.WithdrawStatus status;
    @ApiModelProperty(value = "审核未通过理由）")
    private String reason;

    public String check(){
        if(this.status != CommissionConstant.WithdrawStatus.UNPASSED && this.status != CommissionConstant.WithdrawStatus.TO_BE_PAY){
            return "非法的状态";
        }
        if (this.status == CommissionConstant.WithdrawStatus.UNPASSED){
            if(StringUtils.isEmpty(this.reason)){
                return "拒绝申请请填写拒绝理由";
            }
        }
        return null;
    }

    public String payCheck(){
        if(this.status != CommissionConstant.WithdrawStatus.PAYED){
            return "非法的状态";
        }
        return null;
    }

    public String businessCheck(){
        if(this.status != CommissionConstant.WithdrawStatus.PAYED && this.status != CommissionConstant.WithdrawStatus.UNPASSED){
            return "非法的状态";
        }
        return null;
    }
}
