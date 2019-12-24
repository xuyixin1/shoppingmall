package com.vicmob.shoppingmall.web.goodsAPI.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class MallGoodsCollageDetailVO implements Serializable {
    @ApiModelProperty(value="拼团id",name="collageId")
    private Integer collageId;
    @ApiModelProperty(value="团单号(唯一的不重复)",name="collageNo")
    private String collageNo;
    @ApiModelProperty(value="客户集合",name="customerVO")
    private List<CustomerVO> customerVO;
    @ApiModelProperty(value="剩余时间",name="surplusTime")
    private Long surplusTime;
    @ApiModelProperty(value="剩余人数",name="remainingNumber")
    private Integer remainingNumber;
}