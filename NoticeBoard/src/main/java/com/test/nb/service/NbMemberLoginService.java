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

	public int login(String id, String pw, HttpServletRequest request) {
		dao=template.getMapper(nbMemberDao.class);
		
		
		System.out.println("체큰");
		int rCnt = 0;

		NbMemberDto nbDto = dao.selectIdChk(id);
		
		if(nbDto!=null&& encoder.matches(pw, nbDto.getNbm_pw())) {
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
