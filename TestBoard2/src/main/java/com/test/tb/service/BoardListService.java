package com.test.tb.service;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.tb.dao.boardDao;
import com.test.tb.domain.BoardTblDto;

@Service(value = "boardListService")
public class BoardListService {
	@Autowired 
	SqlSessionTemplate template;
	
	boardDao dao;
	//리스트
	public List<BoardTblDto> getList(){
		
		dao=template.getMapper(boardDao.class);
		List<BoardTblDto> list = new ArrayList<BoardTblDto>();

		list=dao.selectList();
		for(BoardTblDto dto  : list ) {
			if(dto.getB2_depth()>0) {
				StringBuffer sb= new StringBuffer();
				String sp= "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
				for(int i=1;i<=dto.getB2_depth();i++){
					sb.append(sp);
				}
				sb.append("ㄴ[답글]");
				sb.append(dto.getB2_title());
				dto.setB2_title(sb.toString());
			}
			
		}
		
		return list;
	}
	
	//총갯수
	public int allBoardcnt() {
		dao=template.getMapper(boardDao.class);
		int rCnt=0;
		rCnt= dao.allBoardCnt();
		return rCnt;
	}
	public BoardTblDto boardInfo(int idx) {
		dao=template.getMapper(boardDao.class);
		
		BoardTblDto dto = new BoardTblDto();
		
		dto=dao.OrgBoardInfo(idx);
		
		return dto;
		
	}

}
