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
	//중복되는 depth구하기
	public int selectDepth(int b2_depth);
	//MAXDEPTH
	public int maxDepth(int b2_grpno);
	//답글입력
	public int reBoardInsert(BoardTblDto dto);
	//게시판 총 갯수
	public int allBoardCnt();
	//게시판 수정
	public int updateBoard(BoardTblDto dto);
	//게시판 삭제
	public int deleteBoard(int b_idx);
}
