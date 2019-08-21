package com.bitcamp.mm.member.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.mm.jdbc.ConnectionProvider;
import com.bitcamp.mm.member.dao.MemberDao;
import com.bitcamp.mm.member.dao.MemberJdbcTempleteDao;
import com.bitcamp.mm.member.dao.memberSessionDao;
import com.bitcamp.mm.member.domain.MemberInfo;

@Service("loginService")
public class MemberLoginService implements MemberService {
	// @Autowired
	// private MemberDao dao;
	// @Autowired
	// private MemberJdbcTempleteDao templeteDao;

	@Autowired
	private SqlSessionTemplate sessionTemplate;

	private memberSessionDao sessionDao;

	public int login(String id, String pw, HttpServletRequest request) {

		sessionDao = sessionTemplate.getMapper(memberSessionDao.class);

		int loginChk = 0;

		MemberInfo memberInfo = null;

		memberInfo = sessionDao.selectMemberById(id);

		if (memberInfo != null && memberInfo.pwChk(pw)) {
			if (memberInfo.getVerify() == 'Y') {
				// 인증을 했으므로 세션에 저장
				request.getSession(true).setAttribute("loginInfo", memberInfo.toLoginInfo());

				loginChk = 2;
			} else {
				request.getSession().setAttribute("reEmail", memberInfo.getuId());
				loginChk = 1;
			}

		}

		return loginChk;
	}
}
