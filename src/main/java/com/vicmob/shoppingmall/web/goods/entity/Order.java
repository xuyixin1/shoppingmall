package com.vicmob.shoppingmall.web.goods.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.vicmob.shoppingmall.constant.Constant;
import lombok.Data;

import java.math.BigDecimal;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Order {
    // 主键id
    private Integer orderId;
    // 小程序id
    private Integer minaId;
    // 粉丝id
    private Integer customerId;
    // 支付方式
    private Constant.PayType payType;
    // 订单编码
    private String orderNumber;
    // 团购编码
    private String collageNo;
    // 联系人（不一定粉丝本人）
    private String name;
    // 联系方式（不一定粉丝本人）
    private String phoneNumber;
    // 配送地址
    private String addressDetails;
    // 下单商品详情
    private String goodsDetails;
    // 配送费用
    private BigDecimal deliveryMoney;
    // 总价
    private BigDecimal totalMoney;
    // 商家取消订单理由
    private String cancelReason;
    // 商家拒绝退款理由
    private String refuseReason;
    // 用户申请退款理由
    private String drawbackReason;
    private Constant.OrderType orderStatus;
    // 备注
    private String remarks;
    // 下单时间
    private String orderStartTime;
    // 订单完成时间
    private String orderEndTime;
    // 订单支付时间
    private String orderPayTime;
    // 申请退款时间
    private String orderRefundTime;
    // 支付场景下，为本次支付的 prepay_id
    private String prepayId;
    // 表单提交场景下，为 submit 事件带上的 form_id
    private String formId;
    private Constant.EvaluateFlag evaluateFlag;
    // 员工ID
    private Integer employeeId;
    private Integer distributionUser;
    private Integer collageStatus;

}
