package com.test.nb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.nb.domain.NbAdminMemberDto;
import com.test.nb.domain.NbMemberDto;
import com.test.nb.service.AdminEmpowerService;
import com.test.nb.service.NbAdminPageListService;
import com.test.nb.service.NbAdminPagerDeleteService;
import com.test.nb.service.NbIdChangeService;
import com.test.nb.service.NbPwChangeService;

@Controller
@RequestMapping("/adminPage")
public class NbAdminPageController {
	@Autowired
	NbAdminPageListService listService;
	@Autowired
	NbAdminPagerDeleteService deleteService;
	@Autowired
	NbPwChangeService pwChangeService;
	@Autowired
	NbIdChangeService idChangeService;
	@Autowired
	AdminEmpowerService empowerService;
	
	
	
	// 페이지이동ㄴ
	@RequestMapping(method = RequestMethod.GET)
	public String myPage() {

		return "nBoard/adminPage";
	}

	// 관리자목록
	@RequestMapping(value = "/adminList", method = RequestMethod.GET)
	@ResponseBody
	public List<NbAdminMemberDto> adminList() {
		List<NbAdminMemberDto> list = null;

		list = listService.adminList();
		return list;

	}

	// 가입회원목록
	@RequestMapping(value = "/memberList", method = RequestMethod.GET)
	@ResponseBody
	public List<NbMemberDto> memberList() {
		List<NbMemberDto> list = null;

		list = listService.memberList();
		return list;

	}

	
	//아이디변경
		@RequestMapping(value = "/idChange", method = RequestMethod.POST)
		@ResponseBody
		public String idChange(
				@RequestParam("admin_id") String admin_id, 
				@RequestParam("oldId") String oldId,
				@RequestParam("newId") String newId) {
			System.out.println("관리자아이디 변경 바인딩체크>>oldId:" + oldId + "newId:" + newId + "admin_id" + admin_id);
			int rCnt = 0;
			rCnt = idChangeService.adminPageIdChange(admin_id, oldId, newId);

			return rCnt > 0 ? "success" : "fail";
		}
	
	

	// 비밀번호변경
	@RequestMapping(value = "/pwChange", method = RequestMethod.POST)
	@ResponseBody
	public String pwChange(
			@RequestParam("admin_id") String id, 
			@RequestParam("oldPw") String oldPw,
			@RequestParam("newPw") String newPw) {
		//System.out.println("관리자 비밀번호 변경 바인딩체크>>oldpw:" + oldPw + "newPw:" + newPw + "admin_id" + id);
		int rCnt = 0;
		rCnt = pwChangeService.adminPagePwChange(id, oldPw, newPw);

		return rCnt > 0 ? "success" : "fail";
	}

	// 로그인중인 관리자 정보
	@RequestMapping(value = "/adminInfo", method = RequestMethod.GET)
	@ResponseBody
	public NbAdminMemberDto adminInfo(@RequestParam("admin_id") String id) {
		NbAdminMemberDto adminDto=null;
		adminDto= listService.adminInfo(id);
		return adminDto;
	}
	

	// 가입회원삭제
	@RequestMapping(value = "memberDelete/{nbm_idx}", method = RequestMethod.POST)
	@ResponseBody
	public String memberDelete
	(@PathVariable("nbm_idx") int nbm_idx
			) {
		int rCnt = 0;
		//System.out.println(nbm_idx + ">>회원삭제");
		rCnt = deleteService.deleteMember(nbm_idx);
		return rCnt > 0 ? "success" : "fail";
	}
	// 가입회원삭제
		@RequestMapping(value = "adminDelete/{admin_idx}", method = RequestMethod.POST)
		@ResponseBody
		public String adminDelete
		(@PathVariable("admin_idx") int admin_idx
				) {
			int rCnt = 0;
			//System.out.println(admin_idx + ">>회원삭제");
			rCnt = deleteService.deleteadmin(admin_idx);
			return rCnt > 0 ? "success" : "fail";
		}
		
	//통합관리자 권한 부여
		@RequestMapping(value = "/adminEmpower", method = RequestMethod.POST)
		@ResponseBody
		public String adminEmpower(
				@RequestParam("oldAdminId") String oldAdminId,
				@RequestParam("oldAdminPw") String oldAdminPw,
				@RequestParam("newAdminIdx") int newAdminIdx
				) {
			
			//System.out.println("바인딩 체크"+oldAdminId+"newIdx"+newAdminIdx+"oldAdminpw"+oldAdminPw);
			int rCnt=0;
			rCnt=empowerService.adminEmpower(oldAdminId, oldAdminPw, newAdminIdx);
			return rCnt>0?"success":"fail";
		}
			

}
