package com.vicmob.shoppingmall.web.goodsAPI.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class OrderQueryVO implements Serializable {
    @ApiModelProperty(name = "customerId",value = "粉丝id")
    private Integer customerId;
    @ApiModelProperty(name = "orderstatus",value = "订单状态（0 :待支付、1：已支付、2：已完成、3：已超时、4：已取消、5：退款中、6：已退款、7.拒绝退款，8：待成团，9：成团失败）")
    private Integer orderstatus;
    @ApiModelProperty(name = "minaStr",value = "小程序id")
    private String minaStr;
    @ApiModelProperty(name = "appId",value = "appId")
    private String appId;
    @ApiModelProperty(name = "orderId",value = "订单id")
    private Integer orderId;
    @ApiModelProperty(value="page",name="分页参数")
    private PageRecord page;
}