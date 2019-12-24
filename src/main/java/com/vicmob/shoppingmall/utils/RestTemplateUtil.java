package com.vicmob.shoppingmall.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

public class RestTemplateUtil {
    private static final Logger log = LoggerFactory.getLogger(RestTemplateUtil.class);
    public static final String APPLICATION_JSON_CHARSET_UTF_8 = "application/json; charset=UTF-8";


    public static  <T> T postResult(String body,String url, Class<T> t ,RestTemplate restTemplate) {
        log.info("request content :" + body);
        HttpHeaders headers = new HttpHeaders();
        String resultText = post(headers, body,url,restTemplate);
        if (resultText == null || "".equals(resultText)) {
            log.error("response content 为空,body : " + body);
            return null;
        }
        log.info("response content :" + resultText);
        try {
            return JacksonUtil.jsonToObject(resultText, t);
        } catch (Exception e) {
            log.error("解析数据 ===> {} 错误" + resultText);
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public static  <T> T  getResult(String url ,Class<T> t ,RestTemplate restTemplate){
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        if (response.getStatusCode() != HttpStatus.OK){
            log.error("请求失败 : url ==>{}, status ==>{}" + url,response.getStatusCode());
            return null;
        }
        try {
            return JacksonUtil.jsonToObject(response.getBody(), t);
        } catch (Exception e) {
            log.error("解析数据 ===> {} 错误" + response.getBody());
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public static String post(HttpHeaders headers, String body , String url,RestTemplate restTemplate) {
        MediaType type = MediaType.parseMediaType(APPLICATION_JSON_CHARSET_UTF_8);
        headers.setContentType(type);
        HttpEntity<String> formEntity = new HttpEntity<>(body, headers);
        String result = restTemplate.postForObject(url, formEntity, String.class);
        return result;
    }




}

