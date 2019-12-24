package com.vicmob.shoppingmall.web.goods.service;

import com.vicmob.shoppingmall.constant.Constant;
import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.ResultData;
import com.vicmob.shoppingmall.web.goods.dao.BusinessTemplateMapper;
import com.vicmob.shoppingmall.web.goods.dao.TemplateMapper;
import com.vicmob.shoppingmall.web.goods.entity.BusinessTemplate;
import com.vicmob.shoppingmall.web.goods.entity.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class BusinessTemplateService {
    private final Logger log = LoggerFactory.getLogger(BusinessTemplateService.class);

    @Autowired
    private BusinessTemplateMapper businessTemplateMapper;

    public BusinessTemplate getTemplateByType(Constant.InformType informType){
        if (informType == null){
            log.error("getTemplateByType 参数为空 informType  ==>{}",informType);
            return null;
        }
       return businessTemplateMapper.getTemplateByType(informType);
    }
}
