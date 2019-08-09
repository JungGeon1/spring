package com.bitcamp.mm.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.mm.jdbc.ConnectionProvider;
import com.bitcamp.mm.member.dao.MemberDao;
import com.bitcamp.mm.member.dao.MemberJdbcTempleteDao;
import com.bitcamp.mm.member.domain.MemberInfo;

@Service("loginService")
public class MemberLoginService implements MemberService {
	// @Autowired
	// private MemberDao dao;
	@Autowired
	private MemberJdbcTempleteDao templeteDao;

	public boolean login(String id, String pw, HttpServletRequest request) {

		boolean loginChk = false;

		MemberInfo memberInfo = null;

		memberInfo = templeteDao.selectMemberById(id);

		if (memberInfo != null && memberInfo.pwChk(pw)) {
			// 세션에 올려야지~
			// loginChk상태값 변경

			request.getSession(true).setAttribute("loginInfo", memberInfo.toLoginInfo());

			loginChk = true;
		}

		return loginChk;
	}
}
