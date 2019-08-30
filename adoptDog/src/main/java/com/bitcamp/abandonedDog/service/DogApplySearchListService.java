package com.bitcamp.abandonedDog.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.abandonedDog.dao.DogInterface;
import com.bitcamp.abandonedDog.domain.Doginfo;
import com.bitcamp.abandonedDog.domain.SearchParam;

@Service("searchListService")
public class DogApplySearchListService {
	
	@Autowired
	SqlSessionTemplate template;
	
	DogInterface dInterface;
	
	public List<Doginfo> searchList(SearchParam params) {
		
		dInterface=template.getMapper(DogInterface.class);
		
		List<Doginfo> list=null;
		
		list=dInterface.selectSearchList(params);
		
		return list;
	}

}
