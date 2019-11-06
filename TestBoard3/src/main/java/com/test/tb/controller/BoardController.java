package com.test.tb.controller;

import java.util.List;

import org.apache.ibatis.annotations.Case;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.tb.domain.AdminTblDto;
import com.test.tb.domain.BoardTblDto;
import com.test.tb.service.AdminInsertService;
import com.test.tb.service.BoardDeleteService;
import com.test.tb.service.BoardInsertService;
import com.test.tb.service.BoardListService;
import com.test.tb.service.BoardUpdateService;

@Controller
public class BoardController {
	
	@Autowired
	BoardInsertService boardInsertServie;
	@Autowired
	BoardListService boardLisetService;
	@Autowired
	BoardUpdateService boardUpateService;
	@Autowired
	BoardDeleteService boardDeleteService;

	
	@RequestMapping("/board")
	public String moveBoard() {
		
		
		return "start";
	}
	@ResponseBody
	@RequestMapping(value = "/boardInsert" , method = RequestMethod.POST )
	public String boardInsert(
			BoardTblDto dto
			) {
		int rCnt=0;
		System.out.println("게시판 바인딩체크>>"+dto.toString());
		rCnt= boardInsertServie.boardInsert(dto);
		
		return rCnt>0?"success":"fail";
		
	}
	@ResponseBody
	@RequestMapping(value = "boardReInsert", method = RequestMethod.POST)
	public String boardReInsert(
			BoardTblDto dto
			) {
		int rCnt=0;
		System.out.println("바인딩체크>>"+dto.toString());
		rCnt=boardInsertServie.reBoardInsert(dto);
		return rCnt>0?"success":"fail";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/boardList", method = RequestMethod.GET)
	public List<BoardTblDto> getList(){
		
		List<BoardTblDto> list= null;
		list= boardLisetService.getList();
		return list;
	}
	
	@ResponseBody
	@RequestMapping(value = "/allBoardCnt", method = RequestMethod.GET ) 
	public int allBoardCnt() {
		int rCnt=0;
		
		rCnt=boardLisetService.allBoardcnt();
		
		return rCnt;
		
	}
	@ResponseBody
	@RequestMapping(value = "/boardInfo/{idx}", method = RequestMethod.GET)
	public BoardTblDto boardInfo(
			@PathVariable(value = "idx")int idx
			) {
		
		BoardTblDto dto=null;
		dto=boardLisetService.boardInfo(idx);
		return dto;
		
	}
	@ResponseBody                                                                    //반환을 한글로 인코딩할경우
	@RequestMapping(value = "/boardUpdate", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	public String boardUpdate(
			BoardTblDto dto
			) {
		
		int rCnt=0;
		String resultMsg="";
		rCnt=boardUpateService.updateBoard(dto);
		switch(rCnt){
			
		
			case 1 :
				resultMsg="수정되었습니다.";
				
				break;
				
			case 2 :
				
				resultMsg="비밀번호가 일치하지 않습니다.";
				break;	
		}
		return resultMsg;
		
	}
	
	@ResponseBody                                                                    //반환을 한글로 인코딩할경우
	@RequestMapping(value = "/boardDelete", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	public String boardDelete(
			BoardTblDto dto
			) {
		
		int rCnt=0;
		String resultMsg="";
		rCnt=boardDeleteService.deleteBoard(dto);
		switch(rCnt){
			
		
			case 1 :
				resultMsg="삭제되었습니다.";
				
				break;
				
			case 2 :
				
				resultMsg="비밀번호가 일치하지 않습니다.";
				break;	
		}
		return resultMsg;
		
	}

	
	
	
}	
