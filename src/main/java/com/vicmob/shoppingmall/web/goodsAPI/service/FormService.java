package com.vicmob.shoppingmall.web.goodsAPI.service;

import com.vicmob.shoppingmall.web.goodsAPI.dao.FormMapper;
import com.vicmob.shoppingmall.web.goodsAPI.model.Form;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class FormService {
    private final Logger log = LoggerFactory.getLogger(FormService.class);

    @Autowired
    private FormMapper formMapper;
    public String  getFormId(Integer customerId){
        Form form = formMapper.getFormByCustomerId(customerId);
        if (form == null || StringUtils.isEmpty(form.getFormId())){
            log.error("获取form信息失败，customerId ==>{}",customerId);
            return null;
        }

       if (formMapper.deleteFormById(form.getMinaFormId())!= 1 ){
            log.error("删除form信息失败，form ==>{}",form);
            return null;
        }
        return form.getFormId();
    }
}
