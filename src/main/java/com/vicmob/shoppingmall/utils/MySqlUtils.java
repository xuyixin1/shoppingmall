/**
 * Copyright &copy; 2015-2020 <a href="http://www.jeeplus.org/">JeePlus</a> All rights reserved.
 */
package com.vicmob.shoppingmall.utils;

public class MySqlUtils {

	/**
	 * 根据搜索特殊字符串
	 * @param str
	 * @return 取不到返回null
	 */
	public static String specialStr(String str){
		Integer index=str.indexOf("%");
		Integer index1=str.indexOf("_");
		Integer index2=str.indexOf("\\");
		StringBuffer stringBuffer = new StringBuffer(str);
		if(index!=-1) {
			 stringBuffer.insert(index, "\\");
		}
		if(index1!=-1) {
			 stringBuffer.insert(index1, "\\");
		}
		if(index2!=-1) {
			 stringBuffer.insert(index2, "\\");
		}
		return stringBuffer.toString();
		
	}
	
	
	
}
