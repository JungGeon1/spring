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
	
	public int deleteMember(int idx);
	
	public int totalBoardCnt(String id);
	
	public int selectBoardCnt(Map<String, String> map);
	
	public int selectTotalCmCnt(String id);

	public List<NbInfoDto> selectMypageList(Map<String, String>map);
	
	public int pwChage(Map<String, String> map);
	
	public List<NbInfoDto> ReadCntList(String id);
	
	public List<NbInfoDto> mainBestList();
	
}
