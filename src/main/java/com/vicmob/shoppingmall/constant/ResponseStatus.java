package com.vicmob.shoppingmall.constant;

public enum ResponseStatus {
    //成功
    SUCCESS(0),
    //失败
    FAIL(-1),
    //微信退款失败
    WXFAIL(-2),
    //版本过低
    VERSION_LOWER(-3);
    public Integer value;

    private ResponseStatus(Integer value){
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
