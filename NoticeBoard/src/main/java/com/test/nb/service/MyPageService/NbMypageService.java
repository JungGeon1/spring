package com.test.nb.service.MyPageService;

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
//마이페이지 회워정보 	
	public NbMemberDto getMyPageView(String id) {
		
		
		NbMemberDto memberDto= new NbMemberDto();
		
		memberDao=template.getMapper(nbMemberDao.class);
		
		memberDto=memberDao.selectIdChk(id);
		
		return memberDto;
	}
	
	
}
