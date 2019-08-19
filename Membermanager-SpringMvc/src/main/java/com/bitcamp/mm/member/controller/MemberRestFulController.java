package com.bitcamp.mm.member.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitcamp.mm.member.domain.MemberInfo;
import com.bitcamp.mm.member.domain.RequestMemberEdit;
import com.bitcamp.mm.member.domain.RequestMemberRegist;
import com.bitcamp.mm.member.service.MemberDeleteService;
import com.bitcamp.mm.member.service.MemberEditService;
import com.bitcamp.mm.member.service.MemberListService;
import com.bitcamp.mm.member.service.MemberRegService;

@RestController//@responseBody생략가능
@RequestMapping("/rest/members")
public class MemberRestFulController {
	
	@Autowired
	private MemberListService listService;
	@Autowired
	private MemberDeleteService deleteService;
	@Autowired
	private MemberRegService regService;
	@Autowired
	private MemberEditService editService;
	
	//@RequestMapping(method = RequestMethod.GET)과 같디
	//@ResponseBody
	@CrossOrigin
	@GetMapping()
	public ResponseEntity <List<MemberInfo>> getAllList(){
		
		List<MemberInfo> list= listService.getAllList();
		
		ResponseEntity<List<MemberInfo>> entity= new  ResponseEntity<List<MemberInfo>>(list, HttpStatus.OK);
		//HttpStatus.OK->200
		//HttpStatus.NOT_FOUND->404
		//HttpStatus.INTERNAL_SERVER_ERROR->500
		
		return entity;
	}
	@CrossOrigin
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteMember(
			@PathVariable("id")int idx
			) {
		
		//int cnt=deleteService.memberDelete(idx);
		return new ResponseEntity<String>(deleteService.memberDelete(idx)>0?"success":"fail",HttpStatus.OK);
	}
	@CrossOrigin
	@PostMapping
	public ResponseEntity<String> regMember(
			RequestMemberRegist regRequest,
			HttpServletRequest request
			) {
		//System.out.println("체크"+regRequest);
		
		int cnt= regService.memberInsert(request,regRequest);
		return new ResponseEntity<String>(cnt>0?"success":"fail",HttpStatus.OK);
	}
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<MemberInfo> getEditMember(
			@PathVariable("id")int idx
			) {
		MemberInfo info = null;
		
		info =editService.getEditFormData(idx);
		//int cnt=deleteService.memberDelete(idx);
		return new ResponseEntity<MemberInfo>(info,HttpStatus.OK);
	}
	@CrossOrigin
	@PutMapping
	public ResponseEntity<String> editMember(
			@RequestBody RequestMemberEdit edit,
			HttpServletRequest request
			){
	    System.out.println(edit.getIdx());
	    System.out.println(edit.getuName());
	    
		int cnt= editService.edit(edit, null,request);
		return new ResponseEntity<String>(cnt>0?"success":"fail",HttpStatus.OK);
	}
	
	
	

}
