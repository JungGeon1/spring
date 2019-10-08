package com.test.nb.dao;

import java.util.List;
import java.util.Map;

import com.test.nb.domain.NbInfoDto;

public interface nbStartPageDao {
	//main화면 조회수TOP 3
	public List<NbInfoDto> ReadCntList(String id);
	//main화면 베스트TOP 3
	public List<NbInfoDto> mainBestList();
	//유저가 작성한?? 게시판의 갯수
	public int selectBoardCnt(Map<String, String> map);
	//가입기간
	public int selectMemberDate(String id);
	//총 조회수
	public int selectTotalViews(String id);
	//총 댓글수
	public int selectTotalCmCnt(String id);
	//총 업로드한사진 수
	public int selectTotalImage(String id);
}
