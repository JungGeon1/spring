package com.bitcamp.mm.member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.mm.jdbc.ConnectionProvider;
import com.bitcamp.mm.member.dao.MemberDao;
import com.bitcamp.mm.member.dao.MemberJdbcTempleteDao;
import com.bitcamp.mm.member.dao.memberSessionDao;
import com.bitcamp.mm.member.domain.ListViewData;
import com.bitcamp.mm.member.domain.MemberInfo;
import com.bitcamp.mm.member.domain.SearchParam;

@Service("listServcie")
public class MemberListService implements MemberService {

	// @Autowired
	// private MemberDao dao;
	//@Autowired
	//private MemberJdbcTempleteDao templeteDao;
	
	@Autowired
	private SqlSessionTemplate sessionTemplate;
	
	private memberSessionDao sessionDao;
	
	final int MEMBER_CNT_List = 3;

	public ListViewData getListData(int currentPageNumber, SearchParam searchParam) {
		
		sessionDao=sessionTemplate.getMapper(memberSessionDao.class);
		
		ListViewData listData = new ListViewData();

		// 현재 페이지 번호
		listData.setCurrentPageNumber(currentPageNumber);

		// 전체 게시물의 개수
		
		
		int totalCnt = sessionDao.selectTotalCount(searchParam);
		System.out.println(totalCnt);
		int totalPageCnt = 0;
		// 전체 페이지 개수
		if (totalCnt > 0) {
			totalPageCnt = totalCnt / MEMBER_CNT_List;
			if (totalCnt % MEMBER_CNT_List > 0) {
				totalPageCnt++;
			}
		}
		listData.setPageTotalCount(totalPageCnt);

		// 구간 검색을 위한 index
		// 1 -> 0 , 2 -> 3, 3 -> 6, 4 -> 9
		int index = (currentPageNumber - 1) * MEMBER_CNT_List;
		// 회원 정보 리스트
		List<MemberInfo> memberList = null;
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("search", searchParam);
		params.put("index", index);
		params.put("count",  MEMBER_CNT_List);
		
		memberList = sessionDao.selectList(params);
		/*
		 * if (searchParam == null) { memberList = sessionDao.selectList(params); } else
		 * if (searchParam.getStype().equals("both")) { memberList =
		 * templeteDao.selectListByBoth(index, MEMBER_CNT_List, searchParam); } else if
		 * (searchParam.getStype().equals("id")) { memberList =
		 * templeteDao.selectListById(index, MEMBER_CNT_List, searchParam); } else if
		 * (searchParam.getStype().equals("name")) { memberList =
		 * templeteDao.selectListByName(index, MEMBER_CNT_List, searchParam); }
		 */

		listData.setMemberList(memberList);
		for(MemberInfo m : memberList) {
			System.out.println(m);
		}
		// 1 -> 9-0 =9, 2 -> 9-3=6
		int no = totalCnt - index;
		listData.setNo(no);

		listData.setTotalCount(totalCnt);

		return listData;

	}
	
	public List<MemberInfo> getAllList(){
		
		
		
		sessionDao=sessionTemplate.getMapper(memberSessionDao.class);
		
		List<MemberInfo> list=sessionDao.selectAllList();
		
		return list;
		
	}
	
	
	
}