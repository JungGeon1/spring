package com.test.tb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.tb.domain.BoardTblDto;
import com.test.tb.domain.CommentTblDto;
import com.test.tb.service.commentService.CommentDeleteService;
import com.test.tb.service.commentService.CommentInsertService;
import com.test.tb.service.commentService.CommentListService;
import com.test.tb.service.commentService.CommentUpdateService;

@Controller
public class ViewPageController {
	
	@Autowired
	CommentInsertService cmtInsertService;
	@Autowired
	CommentListService cmtListService;
	@Autowired
	CommentDeleteService cmtDeleteService;
	@Autowired
	CommentUpdateService cmtUpdateService;
	@RequestMapping("/viewPage")
	public String moveViewPage(
			@RequestParam("idx") int idx,
			Model model
			) {
		model.addAttribute("idx",idx);
		return "viewPage";
		
	}
	//댓글 입력
	@ResponseBody
	@RequestMapping(value = "/commentInsert" , method = RequestMethod.POST )
	public String cmtInsert(
			CommentTblDto dto
			) {
		int rCnt=0;
		System.out.println("댓글 바인딩체크>>"+dto.toString());
		rCnt=cmtInsertService.commentInsert(dto);
		return rCnt>0?"success":"fail";
		
	}
	//답글입력
	@ResponseBody
	@RequestMapping(value = "/commentReInsert", method = RequestMethod.POST)
	public String cmtReInsert(
			CommentTblDto dto
			) {
		int rCnt=0;
		System.out.println("답글바인딩체크>>"+dto.toString());
		rCnt=cmtInsertService.reCommentInsert(dto);
		return rCnt>0?"success":"fail";
	}
	
	//ㅐㅅ글리스트
	@ResponseBody
	@RequestMapping(value = "/commentList/{idx}", method = RequestMethod.GET)
	public List<CommentTblDto> getList(
			@PathVariable("idx")int idx
			){
		
		List<CommentTblDto> list= null;
		list= cmtListService.getList(idx);
		return list;
	}
	
	//총갯수
	@ResponseBody
	@RequestMapping(value = "/allCommentCnt", method = RequestMethod.GET ) 
	public int allCmtCnt() {
		int rCnt=0;
		
		rCnt=cmtListService.allCommentcnt();
		
		return rCnt;
		
	}
	//정보
	@ResponseBody
	@RequestMapping(value = "/commentInfo/{idx}", method = RequestMethod.GET)
	public CommentTblDto boardInfo(
			@PathVariable(value = "idx")int idx
			) {
		
		CommentTblDto dto=null;
		dto=cmtListService.commentInfo(idx);
		return dto;
		
	}
	//수정
	@ResponseBody                                                                    //반환을 한글로 인코딩할경우
	@RequestMapping(value = "/commentUpdate", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	public String cmtUpdate(
			CommentTblDto dto
			) {
		
		int rCnt=0;
		String resultMsg="";
		rCnt=cmtUpdateService.updateComment(dto);
		switch(rCnt){
			case 0 :
			resultMsg="실패";
			
			break;
		
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
	@RequestMapping(value = "/commentDelete", method = RequestMethod.POST, produces = "application/text; charset=utf8")
	public String cmtDelete(
			CommentTblDto dto
			) {
		
		int rCnt=0;
		String resultMsg="";
		rCnt=cmtDeleteService.deleteComment(dto);
		switch(rCnt){
			case 0 :
			resultMsg="실패";
				break;
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
