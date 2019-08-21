<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<link href="<c:url value="/css/default.css"/>" rel="stylesheet" type="text/css">
<style>
	div.mypage_box {
		width : 450px;
	}
	img {
		display: block;
		width: 100px;
	}
	h1, h3 {
		text-align: center;
	}
</style>
</head>
<body>


<!-- 해더 시작 -->
<%@ include file="/WEB-INF/views/frame/header.jsp" %>
<!-- 해더 끝 -->

<!-- 네비게이션 시작 -->
<%@ include file="/WEB-INF/views/frame/nav.jsp" %>
<!-- 네비게이션 끝 -->

<!-- 컨텐츠 시작 -->
<div id="contents">
	
	<h1>실패다잇!</h1>
	<!-- 로그인서비스에서 세션에 올려둔 이메일 -->
	<h3><a href="#" id="reEmailSend">메일 재전송(${reEmail})</a></h3>
</div>
<!-- 컨텐츠 끝 -->


<!-- 푸터 시작 -->
<%@ include file="/WEB-INF/views/frame/footer.jsp" %>
<!-- 푸터 끝 -->


<script>


	$(document).ready(function () {
		
		$('#reEmailSend').click(function() {
			
			$.ajax({
				
					url:'verify/reMailSend',
					type:'POST',
					data:{ email:'${reEmail}'},
					success: function (data) {
						if(data=='success'){
							alert('메일이 재전송됬어! 이번엔 똑바로 해!');
						}
					}
				
				
				
			});
		
		return false;
		
		});
		
		
	
	});





</script>
</body>
</html>
