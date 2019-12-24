package com.vicmob.shoppingmall.web.goodsAPI.model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class MallGoodsVO{
    @ApiModelProperty(name= "goodsId",value ="商品id")
    private Integer goodsId;
    @ApiModelProperty(name= "minaId",value ="平台id")
    private Integer minaId;
    @ApiModelProperty(name= "classifyId",value ="一级分类id")
    private Integer classifyId;
    @ApiModelProperty(name= "secondClassifyId",value ="二级分类id")
    private Integer secondClassifyId;
    @ApiModelProperty(name= "goodsName",value ="商品名称")
    private String goodsName;
    @ApiModelProperty(name= "picUrl",value ="图片url")
    private String picUrl;
    @ApiModelProperty(name= "detailPicUrl",value ="产品图片url")
    private String detailPicUrl;
    @ApiModelProperty(name= "sailed",value ="已售出")
    private Integer sailed;
    @ApiModelProperty(name= "label",value ="标签")
    private String label;
    @ApiModelProperty(name= "saleFlag",value ="是否上架")
    private Integer saleFlag;
    @ApiModelProperty(name= "sort",value ="排序")
    private Integer sort;
    @ApiModelProperty(name= "description",value ="产品描述")
    private String description;
    @ApiModelProperty(name= "deleteFlag",value ="删除标志")
    private Integer deleteFlag;
    @ApiModelProperty(name= "showPrice",value ="展示价格")
    private BigDecimal showPrice;
    @ApiModelProperty(name= "showFlag",value ="是否展示首页")
    private Integer showFlag;
    @ApiModelProperty(name= "distributionFlag",value ="（0:不参与分销；1：参与分销）")
    private Integer distributionFlag;
    @ApiModelProperty(name= "collageSailed",value ="拼团已售件数")
    private Integer collageSailed;
    @ApiModelProperty(name= "collageFlag",value ="是否是拼团商品(0:不是;1:是)")
    private Integer collageFlag;
    @ApiModelProperty(name= "parameters",value ="商品参数")
    private String parameters;
    @ApiModelProperty(name= "highPrice",value ="商品最高价格")
    private BigDecimal highPrice;
    @ApiModelProperty(name= "lowPrice",value ="商品最低价格")
    private BigDecimal lowPrice;
    @ApiModelProperty(name= "mallEvaluate",value ="商品的最新一条评价(不带图片)")
    private MallEvaluateVO mallEvaluate;
    @ApiModelProperty(name= "mallEvaluateNum",value ="商品评价的总数量")
    private Integer mallEvaluateNum;
    @ApiModelProperty(name= "totalStock",value ="商品总库存")
    private Integer totalStock;
    @ApiModelProperty(name= "qrCode",value ="商品二维码")
    private String qrCode;
    @ApiModelProperty(name= "mallGoodsCollageParamVOList",value ="快速成团列表")
    private List<MallGoodsCollageParamVO> mallGoodsCollageParamVOList;
    @ApiModelProperty(name= "collageActivityPeople",value ="成团人数")
    private Integer collageActivityPeople;
    @ApiModelProperty(name= "partsNumber",value ="已拼件数")
    private Integer partsNumber;
    @ApiModelProperty(name= "remainingPreferentialDay",value ="剩余优惠天数")
    private String remainingPreferentialDay;
    @ApiModelProperty(name= "collageHighPrice",value ="拼团最高价格")
    private String collageHighPrice;
    @ApiModelProperty(name= "collageLowPrice",value ="拼团最低价格")
    private String collageLowPrice;
    @ApiModelProperty(name= "collageActivityId",value ="拼团活动id")
    private String collageActivityId;
    @ApiModelProperty(name= "collageActivityStatus",value ="拼团活动状态(0:活动未开始;1:活动中;2:已结束)")
    private Integer collageActivityStatus;
    @ApiModelProperty(name= "commissionMode",value ="分销模式")
    private Integer commissionMode;
    @ApiModelProperty(name= "fixedCommission",value ="固定值")
    private BigDecimal fixedCommission;
    @ApiModelProperty(name= "percentageCommission",value ="百分比")
    private BigDecimal percentageCommission;
    @ApiModelProperty(name= "minAmount",value ="分销最低佣金")
    private BigDecimal minAmount;
    @ApiModelProperty(name= "limitedPurchase",value ="每人限购数")
    private Integer limitedPurchase;



}