package com.vicmob.shoppingmall.web.goodsAPI.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.util.Date;

@Data
public class MallGoodsCollageQueryVO implements Serializable {
    @ApiModelProperty(value="团单号(唯一的不重复)",name="collageno")
    private String collageno;
    @ApiModelProperty(value="拼团活动名称",name="collageactivityname")
    private String collageactivityname;
    @ApiModelProperty(value="发起拼团时间",name="collagestartdate")
    private Date collagestartdate;
    @ApiModelProperty(value="拼团结束时间",name="collageenddate")
    private Date collageenddate;
    @ApiModelProperty(value="分页参数",name="page")
    private PageRecord page;
    @ApiModelProperty(value="平台id",name="minaid")
    private Integer minaid;
}