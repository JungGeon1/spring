package com.test.nb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.nb.service.boardService.NbDeleteService;

@Controller
@RequestMapping("/adminBoard")
public class NbAdminBoardController {
	@Autowired
	NbDeleteService deleteService;
	
	@RequestMapping(value = "/boardDelete", method = RequestMethod.POST)
	@ResponseBody
	public String adminBoardDelete(
			@RequestParam("idx") String idx,
			@RequestParam("category") String category
			) {
		int rCnt=0;
		
		rCnt=deleteService.deleteBoard(idx, category);
		
		
		return rCnt>0?"success":"fail";
		
	}
}
