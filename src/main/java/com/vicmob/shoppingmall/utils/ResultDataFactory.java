package com.vicmob.shoppingmall.utils;

import com.github.pagehelper.PageInfo;
import com.vicmob.shoppingmall.constant.ResponseStatus;

import java.util.Collections;
import java.util.List;

/**
 * 
 * @author cardinfolink
 *
 */
public class ResultDataFactory {

	public static <T> ResultData getResultData(List<T> list) {
		if(list == null){
			list = Collections.emptyList();
		}
		PageInfo<T> pageInfo = new PageInfo<T>(list);
        ResultData result = new ResultData("success", ResponseStatus.SUCCESS.getValue(),list,pageInfo.getSize(),
        		pageInfo.getPageNum(),pageInfo.getTotal());
		return result;
	}

}
