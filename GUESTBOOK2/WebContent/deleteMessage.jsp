<%@page import="guestbook.service.InvalidMessagePasswordException"%>
<%@page import="guestbook.service.MessageNotFoundException"%>
<%@page import="java.sql.SQLException"%>
<%@page import="guestbook.service.DeleteMessageSrvice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	int messageId = Integer.parseInt(request.getParameter("messageId"));
	String password = request.getParameter("password");
	
	int resultCnt = 0;
	boolean chk = false;
	String msg = "";
	
	// 서비스 객체 생성
	DeleteMessageSrvice service = DeleteMessageSrvice.getInstance();
	
	try {
		resultCnt = service.deleteMessage(messageId, password);
		chk = true;
	} catch ( SQLException e ){
		msg = e.getMessage();
	} catch ( MessageNotFoundException e ) {
		msg = e.getMessage();
	} catch ( InvalidMessagePasswordException e ){
		msg = e.getMessage();
	}
	


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>

</style>
</head>
<body>

	<h1>
		<%
			if(chk){		
		%>
			<%= resultCnt %> 개의 행이 삭제 되었습니다.
		<%	} else { %>
			<%= msg %>
		<%	} %>
	</h1>
	
	<a href="list.jsp">리스트</a>



















</body>
</html>