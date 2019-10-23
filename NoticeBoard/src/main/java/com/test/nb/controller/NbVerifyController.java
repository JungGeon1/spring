package com.test.nb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.nb.service.accountService.VerifyService;



@Controller
public class NbVerifyController {
	
	@Autowired
	private VerifyService verifyService;
	
	
	@RequestMapping("/verify")
	public String verify(
			@RequestParam("id") String id,
			@RequestParam("code") String code
			) {
		String verifyResult = verifyService.verify(id, code);
		
		return "nBoard/verify/verify"+verifyResult;		
	}
	
	@ResponseBody
	@RequestMapping(value =  "/verify/reMailSend" ,method = RequestMethod.POST)
	public String reMailSend(
			@RequestParam("email")String eamil
			) {
		
		int rCnt = verifyService.reMailSend(eamil);
		
		//String result = null;
		
		return rCnt>0?"success":"fail";
	}
	
}
