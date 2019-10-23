package com.test.nb.service.accountService;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.test.nb.dao.nbMemberDao;
import com.test.nb.domain.NbMemberDto;
import com.test.nb.service.MailSenderService;

@Service("verrifuSerivce")
public class VerifyService {
	@Autowired
	private MailSenderService mailService;
	@Autowired
	private SqlSessionTemplate template;
	
	private nbMemberDao dao;
	//이메일 인증여부
	public String verify(String id, String code) {
		
		dao=template.getMapper(nbMemberDao.class);
		
		int rCnt= dao.verify(id, code);
		// TODO Auto-generated method stub
		return rCnt>0?"Success":"Fail";
	}
	//메일 재인증
	public int reMailSend(String eamil) {
		
		dao = template.getMapper(nbMemberDao.class);
		
		//System.out.println("nbm_id: " + eamil);
		
		 NbMemberDto dto = dao.selectIdChk( eamil);
		//System.out.println("check : " + dto);
		
		mailService.reSend(dto.getNbm_id(), dto.getNbm_code());
		
		
		return 1;
	}
	
	

}
