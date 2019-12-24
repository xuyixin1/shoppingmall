package com.vicmob.shoppingmall.web.distribution.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.vicmob.shoppingmall.annotation.Number;
import com.vicmob.shoppingmall.constant.CommissionConstant;
import com.vicmob.shoppingmall.constant.Constant;
import com.vicmob.shoppingmall.web.goods.entity.Goods;
import com.vicmob.shoppingmall.web.goods.entity.Order;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @author  xuyx
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel(description="分销记录表")
@Data
public class CommissionRecord {
    @ApiModelProperty(value = "主键id")
    private Integer id;
    @ApiModelProperty(value = "小程序id")
    private Integer minaId;
    @ApiModelProperty(value = "订单编号")
    private String orderNumber;
    @ApiModelProperty(value = "商品id")
    private Integer goodsId;
    @ApiModelProperty(value = "商品名称")
    private String goodsName;
    @ApiModelProperty(value = "图片url")
    private String picUrl;
    @ApiModelProperty(value = "分销模式")
    private CommissionConstant.CommissionMode commissionMode;
    @ApiModelProperty(value = "固定值")
    private BigDecimal fixedCommission;
    @ApiModelProperty(value = "百分比")
    private BigDecimal percentageCommission;
    @ApiModelProperty(value = "商品总价")
    private BigDecimal totalMoney;
    @ApiModelProperty(value = "实付金额")
    private BigDecimal payMoney;
    @ApiModelProperty(value = "佣金")
    private BigDecimal commission;
    @ApiModelProperty(value = "佣金状态")
    private CommissionConstant.CommissionStatus status;
    @ApiModelProperty(value = "分销的用户openId")
    private String distributionUser;
    @ApiModelProperty(value = "订单拥有者openId")
    private String openId;
    @ApiModelProperty(value = "订单拥有者nickNmae")
    private String nickName;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "订单结束时间")
    private Date date;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "订单支付时间")
    private Date payDate;

    public void fill(Order order, Goods goods) throws Exception{
        this.minaId = order.getMinaId();
        this.orderNumber = order.getOrderNumber();
        this.goodsId = goods.getGoodsId();
        this.goodsName = goods.getGoodsName();
        this.picUrl = goods.getPicUrl();
        this.commissionMode = goods.getDistribution().getCommissionMode();
        this.fixedCommission = goods.getDistribution().getFixedCommission();
        this.percentageCommission = goods.getDistribution().getPercentageCommission();
        this.totalMoney = order.getTotalMoney();
        this.payMoney = order.getTotalMoney();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(order.getOrderPayTime());
        this.payDate = date;

    }
}
