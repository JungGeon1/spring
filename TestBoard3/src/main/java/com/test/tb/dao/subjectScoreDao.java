package com.test.tb.dao;

import java.util.List;

import com.test.tb.domain.SubjectScoreTblDto;

public interface subjectScoreDao {
	
	public int scoreInsert(SubjectScoreTblDto dto);

	public List<SubjectScoreTblDto> scoreList();
	
	public int listEdit(SubjectScoreTblDto dto);

	public SubjectScoreTblDto totalInfo(SubjectScoreTblDto paramDto);
	
	public List<SubjectScoreTblDto>searchList(SubjectScoreTblDto paramDto);
	
	public List<SubjectScoreTblDto> subjectInfo(SubjectScoreTblDto paramDto);
}
