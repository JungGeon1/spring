package com.test.nb.dao;

import java.util.List;
import java.util.Map;

import com.test.nb.domain.CommentDto;
import com.test.nb.domain.ListViewDataDto;
import com.test.nb.domain.NbInfoDto;
import com.test.nb.domain.ViewPageDataDto;

public interface commentDao {
	
	//댓글 등록
	public int insertCm(CommentDto cDto);
	//내림차순 댓글 grpord증가용
	public int ReCmUp(CommentDto cDto);
	//내림차순 댓글용
	public int insertReCm(CommentDto cDto);
	//댓글 갯수
	public int selectCommentCnt(int idx);
	//댓글 리스트
	public List<CommentDto> commentList(int idx);
	//댓글삭제
	public int deleteCm(int n_idx);
	
	
	//오름차순 답글입력
	//입력받은 답글의n_grpord가 0일지 아닐지 체크
	public int chkGrpord(CommentDto cDto);
	//위 쿼리가 0일경우의 grpord select
	public int selectGrpord(int n_grpno);
	// 위 쿼리가 0이 아닐경우 중간에 들어가는 답글이기 때문에 다른 답글들의 n_grpord 증가
	public int upGrpord(Map<String, Integer> map);
	//답글등록
	public int insertAscReCm(CommentDto cDto);
	
}
