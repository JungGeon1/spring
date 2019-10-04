package com.test.nb.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.nb.dao.nbDao;

@Service("vUpService")
public class ViewsUpService {
	@Autowired
	SqlSessionTemplate template;
	
	nbDao nbIf;

	//조회수 업
	public int viewsUp(int idx) {
		
		nbIf=template.getMapper(nbDao.class);
		
		int rCnt=0;
		
		rCnt= nbIf.viewUp(idx);
		
		return rCnt;
	}
}
