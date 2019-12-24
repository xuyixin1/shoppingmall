package com.vicmob.shoppingmall.web.goodsAPI.model;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.io.Serializable;
@Data
public class ClassifyIdQueryVO implements Serializable {
    @ApiModelProperty(value="一级分类id",name="一级分类id")
    private Integer classifyId;
    @ApiModelProperty(value="平台id",name="minaId")
    private Integer minaId;
    @ApiModelProperty(name = "secondClassifyId",value = "二级分类id")
    private Integer secondClassifyId;
    @ApiModelProperty(value="商品id",name="goodsId")
    private Integer goodsId;

}