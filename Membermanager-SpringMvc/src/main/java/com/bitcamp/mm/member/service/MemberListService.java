package com.bitcamp.mm.member.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.mm.jdbc.ConnectionProvider;
import com.bitcamp.mm.member.dao.MemberDao;
import com.bitcamp.mm.member.dao.MemberJdbcTempleteDao;
import com.bitcamp.mm.member.domain.ListViewData;
import com.bitcamp.mm.member.domain.MemberInfo;
import com.bitcamp.mm.member.domain.SearchParam;

@Service("listServcie")
public class MemberListService implements MemberService {

	// @Autowired
	// private MemberDao dao;
	@Autowired
	private MemberJdbcTempleteDao templeteDao;
	
	final int MEMBER_CNT_List = 3;

	public ListViewData getListData(int currentPageNumber, SearchParam searchParam) {

		ListViewData listData = new ListViewData();

		// 현재 페이지 번호
		listData.setCurrentPageNumber(currentPageNumber);

		// 전체 게시물의 개수
		int totalCnt = templeteDao.selectTotalCount(searchParam);

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

		if (searchParam == null) {
			memberList = templeteDao.selectList(index, MEMBER_CNT_List);
		} else if (searchParam.getStype().equals("both")) {
			memberList = templeteDao.selectListByBoth(index, MEMBER_CNT_List, searchParam);
		} else if (searchParam.getStype().equals("id")) {
			memberList = templeteDao.selectListById(index, MEMBER_CNT_List, searchParam);
		} else if (searchParam.getStype().equals("name")) {
			memberList = templeteDao.selectListByName(index, MEMBER_CNT_List, searchParam);
		}

		listData.setMemberList(memberList);

		// 1 -> 9-0 =9, 2 -> 9-3=6
		int no = totalCnt - index;
		listData.setNo(no);

		listData.setTotalCount(totalCnt);

		return listData;

	}

}