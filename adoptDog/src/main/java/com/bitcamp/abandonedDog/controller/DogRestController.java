package com.bitcamp.abandonedDog.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.abandonedDog.domain.Doginfo;
import com.bitcamp.abandonedDog.domain.SearchParam;
import com.bitcamp.abandonedDog.service.DogApplyDeleteService;
import com.bitcamp.abandonedDog.service.DogApplySearchListService;
import com.bitcamp.abandonedDog.service.DogApplyService;
import com.bitcamp.abandonedDog.service.DogApplyShowListService;
import com.bitcamp.abandonedDog.service.DogChkService;
import com.bitcamp.abandonedDog.service.DogEditFormService;





@RestController
@RequestMapping("/rest")
public class DogRestController {
	@Autowired
	DogApplyService applyService;
	@Autowired
	DogApplyShowListService listService;
	@Autowired
	DogApplyDeleteService delteService;
	@Autowired
	DogEditFormService editService;
	@Autowired
	DogChkService chkService;
	@Autowired
	DogApplySearchListService searchService;
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<String> applyDog(
			Doginfo doginfo
			) {
		System.out.println("바인딩체크-->"+doginfo);
		
		int cnt= applyService.insertDog(doginfo);
		System.out.println(cnt);
		return new ResponseEntity<String>(cnt>0?"success":"fail",HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<Doginfo>> showList(){
		
		
		List<Doginfo> list=null;
		list=listService.showList();
		System.out.println("리스트 체크-->"+list.size());
		
		ResponseEntity<List<Doginfo>> entity = new ResponseEntity<List<Doginfo>>(list, HttpStatus.OK);
		
		return entity;
	}
	
	@CrossOrigin
	@DeleteMapping("/{idx}")
	public ResponseEntity<String> deleteDog(
			@PathVariable("idx")int idx,
			@RequestParam("id")String m_id
			){
		System.out.println("삭제idx테크-->"+idx);
		System.out.println("삭제id테크-->"+m_id);
		int cnt=delteService.dogDelete(idx, m_id);
		System.out.println("삭제체크-->"+cnt);
		ResponseEntity<String> entity=  new ResponseEntity<String>(cnt>0?"success":"fail",HttpStatus.OK);
		
		return entity;
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<Doginfo> editDog(
			@PathVariable("id")int id
			) {
		Doginfo info = null;
		
		info =editService.getEditFormData(id);
		System.out.println("셀렉트 아디체크->"+info.toString());
		
		return new ResponseEntity<Doginfo>(info,HttpStatus.OK);
	}
	@CrossOrigin
	@PutMapping
	public ResponseEntity<String> updateDog(
			@RequestBody Doginfo info,
			HttpServletRequest request
			){
	    System.out.println("바인딩 체크->"+info.toString());
	    
	    
		int cnt= editService.edit(info);
		return new ResponseEntity<String>(cnt>0?"success":"fail",HttpStatus.OK);
	}
	
	
	//분양확이
	@CrossOrigin
	@GetMapping("/chk")
	public ResponseEntity<String> chkDog(
			@RequestParam("dno")String dNo
			) {
		System.out.println("체크-->"+dNo);
		Doginfo info = null;
		
		info=chkService.chkDog(dNo);
		
		return new ResponseEntity<String>(info==null?"success":"fail",HttpStatus.OK);
	}
	
	
	//검색리스트
	@CrossOrigin
	@GetMapping("/searchList")
	public ResponseEntity<List<Doginfo>> searchApplyList(

			SearchParam searchParam
			) {
		
		System.out.println(searchParam.toString());
		List<Doginfo> list=null;
		list= searchService.searchList(searchParam);
		System.out.println("검색 개수체크->"+list.size());
		ResponseEntity<List<Doginfo>> enity= new ResponseEntity<List<Doginfo>>(list, HttpStatus.OK);
		
		return enity;
	}
	
}
