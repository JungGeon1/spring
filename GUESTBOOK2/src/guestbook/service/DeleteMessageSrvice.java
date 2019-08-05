package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guestbook.dao.MessageDao;
import guestbook.model.Message;
import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;

public class DeleteMessageSrvice implements GuestBookService {
	
	//private DeleteMessageSrvice() {}
	
	//private static DeleteMessageSrvice service = new DeleteMessageSrvice();
	
	/*
	 * public static DeleteMessageSrvice getInstance() { return service; }
	 */
	
	public int deleteMessage(int messageId, String password) throws SQLException, MessageNotFoundException, InvalidMessagePasswordException {
		
		int resultCnt = 0;
		
		Connection conn=null;
		
		try {
			conn = ConnectionProvider.getConnection();
			
			// 트렌젝션 처리
			conn.setAutoCommit(false);
			
			
			// Message Dao 필요  
			MessageDao dao = MessageDao.getInstance();
			// 1. 전달받은 게시물 아이디로 게시물 확인
			Message message = dao.select(conn, messageId);
			
			// 2. 게시물이 존재 하지 않으면 예외 처리
			if(message == null) {
				throw new MessageNotFoundException("메시지가 존재하지 않습니다. : " + messageId);
			
			}			
			
			// 3. 게시물이 존재 하면 비밀번호 확인 -> 사용자가 입력한 비밀번호와 비교
			// 4. 비밀번호가 존재하지 않거나 사용자 비밀번호가 틀린경우 예외처리
			if(!message.hasPassword()) {
				throw new InvalidMessagePasswordException("비밀번호가 일치하지 않습니다.");
			}
			// 비밀번호 비교
			if(!message.matchPassword(password)) {
				throw new InvalidMessagePasswordException("비밀번호가 일치하지 않습니다.");
			}
				
			// 5. 비밀번호가 일치하면 정상 처리(삭제) ->  commit
			
			resultCnt = dao.deleteMessage(conn, messageId);
			
			// 정상 처리
			conn.commit();
			
		} catch (SQLException e) {
			// 트렌젝션의 롤백
			JdbcUtil.rollback(conn);
			e.printStackTrace();
			throw e; 
			
		} catch (MessageNotFoundException e) {
			// 트렌젝션의 롤백
			JdbcUtil.rollback(conn);
			e.printStackTrace();
			throw e;
			
		} catch (InvalidMessagePasswordException e) {
			// 트렌젝션의 롤백
			JdbcUtil.rollback(conn);
			e.printStackTrace();
			throw e;
		}
		
		return resultCnt;
		
	}

	
	
	
	
	@Override
	public String getViewName(HttpServletRequest request, HttpServletResponse response) {
		
		String viewpage = "/WEB-INF/view/delete.jsp";
		
		int messageId = Integer.parseInt(request.getParameter("messageId"));
		String password = request.getParameter("password");
		
		// 결과 : true/fale
		// 처리개수 : resultCnt
		// 메시지 : msg
		
		boolean chk = false;
		int resultCnt = 0;
		String msg = "";
		
		
		// 핵심 처리 
		try {
			resultCnt = deleteMessage(messageId, password);
			chk = true;			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			msg = e.getMessage();
			
		} catch (MessageNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			msg = e.getMessage();
			
		} catch (InvalidMessagePasswordException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			msg = e.getMessage();
		}
		
		// 뷰 페이지와 결과 데이터를 공유(전달)
		request.setAttribute("chk", chk);
		request.setAttribute("resultCnt", resultCnt);
		request.setAttribute("msg", msg);
		
		
		
		return viewpage;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
