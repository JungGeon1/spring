package com.test.nb.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.nb.dao.nbAdminMemberDao;
import com.test.nb.dao.nbMemberDao;
import com.test.nb.domain.NbAdminMemberDto;
import com.test.nb.domain.NbMemberDto;

@Service("findPwChkService")
public class NbFindPwIdChkService {
	@Autowired
	MailSenderService mailService;
	
	@Autowired
	SqlSessionTemplate template;
	
	@Autowired
	BCryptPasswordEncoder encoder;
	
	nbMemberDao dao;
	
	nbAdminMemberDao adminDao;
	
	//가입자 아이디 존재유무 확인과 인증메일 보내기
	public int findPwIdchk(String id, String name) {
		
		dao=template.getMapper(nbMemberDao.class);
		
		NbMemberDto	 memberDto= new NbMemberDto();
		
		
		int rCnt=0;
		int pwTempChk=0;
		String tempPassword=null;
		Map<String, String> pwChkMap= new HashMap<String, String>(); 
		Map<String, String> pwUpMap= new HashMap<String, String>(); 
	
		pwChkMap.put("nbm_id", id);
		pwChkMap.put("nbm_name", name);
		
		memberDto=dao.findPwChk(pwChkMap);
		
		if(memberDto!=null) {
		
		//임시비밀번호 
		tempPassword=RandomPwString(); 	
		//임시 비밀번호로 비밀번호를 변경
	
		pwUpMap.put("tempPw", encoder.encode(tempPassword));
		pwUpMap.put("nbm_id",memberDto.getNbm_id());
		pwTempChk=dao.upTempPw(pwUpMap);
		System.out.println("임시비밀번호로변경확인>>"+pwTempChk);	
		 mailService.findPwChksend(memberDto.getNbm_id(), tempPassword);
		
		rCnt=1;
		}
		
		
		return rCnt;
	}
	//관리자 아이디 존재유무 확인과 인증메일 보내기
		public int findAdminPwIdchk(String id, String email) {
			
			adminDao=template.getMapper(nbAdminMemberDao.class);
			
			NbAdminMemberDto adminDto= new NbAdminMemberDto();
			
			
			int rCnt=0;
			int pwTempChk=0;
			String tempPassword=null;
			Map<String, String> pwChkMap= new HashMap<String, String>(); 
			Map<String, String> pwUpMap= new HashMap<String, String>(); 
		
			pwChkMap.put("admin_id", id);
			pwChkMap.put("admin_email", email);
			//아이디와 이메일 정보호가인
			adminDto=adminDao.findAdminPwChk(pwChkMap);
			//후에 여기서 분기처릴 늘려서 아이디만 일치하고 이메일은 일치하지 않는경우도 구현
			if(adminDto!=null) {
			
			//임시비밀번호 
			tempPassword=RandomPwString(); 	
			pwUpMap.put("tempPw", encoder.encode(tempPassword));
			pwUpMap.put("admin_id",adminDto.getAdmin_id());
			//임시 비밀번호로 비밀번호를 변경
			pwTempChk=adminDao.upTempPw(pwUpMap);
			System.out.println("임시비밀번호로변경확인>>"+pwTempChk);	
			mailService.findAdminPwChksend(adminDto.getAdmin_email(), tempPassword);
			
			rCnt=1;
			}
			
			
			return rCnt;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	//임시비밀번호만들기
		private String RandomPwString() {
				
				
				Random r = new Random(System.nanoTime());
				StringBuffer sb = new StringBuffer();
				
				for(int i=0 ; i<20 ; i++ ) {
					
						sb.append(r.nextInt(10));
				}
				
				System.out.println("임시 비밀번호 생성 : " + sb) ;
				
				return sb.toString();
				
					
			}
		
}
