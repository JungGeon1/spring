package com.bitcamp.mm.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.mm.jdbc.ConnectionProvider;
import com.bitcamp.mm.member.dao.MemberDao;
import com.bitcamp.mm.member.dao.MemberJdbcTempleteDao;

@Service("deleteService")
public class MemberDeleteService implements MemberService {

	@Autowired
	private MemberJdbcTempleteDao templeteDao;

	public int memberDelete(int idx) {
		System.out.println(idx);
		int rCnt = 0;

		rCnt = templeteDao.memberDelete(idx);
		return rCnt;
	}
}
