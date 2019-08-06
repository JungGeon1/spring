package com.bitcamp.mm.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.mm.member.service.MemberLoginService;

@Controller
@RequestMapping("/member/login")
public class LoginController {
	@Autowired
	private MemberLoginService loginService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String loginForm(HttpServletRequest request) {

		String view = "member/loginForm";

		HttpSession session = request.getSession(false);
		//로그인이 되어있으면 메인페이지로 보낸다
		if (session != null && session.getAttribute("loginInfo") != null) {

			view = "redirect:/main";
		}

		return view;

	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(
			@RequestParam("uId")String id,
			@RequestParam("uPW")String pw,
			HttpServletRequest request) {
		
		
		String view="member/loginfail";
		boolean loginChk=false;
		
		loginChk=loginService.login(id, pw, request);
		
		if(loginChk) {
			
		//response없이 리다이렉트-> 코어태그마냥  컨텍스트경로 제외하고 /main 이런식으로 작성한다	
		 view="redirect:/main";
		}
		
		return view;
		
	}
}
