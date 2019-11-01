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
		int chkDepth=0;
		int maxDepth=0;
		BoardTblDto orgBoardInfo = new BoardTblDto();
		
		orgBoardInfo = dao.OrgBoardInfo(dto.getO_no());
		chkDepth=dao.selectDepth(orgBoardInfo.getB2_depth()+1);
		if(chkDepth==0) {
		if(orgBoardInfo!=null) {
			System.out.println("0인경우");
			dto.setB2_grpord(orgBoardInfo.getB2_idx());
			dto.setB2_depth(orgBoardInfo.getB2_depth()+1);
			dto.setB2_grpno(orgBoardInfo.getB2_grpno());
			rCnt=dao.reBoardInsert(dto);
			
			}
		}else {
			System.out.println("0이아닌경우");
			maxDepth=dao.maxDepth(orgBoardInfo.getB2_grpno());
			System.out.println(maxDepth);
			dto.setB2_grpord(orgBoardInfo.getB2_idx());
			dto.setB2_depth(maxDepth+1);
			dto.setB2_grpno(orgBoardInfo.getB2_grpno());
			rCnt=dao.reBoardInsert(dto);
		}
		return rCnt;
	}
	
	
	

	
}
