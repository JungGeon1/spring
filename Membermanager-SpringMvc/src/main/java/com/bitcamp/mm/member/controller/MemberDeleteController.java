package com.bitcamp.mm.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitcamp.mm.member.service.MemberDeleteService;

import oracle.net.aso.d;

@Controller
public class MemberDeleteController {
	@Autowired
	private MemberDeleteService deleteSerivce;

	@RequestMapping("/member/memberdelete")
	public String delete(@RequestParam("memberId") int idx, Model model) {

		int dCnt = 0;
		dCnt = deleteSerivce.memberDelete(idx);
		model.addAttribute("dCnt", dCnt);
		return "redirect:/member/memberList";
	}

	@RequestMapping("member/delete/{id}")
	public String del(@PathVariable("id") int idx) {

		deleteSerivce.memberDelete(idx);

		return "redirect:/member/memberList";
	}
}