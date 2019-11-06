package com.test.tb.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.tb.dao.subjectScoreDao;
import com.test.tb.domain.SubjectScoreTblDto;

@Service("socreListService")
public class ScoreListService {
	@Autowired 
	SqlSessionTemplate template;
	
	subjectScoreDao dao;
	//입력점수쪽 리스트
	public List<SubjectScoreTblDto> scoreList(){
		dao= template.getMapper(subjectScoreDao.class);
		List<SubjectScoreTblDto> list= new ArrayList<SubjectScoreTblDto>();
		
		list= dao.scoreList();
		return list;
		
	}
	
	//조회점수쪽 토탈정보
	public SubjectScoreTblDto totalInfo(SubjectScoreTblDto paramDto){
		dao=template.getMapper(subjectScoreDao.class);
		SubjectScoreTblDto infoDto = new SubjectScoreTblDto();
		infoDto = dao.totalInfo(paramDto);
		return infoDto;
	}
	//조회쪽 리스트
	public List<SubjectScoreTblDto> searchList(SubjectScoreTblDto paramDto){
		dao=template.getMapper(subjectScoreDao.class);
		List<SubjectScoreTblDto> list = new ArrayList<SubjectScoreTblDto>();
		list = dao.searchList(paramDto);
	
		return list;
	}
	//평균 합계
	public List<SubjectScoreTblDto> subjectInfo(SubjectScoreTblDto paramDto){
		dao=template.getMapper(subjectScoreDao.class);
		List<SubjectScoreTblDto> list= new ArrayList<SubjectScoreTblDto>();
		list=dao.subjectInfo(paramDto);
		return list;
	} 
}
