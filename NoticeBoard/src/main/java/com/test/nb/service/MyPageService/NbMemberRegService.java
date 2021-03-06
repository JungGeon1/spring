package com.test.nb.service.MyPageService;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.nb.dao.nbMemberDao;
import com.test.nb.domain.NbMemberDto;
import com.test.nb.service.MailSenderService;

@Service("regService")
public class NbMemberRegService {
	@Autowired
	MailSenderService mailService;
	@Autowired
	SqlSessionTemplate template;
	@Autowired
	BCryptPasswordEncoder encoder;
	
	nbMemberDao dao;
	//입력받은 아이디가 db에 저장되있는지 확인
	public int  idChk(String id) {
		
		dao=template.getMapper(nbMemberDao.class);
		
		int rCnt=0;
		
		rCnt=dao.selectIdChk(id)==null?1:0;
		
		
		return rCnt;
		
	}
	//회원가입
	public int regMember(NbMemberDto dto) {
		dao=template.getMapper(nbMemberDao.class);
		//비밀번호암호화
		dto.setNbm_pw(encoder.encode(dto.getNbm_pw()));
		//주소 세팅-> 셋 어드레스안에 난수생성메소드 같이 호출 
		dto.setNbm_address();
		
		int rCnt=dao.insertNbMember(dto);
		if(rCnt>0) {
			mailService.send(dto.getNbm_id(), dto.getNbm_code());
		}
		System.out.println("service쪽 reg>>"+rCnt);
		return rCnt;
		
		
	}
}
