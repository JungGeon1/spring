package com.test.nb.service;

import java.util.HashMap;
import java.util.Map;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.test.nb.dao.nbMemberDao;
import com.test.nb.domain.NbMemberDto;

@Service("pwChangeService")
public class NbMypagePwChangeService {
	
	@Autowired
	SqlSessionTemplate template;
	
	nbMemberDao dao;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	//비빌먼호 변경
	public int myPagePwChange(String id, String oldPw, String newPw) {
		dao=template.getMapper(nbMemberDao.class);
		
		int rCnt = 0;
		//아이디로 기존 가입정보를 가져온다
		NbMemberDto nbDto = dao.selectIdChk(id);
		// 정보가 존재할시 암호와되있는 비빌번호 비교
		if(nbDto!=null&& encoder.matches(oldPw, nbDto.getNbm_pw())) {
			//이메일 인증 여부 확인
			if (nbDto.getNbm_verify().equals("Y")) {
				
				Map<String, String> pwChangeMap= new HashMap<String, String>();
				pwChangeMap.put("pw", encoder.encode(newPw));
				pwChangeMap.put("nbm_id", id);
				rCnt= dao.pwChage(pwChangeMap);
			} 
		}

		return rCnt;

	}
	


}
