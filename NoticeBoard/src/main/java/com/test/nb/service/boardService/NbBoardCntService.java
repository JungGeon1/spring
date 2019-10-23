package com.test.nb.service.boardService;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.nb.dao.nbDao;

@Service("boardCntService")
public class NbBoardCntService {

	@Autowired
	SqlSessionTemplate template;
	
	nbDao dao;
	
	
	//전체 포토보드 수
	public int totalBoard() {
		dao= template.getMapper(nbDao.class);
		
		int rCnt= 0;
		
		rCnt= dao.totalBoardCnt();
		
		return rCnt;
		}
	//오늘 작성한 보드수
	public int todayBoard() {
		dao= template.getMapper(nbDao.class);
		
		int rCnt= 0;
		
		rCnt= dao.totalTodayBoardCnt();
		
		return rCnt;
		
		
	}
}
