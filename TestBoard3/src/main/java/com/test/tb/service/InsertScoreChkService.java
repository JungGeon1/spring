package com.test.tb.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.tb.dao.subjectScoreDao;
import com.test.tb.domain.SubjectScoreTblDto;

@Service("insetScoreChk")
public class InsertScoreChkService {

	@Autowired
	SqlSessionTemplate template;

	subjectScoreDao dao;
	
	public int insertScoreChk(SubjectScoreTblDto paramDto) {
		dao= template.getMapper(subjectScoreDao.class);
		
		int rCnt=0;
		
		rCnt= dao.insertScoreChk(paramDto);
		
		return rCnt;
		
	}
}
