package com.vicmob.shoppingmall.web.goodsAPI.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class MallGoodsCollageVO implements Serializable {
    @ApiModelProperty(value="拼团记录id",name="collageId")
    private Integer collageId;
    @ApiModelProperty(value="团单号(唯一的不重复)",name="collageNo")
    private String collageNo;
    @ApiModelProperty(value="拼团活动名称",name="collageActivityName")
    private String collageActivityName;
    @ApiModelProperty(value="订单编号",name="orderNumber")
    private String orderNumber;
    @ApiModelProperty(value="商品名称",name="goodsName")
    private String goodsName;
    @ApiModelProperty(value="发起拼团时间",name="collageStartDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date collageStartDate;
    @ApiModelProperty(value="拼团结束时间",name="collageEndtDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date collageEndDate;
    @ApiModelProperty(value="成团有效时间",name="collageValidDate")
    private Integer collageValidDate;
    @ApiModelProperty(value="成团人数",name="collageActivityPeople")
    private Integer collageActivityPeople;
    @ApiModelProperty(value="已成团人数",name="alCollagePeople")
    private Integer alCollagePeople;
    @ApiModelProperty(value="成团状态",name="collageStatus")
    private Integer collageStatus;

}