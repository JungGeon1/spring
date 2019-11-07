package com.test.tb.service;

import java.util.List;

import javax.security.auth.Subject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.tb.dao.subjectScoreDao;
import com.test.tb.domain.SubjectScoreTblDto;

@Service("scoreEditService")
public class ScoreEditService {
	@Autowired
	SqlSessionTemplate template;
	subjectScoreDao dao;
	
	public int updateScore(List<SubjectScoreTblDto> list) {
		
		dao=template.getMapper(subjectScoreDao.class);
		
		int rCnt=0;
		 
		SubjectScoreTblDto dto= new SubjectScoreTblDto();
			
			for(int i=0;i<list.size();i++) {
				
				if(list.get(i).getEditChk()!=null) {
					dto.setScore_idx(list.get(i).getScore_idx());
					dto.setScore_id(list.get(i).getScore_id());
					dto.setScore_score(list.get(i).getScore_score());
					dto.setScore_semester(list.get(i).getScore_semester());
					dto.setScore_subject(list.get(i).getScore_subject());
					dto.setScore_year(list.get(i).getScore_year());
					rCnt+=dao.updateScore(dto);
				}
			}
			
		
		return rCnt;		
	}
	
	 public int deleteScore(List<SubjectScoreTblDto> list) {
	
		dao=template.getMapper(subjectScoreDao.class);
		
		int rCnt=0;
		for(int i=0;i<list.size();i++) {
				
				if(list.get(i).getEditChk()!=null) {
					System.out.println(list.get(i).getEditChk());
					System.out.println(list.get(i).getScore_idx());
					rCnt += dao.deleteScore(list.get(i).getScore_idx());
				}
			}
			
		
		return rCnt;
		
		
	}
	
}
