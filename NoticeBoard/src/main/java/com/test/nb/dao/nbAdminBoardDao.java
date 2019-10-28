package com.test.nb.dao;

import java.util.List;
import java.util.Map;

import com.test.nb.domain.ListViewDataDto;
import com.test.nb.domain.NbAdminBoardDto;
import com.test.nb.domain.NbInfoDto;
import com.test.nb.domain.SearchParamDto;
import com.test.nb.domain.ViewPageDataDto;

public interface nbAdminBoardDao {
	
	//관리자 게시글 등록
	public int insertAdminBoard(NbAdminBoardDto dto);
	//찾고자하는 게시판의 총갯수
	public int selectList(SearchParamDto sParamDto);
	//게시판 페이지
	public List<NbAdminBoardDto> adminBoardList(Map<String, Object> searchMap);
	//관리자 게시글 삭제
	public int adminDeleteBoard(int idx);
	//보드정보				  
	public NbAdminBoardDto adminBoardInfo(int idx);
	//조회수증가
	public int viewUp(int idx); 


}
