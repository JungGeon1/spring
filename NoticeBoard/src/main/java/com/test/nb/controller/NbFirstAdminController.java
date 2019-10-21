package com.test.nb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.nb.dao.nbAdminMemberDao;
import com.test.nb.domain.NbAdminMemberDto;
import com.test.nb.domain.NbMemberDto;
import com.test.nb.service.NbAdminPageListService;
import com.test.nb.service.NbCreateAdminService;

@Controller
@RequestMapping(value = "/firstAdmin")
public class NbFirstAdminController {

	@Autowired
	NbAdminPageListService listService;
	@Autowired
	NbCreateAdminService createService;

	// 관리자 수 체크
	@RequestMapping(value = "/adminChk", method = RequestMethod.GET)
	@ResponseBody
	public List<NbAdminMemberDto> madminChk() {
		List<NbAdminMemberDto> list = null;

		list = listService.adminList();
		return list;

	}

	// 계정생성으로 이동
	@RequestMapping(value = "/createAdmin", method = RequestMethod.GET)
	public String createAdminFrom() {

		return "nBoard/createAdmin";
	}

	// 계정생성
	@RequestMapping(value = "/createAdmin", method = RequestMethod.POST)
	@ResponseBody
	public String createAdmin(NbAdminMemberDto adminDto) {
		int rCnt = 0;
		//System.out.println(adminDto.toString());
		rCnt=createService.createAdminMember(adminDto);
		return rCnt > 0 ? "success" : "fail";
	}
	
	
}
