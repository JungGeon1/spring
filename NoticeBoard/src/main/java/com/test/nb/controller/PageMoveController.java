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
	public String pageList(
			@RequestParam(value = "category")String category,
			Model model
			) {
		model.addAttribute("category",category);
		return "nBoard/pageList";
	}// 리스트
	@RequestMapping("/storyList")
	public String storyList(
			@RequestParam(value = "category")String category,
			Model model
			) {
		model.addAttribute("category",category);
		return "nBoard/pageList";
	}

	// pageList입력화면
	@RequestMapping("/insert")
	public String insert(
		@RequestParam(value = "category")String category,
		Model model
			) {
		model.addAttribute("category",category);
		return "/nBoard/insertForm";
	};

	// pageListView페이지
	@RequestMapping("/view")
	public String view(
			@RequestParam(value = "idx") int idx, 
			@RequestParam(value = "category") String category,
			Model model) {

		model.addAttribute("idx", idx);
		model.addAttribute("category",category);
		return "/nBoard/pageView";
	}

	@RequestMapping("/updatePage")
	public String updatePage(
			@RequestParam(value = "idx") int idx, 
			@RequestParam(value = "category")String category,
			Model model) {
		model.addAttribute("category",category);
		model.addAttribute("idx", idx);
		return "/nBoard/updateForm";
	}

	// 방명록
	@RequestMapping("/scrollList")
	public String ScrollList(
			@RequestParam(value = "category")String category,
			Model model
			) {
		model.addAttribute("category",category);
		return "/nBoard/scrollList";
	}

	// 유튜브
	@RequestMapping("/youTube")
	public String youTube() {

		return "nBoard/youTubeView";
	}

	
}
