package com.test.nb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.nb.domain.NbFindAdminIdDto;
import com.test.nb.service.NbFindIdChkService;
import com.test.nb.service.NbFindPwIdChkService;


@Controller
@RequestMapping(value = "/findAccount")
public class NbfindAccountController {
	
	@Autowired
	NbFindPwIdChkService pwIdChkService;
	@Autowired
	NbFindIdChkService findIdChkService;
	

	//관리자 아이디 찾기
	@RequestMapping(value = "/findAdminId")
	public  String moveFindID() {
		
		return "nBoard/findAccount/findAdminIdForm";
	}
	
	//관리자비밀번호찾기
	@RequestMapping(value = "/findAdminPw")
	public  String moveFindAdminPw() {
		
		
		return "nBoard/findAccount/findAdminPwForm";
	}
	
	//가입자 비밀번호찾기
	@RequestMapping(value = "/findPw")
	public  String moveFindPw() {
		
		
		return "nBoard/findAccount/findPwForm";
	}
	
	//가입자 비밀번호변경 및 메일전송
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
	//관리자 아이디 찾기 및 리스트반환
	@RequestMapping(value = "/findAdminId", method = RequestMethod.POST)
	@ResponseBody
	public List<NbFindAdminIdDto> findAdminId(
			@RequestParam("admin_name")String name,
			@RequestParam("admin_email")String email
			) {
		
		List<NbFindAdminIdDto> list= null;
		
		list= findIdChkService.findIdChk(name, email);
	
		return list;
		
	}
	//관리자 비밀번호변경 및 메일전송
	@RequestMapping(value = "/findAdminPwIdChk", method = RequestMethod.POST)
	@ResponseBody
	public String findAdminPwIdChk(
			@RequestParam("admin_id")String id,
			@RequestParam("admin_email")String email
			) {
		
		int rCnt=0;
		//System.out.println(id+email);
		rCnt=pwIdChkService.findAdminPwIdchk(id, email);
		
		return rCnt>0?"success":"fail";
		
	}
	
	
}
