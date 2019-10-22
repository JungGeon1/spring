package com.test.nb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import com.test.nb.service.NbLoginService;

@Controller
public class NbLoginController {
	@Autowired
	NbLoginService loginService;

	// 로그인
	@RequestMapping("/login")
	public String login(HttpSession session) {
		session.invalidate();
		return "nBoard/login/loginForm";
	}

	// 로그아웃
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		System.out.println("로그아웃");
		return "redirect:/login";
	}

	@RequestMapping(value = "login/loginReq", method = RequestMethod.POST)
	public String login(
			@RequestParam("nbm_id") String id, 
			@RequestParam("nbm_pw") String pw,
			HttpServletRequest request) {
		System.out.println("아이디비번>>>"+id+pw);
		System.out.println(request.getContextPath());
		String view = "nBoard/login/loginFail";

		int loginChk = 0;

		loginChk = loginService.login(id, pw, request);

		switch (loginChk) {
	
		case 1:
			// response없이 리다이렉트-> 코어태그마냥 컨텍스트경로 제외하고 /main 이런식으로 작성한다
			view = "redirect:/myPage/start";
			break;
			
		case 2:
			view = "nBoard/verify/notVerify";
			break;

		}

		return view;

	}
	
	
		//관리자 로그인 페이지 이동
		@RequestMapping("/login/admin")
		public String loginAdmin(HttpSession session) {
			session.invalidate();
			return "nBoard/login/adminLoginForm";
		}
		
		//관리자로그인
		@RequestMapping(value = "login/adminLoginReq", method = RequestMethod.POST)
		public String adminlogin(
				@RequestParam("admin_id") String id, 
				@RequestParam("admin_pw") String pw,
				HttpServletRequest request) {
			System.out.println("아이디비번>>>"+id+pw);
			System.out.println(request.getContextPath());
			String view = "nBoard/login/adminLoginFail";

			int loginChk = 0;

			loginChk = loginService.adminLogin(id, pw, request);

			if(loginChk>0) {
		
				// response없이 리다이렉트-> 코어태그마냥 컨텍스트경로 제외하고 /main 이런식으로 작성한다
				view = "redirect:/adminPage";
				}

			return view;

		}
		
		
}
