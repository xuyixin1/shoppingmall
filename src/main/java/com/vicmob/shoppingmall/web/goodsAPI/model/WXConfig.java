package com.vicmob.shoppingmall.web.goodsAPI.model;

import com.github.wxpay.sdk.IWXPayDomain;

import com.github.wxpay.sdk.WXPayConfig;
import com.github.wxpay.sdk.WXPayConstants;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public  class WXConfig extends WXPayConfig {
    private String appID;
    private String mchID;
    private String key;

    private byte[] certData;

    public WXConfig(String certPath) throws Exception {
        File file = new File(certPath);
        InputStream certStream = new FileInputStream(file);
        this.certData = new byte[(int) file.length()];
        certStream.read(this.certData);
        certStream.close();
    }

    public WXConfig(){}

    @Override
    public String getAppID(){
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }
    @Override
    public String getMchID() {
        return mchID;
    }

    public void setMerchID(String merchID) {
        this.mchID = merchID;
    }
    @Override
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    @Override
    public InputStream getCertStream() {
        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }
    @Override
    public IWXPayDomain getWXPayDomain() {
        // 这个方法需要这样实现, 否则无法正常初始化WXPay
        IWXPayDomain iwxPayDomain = new IWXPayDomain() {

            @Override
            public void report(String domain, long elapsedTimeMillis, Exception ex) {

            }

            @Override
            public DomainInfo getDomain(com.github.wxpay.sdk.WXPayConfig wxPayConfig) {
                return new DomainInfo(WXPayConstants.DOMAIN_API, true);
            }
        };
        return iwxPayDomain;

    }


    @Override
    public boolean shouldAutoReport() {
        return false;
    }
}
