package com.test.nb.service.adminService;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.nb.dao.nbAdminMemberDao;

import com.test.nb.domain.NbAdminMemberDto;

@Service("empowerService")
public class AdminEmpowerService {
	
	@Autowired
	SqlSessionTemplate template;
	@Autowired
	BCryptPasswordEncoder encoder;
	
	nbAdminMemberDao dao;
	//권한인계
	public int adminEmpower(String oldAdminId, String oldAdminPw, int newAdminIdx) {
		
		dao=template.getMapper(nbAdminMemberDao.class);
		
		int rCnt=0;
		int delEmpowerChk=0;
		NbAdminMemberDto adminDto= new NbAdminMemberDto();
		//비밃번호체크를 위해 아이디를 키워드로 가져온다
		adminDto=dao.selectAdminIdChk(oldAdminId);
		
		if(adminDto!=null&&encoder.matches(oldAdminPw, adminDto.getAdmin_pw())) {
			
			//기존권한삭제
			delEmpowerChk= dao.empowerOldAdmin(oldAdminId);
			
			if(delEmpowerChk==1) {
				
				//새로운 관리자에게권한부여
				rCnt=dao.empowerNewAdmin(newAdminIdx);
			}
			
			
		}
		return rCnt;
	}
	
	
}
