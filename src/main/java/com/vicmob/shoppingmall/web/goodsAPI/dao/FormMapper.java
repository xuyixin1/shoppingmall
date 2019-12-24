package com.vicmob.shoppingmall.web.goodsAPI.dao;

import com.vicmob.shoppingmall.web.goodsAPI.model.Form;
import org.apache.ibatis.annotations.Param;

public interface FormMapper {
    Form getFormByCustomerId(@Param("customerId") Integer customerId);

    int  deleteFormById(@Param("minaFormId") Integer minaFormId);

}
