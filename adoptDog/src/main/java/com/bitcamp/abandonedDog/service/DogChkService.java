package com.bitcamp.abandonedDog.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.abandonedDog.dao.DogInterface;
import com.bitcamp.abandonedDog.domain.Doginfo;

@Service("chkService")
public class DogChkService {
	
	@Autowired
	SqlSessionTemplate sessionTemplate;
	
	DogInterface dInterface;
	
	
	
	public Doginfo chkDog(String dNo) {
		
		dInterface=sessionTemplate.getMapper(DogInterface.class);
		Doginfo info=null;
		info =dInterface.selectDno(dNo);
		//System.out.println("dno댕댕이체크-->"+info.toString());
		return info;
	}
	
	
}
