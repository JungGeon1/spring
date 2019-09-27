package com.test.nb.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.nb.dao.nbMemberDao;
import com.test.nb.domain.NbMemberDto;

@Service("mypageService")
public class NbMypageService {
	
	@Autowired
	SqlSessionTemplate template;
	
	nbMemberDao memberDao;
	
	public NbMemberDto getMyPageView(String id) {
		
		
		NbMemberDto memberDto= new NbMemberDto();
		
		memberDao=template.getMapper(nbMemberDao.class);
		
		memberDto=memberDao.selectIdChk(id);
		
		return memberDto;
	}
	
	
}
