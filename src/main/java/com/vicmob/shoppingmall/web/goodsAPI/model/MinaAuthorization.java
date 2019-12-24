package com.vicmob.shoppingmall.web.goodsAPI.model;

import lombok.Data;

@Data
public class MinaAuthorization {
    private Integer minaId;
    private String appId;
    private String appSecret;
    private String accessToken;
    private Long accessTokenEndTime;
}
