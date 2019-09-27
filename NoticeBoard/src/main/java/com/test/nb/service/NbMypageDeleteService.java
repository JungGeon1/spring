package com.test.nb.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.nb.dao.nbMemberDao;
import com.test.nb.domain.NbMemberDto;

@Service("myPageDelete")
public class NbMypageDeleteService {
	
	@Autowired
	SqlSessionTemplate template;
	@Autowired
	BCryptPasswordEncoder encoder;
	
	nbMemberDao dao;
	
	public int deleteMember(String id, String pw) {
		dao=template.getMapper(nbMemberDao.class);
		
		int rCnt=0;
		
		NbMemberDto memberDto= new NbMemberDto();
		memberDto=dao.selectIdChk(id);
		System.out.println(memberDto.getNbm_pw());
		if(memberDto!=null&&encoder.matches(pw,memberDto.getNbm_pw())) {
			
			rCnt=dao.deleteMember(memberDto.getNbm_idx());
		}
		
		return rCnt;
	}
	
}
