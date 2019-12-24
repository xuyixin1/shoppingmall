package com.vicmob.shoppingmall.web.goodsAPI.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;

@Data
public class EmployIdVO implements Serializable {
    @ApiModelProperty(value="商品id",name="goodsId")
    private Integer goodsId;
    @ApiModelProperty(value="employeeId",name="员工id")
    private Integer employeeId;
    @ApiModelProperty(value="粉丝Id",name="customerId")
    private Integer customerId;
    public EmployIdVO() {
    }

    public EmployIdVO(Integer goodsId, Integer employeeId,Integer customerId) {
        this.goodsId = goodsId;
        this.employeeId = employeeId;
        this.customerId = customerId;
    }
}