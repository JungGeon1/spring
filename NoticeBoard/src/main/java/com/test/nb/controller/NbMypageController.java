package com.test.nb.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.nb.domain.NbMemberDto;
import com.test.nb.service.NbMypageDeleteService;
import com.test.nb.service.NbMypageService;

@Controller
@RequestMapping("/myPage")
public class NbMypageController {

	@Autowired
	NbMypageService myPageService;
	@Autowired
	NbMypageDeleteService deleteService;
	
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
	@ResponseBody
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String nbMypageDelete(
			@RequestParam("nbm_id") String id,
			@RequestParam("nbm_pw") String pw
			) {
		int rCnt=0;
		System.out.println("바인딩 id :"+id+"pw:"+pw);
		rCnt= deleteService.deleteMember(id, pw);
		
		
		return rCnt>0?"success":"fail";
	}
	
}
