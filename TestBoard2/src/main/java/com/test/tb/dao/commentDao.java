package com.test.tb.dao;

import java.util.List;
import java.util.Map;

import com.test.tb.domain.BoardTblDto;
import com.test.tb.domain.CommentTblDto;

public interface commentDao {
	//댓글
	public int commentInsert(CommentTblDto dto);
	//댓글 리스트
	public List<CommentTblDto>selectList(int idx);
	//원글정보
	public CommentTblDto commentInfo(int b_idx);
	//답글 쿼리1
	public int selectGrpord(CommentTblDto dto);
	//답글 쿼리1-1
	public int selectMaxOrd(int b_grpno);
	//답글 쿼리1-2
	public int upGrpOrd(Map<String,Integer> map); 
	//답글 입력
	public int reInsert(CommentTblDto dto);
	//댓글총 갯수
	public int allCommentdCnt();
	//댓글 수정
	public int updateComment(CommentTblDto dto);
	//댓글 삭제
	public int deleteComment(int c_idx);
}
