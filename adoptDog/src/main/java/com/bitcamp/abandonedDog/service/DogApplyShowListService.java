package com.bitcamp.abandonedDog.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.abandonedDog.dao.DogInterface;
import com.bitcamp.abandonedDog.domain.Doginfo;

@Service("showListService")
public class DogApplyShowListService {
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	private DogInterface dInterface;
	
	
	public List<Doginfo> showList(){
		
		List<Doginfo> list=null;
		
		dInterface=sessionTemplate.getMapper(DogInterface.class);
		
		list = dInterface.showList();
		
		return list;
	}

}
