package com.vicmob.shoppingmall.web.goodsAPI.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class BusinessData {
    private Keyword first;
    private Keyword keyword1;
    private Keyword keyword2;
    private Keyword keyword3;
    private Keyword keyword4;
    private Keyword remark;
}
