package com.vicmob.shoppingmall.web.goodsAPI.model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Data
public class MallEvaluateAddVO implements Serializable {
    @ApiModelProperty(value="小程序id",name="minaStr")
    private String minaStr;
    @ApiModelProperty(value="appId",name="appId")
    private String appId;
    @ApiModelProperty(value="粉丝id",name="customerId")
    private Integer customerId;
    @ApiModelProperty(value="订单编号",name="orderid")
    private Integer orderid;
    @ApiModelProperty(value="商品评价列表",name="mallEvaluateParamsVOList")
    private List<MallEvaluateParamsVO> mallEvaluateParamsVOList;

}