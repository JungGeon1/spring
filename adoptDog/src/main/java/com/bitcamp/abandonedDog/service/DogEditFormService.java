package com.bitcamp.abandonedDog.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.abandonedDog.dao.DogInterface;
import com.bitcamp.abandonedDog.domain.Doginfo;

@Service("editFormService")
public class DogEditFormService {
	@Autowired
	SqlSessionTemplate template;	
	
	DogInterface dInterface;
	
	public Doginfo getEditFormData(int id) {
		
		dInterface =template.getMapper(DogInterface.class);
		
		Doginfo info= dInterface.selectId(id);
		
		return info;
	
	
	
	}

	public int edit(Doginfo info) {
		dInterface =template.getMapper(DogInterface.class);
		int rCtn=0;
		
		rCtn=dInterface.updateDog(info);
		
		return rCtn;
	}

}
