package com.bitcamp.abandonedDog.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.abandonedDog.dao.DogInterface;

@Service("deleteService")
public class DogApplyDeleteService {
	@Autowired
	SqlSessionTemplate sessionTemplate;
	
	DogInterface dInterface;
	
	public int dogDelete(int id, String m_id) {
		
		dInterface=sessionTemplate.getMapper(DogInterface.class);
		
		int rCnt=0;
		
		rCnt=dInterface.deleteDog(id, m_id);
		
		return rCnt;
	}
	
}
