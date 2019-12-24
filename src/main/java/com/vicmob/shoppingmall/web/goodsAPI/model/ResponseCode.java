package com.vicmob.shoppingmall.web.goodsAPI.model;
/**
 *
* @author WANGLIANG
* @version 2019.5.7
*
*/
public enum ResponseCode {
	 SUCCESS(0,"SUCCESS"),
	 ERROR(1,"ERROR");

	    private final int code;
	    private final String desc;


	    ResponseCode(int code, String desc){
	        this.code = code;
	        this.desc = desc;
	    }

	    public int getCode(){
	        return code;
	    }
	    public String getDesc(){
	        return desc;
	    }
}
