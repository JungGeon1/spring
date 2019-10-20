package com.test.nb.dao;

import java.util.List;
import java.util.Map;

import com.test.nb.domain.CommentDto;
import com.test.nb.domain.ListViewDataDto;
import com.test.nb.domain.NbAdminMemberDto;
import com.test.nb.domain.NbInfoDto;
import com.test.nb.domain.NbMemberDto;
import com.test.nb.domain.ViewPageDataDto;

public interface nbAdminMemberDao {
	
	//아이디를 키워드로 관리자 DB저장정보 화인
	public NbAdminMemberDto selectAdminIdChk(String id);
	//관리자리스트
	public List<NbAdminMemberDto> adminLsit();
	//회워리스트
	public List<NbMemberDto> memberLsit();
	//회원삭제
	public int memberDelete(int nbm_idx);
	
}
