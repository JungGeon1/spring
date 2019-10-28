package com.test.nb.dao;

import java.util.List;
import java.util.Map;

import com.test.nb.domain.ListViewDataDto;
import com.test.nb.domain.NbInfoDto;
import com.test.nb.domain.SearchParamDto;
import com.test.nb.domain.ViewPageDataDto;

public interface nbDao {
	
	//게시글 등록
	public int insertNb(NbInfoDto nbInfo);
	//게시글등록 첨부 이미지없이
	public int insertNbNoImg(NbInfoDto nbInfo);
	//게시판 갯수
	public int selectList(Map<String, Object> map);
	//게시판 리스트
	public List<NbInfoDto> List(Map<String, Object> map);
	//포토보드뷰페이지 가져오기
	public NbInfoDto selectViewPage(int idx);
	//조회수 업
	public int viewUp(int idx);
	//게시글삭제
	public int deleteNb(int idx);
	//게시글 수정
	public int updateNb(NbInfoDto nbInfo);
	//이미지 없이 게시글 수정
	public int updateNbNoImg(NbInfoDto nbInfo);
	//모든 포토게시판의 갯수
	public int totalBoardCnt(String category);
	//당일 작성한 포토 게시판의 갯수
	public int totalTodayBoardCnt(String category);
}
