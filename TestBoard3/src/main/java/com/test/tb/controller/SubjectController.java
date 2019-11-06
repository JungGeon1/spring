package com.test.tb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.tb.domain.SubjectScoreTblDto;
import com.test.tb.service.ScoreEditService;
import com.test.tb.service.ScoreInsertService;
import com.test.tb.service.ScoreListService;

@Controller
public class SubjectController {
	@Autowired 
	ScoreInsertService insertService;
	@Autowired
	ScoreListService listService;
	@Autowired
	ScoreEditService editService;
	
	@RequestMapping(value = "/subjectScore")
	public String moveSubjcetScore() {
		return "subjectScoreForm";
	}

	@RequestMapping(value = "/insertScore",method = RequestMethod.POST)
	@ResponseBody
	public String insertScore(
			SubjectScoreTblDto dto
			) {
		int rCnt = 0;
		
		System.out.println("score바인딩체크>>" + dto.toString());
		rCnt=insertService.insertScore(dto);
		return rCnt > 0 ? "successs" : "fail";

	}
	
	
	
	
	@RequestMapping(value = "/editScore",method = RequestMethod.POST)
	@ResponseBody
	public int editScore(
			SubjectScoreTblDto dto
			) {
		int rCnt = 0;
		
		//System.out.println("score바인딩체크>>" + dto.toString());
		System.out.println(dto.getList().size());
		
		rCnt=editService.scoreEdit(dto.getList());
		return rCnt;

	}
	
	
	@ResponseBody
	@RequestMapping(value = "/scoreList", method = RequestMethod.GET)
	public List<SubjectScoreTblDto> scoreList(){
		
		List<SubjectScoreTblDto> list= null;
		list=listService.scoreList();
		return list;
		
	}
	
	@RequestMapping(value = "/totalScore")
	public String movetotalScore() {
		return "totalScore";
	}
	
	@ResponseBody
	@RequestMapping(value = "/totalInfo", method = RequestMethod.GET)
	public SubjectScoreTblDto  totalInfo(
			SubjectScoreTblDto paramDto
			) {
		SubjectScoreTblDto totalInfoDto=null;
		System.out.println(paramDto.getScore_year());
		System.out.println(paramDto.getScore_semester());
		totalInfoDto = listService.totalInfo(paramDto);
		return totalInfoDto;
	}
	@ResponseBody
	@RequestMapping(value = "/searchList", method = RequestMethod.GET)
	public List<SubjectScoreTblDto>searchList(
			SubjectScoreTblDto paramDto
			){
		List<SubjectScoreTblDto> list= null;
		System.out.println(paramDto.getScore_year());
		System.out.println(paramDto.getScore_semester());
		list = listService.searchList(paramDto);
		return list;
	}
	@ResponseBody
	@RequestMapping(value = "/subjectInfo", method = RequestMethod.GET)
	public List<SubjectScoreTblDto> subjectInfo(
			SubjectScoreTblDto paramDto
			){
		List<SubjectScoreTblDto> list= null;
		list=listService.subjectInfo(paramDto);
		return list;
	}
}
