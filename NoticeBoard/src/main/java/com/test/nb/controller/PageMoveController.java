package com.test.nb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageMoveController {


	// 회원가입
	@RequestMapping("/regist")
	public String regist() {
		return "nBoard/registForm";
	}

	// 리스트
	@RequestMapping("/pageList")
	public String pageList() {

		return "nBoard/pageList";
	}

	// pageList입력화면
	@RequestMapping("/insert")
	public String insert() {
		return "/nBoard/insertForm";
	}

	// pageListView페이지
	@RequestMapping("/view")
	public String view(@RequestParam(value = "idx") int idx, Model model) {

		model.addAttribute("idx", idx);
		return "/nBoard/pageView";
	}

	@RequestMapping("/updatePage")
	public String updatePage(@RequestParam(value = "idx") int idx, Model model) {

		model.addAttribute("idx", idx);
		return "/nBoard/updateForm";
	}

	// 방명록
	@RequestMapping("/scrollList")
	public String ScrollList() {
		return "/nBoard/scrollList";
	}

	// 유튜브
	@RequestMapping("/youTube")
	public String youTube() {

		return "nBoard/youTubeView";
	}

	
}
