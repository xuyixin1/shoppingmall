package com.vicmob.shoppingmall.web.goodsAPI.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;

@Data
public class GoodsIdVO implements Serializable {
    @ApiModelProperty(value="商品id",name="goodsId")
    private Integer goodsId;
    @ApiModelProperty(value="小程序id",name="minaStr")
    private String minaStr;
    @ApiModelProperty(value="appId",name="appId")
    private String appId;
    @ApiModelProperty(value="评价类型(全部:all,有图:pic,好评:good,中评:mid,差评:bad)",name="evaluateType")
    private String evaluateType;
    @ApiModelProperty(value="page",name="分页参数")
    private PageRecord page;
    @ApiModelProperty(value="粉丝Id",name="customerId")
    private Integer customerId;
    @ApiModelProperty(value="employeeId",name="员工id")
    private Integer employeeId;

}