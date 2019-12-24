package com.vicmob.shoppingmall.web.distribution.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.vicmob.shoppingmall.constant.CommissionConstant;
import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.AesEncrypt;
import com.vicmob.shoppingmall.utils.ResultData;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author  xuyx
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description="提现表")
@Data
public class Withdraw {
    @ApiModelProperty(value = "主键id")
    private Integer id ;
    @ApiModelProperty(value = "小程序id")
    private Integer minaId ;
    @ApiModelProperty(value = "openId")
    private String distributionUser;
    @ApiModelProperty(value = "提现单号")
    private String withdrawNo;
    @ApiModelProperty(value = "用户名")
    private String userName;
    @ApiModelProperty(value = "电话号码")
    private String phone;
    @ApiModelProperty(value = "提现申请金额")
    private BigDecimal cashApply;
    @ApiModelProperty(value = "佣金提现手续费（满足免手续费条件插入0.00")
    private BigDecimal commissionApply;
    @ApiModelProperty(value = "申请时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date applyTime;
    @ApiModelProperty(value = "审核未通过理由）")
    private String reason;
    @ApiModelProperty(value = "审核时间（通过或驳回）")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date auditTime;
    @ApiModelProperty(value = "打款时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date payTime;
    @ApiModelProperty(value = "状态")
    private CommissionConstant.WithdrawStatus status;

    public void fill(WithdrawVO withdrawVO) throws Exception{
        String minaStr = AesEncrypt.aesDecryption(withdrawVO.getAppId(), withdrawVO.getMinaStr());
        if (StringUtils.isEmpty(minaStr)){
            throw new Exception("minaId解析失败");
        }
        this.minaId = Integer.valueOf(minaStr);
        this.distributionUser = withdrawVO.getDistributionUser();
        this.userName = withdrawVO.getUserName();
        this.phone = withdrawVO.getPhone();
        this.cashApply = withdrawVO.getCashApply();
        this.applyTime = new Date();
        this.status = CommissionConstant.WithdrawStatus.TO_BE_AUDITED;
    }

}
