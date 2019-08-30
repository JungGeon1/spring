package com.bitcamp.rc;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class RestfulClientController {
	
	@CrossOrigin
	@RequestMapping("/list")
	@ResponseBody
	public List<MemberInfo> getAllList() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		MemberInfo[] members = restTemplate.getForObject(
				"http://localhost:8080/mm/rest/members", 
				MemberInfo[].class);
		
		List<MemberInfo> list = Arrays.asList(members);
		
		for(MemberInfo m : list) {
			System.out.println(m);
		}
		
		
		return list;
	}
	
	
	@RequestMapping("/member/{idx}")
	@ResponseBody
	public String getMemember(
			@PathVariable("idx") int idx
			) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		MemberInfo info = restTemplate.getForObject(
				"http://localhost:8080/mm/rest/members/{id}", 
				MemberInfo.class,
				idx);
		
		System.out.println(info);
		
		
		
		
		return null;
		
	}


	
	@RequestMapping("/member/xml/list")
	@ResponseBody
	public ListViewDataXml getMememberXml() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		ListViewDataXml data = restTemplate.getForObject(
				"http://localhost:8080/mm/member/xml/memberList.xml", 
				ListViewDataXml.class);
		
		System.out.println(data.getTotalCount());
		System.out.println(data.getCurrentPageNumber());
		
		for(MemberInfoXml m : data.getMemberList()) {
			System.out.println(m);
		}
		
		
		
		
		return data;
		
	}
	

	
	@RequestMapping("/dog/xml/list")
	@ResponseBody
	public DogRestResponse getDogXml() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		DogRestResponse data = restTemplate.getForObject(
				"http://localhost:8080/client/dog.xml", 
				DogRestResponse.class);
		
		//System.out.println(data.getHeader().getResultCode());
		//System.out.println(data.getHeader().getResultMsg());
		System.out.println(data.getBody().getTotalCount());
		
		for(Item i : data.getBody().getItems()) {
			System.out.println(i);
		}
		
		
		
		
		return data;
		
	}
	
	
	
	
	
	
	
	
	
	
}
