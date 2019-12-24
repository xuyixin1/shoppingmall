package com.vicmob.shoppingmall.web.goodsAPI.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

@Data
public class MallEvaluateVO {
    @ApiModelProperty(name= "nickName",value ="微信昵称")
    private String nickName;
    @ApiModelProperty(name= "avatar",value ="微信头像")
    private String avatar;
    @ApiModelProperty(name= "evaluateId",value ="主键id")
    private Integer evaluateId;
    @ApiModelProperty(name= "customerId",value ="粉丝id")
    private Integer customerId;
    @ApiModelProperty(name= "minaId",value ="平台id")
    private Integer minaId;
    @ApiModelProperty(name= "orderId",value ="订单id")
    private Integer orderId;
    @ApiModelProperty(name= "classifyId",value ="一级分类id")
    private Integer classifyId;
    @ApiModelProperty(name= "secondClassifyId",value ="二级分类id")
    private Integer secondClassifyId;
    @ApiModelProperty(name= "goodsId",value ="商品id")
    private Integer goodsId;
    @ApiModelProperty(name= "specId",value ="产品规格id")
    private Integer specId;
    @ApiModelProperty(name= "isAnonymous",value ="是否匿名（0为不匿名，1为匿名）")
    private Integer isAnonymous;
    @ApiModelProperty(name= "evalLevel",value ="评论星级（1-5,分别为1星-5星: 1星:非常差;2星:差;3星;一般;4星:好;5星:非常好)")
    private Integer evalLevel;
    @ApiModelProperty(name= "evalContent",value ="评论内容")
    private String evalContent;
    @ApiModelProperty(name= "evalPic",value ="评论图片")
    private String evalPic;
    @ApiModelProperty(name= "evalTime",value ="评论时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date evalTime;
    @ApiModelProperty(name= "storeReply",value ="商家回复")
    private String storeReply;
    @ApiModelProperty(name= "replyTime",value ="商家回复时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private String replyTime;
    @ApiModelProperty(name= "deleteFlag",value ="删除标识(0:未删除;1:已删除)")
    private Integer deleteFlag;

}