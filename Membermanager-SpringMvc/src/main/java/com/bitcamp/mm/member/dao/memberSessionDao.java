package com.bitcamp.mm.member.dao;

import java.util.List;
import java.util.Map;


import com.bitcamp.mm.member.domain.MemberInfo;
import com.bitcamp.mm.member.domain.SearchParam;

public interface memberSessionDao {
	
	public int insertMember(MemberInfo memberInfo);
	
	public MemberInfo selectMemberById(String userId);
	
	public MemberInfo  selectMemberById2(String id);
	
	public MemberInfo selectMemberByIdx(int id);
	
	public int memberUpdate(MemberInfo memberInfo);
	
	public int memberDelete(int messageId);
	
	public List<MemberInfo> selectList(Map<String, Object> params);
	
	public int selectTotalCount(SearchParam searchParam);
	
	public List<MemberInfo> selectAllList();

}
