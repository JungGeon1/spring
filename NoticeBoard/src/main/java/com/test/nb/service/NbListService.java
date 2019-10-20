package com.test.nb.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.nb.dao.nbDao;
import com.test.nb.domain.ListViewDataDto;
import com.test.nb.domain.NbInfoDto;
import com.test.nb.domain.SearchParamDto;

@Service("pListService")
public class NbListService {
	@Autowired
	SqlSessionTemplate template;
	
	nbDao nbIf;
	//찾고자 하는 게시판의 총갯수
	public int selectPagelist(String category, SearchParamDto sParamDto) {
		
		int rCnt=0;
		nbIf=template.getMapper(nbDao.class);
		//System.out.println("체크"+sParamDto.getStype());
		Map<String, Object> searchMap= new  HashMap<String, Object>();
		searchMap.put("category", category);
		searchMap.put("search", sParamDto);
		
		rCnt= nbIf.selectList(searchMap);
		System.out.println(rCnt);
		return rCnt;
	}
	//찾아야하는 페이지를 키워드로  리스트를 가져온다
	public List<NbInfoDto> getPageList(int pageNumber, String category, SearchParamDto sParamDto) {
		
		
		nbIf=template.getMapper(nbDao.class);
		List<NbInfoDto> list=null;
		ListViewDataDto viewData = new ListViewDataDto();
		Map<String, Object> searchMap= new  HashMap<String, Object>();
		//가져와야하는 페이지의 시작 인데스를 찾는 식
		int startIdx=0;
		// 한 페이지당 6개의 글을 가져온다  나중에 페이지당 요청갯수도 파라메터로 받을시 6을  받고자 하는 페이지 갯수로 변경
		startIdx=(pageNumber-1)*6;
		
		viewData.setStartIdx(startIdx);
		viewData.setCategory(category);
		searchMap.put("viewData", viewData);
		searchMap.put("search", sParamDto);
		
		list=nbIf.List(searchMap);
		
		return list;
	}

}
