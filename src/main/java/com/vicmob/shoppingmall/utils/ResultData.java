package com.vicmob.shoppingmall.utils;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 
 * @author xyx
 *
 */
public class ResultData extends HashMap<String, Object> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -203537849914820910L;

    public ResultData() {
    	this.put("status", 0);
    }

    public ResultData(Object obj) {
        this.put("status", 0);
        this.put("data", obj);
    }

    public ResultData(int status, Object obj) {
        this.put("status", status);
        this.put("data", obj);
    }

    public ResultData(String msg, Integer status) {
        this.put("status", status);
        this.put("msg", msg);
    }

    public ResultData(String msg,Integer status, Object obj) {
        this.put("status", status);
        this.put("msg", msg);
        this.put("data", obj);
    }



    public ResultData(String msg,Integer status, Object mems, Object size, Object page, Object total) {

        this.put("status", status);
        this.put("msg", msg);
        this.put("data", mems);
        this.put("size", size);
        this.put("page", page);
        this.put("total", total);
    }

    public int getStatus() {
        return (Integer) this.get("status");
    }

    public Object getData() {
        return  this.get("data");
    }
}
