package com.vicmob.shoppingmall.web.goods.service;

import com.vicmob.shoppingmall.constant.Constant;
import com.vicmob.shoppingmall.constant.ResponseStatus;
import com.vicmob.shoppingmall.utils.ResultData;
import com.vicmob.shoppingmall.web.goods.dao.TemplateMapper;
import com.vicmob.shoppingmall.web.goods.entity.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class TemplateService {
    private final Logger log = LoggerFactory.getLogger(TemplateService.class);

    @Autowired
    private TemplateMapper templateMapper;

    public List<Template> findTemplatList(Integer minaId){
        List<Template> templates = templateMapper.findTemplateList(minaId);
        return templates;
    }

    @Transactional(rollbackFor = Exception.class)
    public ResultData sveTemplateList(List<Template> templates){
       for (Template template : templates){
           if (!StringUtils.isEmpty(template.getInformId())) {
               if (template.getTemplateId() != null) {
                   templateMapper.updateTemplate(template);
               } else {
                   templateMapper.addTemplate(template);
               }
           } else {// 若没有设置就删除
               templateMapper.deleteTemplate(template);
           }
       }
        return new ResultData("success", ResponseStatus.SUCCESS.getValue());
    }

    public Template getTemplateByType(Integer minaId, Constant.InformType informType){
        if (minaId == null || informType == null){
            log.error("getTemplateByType 参数为空 minaId ==>{}, informType  ==>{}",minaId,informType);
            return null;
        }
       return templateMapper.getTemplateByType(minaId,informType);
    }
}
