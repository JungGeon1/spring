package com.test.nb.service.adminBoardService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.nb.dao.nbAdminBoardDao;
import com.test.nb.dao.nbDao;
import com.test.nb.domain.ListViewDataDto;
import com.test.nb.domain.NbAdminBoardDto;
import com.test.nb.domain.NbInfoDto;
import com.test.nb.domain.SearchParamDto;

@Service("adminBoardListService")
public class NbAdminBoardListService {
	@Autowired
	SqlSessionTemplate template;
	
	nbAdminBoardDao dao;
	//찾고자 하는 게시판의 총갯수
	public int selectPagelist( SearchParamDto sParamDto) {
		
		int rCnt=0;
		dao=template.getMapper(nbAdminBoardDao.class);
		//System.out.println("체크"+sParamDto.getStype());
		
		
		rCnt= dao.selectList(sParamDto);
		System.out.println(rCnt);
		return rCnt;
	}
	//찾아야하는 페이지를 키워드로  리스트를 가져온다
	public List<NbAdminBoardDto> getPageList(int pageNumber,SearchParamDto sParamDto) {
		
		
		dao=template.getMapper(nbAdminBoardDao.class);
		List<NbAdminBoardDto> list=null;
		ListViewDataDto viewData = new ListViewDataDto();
		Map<String, Object> searchMap= new  HashMap<String, Object>();
		//가져와야하는 페이지의 시작 인데스를 찾는 식
		int startIdx=0;
		final int lastIdx=10;
		// 한 페이지당 10개의 글을 가져온다  나중에 페이지당 요청갯수도 파라메터로 받을시 6을  받고자 하는 페이지 갯수로 변경
		startIdx=(pageNumber-1)*10;
		
		viewData.setStartIdx(startIdx);
		viewData.setLastIdx(lastIdx);
		searchMap.put("viewData", viewData);
		searchMap.put("search", sParamDto);
		
		list=dao.adminBoardList(searchMap);
		
		return list;
	}
	
	//뷰페이지 정보 뿌려주기
	public NbAdminBoardDto adminBoardViewInfo(int idx) {
		dao= template.getMapper(nbAdminBoardDao.class);
		
		NbAdminBoardDto dto= new NbAdminBoardDto();
		dto= dao.adminBoardInfo(idx);
		
		return dto;
		
		
	}

}
