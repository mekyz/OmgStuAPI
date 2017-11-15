package com.omgz.dao.mapper;

import java.util.List;
import java.util.Map;

import com.omgz.pojo.Users;

public interface TestMapper {
	
	public int varidateUserPsword();
	
	public List<Map<String, Object>> getProductListByDid(Long did);
	
	

}