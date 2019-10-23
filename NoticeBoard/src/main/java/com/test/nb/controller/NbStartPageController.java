package com.test.nb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.nb.domain.MainImgClickCommentDto;
import com.test.nb.domain.NbInfoDto;
import com.test.nb.service.boardService.NbReadCntListService;
import com.test.nb.service.mainPageService.NbMainBestListService;
import com.test.nb.service.mainPageService.NbMainImgClickCommentService;

@Controller
@RequestMapping("/start")
public class NbStartPageController {
	@Autowired
	NbReadCntListService readCntService;
	@Autowired
	NbMainBestListService mainBestService;

	
	
	
	//시작화면 베스트 3
	@ResponseBody
	@RequestMapping(value =  "/mainBestList",method = RequestMethod.GET)
	public List<NbInfoDto> mainBestList(){
		List<NbInfoDto> list= null;
		list= mainBestService.mainBestList();
		
		return list;
		
		
	}
	
}
