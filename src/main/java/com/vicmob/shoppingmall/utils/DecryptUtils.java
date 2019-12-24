package com.vicmob.shoppingmall.utils;

public class DecryptUtils {
	/** 
	*  解密
	* @return String    返回字符串
	*/
	@SuppressWarnings("finally")
	public static String getMinaId(String appId,String minaId) {
		String result=null;
		try {
			result = AesEncrypt.aesDecryption(appId, minaId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			return result;
		}
	}
}
