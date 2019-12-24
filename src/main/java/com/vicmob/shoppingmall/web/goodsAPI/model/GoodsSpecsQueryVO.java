package com.vicmob.shoppingmall.web.goodsAPI.model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
@Data
public class GoodsSpecsQueryVO implements Serializable {
    @ApiModelProperty(value="商品属性值1",name="attributeValueName1")
    private String attributeValueName1;
    @ApiModelProperty(value="商品属性值2",name="attributeValueName2")
    private String attributeValueName2;
    @ApiModelProperty(value="商品id",name="goodsId")
    private Integer goodsId;
    @ApiModelProperty(value="小程序id",name="minaStr")
    private String minaStr;
    @ApiModelProperty(value="appId",name="appId")
    private String appId;
    @ApiModelProperty(value="是否是拼团商品(0:不是;1:是)",name="collageFlag")
    private Integer collageFlag;
}