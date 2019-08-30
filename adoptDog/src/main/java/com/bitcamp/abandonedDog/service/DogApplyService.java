package com.bitcamp.abandonedDog.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.abandonedDog.dao.DogInterface;
import com.bitcamp.abandonedDog.domain.Doginfo;

@Service(value =  "ApplyService")
public class DogApplyService {

	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	private DogInterface dInterface;
	
	public int insertDog(Doginfo doginfo) {
		int rCnt=0;
		
		System.out.println("바인딩테스트-->"+doginfo.toString());
		dInterface= sessionTemplate.getMapper(DogInterface.class);
		
		rCnt=dInterface.insertDog(doginfo);
		System.out.println("인설트 테스트 ->"+rCnt);
		return rCnt; 
	}
	
}
