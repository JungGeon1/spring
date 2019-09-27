package com.test.nb.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.nb.domain.NbMemberDto;
import com.test.nb.service.NbMypageService;

@Controller
@RequestMapping("/myPage")
public class NbMypageController {

	@Autowired
	NbMypageService myPageService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String  myPage() {
		
		
		return "nBoard/myPage";
	}
	
	
	
	@RequestMapping(value = "/view",method = RequestMethod.GET)
	@ResponseBody
	public NbMemberDto myPageView(
			@RequestParam("nbm_id") String nbm_id
			) {
		System.out.println(nbm_id);
		NbMemberDto memberDto= null;
		
		memberDto =myPageService.getMyPageView(nbm_id);
		
		return memberDto;
	}
	
}
