package com.test.nb.service.adminService;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.nb.dao.nbAdminMemberDao;
import com.test.nb.domain.NbAdminMemberDto;
import com.test.nb.domain.NbMemberDto;

@Service("adminPageDelete")
public class NbAdminPagerDeleteService {
	@Autowired
	SqlSessionTemplate template;
	
	nbAdminMemberDao dao;

	public int deleteMember(int nbm_idx){
		
		dao=template.getMapper(nbAdminMemberDao.class);
		int rCnt=0;
		
		rCnt= dao.memberDelete(nbm_idx);
		return rCnt;
		
	}

	
	public int deleteadmin(int admin_idx) {
		
		dao=template.getMapper(nbAdminMemberDao.class);
		int rCnt=0;
		
		rCnt= dao.adminDelete(admin_idx);
		return rCnt;
	}

}
