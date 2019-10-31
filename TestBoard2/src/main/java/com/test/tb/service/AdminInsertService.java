package com.test.tb.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.tb.dao.adminDao;
import com.test.tb.domain.AdminTblDto;

@Service(value = "adminInsertService")
public class AdminInsertService {
	@Autowired
	SqlSessionTemplate template;
	adminDao dao;
	
	//관리자 입력
	public int adminInsert(AdminTblDto dto) {
		
		dao= template.getMapper(adminDao.class);
		int rCnt=0;
		
		rCnt=dao.adminInsert(dto);
		System.out.println("입력체크>>"+rCnt);
		return rCnt;
	}
}
