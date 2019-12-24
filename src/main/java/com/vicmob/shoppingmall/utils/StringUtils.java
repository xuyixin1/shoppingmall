package com.vicmob.shoppingmall.utils;

import com.vicmob.shoppingmall.web.goods.entity.Specification;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringUtils {
    public static final String SPILT = ":";
    public static final String DUPLICATE_SPILT = ",";
    public static String getViolationMessage(String message){
        int index = message.indexOf(SPILT);
        return message.substring(index + 2);
    }

    public static Boolean checkDuplicate(String names){
        if (org.springframework.util.StringUtils.isEmpty(names)){
            return false;
        }
       String[] name =  names.split(DUPLICATE_SPILT);
        if (name.length == 1){
            return false;
        }
        Set<String> setName = new HashSet();
        for(int i=0; i<name.length; i++){
            setName.add(org.springframework.util.StringUtils.trimWhitespace(name[i]));
        }
        if (setName.size() != name.length){
            return true;
        }
        return false;
    }

    public static Boolean checkDuplicate(List<Specification> sps){
        Set<String> setName = new HashSet();
        for (Specification sp :sps){
            String value = "";
            if (org.springframework.util.StringUtils.isEmpty(sp.getAttributeValueName2())){
                value = sp.getAttributeValueName1();
            }else{
                value = sp.getAttributeValueName1() + sp.getAttributeValueName2();
            }
            setName.add(value);
        }
        if (setName.size() != sps.size()){
            return true;
        }
        return false;
    }
}
