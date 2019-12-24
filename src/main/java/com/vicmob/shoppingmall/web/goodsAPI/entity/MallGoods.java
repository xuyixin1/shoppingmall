package com.vicmob.shoppingmall.web.goodsAPI.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
@Data
public class MallGoods implements Serializable {
    @ApiModelProperty(name= "goodsid",value ="商品id")
    private Integer goodsid;
    @ApiModelProperty(name= "minaid",value ="平台id")
    private Integer minaid;
    @ApiModelProperty(name= "classifyid",value ="一级分类id")
    private Integer classifyid;
    @ApiModelProperty(name= "secondclassifyid",value ="二级分类id")
    private Integer secondclassifyid;
    @ApiModelProperty(name= "goodsname",value ="商品名称")
    private String goodsname;
    @ApiModelProperty(name= "picurl",value ="图片url")
    private String picurl;
    @ApiModelProperty(name= "detailpicurl",value ="产品图片url")
    private String detailpicurl;
    @ApiModelProperty(name= "sailed",value ="已售出")
    private Integer sailed;
    @ApiModelProperty(name= "label",value ="标签")
    private String label;
    @ApiModelProperty(name= "saleflag",value ="是否上架")
    private Integer saleflag;
    @ApiModelProperty(name= "sort",value ="排序")
    private Integer sort;
    @ApiModelProperty(name= "description",value ="产品描述")
    private String description;
    @ApiModelProperty(name= "deleteflag",value ="删除标志")
    private Integer deleteflag;
    @ApiModelProperty(name= "showprice",value ="展示价格")
    private BigDecimal showprice;
    @ApiModelProperty(name= "showflag",value ="是否展示首页")
    private Integer showflag;
    @ApiModelProperty(name= "distributionflag",value ="（0:不参与分销；1：参与分销）")
    private Integer distributionflag;
    @ApiModelProperty(name= "collagesailed",value ="拼团已售件数")
    private Integer collagesailed;
    @ApiModelProperty(name= "distributionflag",value ="是否是拼团商品(0:不是;1:是)")
    private Integer collageflag;
    @ApiModelProperty(name= "parameters",value ="商品参数")
    private String parameters;
}