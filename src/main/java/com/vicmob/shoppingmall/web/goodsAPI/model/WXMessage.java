package com.vicmob.shoppingmall.web.goodsAPI.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class WXMessage {
    private String touser;
    @JsonProperty("weapp_template_msg")
    private WeappTemplateMsg weappTemplateMsg;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }

    public WeappTemplateMsg getWeappTemplateMsg() {
        return weappTemplateMsg;
    }

    public void setWeappTemplateMsg(WeappTemplateMsg weappTemplateMsg) {
        this.weappTemplateMsg = weappTemplateMsg;
    }

    @Override
    public String toString() {
        return "WXMessage{" +
                ", touser='" + touser + '\'' +
                ", weappTemplateMsg=" + weappTemplateMsg +
                '}';
    }
}
