<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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

	<h1>비밀번호를 확인해주겠노라</h1>
	<form action="delete" method="post">
	
		${messageId}번 메시지를 삭제하고싶으면 비밀번호를 입력해보거라 <br>
		<input type="hidden" name="messageId" value="${param.messageId}">
		비밀번호 <input type="password" name="password" required> <br>
		<input type="submit" value="메시지삭제">	
	
	
	</form>

















</body>
</html>