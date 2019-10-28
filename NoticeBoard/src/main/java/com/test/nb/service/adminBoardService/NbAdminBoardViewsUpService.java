package com.test.nb.service.adminBoardService;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.nb.dao.nbAdminBoardDao;
import com.test.nb.dao.nbDao;

@Service("adminBoardViewsService")
public class NbAdminBoardViewsUpService {
	@Autowired
	SqlSessionTemplate template;
	
	nbAdminBoardDao dao;

	//조회수 업
	public int viewsUp(int idx) {
		
		dao=template.getMapper(nbAdminBoardDao.class);
		
		int rCnt=0;
		
		rCnt= dao.viewUp(idx);
		
		return rCnt;
	}
}
