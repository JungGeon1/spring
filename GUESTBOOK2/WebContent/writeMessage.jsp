<%@page import="guestbook.service.WriteMessageService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 1. 폼으로 부터 데이터를 받는다.
	// 2. Message 객체에 저장 : useBean 액션테그
	// 3. WriteMessageService  객체 생성
	// 4. write 메서드 실행  : 1/0
%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="message" class="guestbook.model.Message"/>
<jsp:setProperty property="*" name="message"/>
<%
	WriteMessageService service = WriteMessageService.getInstance();
	int cnt = service.write(message);
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
	<%= cnt>0 ? "방명록에 메시지를 남겼습니다." : "메시지 등록이 되지 않았습니다. "  %>
	</h1>
	<a href="list.jsp">목록보기</a>








</body>
</html>