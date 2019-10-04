package com.test.nb.service;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.nb.dao.nbMemberDao;
import com.test.nb.domain.NbLoginInfoDto;
import com.test.nb.domain.NbMemberDto;

@Service("loginService")
public class NbMemberLoginService {
	@Autowired
	BCryptPasswordEncoder encoder;
	@Autowired
	SqlSessionTemplate template;

	nbMemberDao dao;
//로그인
	public int login(String id, String pw, HttpServletRequest request) {
		dao=template.getMapper(nbMemberDao.class);
		
		int rCnt = 0;
		//입력받은 아이디로  db에서 정보를 가져온다
		NbMemberDto nbDto = dao.selectIdChk(id);
		//정보가 존재할시 암호화된 비밀번호 비교
		if(nbDto!=null&& encoder.matches(pw, nbDto.getNbm_pw())) {
			//메일 인증여부 체크
			if (nbDto.getNbm_verify().equals("Y")) {
				NbLoginInfoDto logindto = new NbLoginInfoDto(nbDto.getNbm_id(), nbDto.getNbm_pw());
				request.getSession(true).setAttribute("nbm_id", logindto.getNbm_id());
				request.getSession(true).setAttribute("nbm_pw", logindto.getNbm_pw());
				rCnt = 1;

			} else {
				rCnt = 2;
				request.getSession().setAttribute("reEmail", nbDto.getNbm_id());
			}

		}

		return rCnt;

	}

}
