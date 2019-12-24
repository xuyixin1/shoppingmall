package com.vicmob.shoppingmall.web.goodsAPI.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class MallSlide implements Serializable {
    @ApiModelProperty(name= "slideid",value ="幻灯片id")
    private Integer slideid;
    @ApiModelProperty(name= "minaid",value ="平台id")
    private Integer minaid;
    @ApiModelProperty(name= "slidename",value ="幻灯片名称")
    private String slidename;
    @ApiModelProperty(name= "picurl",value ="幻灯片url")
    private String picurl;
    @ApiModelProperty(name= "useflag",value ="是否启用(0:不启用;1:启用)")
    private Integer useflag;
    @ApiModelProperty(name= "classifyid",value ="一级分类id")
    private Integer classifyid;
    @ApiModelProperty(name= "secondclassifyid",value ="二级分类id")
    private Integer secondclassifyid;
    @ApiModelProperty(name= "goodsid",value ="商品id")
    private Integer goodsid;

}