package com.vicmob.shoppingmall.web.goodsAPI.model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Data
public class GoodsSpecsListVO implements Serializable {
    @ApiModelProperty(value="属性1列表",name="attributeId1VOList")
    private List<AttributeId1VO> attributeId1VOList;
    @ApiModelProperty(value="属性2列表",name="attributeId2VOList")
    private List<AttributeId2VO> attributeId2VOList;
}