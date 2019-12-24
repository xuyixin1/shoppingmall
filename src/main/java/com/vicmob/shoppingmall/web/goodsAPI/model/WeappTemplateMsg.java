package com.vicmob.shoppingmall.web.goodsAPI.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WeappTemplateMsg {
    @JsonProperty("template_id")
    private String templatId;
    private String page;
    @JsonProperty("form_id")
    private String formId;
    private WXData data;
    @JsonProperty("emphasis_keyword")
    private String emphasisKeyword;

    public String getTemplatId() {
        return templatId;
    }

    public void setTemplatId(String templatId) {
        this.templatId = templatId;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getFormId() {
        return formId;
    }

    public void setFormId(String formId) {
        this.formId = formId;
    }

    public WXData getData() {
        return data;
    }

    public void setData(WXData data) {
        this.data = data;
    }

    public String getEmphasisKeyword() {
        return emphasisKeyword;
    }

    public void setEmphasisKeyword(String emphasisKeyword) {
        this.emphasisKeyword = emphasisKeyword;
    }

    @Override
    public String toString() {
        return "WeappTemplateMsg{" +
                "TemplatId='" + templatId + '\'' +
                ", page='" + page + '\'' +
                ", formId='" + formId + '\'' +
                ", data='" + data + '\'' +
                ", emphasisKeyword='" + emphasisKeyword + '\'' +
                '}';
    }
}
