package com.vicmob.shoppingmall.web.goods.dao;

import com.vicmob.shoppingmall.constant.Constant;
import com.vicmob.shoppingmall.web.goods.entity.Template;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TemplateMapper {
    public List<Template> findTemplateList(@Param("minaId") Integer minaId);

    public Integer addTemplate(@Param("t") Template template);

    public Integer updateTemplate(@Param("t") Template template);

    public Integer deleteTemplate(@Param("t") Template template);

    public Template getTemplateByType(@Param("minaId")Integer minaId, @Param("informType")Constant.InformType informType);
}
