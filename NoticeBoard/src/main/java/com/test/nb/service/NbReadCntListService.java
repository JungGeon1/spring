package com.test.nb.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.nb.dao.nbMemberDao;
import com.test.nb.domain.NbInfoDto;

@Service("readCntService")
public class NbReadCntListService {
	
	@Autowired
	SqlSessionTemplate template;
	
	nbMemberDao memberDao;
	//마이페이지 조회수 리스트
	public List<NbInfoDto> selectReadCntList(String id){
		
		memberDao=template.getMapper(nbMemberDao.class);
		
		
		List<NbInfoDto> list= new ArrayList<NbInfoDto>();
		
		list=memberDao.ReadCntList(id);
		
		return list;
	}
	
}