package com.ycxy.wdgj.common.utils;

import java.util.List;

public class CollectionUtils {
	public static <T>T getFirst(List<T> arr){
		return (arr==null || arr.size()==0)?null:arr.get(0);
	}

}
