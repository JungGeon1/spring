package com.bitcamp.mvc.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitcamp.mvc.domain.Login;

@Controller
public class LoginControler {
	
	//로그인 폼 페이지 요청
	@RequestMapping(value = "/member/login")
	public String getLoginForm() {
		
		//view Path: Resolver의 범위에 포함된 경롱
		return "member/loginForm";
		// -> /WEB-INF/view/member/loginForm.jsp
	}
	@RequestMapping(value = "/member/loginProcess", method = RequestMethod.POST)
	public ModelAndView loginProcess(HttpServletRequest requset) {
		String id=requset.getParameter("uId");
		String pw=requset.getParameter("uPw");
		System.out.println(id+":"+pw);
		ModelAndView modelAndView= new ModelAndView();
		//viewName 설정
		
		modelAndView.setViewName("member/login");
		modelAndView.addObject("id", id);
		modelAndView.addObject("pw", pw);

		return modelAndView;
	}
	@RequestMapping(value = "/member/loginProc")																//required가 true 인 상태에서 넓값이 들어오면 400에러나옴 
	public String loginProc(@RequestParam(value = "uId",defaultValue = "holo" )String id, @RequestParam(value = "uPw", required = false)String pw, Model model) {
		System.out.println("리퀘스트 파람:"+id+":"+pw);
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "member/login";
	}
	
	
	@RequestMapping("/member/loginOk")
	public String loginOk(@ModelAttribute("user") Login login) {
		System.out.println(login.getuId()+":"+login.getuPw());
		login.setuId(login.getuId()+"-1999");
		return "member/login";
	}
	
	
	
	
	
}
