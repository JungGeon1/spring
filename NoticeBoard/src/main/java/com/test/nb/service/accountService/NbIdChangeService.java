package com.test.nb.service.accountService;

import java.util.HashMap;
import java.util.Map;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.nb.dao.nbAdminMemberDao;
import com.test.nb.dao.nbMemberDao;
import com.test.nb.domain.NbAdminMemberDto;
import com.test.nb.domain.NbMemberDto;

@Service("idChangeService")
public class NbIdChangeService {
	
	@Autowired
	SqlSessionTemplate template;
	
	nbMemberDao dao;
	
	nbAdminMemberDao adminDao;
	

	
	//관리자 아이디 변경 
	public int adminPageIdChange(String admin_id, String oldId, String newId) {
		adminDao=template.getMapper(nbAdminMemberDao.class);
		
		int rCnt = 0;
		//아이디로 기존 가입정보를 가져온다
		NbAdminMemberDto nbDto = adminDao.selectAdminIdChk(admin_id);
		// 정보가 존재할시 암호와되있는 비빌번호 비교
		if(nbDto!=null&& nbDto.getAdmin_id().equals(oldId)) {
		
				Map<String, String> idChangeMap= new HashMap<String, String>();
				idChangeMap.put("newId",newId);
				idChangeMap.put("admin_id", admin_id);
				rCnt= adminDao.idChage(idChangeMap);
			
		}

		return rCnt;

	}


}
