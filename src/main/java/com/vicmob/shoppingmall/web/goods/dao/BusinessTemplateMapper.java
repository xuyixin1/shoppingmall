package com.vicmob.shoppingmall.web.goods.dao;

import com.vicmob.shoppingmall.constant.Constant;
import com.vicmob.shoppingmall.web.goods.entity.BusinessTemplate;
import org.apache.ibatis.annotations.Param;

public interface BusinessTemplateMapper {
    public BusinessTemplate getTemplateByType(@Param("informType") Constant.InformType informType);
}
