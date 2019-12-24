package com.vicmob.shoppingmall.web.goodsAPI.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
@Data
public class MallEvaluateNumVO implements Serializable {
    @ApiModelProperty(value="所有评价总数",name="allNum")
    private Integer allNum;
    @ApiModelProperty(value="有图评价数",name="picNum")
    private Integer picNum;
    @ApiModelProperty(value="好评评价数",name="goodNum")
    private Integer goodNum;
    @ApiModelProperty(value="好评评价数",name="midNum")
    private Integer midNum;
    @ApiModelProperty(value="差评评价数",name="badNum")
    private Integer badNum;
}