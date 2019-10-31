package com.test.tb.dao;


import java.util.List;
import java.util.Map;

import com.test.tb.domain.BoardTblDto;

public interface boardDao {
	//게시판 입력
	public int boardInsert(BoardTblDto dto);
	//게시판 리스트
	public List<BoardTblDto>selectList();
	//원글정보
	public BoardTblDto OrgBoardInfo(int o_no);
	//답글 쿼리1
	public int selectGrpord(BoardTblDto dto);
	//답글 쿼리1-1
	public int selectMaxOrd(int b_grpno);
	//답글 쿼리1-2
	public int upGrpOrd(Map<String,Integer> map); 
	//답글 입력
	public int reInsert(BoardTblDto dto);
	//게시판 총 갯수
	public int allBoardCnt();
	//게시판 수정
	public int updateBoard(BoardTblDto dto);
	//게시판 삭제
	public int deleteBoard(int b_idx);
}
