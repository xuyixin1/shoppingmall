package com.vicmob.shoppingmall.web.goodsAPI.model;

import lombok.Data;

import java.util.Date;

@Data
public class Form {
    private Integer minaFormId;

    private String formId;

    private Integer customerId;

    private Date endDate;
}
