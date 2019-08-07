package com.bitcamp.mm.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberDeleteController {
	
	@RequestMapping("/member/delete")
	public String deleteMember(@RequestParam("id")String id, Model model) {
		model.addAttribute("id", id);
		System.out.println(id);
		
		
		return "member/deleteForm";
	}
	@RequestMapping("/member/delete")
	public String delete() {
		
		
		return "member/delete";
	}
	
}
