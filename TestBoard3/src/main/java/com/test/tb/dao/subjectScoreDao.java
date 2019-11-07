package com.test.tb.dao;

import java.util.List;

import com.test.tb.domain.SubjectScoreTblDto;

public interface subjectScoreDao {
	
	public int scoreInsert(SubjectScoreTblDto dto);

	public List<SubjectScoreTblDto> scoreList();
	
	public int updateScore(SubjectScoreTblDto dto);
	
	public int deleteScore(int score_idx);

	public SubjectScoreTblDto totalInfo(SubjectScoreTblDto paramDto);
	
	public List<SubjectScoreTblDto>searchList(SubjectScoreTblDto paramDto);
	
	public List<SubjectScoreTblDto> subjectInfo(SubjectScoreTblDto paramDto);
	
	public int insertScoreChk(SubjectScoreTblDto paramDto);
	
	public List<SubjectScoreTblDto>detailSbjInfo(SubjectScoreTblDto paramDto);
}
