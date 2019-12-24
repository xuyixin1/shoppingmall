package com.vicmob.shoppingmall.web.goodsAPI.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Data
public class MallEvaluateAllVO implements Serializable {
    @ApiModelProperty(value="所有类型的评价数量",name="evluateNum")
    private MallEvaluateNumVO evluateNum;
    @ApiModelProperty(value="所有类型的评价列表",name="mallEvaluateVOlist")
    private List<MallEvaluateVO> mallEvaluateVOlist;
    @ApiModelProperty(value="page",name="分页参数")
    private PageRecord page;

}