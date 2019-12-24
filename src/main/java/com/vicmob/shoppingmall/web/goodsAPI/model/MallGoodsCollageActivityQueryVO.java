package com.vicmob.shoppingmall.web.goodsAPI.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class MallGoodsCollageActivityQueryVO implements Serializable {
    @ApiModelProperty(value="商品名称",name="goodsname")
    private String goodsname;
    @ApiModelProperty(value="拼团活动状态",name="collageactivitystatus")
    private Integer collageactivitystatus;
    @ApiModelProperty(value="平台id",name="minaid")
    private Integer minaid;
    @ApiModelProperty(value="分页参数",name="page")
    private PageRecord page;

}