package com.vicmob.shoppingmall.web.goodsAPI.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class MallGoodsCollageActivityDetailVO implements Serializable {
    @ApiModelProperty(value="平台id",name="minaId")
    private Integer minaId;
    @ApiModelProperty(value="拼团活动名称",name="collageActivityName")
    private String collageActivityName;
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
    @ApiModelProperty(value="以拼件数",name="partsNumber")
    private String partsNumber;
    @ApiModelProperty(value="每人限购数",name="limitedPurchase")
    private Integer limitedPurchase;
    @ApiModelProperty(value="商品id",name="goodsId")
    private Integer goodsId;
    @ApiModelProperty(value="商品名称",name="goodsName")
    private String goodsName;
    @ApiModelProperty(value="一级分类id",name="classifyId")
    private Integer classifyId;
    @ApiModelProperty(value="一级分类名称",name="classifyName")
    private String classifyName;
    @ApiModelProperty(value="二级分类id",name="secondClassifyId")
    private Integer secondClassifyId;
    @ApiModelProperty(value="二级分类名称",name="secondClassifyName")
    private String secondClassifyName;
    @ApiModelProperty(value="商品的不同规格和拼团价",name="mallGoodsCollageActivityParamVOList")
    private List<MallGoodsCollageActivityParamVO> mallGoodsCollageActivityParamVOList;

}