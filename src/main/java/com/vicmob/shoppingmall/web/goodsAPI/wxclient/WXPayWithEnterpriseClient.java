package com.vicmob.shoppingmall.web.goodsAPI.wxclient;

import com.jpay.ext.kit.PaymentKit;
import com.jpay.weixin.api.WxPayApi;
import com.vicmob.shoppingmall.constant.Constant;
import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.IPUtils;
import com.vicmob.shoppingmall.utils.ResultData;
import com.vicmob.shoppingmall.web.distribution.entity.Withdraw;
import com.vicmob.shoppingmall.web.goodsAPI.model.PayAccount;
import com.vicmob.shoppingmall.web.goodsAPI.service.PayAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class WXPayWithEnterpriseClient {

    @Autowired
    private PayAccountService payAccountService;

    @Value("${wx.pay.checkName}")
    private String checkName;

    @Value("${wx.pay.desc}")
    private String desc;

    /**
     * 企业付款到零钱
     */
    public ResultData payWithEnterprise(Withdraw withdraw){
        ResultData result = new ResultData("付款失败", ResponseStatus.FAIL.getValue());
        PayAccount payAccount = payAccountService.getPayAccount(withdraw.getMinaId());
        if (payAccount == null || StringUtils.isEmpty(payAccount.getApiKey()) || StringUtils.isEmpty(payAccount.getMchId())
                || StringUtils.isEmpty(payAccount.getAppId()) || StringUtils.isEmpty(payAccount.getCertificatePath())){
            log.error("payAccount获取失败或者必须参数不存在,withdraw ==>{}" ,withdraw);
            return null;
        }
        Map<String,String> params = getParam(payAccount,withdraw);

        for(int i=0;i<2;i++){
            String transfers = WxPayApi.transfers(params, payAccount.getCertificatePath(), payAccount.getMchId());
            Map<String, String> response = PaymentKit.xmlToMap(transfers);
            String returnCode = response.get("return_code");
            if (Constant.FAIL.equals( returnCode)){
                log.error("微信企业付款到用户通信失败,msg ==>{}",response.get("return_msg"));
                continue;
            }
            String resultCode = response.get("result_code");
            if(Constant.FAIL.equals(resultCode)){
                String errCode = response.get("err_code");
                if (!errCode.equals("SYSTEMERROR")){
                    log.error("微信企业付款到用户失败,errCode ==>{},msg ==>{}",errCode,response.get("err_code_des"));
                    break;
                }else{
                    log.error("微信企业付款到用户失败,errCode ==>{},msg ==>{}",errCode,response.get("err_code_des"));
                    if(i==1){
                        result = new ResultData("微信出现未明确的错误码时（SYSTEMERROR等）", ResponseStatus.WXFAIL.getValue());
                    }
                    continue;
                }
            }
            result = new ResultData("付款成功", ResponseStatus.SUCCESS.getValue());
            break;
        }
        return result;
    }

    private Map<String, String> getParam(PayAccount payAccount,Withdraw withdraw){

        BigDecimal payMoney = withdraw.getCashApply().subtract(withdraw.getCommissionApply()).multiply(new BigDecimal("100"));
        Map<String, String> params = new HashMap<>();
        params.put("mch_appid", payAccount.getAppId());
        params.put("mchid", payAccount.getMchId());
        String nonceStr = String.valueOf(System.currentTimeMillis());
        params.put("nonce_str", nonceStr);
        params.put("partner_trade_no", withdraw.getWithdrawNo());
        params.put("openid", withdraw.getDistributionUser());
        params.put("check_name", checkName);
        params.put("amount", payMoney.intValue() + "");
        params.put("desc", desc);
        params.put("spbill_create_ip", IPUtils.getServiceIp());
        params.put("sign", PaymentKit.createSign(params, payAccount.getApiKey()));
        return params;
    }
}
