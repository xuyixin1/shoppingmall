package com.vicmob.shoppingmall.web.goodsAPI.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

import java.io.Serializable;

/**
 * @author  wangliang
 * @param <T>
 */
@JsonInclude(Include.NON_NULL)
@Data
public class ServerResponse<T> implements Serializable{

	private static final long serialVersionUID = 1L;
	private int    status;
    private String msg;
    private T      data;

    public ServerResponse(int status) {
        this.status = status;
    }

    public ServerResponse(int status, T data) {
        this.status = status;
        this.data = data;
    }

    public ServerResponse(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public ServerResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }


    public static <T> ServerResponse<T> createBySuccess() {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String msg) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg);
    }

    public static <T> ServerResponse<T> createBySuccess(T data) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), data);
    }
    
    public static <T> ServerResponse<T> createBySuccess(String msg, T data) {
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(), msg, data);
    }
    public static <T> ServerResponse<T> createBySuccess(int successCode, T data) {
        return new ServerResponse<T>(successCode,data);
    }
    public static <T> ServerResponse<T> createBySuccessCodeMessage(int successCode, String successMessage) {
        return new ServerResponse<T>(successCode, successMessage);
    }

    public static <T> ServerResponse<T> createByError() {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), ResponseCode.ERROR.getDesc());
    }

    public static <T> ServerResponse<T> createByError(T data) {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), data);
    }  
    public static <T> ServerResponse<T> createByErrorMessage(String errorMessage) {
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(), errorMessage);
    }

    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode, String errorMessage,T data) {
        return new ServerResponse<T>(errorCode,errorMessage,data);
    }
    
    
}
