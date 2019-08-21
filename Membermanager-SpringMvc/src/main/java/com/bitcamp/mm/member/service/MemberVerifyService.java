package com.bitcamp.mm.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.mm.member.dao.memberSessionDao;
import com.bitcamp.mm.member.domain.MemberInfo;

@Service("verrifuSerivce")
public class MemberVerifyService {
	@Autowired
	private MailSenderService mailService;
	@Autowired
	private SqlSessionTemplate template;
	
	private memberSessionDao dao;
	
	public String verify(String id, String code) {
		
		dao=template.getMapper(memberSessionDao.class);
		
		int rCnt= dao.verify(id, code);
		// TODO Auto-generated method stub
		return rCnt>0?"Success":"Fail";
	}

	public int reMailSend(String eamil) {
		
		dao = template.getMapper(memberSessionDao.class);
		
		System.out.println("uId: " + eamil);
		
		MemberInfo member = dao.selectMemberById(eamil);
		System.out.println("check : " + member);
		
		mailService.reSend(member.getuId(), member.getCode());
		
		
		return 1;
	}
	
	

}
