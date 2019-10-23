package com.test.nb.service.boardService;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.nb.dao.nbMemberDao;
import com.test.nb.dao.nbStartPageDao;
import com.test.nb.domain.NbInfoDto;

@Service("readCntService")
public class NbReadCntListService {
	
	@Autowired
	SqlSessionTemplate template;
	
	nbStartPageDao dao;
	//조회수TOP3 리스트
	public List<NbInfoDto> selectReadCntList(String id){
		
		dao=template.getMapper(nbStartPageDao.class);
		
		
		List<NbInfoDto> list= new ArrayList<NbInfoDto>();
		
		list=dao.ReadCntList(id);
		
		return list;
	}
	
}
