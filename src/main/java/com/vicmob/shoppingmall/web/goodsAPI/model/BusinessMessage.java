package com.vicmob.shoppingmall.web.goodsAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BusinessMessage {
    @JsonProperty("touser")
    private String openId;
    @JsonProperty("template_id")
    private String templateId;
    @JsonProperty("data")
    private BusinessData data;
}
