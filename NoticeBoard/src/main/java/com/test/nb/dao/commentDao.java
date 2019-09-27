package com.test.nb.dao;

import java.util.List;
import java.util.Map;

import com.test.nb.domain.CommentDto;
import com.test.nb.domain.ListViewDataDto;
import com.test.nb.domain.NbInfoDto;
import com.test.nb.domain.ViewPageDataDto;

public interface commentDao {
	

	public int insertCm(CommentDto cDto);
	
	public int ReCmUp(CommentDto cDto);
	
	public int insertReCm(CommentDto cDto);
	
	public int selectCommentCnt(int idx);
	
	public List<CommentDto> commentList(int idx);

	public int deleteCm(int n_idx);
}
