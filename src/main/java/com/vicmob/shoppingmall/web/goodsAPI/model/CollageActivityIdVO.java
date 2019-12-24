package com.vicmob.shoppingmall.web.goodsAPI.model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;

@Data
public class CollageActivityIdVO implements Serializable {
    @ApiModelProperty(value="拼团活动id",name="collageActivityId")
    private String collageActivityId;
    @ApiModelProperty(value="商品id",name="goodsId")
    private Integer goodsId;
    @ApiModelProperty(value="平台id",name="minaId")
    private Integer minaId;
}