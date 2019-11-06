package com.test.tb.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.tb.dao.subjectScoreDao;
import com.test.tb.domain.SubjectScoreTblDto;

@Service("scoreInsertService")
public class ScoreInsertService {
	@Autowired
	SqlSessionTemplate template;
	
	subjectScoreDao dao;
	
	
	public int insertScore(SubjectScoreTblDto dto) {
		dao=template.getMapper(subjectScoreDao.class );
		
		int rCnt=0;
		rCnt=dao.scoreInsert(dto);
		return rCnt;
	}
}
