package com.test.nb.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.nb.dao.nbDao;
import com.test.nb.domain.ListViewDataDto;
import com.test.nb.domain.NbInfoDto;

@Service("pListService")
public class ListService {
	@Autowired
	SqlSessionTemplate template;
	
	nbDao nbIf;
	
	public int selectPagelist(String category) {
		int rCnt=0;
		nbIf=template.getMapper(nbDao.class);
		rCnt= nbIf.selectList(category);
		return rCnt;
	}

	public List<NbInfoDto> getPageList(int pageNumber, String category) {
		
		
		nbIf=template.getMapper(nbDao.class);
		List<NbInfoDto> list=null;
		ListViewDataDto viewData = new ListViewDataDto();
		//가져와야하는 페이지의 시작 인데스를 찾는 식
		int startIdx=0;
		startIdx=(pageNumber-1)*6;
		
		viewData.setStartIdx(startIdx);
		viewData.setCategory(category);
		
		list=nbIf.List(viewData);
		
		return list;
	}

}
