package com.test.tb.service;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.tb.dao.boardDao;
import com.test.tb.domain.BoardTblDto;

@Service(value = "boardInsertService")
public class BoardInsertService {
	@Autowired
	SqlSessionTemplate template;
	
	boardDao dao;
	
	public int boardInsert(BoardTblDto dto) {
		
		dao=template.getMapper(boardDao.class);
		
		int rCnt=0;
		
		rCnt=dao.boardInsert(dto);
		
		return rCnt;
	}
	
	
	
	public int reBoardInsert(BoardTblDto dto) {
		
		dao=template.getMapper(boardDao.class);

		int rCnt=0;
		//1번쿼리체크
		int chkOrd=0;
		
		int maxOrd=0;
		//원글 정보 바인딩
		BoardTblDto orgBoardDto = new BoardTblDto();
		
		orgBoardDto=dao.OrgBoardInfo(dto.getO_no());
		
		//System.out.println("원글 정보확인>>"+orgBoardDto.toString());
		
		chkOrd= dao.selectGrpord(orgBoardDto);
		//답글이 맨 밑으로 가는경우
		if(chkOrd==0) {
			maxOrd=dao.selectMaxOrd(orgBoardDto.getB_grpno());
			System.out.println("쿼리가 0일떄");
			dto.setB_grpno(orgBoardDto.getB_grpno());
			dto.setB_grpord(maxOrd);
			dto.setB_depth(orgBoardDto.getB_depth());
			rCnt=dao.reInsert(dto);
		}
		//답글이 중간에 들어가는 경우
		else {
			System.out.println("쿼리가 1일떄");
			Map<String, Integer> map = new HashMap<String, Integer>();
			
			map.put("b_grpno",orgBoardDto.getB_grpno());
			map.put("selectGrpOrd", chkOrd);
			dao.upGrpOrd(map);
			
			dto.setB_grpno(orgBoardDto.getB_grpno());
			dto.setB_grpord(chkOrd);
			dto.setB_depth(orgBoardDto.getB_depth());
			rCnt=dao.reInsert(dto);
			
		}
		
		return rCnt;
	}
	
}
