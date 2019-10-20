package com.test.nb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.nb.domain.InsertInfoDto;
import com.test.nb.domain.NbInfoDto;
import com.test.nb.domain.SearchParamDto;
import com.test.nb.domain.ViewPageDataDto;
import com.test.nb.service.NbBoardCntService;
import com.test.nb.service.NbDeleteService;
import com.test.nb.service.NbInsertService;
import com.test.nb.service.NbListService;
import com.test.nb.service.UpdateService;
import com.test.nb.service.ViewPageService;
import com.test.nb.service.ViewsUpService;

@RestController
@RequestMapping("/rest")
public class NbController {
	
	@Autowired
	NbInsertService insertService;
	@Autowired
	NbListService pListService;
	@Autowired
	ViewPageService viewService;
	@Autowired
	ViewsUpService upService;
	@Autowired
	NbDeleteService deleteService;
	@Autowired
	UpdateService UpdateService;
	@Autowired
	NbBoardCntService boardCntService;
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<String>insetNb(
			InsertInfoDto info,
			HttpServletRequest request
			){
		System.out.println("바인딩 체크>>"+info.toString());
		
		int rCnt=0;
		rCnt=insertService.insertNb(request, info);
		return new ResponseEntity<String>(rCnt>0?"success":"fail",HttpStatus.OK);
	}
	
	
	//받은 페이지번호에 해당하는 페이지리스트구하기
	@CrossOrigin
	@GetMapping("/pList")
	public ResponseEntity<List<NbInfoDto>>pageList(
			@RequestParam(value = "p") int pageNumber,
			@RequestParam(value = "category") String category,
			@RequestParam(value = "stype") String stype,
			@RequestParam(value = "keyword") String keyword
			){
		
		List<NbInfoDto> list=null;
		int totalPageList=0;
		SearchParamDto sParamDto= new SearchParamDto();
		
		if(stype!=null&&keyword!=null&&!stype.isEmpty()&&!keyword.isEmpty()) {
			sParamDto.setKeyword(keyword);
			sParamDto.setStype(stype);
		}
		
		
		totalPageList=pListService.selectPagelist(category, sParamDto);
		//리스트 출력시 시작 게시글 번호를 구하기 위해
		totalPageList=totalPageList-((pageNumber-1)*6);
		
		System.out.println("토탈페이지리스트체크>>"+totalPageList);
		
		
		
		list=pListService.getPageList(pageNumber,category,sParamDto);
		
		System.out.println("리스트사이즈체크>>>"+list.size());
		//리스트 출력시 시작 게시글 번호를 구하기 위해
		for (NbInfoDto nbInfo : list) {
			nbInfo.setpListCnt(totalPageList);
		}
		
		return new ResponseEntity<List<NbInfoDto>>(list,HttpStatus.OK);
	}
	
	
	//총 필요한 페이지 갯수 구하기
	@CrossOrigin
	@GetMapping("/pCount")
	public ResponseEntity<Integer> pCount(
			@RequestParam(value = "category") String category,
			@RequestParam(value = "stype") String stype,
			@RequestParam(value = "keyword") String keyword
			){
		System.out.println(stype+keyword);
		int totalPageList=0;
		int pageCount=0;
		SearchParamDto sParamDto= new SearchParamDto();
		
		if(stype!=null&&keyword!=null&&!stype.isEmpty()&&!keyword.isEmpty()) {
			sParamDto.setKeyword(keyword);
			sParamDto.setStype(stype);
		}
	
		totalPageList=pListService.selectPagelist(category, sParamDto);
		
		pageCount=totalPageList%6==0?totalPageList/6:totalPageList/6+1;
		
		
		return new ResponseEntity<Integer>(pageCount,HttpStatus.OK);
	}
	
	
	
	
	//PageListViewPage
	@CrossOrigin
	@GetMapping("/viewPage")
	public ResponseEntity<NbInfoDto> getViewPage(
			@RequestParam(value = "category") String category,
			@RequestParam(value = "idx")int idx
			){
		
		ViewPageDataDto pageData= new ViewPageDataDto();
		
		pageData.setCategory(category);
		pageData.setIdx(idx);
		
		return new ResponseEntity<NbInfoDto>(viewService.viewData(pageData),HttpStatus.OK);
	}
	@CrossOrigin
	@PutMapping("/viewUp/{idx}")
	public ResponseEntity<String> getViewUp(
			@PathVariable int idx
			){
		int rCnt= upService.viewsUp(idx);		
		
		return new ResponseEntity<String>(rCnt>0?"success":"fail",HttpStatus.OK);
	}
	
	@CrossOrigin
	@DeleteMapping("/delete/{idx}")
	public ResponseEntity<String> getDelete(
			@RequestParam(value = "category") String category,
			@PathVariable String idx,
			HttpServletRequest request
			){
		
		Map<String, String> deleteMap= new HashMap<String, String>();
		deleteMap.put("idx", idx);
		deleteMap.put("category", category);
		int rCnt=0;	
		rCnt=deleteService.deleteBoard(request,deleteMap);
		return new ResponseEntity<String>(rCnt>0?"success":"fail",HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping("/update")
	public ResponseEntity<String>UpdateNb(
			InsertInfoDto info,
			HttpServletRequest request
			){
		System.out.println("바인딩 체크>>"+info.toString());
		
		int rCnt=0;
		rCnt=UpdateService.updateNb(request, info);
		
		return new ResponseEntity<String>(rCnt>0?"success":"fail",HttpStatus.OK);
	}
	
	
	@CrossOrigin
	@GetMapping("/totalBoardCnt")
	public ResponseEntity<Integer>totalBoardCnt(){
		
		int rCnt=0;
		rCnt=boardCntService.totalBoard();		
		return new ResponseEntity<Integer>(rCnt,HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/todayBoardCnt")
	public ResponseEntity<Integer>todayBoardCnt(){
		
		int rCnt=0;
		rCnt=boardCntService.todayBoard();	
		
		return new ResponseEntity<Integer>(rCnt,HttpStatus.OK);
	}

}
