package com.vicmob.shoppingmall.web.goodsAPI.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TokenResponse extends WXBaseResponse {
    @JsonProperty("expires_in")
    private Integer expiresIn;
    @JsonProperty("access_token")
    private String accessToken;

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Override
    public String toString() {
        return "TokenResponse{" +
                "expiresIn=" + expiresIn +
                ", accessToken='" + accessToken + '\'' +
                '}';
    }
}
