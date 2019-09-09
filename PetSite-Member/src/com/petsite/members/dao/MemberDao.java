package com.petsite.members.dao;

import com.petsite.members.domain.MemberInfo;

public interface MemberDao {
	public int insertMem(MemberInfo memberInfo); // 회원가입
	public MemberInfo selectById(String id); // 로그인, 중복 아이디 체크
	public int updateVerify(String id); // verify값 변경
	public int updateMem(MemberInfo memberInfo); // 내 정보 수정
	public int deleteMem(String id); // 회원탈퇴
}
