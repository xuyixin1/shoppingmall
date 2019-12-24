package com.vicmob.shoppingmall.web.goodsAPI.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class MallCustomerLimitpurchase implements Serializable {
    private Integer limitid;

    private Integer minaid;

    private String collageactivityid;

    private Integer customerid;

    private Integer goodsid;

    private Integer surplusnum;

    private Date createdate;


}