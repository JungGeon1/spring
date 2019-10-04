package com.test.nb.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.nb.dao.nbMemberDao;
import com.test.nb.domain.NbInfoDto;

@Service("mainBestLsitService")
public class NbMainBestListService {
	
	@Autowired
	SqlSessionTemplate template;
	
	nbMemberDao memberDao;
	//시작 화면에 출력할 BestList 3개 
	public List<NbInfoDto> mainBestList(){
		
		memberDao=template.getMapper(nbMemberDao.class);
		
		
		List<NbInfoDto> list= new ArrayList<NbInfoDto>();
		
		list=memberDao.mainBestList();
		return list;
	}
	
}
