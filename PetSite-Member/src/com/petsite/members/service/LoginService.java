package com.petsite.members.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.petsite.members.dao.MemberDao;
import com.petsite.members.domain.MemberInfo;

@Service("loginService")
public class LoginService {
	
	@Autowired
	private SqlSessionTemplate template;
	private MemberDao dao;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	public int login(String id, String pw, HttpServletRequest request) {
		
		dao = template.getMapper(MemberDao.class);
		
		int cnt = 0;
		MemberInfo memberInfo = null;
		
		memberInfo = dao.selectById(id);
		
		// 인증처리된 아이디인지 확인
		char verify = memberInfo.getVerify();
		
		// 1. 인증 처리됨 -> 암호화된 비밀번호 비교->1번째 인자는 암호화되지않은 값을, 2번째는 암호화된값을 넣어주면된다
		if(verify == 'Y' && memberInfo!=null && encoder.matches(pw, memberInfo.getPw())) {
			cnt = 1;
		} else if (verify == 'N') {
			cnt = 2; // 2. 미인증 회원
		} else {
			cnt = 3; // 3. 로그인 실패
		}
		
		return cnt; 
	}
}
