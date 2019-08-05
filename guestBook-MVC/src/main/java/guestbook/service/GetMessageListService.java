package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.dao.MessageDao;
import guestbook.model.Message;
import guestbook.model.MessageListView;
import jdbc.ConnectionProvider;

public class GetMessageListService implements GuestBookService {
	
	// MessageListView 를 생성해서 결과로 반환
	
	//private GetMessageListService() {}
	
	//private static GetMessageListService service = new GetMessageListService();
	/*
	 * public static GetMessageListService getInstance() { return service; }
	 */
	
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
			MessageDao dao = MessageDao.getInstance();
			
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


	@Override
	public String getViewName(HttpServletRequest request, HttpServletResponse response) {
		
		String viewName = "/WEB-INF/view/list_view.jsp";
		
		// 사용자의 요청 받기
		int pageNumber = 1;
		String pageNo = request.getParameter("page");
		if(pageNo != null) {
			pageNumber = Integer.parseInt(pageNo);
		}
		
		MessageListView viewData = getMessageListView(pageNumber);
		
		request.setAttribute("viewData", viewData);
		
		
		
		return viewName;
	}
	
	
	
	
	
	
	
	
	
	
	

}
