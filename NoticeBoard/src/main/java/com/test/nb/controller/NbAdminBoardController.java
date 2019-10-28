package com.test.nb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.nb.domain.NbAdminBoardDto;
import com.test.nb.domain.NbAdminBoardInsetInfoDto;
import com.test.nb.domain.SearchParamDto;
import com.test.nb.service.adminBoardService.NbAdminBoardDeleteService;
import com.test.nb.service.adminBoardService.NbAdminBoardInsertService;
import com.test.nb.service.adminBoardService.NbAdminBoardListService;
import com.test.nb.service.adminBoardService.NbAdminBoardViewsUpService;
import com.test.nb.service.boardService.NbDeleteService;

@Controller
@RequestMapping("/adminBoard")
public class NbAdminBoardController {
	@Autowired
	NbDeleteService deleteService;
	@Autowired
	NbAdminBoardInsertService adminBoardInsertSerivce;
	@Autowired
	NbAdminBoardListService adminBoardListService;
	@Autowired
	NbAdminBoardDeleteService adminBoardDeleteService;
	@Autowired
	NbAdminBoardViewsUpService adminBoardViewsUpService;

	// 이 딜리트는 관리자 권한으로 유저의 게시글을 삭제하는 딜리트
	@RequestMapping(value = "/boardDelete", method = RequestMethod.POST)
	@ResponseBody
	public String adminMemberBoardDelete(
			@RequestParam("idx") int idx
			) {
		int rCnt = 0;

		rCnt = deleteService.deleteBoard(idx);

		return rCnt > 0 ? "success" : "fail";

	}

	// 관리자 게시판으로 이동
	@RequestMapping(method = RequestMethod.GET)
	public String adminBoardMove() {

		return "nBoard/adminBoard";

	}

	@RequestMapping(value = "/adminInsertForm")
	public String adminInsertMove() {

		return "nBoard/adminInsertForm";

	}

	@RequestMapping(value = "/adminBoardView")
	public String adminViewtMove(
			@RequestParam(value = "idx") int idx, 
			Model model) {
		model.addAttribute("idx", idx);
		return "nBoard/adminBoardView";

	}

	// 파일 전송
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public String insetNb(NbAdminBoardInsetInfoDto infoDto, HttpServletRequest request) {
		System.out.println("바인딩 체크>>" + infoDto.toString());

		int rCnt = 0;
		rCnt = adminBoardInsertSerivce.insertNb(request, infoDto);
		return rCnt > 0 ? "success" : "fail";
	}

	// 페이지요청
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public List<NbAdminBoardDto> pageList(@RequestParam(value = "p") int pageNumber,
			@RequestParam(value = "stype") String stype, @RequestParam(value = "keyword") String keyword) {

		List<NbAdminBoardDto> list = null;
		int totalPageList = 0;
		SearchParamDto sParamDto = new SearchParamDto();

		if (stype != null && keyword != null && !stype.isEmpty() && !keyword.isEmpty()) {
			sParamDto.setKeyword(keyword);
			sParamDto.setStype(stype);
		}

		totalPageList = adminBoardListService.selectPagelist(sParamDto);
		// 리스트 출력시 시작 게시글 번호를 구하기 위해
		totalPageList = totalPageList - ((pageNumber - 1) * 10);

		System.out.println("토탈페이지리스트체크>>" + totalPageList);

		list = adminBoardListService.getPageList(pageNumber, sParamDto);

		System.out.println("리스트사이즈체크>>>" + list.size());
		// 리스트 출력시 시작 게시글 번호를 구하기 위해
		for (NbAdminBoardDto boardDto : list) {
			boardDto.setListIdx(totalPageList);
		}

		return list;
	}

	@RequestMapping(value = "/pCount", method = RequestMethod.GET)
	@ResponseBody
	public int pCount(@RequestParam(value = "stype") String stype, @RequestParam(value = "keyword") String keyword) {
		// System.out.println(stype+keyword);
		int totalPageList = 0;
		int pageCount = 0;
		SearchParamDto sParamDto = new SearchParamDto();

		if (stype != null && keyword != null && !stype.isEmpty() && !keyword.isEmpty()) {
			sParamDto.setKeyword(keyword);
			sParamDto.setStype(stype);
		}

		totalPageList = adminBoardListService.selectPagelist(sParamDto);

		pageCount = totalPageList % 10 == 0 ? totalPageList / 10 : totalPageList / 10 + 1;

		return pageCount;
	}

	// 관리자 게시글 삭제
	@RequestMapping(value = "/adminBoardDelete", method = RequestMethod.POST)
	@ResponseBody
	public String adminBoardDelete(@RequestParam("idx") int idx, HttpServletRequest request) {
		int rCnt = 0;

		rCnt = adminBoardDeleteService.adminDeleteBoard(idx, request);

		return rCnt > 0 ? "success" : "fail";

	}

	// 관리자 게시글 뷰페이지 정보
	@RequestMapping(value = "/boardViewInfo", method = RequestMethod.GET)
	@ResponseBody
	public NbAdminBoardDto boardViewInfo(@RequestParam("idx") int idx

	) {

		NbAdminBoardDto dto = null;
		dto = adminBoardListService.adminBoardViewInfo(idx);
		return dto;
	}

	// 관리자 게시글 뷰페이지 조회수증가
	@RequestMapping(value = "/viewsUp", method = RequestMethod.POST)
	@ResponseBody
	public int viewsUp(@RequestParam("idx") int idx

	) {
		int rCnt = 0;
		rCnt = adminBoardViewsUpService.viewsUp(idx);
		return rCnt;
	}
}
