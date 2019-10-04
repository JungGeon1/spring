package com.test.nb.service;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.nb.dao.nbMemberDao;
import com.test.nb.domain.NbMypageBoardInfoDto;

@Service("boardInfo")
public class NbMypageBoardInfoService {
	
	@Autowired
	SqlSessionTemplate template;
	
	nbMemberDao dao;
	
	//작성한 게시판 및 댓글들에 대한 정보 
	public NbMypageBoardInfoDto selectBoardInfo(String id) {
		
		dao= template.getMapper(nbMemberDao.class);
		
		NbMypageBoardInfoDto bInfoDto= new NbMypageBoardInfoDto();
		Map<String, String> pageMap= new HashMap<String, String>();
		Map<String, String> scrollMap= new HashMap<String, String>();
		//페이지 게시판갯수를 조회하기위한 맵 
		pageMap.put("category", "page");
		pageMap.put("nbm_id",id);
		//스크롤 게시판갯수를 조회하기위한 맵 
		scrollMap.put("category", "scroll");
		scrollMap.put("nbm_id",id);
		//작성한 총 게시판의 갯수
		bInfoDto.setTotalBoardCnt(dao.totalBoardCnt(id));
		//포토게시판의 총 갯수
		bInfoDto.setPageBoardCnt(dao.selectBoardCnt(pageMap));
		//방명록의 총 갯수
		bInfoDto.setScrollBoardCnt(dao.selectBoardCnt(scrollMap));
		//회원이 작성한 댓글의 총 갯수
		bInfoDto.setSelectTotalCmCnt(dao.selectTotalCmCnt(id));
		
		bInfoDto.toString();
		
		return bInfoDto;
		
	}
}
