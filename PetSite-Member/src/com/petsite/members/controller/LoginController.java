package com.petsite.members.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.petsite.members.domain.KakaoLoginInfo;
import com.petsite.members.domain.MemberInfo;
import com.petsite.members.service.LoginService;
import com.petsite.members.service.RegService;

@RestController
@CrossOrigin
@RequestMapping("/members/login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@PostMapping
	public Map<String, String> login(HttpServletRequest request, @RequestParam("id") String id,
			@RequestParam("pw") String pw) {

		int cnt = loginService.login(id, pw, request);
		String view = "";

		Map<String, String> maps = new HashMap<String, String>();

		if (cnt == 1) {
			// 1. 인증 처리됨 -> 메인 화면으로
			view = "success";
			maps.put("id", id);
			maps.put("view", view);
		} else if (cnt == 2) {
			// 2. 미인증 회원 -> 이메일 다시 보내기
			view = "undefined";
			maps.put("id", null);
			maps.put("view", view);
		} else if (cnt == 3) {
			// 3. 로그인 실패 -> loginFail 페이지
			view = "loginfail";
			maps.put("id", null);
			maps.put("view", view);
		}

		/* return new ResponseEntity<String>(cnt>0?"success":"fail", HttpStatus.OK); */
		// return new ResponseEntity<String>(view, HttpStatus.OK);
		return maps;
	}

	@PostMapping("/kakao")
	public String kakaoLogin(KakaoLoginInfo kakaoLoginInfo) {
		
		
		
		return null;
	}
}
