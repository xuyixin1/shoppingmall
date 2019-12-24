package com.vicmob.shoppingmall.web.goodsAPI.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Keyword {
    private String color;
    private String value;
}
