package com.vicmob.shoppingmall.web.goodsAPI.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class MallGoodsCartVO {
    @ApiModelProperty(name= "attributeId1",value ="属性1")
    private Integer attributeId1;
    @ApiModelProperty(name= "attributeIdName1",value ="属性1名称")
    private String attributeIdName1;
    @ApiModelProperty(name= "attributeValueName1",value ="属性1值")
    private String attributeValueName1;
    @ApiModelProperty(name= "attributeId2",value ="属性2")
    private Integer attributeId2;
    @ApiModelProperty(name= "attributeIdName2",value ="属性2名称")
    private String attributeIdName2;
    @ApiModelProperty(name= "attributeValueName2",value ="属性2值")
    private String attributeValueName2;
    @ApiModelProperty(name= "stock",value ="库存")
    private Integer stock;
    @ApiModelProperty(name = "cartId",value = "购物车id")
    private Integer cartId;
    @ApiModelProperty(name = "customerId",value = "粉丝id")
    private Integer customerId;
    @ApiModelProperty(name = "minaId",value = "小程序id")
    private Integer minaId;
    @ApiModelProperty(name = "goodsId",value = "商品id")
    private Integer goodsId;
    @ApiModelProperty(name = "goodsName",value = "商品名称")
    private String goodsName;
    @ApiModelProperty(name = "picUrl",value = "商品图片")
    private String picUrl;
    @ApiModelProperty(name = "specId",value = "规格id")
    private Integer specId;
    @ApiModelProperty(name = "goodsNum",value = "商品数量")
    private Integer goodsNum;
    @ApiModelProperty(name = "goodsPrice",value = "商品价格")
    private BigDecimal goodsPrice;
    @ApiModelProperty(name = "deleteFlag",value = "删除标识(0:不删除;1:删除)")
    private Integer deleteFlag;
    @ApiModelProperty(name = "createDate",value = "加入购物车时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createDate;
    @ApiModelProperty(name= "collageFlag",value ="是否是拼团商品(0:不是;1:是)")
    private Integer collageFlag;
}