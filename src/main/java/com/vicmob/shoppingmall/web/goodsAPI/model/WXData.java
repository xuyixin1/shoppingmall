package com.vicmob.shoppingmall.web.goodsAPI.model;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WXData {
    private Keyword keyword1;
    private Keyword keyword2;
    private Keyword keyword3;
    private Keyword keyword4;
    private Keyword keyword5;
    private Keyword keyword6;

    public Keyword getKeyword1() {
        return keyword1;
    }

    public void setKeyword1(Keyword keyword1) {
        this.keyword1 = keyword1;
    }

    public Keyword getKeyword2() {
        return keyword2;
    }

    public void setKeyword2(Keyword keyword2) {
        this.keyword2 = keyword2;
    }

    public Keyword getKeyword3() {
        return keyword3;
    }

    public void setKeyword3(Keyword keyword3) {
        this.keyword3 = keyword3;
    }

    public Keyword getKeyword4() {
        return keyword4;
    }

    public void setKeyword4(Keyword keyword4) {
        this.keyword4 = keyword4;
    }

    public Keyword getKeyword5() {
        return keyword5;
    }

    public void setKeyword5(Keyword keyword5) {
        this.keyword5 = keyword5;
    }

    public Keyword getKeyword6() {
        return keyword6;
    }

    public void setKeyword6(Keyword keyword6) {
        this.keyword6 = keyword6;
    }

    @Override
    public String toString() {
        return "WXData{" +
                "keyword1=" + keyword1 +
                ", keyword2=" + keyword2 +
                ", keyword3=" + keyword3 +
                ", keyword4=" + keyword4 +
                ", keyword5=" + keyword5 +
                ", keyword6=" + keyword6 +
                '}';
    }
}
