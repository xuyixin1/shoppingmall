package com.vicmob.shoppingmall.utils;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vicmob.shoppingmall.constant.ResponseStatus;

import java.io.Serializable;

@JsonSerialize(include= JsonSerialize.Inclusion.NON_NULL)
public class ResultData1<T> implements Serializable {
    private static final long serialVersionUID = -4505655308965878999L;


    //返回描述
    private String msg;
    //返回码
    private Integer status;
    //返回数据
    private T data;
    private Integer size;
    private Integer page;
    private Integer total;

    public ResultData1(){
        this.status = ResponseStatus.SUCCESS.value;
        this.msg = "sucess";
    }

    public ResultData1(String msg, Integer status){
        this.msg = msg;
        this.status = status;
    }
    public ResultData1(String msg, Integer status, T data){
        this.msg = msg;
        this.status = status;
        this.data = data;
    }
    public ResultData1(T data){
        this.data = data;
        this.status = ResponseStatus.SUCCESS.value;
    }

    public ResultData1(String msg,Integer status, T data, Integer size, Integer page, Integer total) {

        this.msg = msg;
        this.status = status;
        this.data = data;
        this.size = size;
        this.page = page;
        this.total = total;
    }


}

