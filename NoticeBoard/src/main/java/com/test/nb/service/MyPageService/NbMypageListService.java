package com.test.nb.service.MyPageService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.nb.dao.nbMemberDao;
import com.test.nb.domain.NbInfoDto;
import com.test.nb.domain.NbMemberDto;

@Service("myPageListSErvice")
public class NbMypageListService {
	@Autowired
	SqlSessionTemplate template;
	
	nbMemberDao dao;
	//마이페이지에 출력할 리스트
	public List<NbInfoDto> myPageList(Map<String, String> listMap){
		
		dao=template.getMapper(nbMemberDao.class);
		
		List<NbInfoDto> list= new ArrayList<NbInfoDto>();
		
		list= dao.selectMypageList(listMap);
		
		
		return list;
	}
}
