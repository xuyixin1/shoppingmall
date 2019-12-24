package com.vicmob.shoppingmall.web.goodsAPI.wxclient;

import com.vicmob.shoppingmall.utils.DateUtils;
import com.vicmob.shoppingmall.utils.RestTemplateUtil;
import com.vicmob.shoppingmall.web.goods.entity.BusinessAccount;
import com.vicmob.shoppingmall.web.goods.service.BusinessAccountService;
import com.vicmob.shoppingmall.web.goodsAPI.dao.WXMapper;
import com.vicmob.shoppingmall.web.goodsAPI.model.BusinessWebToken;
import com.vicmob.shoppingmall.web.goodsAPI.model.Customer;
import com.vicmob.shoppingmall.web.goodsAPI.model.MinaAuthorization;
import com.vicmob.shoppingmall.web.goodsAPI.model.TokenResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

/*
* 微信相关信息
 */
@Service
@Slf4j
public class WXInfoClient {

    @Value("${wx.business.webToken.url}")
    private String businessWebTokenUrl;

    @Value("${wx.token.url}")
    private String wxTokenUrl;

    @Autowired
    private BusinessAccountService businessAccountService;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private WXMapper wxMapper;


    //获取公众号openId
    public String getOpenIdByWX(String code){
        BusinessAccount businessAccount = businessAccountService.getBusinessAccount();
        if (businessAccount == null || StringUtils.isEmpty(businessAccount.getAppId()) || StringUtils.isEmpty(businessAccount.getAppSecret())){
            log.error("公众号账户不存在");
            return null;
        }
        String url = businessWebTokenUrl + "?appid=" + businessAccount.getAppId() + "&secret=" + businessAccount.getAppSecret() + "&code=" + code + "&grant_type=authorization_code";
        BusinessWebToken businessWebToken = RestTemplateUtil.getResult(url, BusinessWebToken.class,restTemplate);
        if (businessWebToken == null || StringUtils.isEmpty(businessWebToken.getOpenId())){
            log.error("businessWebToken为空 url ==>{},businessWebToken ==>{}",url,businessWebToken);
            return null;
        }
        return businessWebToken.getOpenId();
    }

    /**
     *获取公众号的accesstoken
     */
    public String getAccessToken(){
        BusinessAccount businessAccount = businessAccountService.getBusinessAccount();
        if (businessAccount == null || StringUtils.isEmpty(businessAccount.getAppId()) || StringUtils.isEmpty(businessAccount.getAppSecret())){
            log.error("公众号账户不存在");
            return null;
        }
        //查询数据库中token是否过期
        if (!DateUtils.expire(businessAccount.getAccessTokenEndTime())){
            if (!StringUtils.isEmpty(businessAccount.getAccessToken())){
                return businessAccount.getAccessToken();
            }
        }
        TokenResponse tokenResponse = RestTemplateUtil.getResult(wxTokenUrl+"&appid="+ businessAccount.getAppId() + "&secret=" + businessAccount.getAppSecret(), TokenResponse.class,restTemplate);
        if (tokenResponse.getErrcode() != null){
            log.error("调用微信token接口失败  errcode==>{} errmsg ==>{}",tokenResponse.getErrcode(),tokenResponse.getErrmsg());
            return null;
        }
        Long time = System.currentTimeMillis() / 1000 + tokenResponse.getExpiresIn();
        businessAccountService.updateAcessToken(tokenResponse.getAccessToken(),time);
        return tokenResponse.getAccessToken();
    }

    //小程序token获取
    public String getAccessToken(Integer minaId){
        MinaAuthorization ma =  wxMapper.getMinaAuthorization(minaId);
        if (ma == null){
            log.error("获取小程序授权账号失败 minaId ==>{}",minaId);
            return null;
        }
        //查询数据库中token是否过期
        if (!DateUtils.expire(ma.getAccessTokenEndTime())){
            if (!StringUtils.isEmpty(ma.getAccessToken())){
                return ma.getAccessToken();
            }
        }
        if (StringUtils.isEmpty(ma.getAppId()) || StringUtils.isEmpty(ma.getAppSecret())){
            log.error("获取小程序appId或appSecret为空  minaAuthorization ==>{} minaId ==>{}",ma,minaId);
            return null;
        }
        TokenResponse tokenResponse = RestTemplateUtil.getResult(wxTokenUrl+"&appid="+ ma.getAppId() + "&secret=" + ma.getAppSecret(), TokenResponse.class,restTemplate);
        if (tokenResponse.getErrcode() != null){
            log.error("调用微信token接口失败  errcode==>{} errmsg ==>{}",tokenResponse.getErrcode(),tokenResponse.getErrmsg());
            return null;
        }
        Long time = System.currentTimeMillis() / 1000 + tokenResponse.getExpiresIn();
        if (wxMapper.updateAcessToken(minaId,tokenResponse.getAccessToken(),time)!=1){
            log.error("更新小程序token 失败 minaId ==>{} ,acessToken ==>{}",minaId,tokenResponse.getAccessToken());
        }
        return tokenResponse.getAccessToken();
    }

    public String getOpenId(Integer minaId, Integer customerId){
        Customer customer = wxMapper.getOpenId(minaId,customerId);
        if (customer == null){
            log.error("获取customer失败 minaId ==>{},customerId ==>{} ",minaId,customerId);
            return null;
        }
        return customer.getOpenId();
    }
}
