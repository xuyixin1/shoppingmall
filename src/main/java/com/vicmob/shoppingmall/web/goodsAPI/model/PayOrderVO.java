package com.vicmob.shoppingmall.web.goodsAPI.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class PayOrderVO implements Serializable {
    @ApiModelProperty(name = "orderId",value = "订单id")
    private Integer orderId;
    @ApiModelProperty(name = "customerId",value = "粉丝id")
    private Integer customerId;
    @ApiModelProperty(name= "collageActivityId",value ="拼团活动id")
    private String collageActivityId;
    @ApiModelProperty(name = "employeeId",value = "员工id")
    private Integer employeeId;
    @ApiModelProperty(name = "minaStr",value = "小程序id")
    private String minaStr;
    @ApiModelProperty(name = "appId",value = "appId")
    private String appId;
    @ApiModelProperty(name = "orderNumber",value = "订单编号")
    private String orderNumber;
    @ApiModelProperty(name = "collageNo",value = "团单号(唯一的不重复)")
    private String collageNo;
    @ApiModelProperty(name = "goodsDetails",value = "商品详情")
    private String goodsDetails;
    @ApiModelProperty(name = "addressDetails",value = "收货地址详情")
    private String addressDetails;
    @ApiModelProperty(name = "totalMoney",value = "总价")
    private BigDecimal totalMoney;
    @ApiModelProperty(name = "remarks",value = "备注")
    private String remarks;
    @ApiModelProperty(name = "type",value = "生成订单类型(0:商品详情,1:购物车)")
    private String type;
    @ApiModelProperty(name = "goodsIdList",value = "商品id的集合")
    private List<Integer> goodsIdList;
    @ApiModelProperty(name = "formId",value = "表单提交场景下，为 submit 事件带上的 form_id")
    private String formId;
    @ApiModelProperty(name = "deliveryMoney",value = "配送费用")
    private BigDecimal deliveryMoney;
    @ApiModelProperty(name = "collageFlag",value = "是否是拼团商品(0:不是;1:是)")
    private Integer collageFlag;
    @ApiModelProperty(name= "distributionUser",value ="（分销的用户fansId）")
    private Integer distributionUser;
    @ApiModelProperty(name= "distributionUser",value ="（分销的用户fansId）")
    private Integer collage;

}