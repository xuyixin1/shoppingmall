package com.vicmob.shoppingmall.web.goods.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BusinessAccount {
    private Integer accountId;
    private String name;
    private String token;
    private String appId;
    private String appSecret;
    private String accessToken;
    private Long accessTokenEndTime;
    private String original;
    private String wxQrcodeUrl;
}
