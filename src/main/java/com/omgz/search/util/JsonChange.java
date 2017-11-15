package com.omgz.search.util;
//package com.omgz.search.util;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
///**
// * JSON格式转换类
// * 
// * @author 詹昌高
// * @version 2016-12-7
// */
//public class JsonChange {
//	
//	@SuppressWarnings("unchecked")
//	public static <T> List<T> toJsonList(String str,Class<?> entityClass,List<T> list){
//		//将json转换为数组形式
//		JSONArray array = JSONArray.parseArray(str);
//		//定义一个list集合
//		List<T> l = new ArrayList<>();
//		for (int i = 0; i < array.size(); i++) {
//			//将对象天添加到集合
//    		l.add((T) JSON.parseObject(array.get(i).toString(),entityClass));
//		}
//		return l;
//	}
//
//}
