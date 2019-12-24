package com.vicmob.shoppingmall.utils;

import com.alibaba.fastjson.JSON;

public abstract class DeepCopyUtils {
    public static Object deepCopyByJson(Object obj) {
        String json = JSON.toJSONString(obj);
        return JSON.parseObject(json, Object.class);
    }
}
