package com.test.nb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.nb.domain.NbMemberDto;
import com.test.nb.service.MyPageService.NbMemberRegService;

@RestController
@RequestMapping("/rest/member")
public class NbMemberController {
	
	@Autowired
	NbMemberRegService regService;
	@CrossOrigin
	@GetMapping("/idChk")
	public ResponseEntity<String> idChk(
			@RequestParam("nbm_id")String id
			){
		int rCnt=0;
		rCnt=regService.idChk(id);
		//System.out.println("셀렉트 아이디 체크>>rCnt="+rCnt);
		return new ResponseEntity<String>(rCnt>0?"success":"fail",HttpStatus.OK);
		
	}
	@CrossOrigin
	@PostMapping("/regist")
	public ResponseEntity<String> regMember(
			NbMemberDto dto
			){
		int rCnt=0;
		System.out.println("회원가입 멤버바인딩체크>>>"+dto.toString());
		
		rCnt=regService.regMember(dto);
		System.out.println("컨트롤러쪽 reg>>"+rCnt);			
		return new ResponseEntity<String>(rCnt>0?"success":"fail",HttpStatus.OK);
		
	}
}
