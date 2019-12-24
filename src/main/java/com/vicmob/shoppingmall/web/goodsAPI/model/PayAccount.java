package com.vicmob.shoppingmall.web.goodsAPI.model;

import lombok.Data;

@Data
public class PayAccount {
    //主键ID
    private Integer weChatPayId;
    //小程序ID
    private Integer minaId;
    //支付appId
    private String appId;
    //支付商户号
    private String mchId;
    //支付apikey
    private String apiKey;
    //证书路径
    private String certificatePath;
    //状态（0：不启用支付， 1：启用支付）
    private String payState;
}
