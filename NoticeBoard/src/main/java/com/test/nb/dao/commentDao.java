package com.test.nb.dao;

import java.util.List;
import java.util.Map;

import com.test.nb.domain.CommentDto;
import com.test.nb.domain.ListViewDataDto;
import com.test.nb.domain.NbInfoDto;
import com.test.nb.domain.ViewPageDataDto;

public interface commentDao {
	

	public int insertCm(CommentDto cDto);
	//내림차순 댓글 grpord증가용
	public int ReCmUp(CommentDto cDto);
	//내림차순 댓글용
	public int insertReCm(CommentDto cDto);
	
	public int selectCommentCnt(int idx);
	
	public List<CommentDto> commentList(int idx);

	public int deleteCm(int n_idx);
	
	
	//오름차순 댓글입력
	public int chkGrpord(CommentDto cDto);
	
	public int selectGrpord(int n_grpno);
	
	public int upGrpord(Map<String, Integer> map);
	
	public int insertAscReCm(CommentDto cDto);
	
}
