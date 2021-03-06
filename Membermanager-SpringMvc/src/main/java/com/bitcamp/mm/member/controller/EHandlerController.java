package com.bitcamp.mm.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bitcamp.mm.member.domain.MemberInfo;

@Controller
public class EHandlerController {
	
	@RequestMapping("/hello")
	public String page() {
		
		MemberInfo info = null;
		System.out.println(info.getIdx());
		
		return "main";
	}
	@ExceptionHandler(NullPointerException.class)
	public String handlerNullPointerExeception(NullPointerException e) {
		System.out.println("ExceptionHandler(NullPointerException.class)에 걸렸따 ");
		return "error/nullException";
	}
}
