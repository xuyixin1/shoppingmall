package com.vicmob.shoppingmall.constant;

//mybatis插入enum数据是需要用到
public interface BaseEnum<T> {
    T getMybatisValue();
}
