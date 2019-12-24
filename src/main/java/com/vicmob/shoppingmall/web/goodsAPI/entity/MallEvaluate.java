package com.vicmob.shoppingmall.web.goodsAPI.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class MallEvaluate implements Serializable {
    @ApiModelProperty(name= "evaluateid",value ="主键id")
    private Integer evaluateid;
    @ApiModelProperty(name= "customerid",value ="粉丝id")
    private Integer customerid;
    @ApiModelProperty(name= "minaid",value ="平台id")
    private Integer minaid;
    @ApiModelProperty(name= "orderid",value ="订单id")
    private Integer orderid;
    @ApiModelProperty(name= "classifyid",value ="一级分类id")
    private Integer classifyid;
    @ApiModelProperty(name= "secondclassifyid",value ="二级分类id")
    private Integer secondclassifyid;
    @ApiModelProperty(name= "goodsid",value ="商品id")
    private Integer goodsid;
    @ApiModelProperty(name= "specid",value ="产品规格id")
    private Integer specid;
    @ApiModelProperty(name= "isanonymous",value ="是否匿名（0为不匿名，1为匿名）")
    private Integer isanonymous;
    @ApiModelProperty(name= "evallevel",value ="评论星级（1-5,分别为1星-5星: 1星:非常差;2星:差;3星;一般;4星:好;5星:非常好)")
    private Integer evallevel;
    @ApiModelProperty(name= "evalcontent",value ="评论内容")
    private String evalcontent;
    @ApiModelProperty(name= "evalpic",value ="评论图片")
    private String evalpic;
    @ApiModelProperty(name= "evaltime",value ="评论时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date evaltime;
    @ApiModelProperty(name= "storereply",value ="商家回复")
    private String storereply;
    @ApiModelProperty(name= "replytime",value ="商家回复时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date replytime;
    @ApiModelProperty(name= "deleteflag",value ="删除标识(0:未删除;1:已删除)")
    private Integer deleteflag;

}