package com.test.nb.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.nb.domain.NbMypageBoardInfoDto;
import com.test.nb.domain.NbInfoDto;
import com.test.nb.domain.NbMemberDto;
import com.test.nb.service.NbMypageBoardInfoService;
import com.test.nb.service.NbMypageDeleteService;
import com.test.nb.service.NbMypageListService;
import com.test.nb.service.NbMypagePwChangeService;
import com.test.nb.service.NbMypageService;
import com.test.nb.service.NbReadCntListService;

@Controller
@RequestMapping("/myPage")
public class NbMypageController {

	@Autowired
	NbMypageService myPageService;
	@Autowired
	NbMypageDeleteService deleteService;
	@Autowired
	NbMypageBoardInfoService boardInfoService; 
	@Autowired
	NbMypageListService listService;
	@Autowired
	NbMypagePwChangeService pwchangeSerivce;
	@Autowired
	NbReadCntListService  readCntService;
	
	
	
	// 로그인 시작화면
		@RequestMapping(value = "/start", method = RequestMethod.GET)
		public String start() {

			return "nBoard/myStart";
		}
	
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
	
	
	//유저가 작성한 게시판정보
	@RequestMapping(value = "/showBoardInfo",method = RequestMethod.GET)
	@ResponseBody
	public NbMypageBoardInfoDto showBoard(
			@RequestParam("nbm_id") String nbm_id
			) {
		System.out.println("바인딩 아이디체큰"+nbm_id);
		
		NbMypageBoardInfoDto bInfoDto= null;
		bInfoDto= boardInfoService.selectBoardInfo(nbm_id);
		
		
		return bInfoDto;
	}
	
	@RequestMapping(value = "/mypageList", method = RequestMethod.GET) 
	@ResponseBody
	public List<NbInfoDto> mypageList(
			@RequestParam("nbm_id")String  nbm_id,
			@RequestParam("category")String category
			){
		
		Map<String, String> listMap= new HashMap<String, String>();
		List<NbInfoDto> list=null;
		listMap.put("nbm_id", nbm_id);
		listMap.put("category", category);
		
		list=listService.myPageList(listMap);
		
		return list;
		
	}

	@RequestMapping(value = "/pwChange", method = RequestMethod.POST)
	@ResponseBody
	public String pwChage(
			@RequestParam("nbm_id") String id,
			@RequestParam("oldPw") String oldPw,
			@RequestParam("newPw")String newPw 
			) {
		System.out.println("바인딩체크>>oldpw:"+oldPw+"newPw:"+newPw+"nbm_id"+id);
		int rCnt=0;
		rCnt=pwchangeSerivce.myPagePwChange(id, oldPw, newPw);
		
		return rCnt>0?"success":"fail";
	}
	//로그인시 유저의 조회수 탑3 
	@ResponseBody
	@RequestMapping(value =  "/readCntList",method = RequestMethod.GET)
	public List<NbInfoDto> readCntList(
			@RequestParam("nbm_id") String id
			){
		List<NbInfoDto> list= null;
		list= readCntService.selectReadCntList(id);
		
		return list;
		
		
	}
}
