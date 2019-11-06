package com.test.tb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.tb.domain.AdminTblDto;
import com.test.tb.domain.BoardTblDto;
import com.test.tb.service.AdminInsertService;
import com.test.tb.service.BoardInsertService;

@Controller
public class AdminController {
	@Autowired
	AdminInsertService insertService;

	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public String adminInsert(
			AdminTblDto tblDto
			) {
		int rCnt=0;
		System.out.println("바인딩 체크>>"+tblDto.toString());
		rCnt=insertService.adminInsert(tblDto);
		return rCnt>0?"success":"fail";
	}
	

	
	
}	
