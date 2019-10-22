package com.test.nb.dao;

import java.util.List;
import java.util.Map;

import com.test.nb.domain.CommentDto;
import com.test.nb.domain.ListViewDataDto;
import com.test.nb.domain.NbAdminMemberDto;
import com.test.nb.domain.NbFindAdminIdDto;
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
	//관리자 생성
	public int createAdminMember(NbAdminMemberDto dto);
	//비밀번호변경
	public int pwChage(Map<String, String> pwChangeMap);
	//아이디변경
	public int idChage(Map<String, String> idChangeMap);
	//관리자삭제
	public int adminDelete(int admin_idx);
	//권한 해제
	public int empowerOldAdmin(String oldAdminId);
	//권한부여
	public int empowerNewAdmin(int newAdminIdx);
	//비밀번호 찾기 계정확인->아이디랑 이메일 키워드
	public NbAdminMemberDto findAdminPwChk(Map<String, String> pwChkMap);
	//임시비밀번호로 계정 비밀번호 변경
	public int upTempPw(Map<String, String> pwUpMap);
	//아이디 찾기
	public List<NbFindAdminIdDto> findAdminIdList(Map<String, String> map);
	
}
