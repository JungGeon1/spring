package com.bitcamp.mm.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitcamp.mm.member.service.MemberVerifyService;

@Controller
public class MemberVerifyController {
	
	@Autowired
	private MemberVerifyService verifyService;
	
	
	@RequestMapping("/member/verify")
	public String verify(
			@RequestParam("id") String id,
			@RequestParam("code") String code
			) {
		String verifyResult = verifyService.verify(id, code);
		
		return "member/verify"+verifyResult;		
	}
	
	@ResponseBody
	@RequestMapping("/member/verify/reMailSend")
	public String reMailSend(
			@RequestParam("email")String eamil
			) {
		
		int rCnt = verifyService.reMailSend(eamil);
		
		//String result = null;
		
		return rCnt>0?"success":"fail";
	}
	
}
