package com.test.nb.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.nb.service.NbFindPwIdChkService;


@Controller
@RequestMapping(value = "/findAccount")
public class NbfindAccountController {
	
	@Autowired
	NbFindPwIdChkService pwIdChkService;
	

	
	@RequestMapping(value = "/findId")
	public  String moveFindID() {
		
		return "nBoard/findAccount/findIdForm";
	}
	
	@RequestMapping(value = "/findPw")
	public  String moveFindPw() {
		
		
		return "nBoard/findAccount/findPwForm";
	}
	
	//회원 비밀번호변경
	@RequestMapping(value = "/findPwIdChk", method = RequestMethod.POST)
	@ResponseBody
	public String fidnPwIdChk(
			@RequestParam("nbm_id")String id,
			@RequestParam("nbm_name")String name
			) {
		
		int rCnt=0;
		
		rCnt=pwIdChkService.findPwIdchk(id, name);
		
		
		return rCnt>0?"success":"fail";
		
	}
	
	
}
