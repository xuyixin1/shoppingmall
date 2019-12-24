package com.vicmob.shoppingmall.web.goodsAPI.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

/**
 * @author  wangliang
 * @param <T>
 */
@JsonInclude(Include.NON_NULL)
@Data
public class ServerRespage<T> extends ServerResponse<T>{

    private PageRecord page;

    public ServerRespage(int status, String msg) {
        super(status,msg);
    }

    public ServerRespage(int status, T data, PageRecord page) {
        super(status, data);
        this.page = page;
    }

    public static <T> ServerRespage<T> createBySuccessPage(T data, PageRecord page) {
        return new ServerRespage<T>(ResponseCode.SUCCESS.getCode(),data,page);
    }

    public static <T> ServerRespage<T> createByErrorMessage(String errorMessage) {
        return new ServerRespage<T>(ResponseCode.ERROR.getCode(), errorMessage);
    }
}
