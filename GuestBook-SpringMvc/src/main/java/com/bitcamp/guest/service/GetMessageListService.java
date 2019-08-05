package com.bitcamp.guest.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitcamp.guest.dao.MessageDao;
import com.bitcamp.guest.domain.Message;
import com.bitcamp.guest.domain.MessageListView;
import com.bitcamp.guest.jdbc.ConnectionProvider;


@Service("listService")
public class GetMessageListService implements GuestBookService {
	
	@Autowired
	private MessageDao dao;
	// 1. 한페이지에 보여줄 게시글의 개수
	private static final int MESSAGE_COUNT_PER_PAGE = 3;
	

	public MessageListView getMessageListView(int pageNumber) {
		
		// 2. 현재 페이지 번호
		int currentPageNumber = pageNumber;
		
		Connection conn;
		
		MessageListView view = null;
		
		try {
			// Connection 
			conn = ConnectionProvider.getConnection();
			
			// DAO
			//MessageDao dao = MessageDao.getInstance();
			
			// 전체 게시물의 개수
			int messageTotalCount = dao.selectCount(conn);
			
			// 게시물 내용 리스트, DB 검색에 사용할 start_row, end_row
			List<Message> messageList = null;
			int firstRow = 0;
			int endRow = 0;
			
			if(messageTotalCount > 0) {
				
				firstRow = (pageNumber-1)*MESSAGE_COUNT_PER_PAGE + 1;
				endRow = firstRow + MESSAGE_COUNT_PER_PAGE -1;
				
				messageList = dao.selectList(conn, firstRow, endRow);
				
			} else {
				currentPageNumber = 0;
				messageList = Collections.emptyList();						
			}
			
			view  = new MessageListView(
					messageTotalCount, 
					currentPageNumber, 
					messageList, 
					MESSAGE_COUNT_PER_PAGE, 
					firstRow, 
					endRow);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return view;
		
	}


	
	
	
	
	
	
	
	
	
	
	
	

}
