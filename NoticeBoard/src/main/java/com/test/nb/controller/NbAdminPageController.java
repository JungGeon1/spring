package com.test.nb.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.nb.domain.NbMypageBoardInfoDto;
import com.test.nb.domain.MainImgClickCommentDto;
import com.test.nb.domain.NbAdminMemberDto;
import com.test.nb.domain.NbInfoDto;
import com.test.nb.domain.NbMemberDto;
import com.test.nb.service.NbAdminPageListService;
import com.test.nb.service.NbAdminPagerDeleteService;
import com.test.nb.service.NbMainImgClickCommentService;
import com.test.nb.service.NbMypageBoardInfoService;
import com.test.nb.service.NbMypageDeleteService;
import com.test.nb.service.NbMypageListService;
import com.test.nb.service.NbMypagePwChangeService;
import com.test.nb.service.NbMypageService;
import com.test.nb.service.NbReadCntListService;

@Controller
@RequestMapping("/adminPage")
public class NbAdminPageController {
	@Autowired 
	NbAdminPageListService listService;
	@Autowired
	NbAdminPagerDeleteService deleteService;
	
	//페이지이동ㄴ
	@RequestMapping(method = RequestMethod.GET)
	public String  myPage() {
		
		
		return "nBoard/adminPage";
	}
	@RequestMapping(value = "/adminList", method = RequestMethod.GET)
	@ResponseBody
	public List<NbAdminMemberDto> adminList(){
		List<NbAdminMemberDto> list= null;
		
		list=listService.adminList();
		return list;
		
	} 
	@RequestMapping(value = "/memberList", method = RequestMethod.GET)
	@ResponseBody
	public List<NbMemberDto> memberList(){
		List<NbMemberDto> list= null;
		
		list=listService.memberList();
		return list;
		
	} 
	
	@RequestMapping(value = "memberDelete/{nbm_idx}",method = RequestMethod.POST )
	@ResponseBody
	public String memberDelete(
			@PathVariable("nbm_idx") int nbm_idx
			) {
		int rCnt=0;
		System.out.println(nbm_idx+">>회원삭제");
		rCnt=deleteService.deleteMember(nbm_idx);
		return rCnt>0?"success":"fail";
	}
	

}
