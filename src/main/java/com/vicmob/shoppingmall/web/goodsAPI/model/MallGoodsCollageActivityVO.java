package com.vicmob.shoppingmall.web.goodsAPI.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class MallGoodsCollageActivityVO implements Serializable {

    @ApiModelProperty(value="拼团活动id",name="collageActivityId")
    private String collageActivityId;
    @ApiModelProperty(value="商品id",name="goodsId")
    private Integer goodsId;
    @ApiModelProperty(value="拼团活动名称",name="collageActivityName")
    private String collageActivityName;
    @ApiModelProperty(value="商品名称",name="goodsName")
    private String goodsName;
    @ApiModelProperty(value="成团人数",name="collageActivityPeople")
    private Integer collageActivityPeople;
    @ApiModelProperty(value="拼团活动开始时间",name="activityStartDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date activityStartDate;
    @ApiModelProperty(value="拼团活动结束时间",name="activityEndDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date activityEndDate;
    @ApiModelProperty(value="成团有效时间",name="collageValidDate")
    private Integer collageValidDate;
    @ApiModelProperty(value="拼团活动状态(0:活动未开始;1:活动中;2:已结束)",name="collageActivityStatus")
    private Integer collageActivityStatus;
}