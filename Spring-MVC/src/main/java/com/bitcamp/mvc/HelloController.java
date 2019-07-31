package com.bitcamp.mvc;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping(value = "/hello")
	public ModelAndView hello() {
		//FromtComtroller로 전송할 view 경로와 결과 데이터 저장하고 전달할 개겣 ->ModelAndView
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("hello"); // /WEB-INF/views/hello.jsp
		modelAndView.addObject("UserName", "cool");
		modelAndView.addObject("greeting","안녕하세요 ");
		modelAndView.addObject("now", new Date());
		return modelAndView;
	}

}
