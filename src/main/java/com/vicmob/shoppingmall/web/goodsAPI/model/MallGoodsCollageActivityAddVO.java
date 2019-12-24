package com.vicmob.shoppingmall.web.goodsAPI.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class MallGoodsCollageActivityAddVO implements Serializable {
    @ApiModelProperty(value="拼团活动id",name="collageactivityid")
    private String collageactivityid;
    @ApiModelProperty(value="拼团活动名称",name="collageactivityname")
    private String collageactivityname;
    @ApiModelProperty(value="平台id",name="minaid")
    private Integer minaid;
    @ApiModelProperty(value="成团人数",name="collagepeople")
    private Integer collageactivitypeople;
    @ApiModelProperty(value="拼团活动开始时间",name="activitystartdate")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date activitystartdate;
    @ApiModelProperty(value="拼团活动结束时间",name="activityenddate")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date activityenddate;
    @ApiModelProperty(value="成团有效时间",name="collagevaliddate")
    private Integer collagevaliddate;
    @ApiModelProperty(value="以拼件数",name="partsnumber")
    private String partsnumber;
    @ApiModelProperty(value="每人限购数",name="limitedpurchase")
    private Integer limitedpurchase;
    @ApiModelProperty(value="商品id",name="goodsid")
    private Integer goodsid;
    @ApiModelProperty(value="不同规格的拼团价",name="mallGoodsCollageVOList")
    private List<MallGoodsCollageActivityParamVO> mallGoodsCollageVOList;
    @ApiModelProperty(value="拼团活动状态(0:活动未开始;1:活动中;2:已结束;3:已失效)",name="collageActivityStatus")
    private Integer collageActivityStatus;
}