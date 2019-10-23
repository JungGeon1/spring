package com.test.nb.service.adminService;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.nb.dao.nbAdminMemberDao;
import com.test.nb.domain.NbAdminMemberDto;
import com.test.nb.domain.NbMemberDto;

@Service("createAdminService")
public class NbCreateAdminService {
	@Autowired
	SqlSessionTemplate template;
	@Autowired
	BCryptPasswordEncoder encoder;
	nbAdminMemberDao dao;
	
	//관리자생성
	public int createAdminMember(NbAdminMemberDto dto) {
		dao=template.getMapper(nbAdminMemberDao.class); 
		
		int rCnt=0;
		//비밀번호암호화
		dto.setAdmin_pw(encoder.encode(dto.getAdmin_pw()));
		
		rCnt=dao.createAdminMember(dto);
		
		
		return rCnt;
		
	}
}
