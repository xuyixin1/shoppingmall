package com.vicmob.shoppingmall.web.goods.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.vicmob.shoppingmall.constant.Constant;
import com.vicmob.shoppingmall.web.goodsAPI.model.Customer;
import lombok.Data;

import java.util.Date;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Evaluate {
    private Integer evaluateId;
    private Integer customerId;
    private Integer minaId;
    private Integer orderId;
    private String orderNumber;
    private Integer classifyId;
    private Integer secondClassifyId;
    private Integer goodsId;
    private Integer specId;
    private Integer isAnonymous;
    private Integer evalLevel;
    private String evalContent;
    private String evalPic;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date evalTime;
    private String storeReply;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date replyTime;
    private Constant.DeleteFlag1 deleteFlag;
    private Customer customerInfo;
    private String startTime;
    private String endTime;
    private String goodsName;
    private String avatar;
    private String picture;
    private String nickname;
    private String attributeValue1;
    private String attributeValue2;
    private String goodsDetail;
}