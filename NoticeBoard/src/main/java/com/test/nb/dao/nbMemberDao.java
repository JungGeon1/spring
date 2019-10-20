package com.test.nb.dao;

import java.util.List;
import java.util.Map;

import com.test.nb.domain.CommentDto;
import com.test.nb.domain.ListViewDataDto;
import com.test.nb.domain.NbAdminMemberDto;
import com.test.nb.domain.NbInfoDto;
import com.test.nb.domain.NbMemberDto;
import com.test.nb.domain.ViewPageDataDto;

public interface nbMemberDao {
	
	//아이디를 키워드로 DB저장정보 화인
	public NbMemberDto selectIdChk(String id);
	//회워가입
	public int insertNbMember(NbMemberDto dto);
	//메일인증 
	public int verify(String id, String code);
	//회워탈퇴
	public int deleteMember(int idx);
	//유저가 작성한 모든 게시판의 갯수
	public int totalBoardCnt(String id);
	//유저가 작성한 ??게시판의 갯수
	public int selectBoardCnt(Map<String, String> map);
	//유저가 작성한 모든 댓글수
	public int selectTotalCmCnt(String id);
	//유저가 작성한 게시판 리스트 마이페이지용
	public List<NbInfoDto> selectMypageList(Map<String, String>map);
	//비밀번호변경
	public int pwChage(Map<String, String> map);
	//로그인시 유조의 조회수 top3
	public List<NbInfoDto> ReadCntList(String id);
	//메인페이지의 조회수 top3
	public List<NbInfoDto> mainBestList();
	//비밀번호찾기를위한 아이디 유무 체크
	public NbMemberDto findPwChk(Map<String, String> map);
	//임시비밀번호생성
	public int upTempPw(Map<String, String> map); 

	
}
