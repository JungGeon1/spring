package com.test.nb.dao;

import java.util.List;
import java.util.Map;

import com.test.nb.domain.CommentDto;
import com.test.nb.domain.ListViewDataDto;
import com.test.nb.domain.NbInfoDto;
import com.test.nb.domain.NbMemberDto;
import com.test.nb.domain.ViewPageDataDto;

public interface nbMemberDao {
	

	public NbMemberDto selectIdChk(String id);
	
	public int insertNbMember(NbMemberDto dto);

	public int verify(String id, String code);
}
