package com.omgz.api.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itextpdf.text.log.SysoCounter;
import com.omgz.dao.mapper.TestMapper;

@Service
public class TestService {
	
	@Autowired
	private TestMapper testMapper;
	
	
	public void handleData(){
		System.out.println("start");
		int district4 = testMapper.varidateUserPsword();
		
		System.out.println(district4);
	}

}
