package com.vicmob.shoppingmall.web.goodsAPI.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
@Data
public class MallOrder implements Serializable {
    @ApiModelProperty(name= "orderid",value ="订单id")
    private Integer orderid;
    @ApiModelProperty(name= "minaid",value ="平台id")
    private Integer minaid;
    @ApiModelProperty(name= "customerid",value ="粉丝id")
    private Integer customerid;
    @ApiModelProperty(name= "paytype",value ="支付方式（现阶段只用微信支付）0：微信支付")
    private Integer paytype;
    @ApiModelProperty(name= "ordernumber",value ="订单编号")
    private String ordernumber;
    @ApiModelProperty(name= "collageno",value ="拼团单号")
    private String collageno;
    @ApiModelProperty(name= "name",value ="联系人")
    private String name;
    @ApiModelProperty(name= "phonenumber",value ="联系方式")
    private String phonenumber;
    @ApiModelProperty(name= "deliverymoney",value ="配送费用")
    private BigDecimal deliverymoney;
    @ApiModelProperty(name= "totalmoney",value ="总价")
    private BigDecimal totalmoney;
    @ApiModelProperty(name= "cancelreason",value ="用户取消订单理由")
    private String cancelreason;
    @ApiModelProperty(name= "refusereason",value ="商家拒绝退款理由")
    private String refusereason;
    @ApiModelProperty(name= "drawbackreason",value ="用户退款理由")
    private String drawbackreason;
    @ApiModelProperty(name= "orderstatus",value ="订单状态（0 :待支付、1：已支付、2：已完成、3：已超时、4：已取消、5：退款申请、6：退款成功、7.退款失败，8：拒绝退款，9：退款中，10支付中）")
    private Integer orderstatus;
    @ApiModelProperty(name= "remarks",value ="备注")
    private String remarks;
    @ApiModelProperty(name= "orderstarttime",value ="下单时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date orderstarttime;
    @ApiModelProperty(name= "orderpaytime",value ="支付时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date orderpaytime;
    @ApiModelProperty(name= "orderrefundtime",value ="申请退款时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date orderrefundtime;
    @ApiModelProperty(name= "orderendtime",value ="订单完成时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date orderendtime;
    @ApiModelProperty(name= "prepayid",value ="支付场景下，为本次支付的 prepay_id")
    private String prepayid;
    @ApiModelProperty(name= "formid",value ="表单提交场景下，为 submit 事件带上的 form_id")
    private String formid;
    @ApiModelProperty(name= "isevaluate",value ="是否评价（0：未评价；1：已评价）")
    private Integer isevaluate;
    @ApiModelProperty(name= "employeeid",value ="员工ID")
    private Integer employeeid;
    @ApiModelProperty(name= "deleteflag",value ="删除标识（0:不删除;1;删除）")
    private Integer deleteflag;
    @ApiModelProperty(name= "distributionuser",value ="（分销的用户fansId）")
    private Integer distributionuser;

}