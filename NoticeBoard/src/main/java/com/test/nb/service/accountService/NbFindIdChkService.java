package com.test.nb.service.accountService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.nb.dao.nbAdminMemberDao;
import com.test.nb.domain.NbFindAdminIdDto;

@Service("findIdchkService")
public class NbFindIdChkService {
	@Autowired
	SqlSessionTemplate template;
	
	nbAdminMemberDao dao;
	//이름과 메일정보로 등록된 아이들의 리스트를 반환
	public List<NbFindAdminIdDto> findIdChk(String name, String email) {
		
		dao= template.getMapper(nbAdminMemberDao.class);
		
		
		Map<String, String> map = new HashMap<String, String>();
		List<NbFindAdminIdDto> list= new ArrayList<NbFindAdminIdDto>();
		
		map.put("admin_name", name);
		map.put("admin_email", email);
		
		list=dao.findAdminIdList(map);
		
		//가져온 아이디들 끝의 두자리를 *로변경
		for(NbFindAdminIdDto dto : list) {
		//System.out.println(dto.getAdmin_id().length());
			String idTemp= null;	
			StringBuffer sb= new StringBuffer();
			
			idTemp=dto.getAdmin_id().substring(0, dto.getAdmin_id().length()-2);
			
			sb.append(idTemp);
			sb.append("**");
			
			dto.setAdmin_id(sb.toString());
			
			
		};
		
		return list;
		
	}
}
