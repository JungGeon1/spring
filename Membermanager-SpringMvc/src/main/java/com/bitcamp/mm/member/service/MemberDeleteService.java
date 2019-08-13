package com.bitcamp.mm.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.mm.jdbc.ConnectionProvider;
import com.bitcamp.mm.member.dao.MemberDao;
import com.bitcamp.mm.member.dao.MemberJdbcTempleteDao;
import com.bitcamp.mm.member.dao.memberSessionDao;

@Service("deleteService")
public class MemberDeleteService implements MemberService {

	//@Autowired
	//private MemberJdbcTempleteDao templeteDao;
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	private memberSessionDao sessionDao;
	

	public int memberDelete(int idx) {
		
		sessionDao= sessionTemplate.getMapper(memberSessionDao.class);
		System.out.println(idx);
		int rCnt = 0;

		rCnt = sessionDao.memberDelete(idx);
		return rCnt;
	}
}
