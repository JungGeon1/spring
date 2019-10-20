package com.test.nb.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.nb.dao.nbAdminMemberDao;
import com.test.nb.domain.NbAdminMemberDto;
import com.test.nb.domain.NbMemberDto;

@Service("adminPageList")
public class NbAdminPageListService {
	@Autowired
	SqlSessionTemplate template;
	
	nbAdminMemberDao dao;
	//관리자 리스트
	public List<NbAdminMemberDto> adminList(){
		
		dao=template.getMapper(nbAdminMemberDao.class);
		List<NbAdminMemberDto> list= new ArrayList<NbAdminMemberDto>();
		
		list= dao.adminLsit();
		return list;
		
	}
	//멤버리스트
		public List<NbMemberDto> memberList(){
			
			dao=template.getMapper(nbAdminMemberDao.class);
			List<NbMemberDto> list= new ArrayList<NbMemberDto>();
			
			list= dao.memberLsit();
			return list;
			
		}
}
