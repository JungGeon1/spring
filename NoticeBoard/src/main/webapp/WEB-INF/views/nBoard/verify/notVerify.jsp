<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/coming-sssoon.css" rel="stylesheet" />
<link href="<c:url value="/css/nbCss.css"/>" rel="stylesheet" />
<!--     Fonts     -->
<link href="https://fonts.googleapis.com/css?family=Lobster&display=swap" rel="stylesheet">
<link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.css" rel="stylesheet">
 <link href="https://fonts.googleapis.com/css?family=Grand+Hotel&display=swap" rel="stylesheet">
 <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'name='viewport' />
<meta name="viewport" content="width=device-width" />
<meta charset="UTF-8">
<title>Insert title here</title>



<style>
#header{
text-align: center;
}

.both{
clear: both;
}

.width{
width: 900px;
height:700px;
margin: 0 auto;
}
#contents{
text-align: center;
padding-top: 40px;
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
	
	<h2>인증이 확인되지 않았습니다.</h2>
	<!-- 로그인서비스에서 세션에 올려둔 이메일 -->
	<h3><a href="#" id="reEmailSend">메일 재전송(${reEmail})</a></h3>
</div>

<!-- 컨텐츠 끝 -->


<!-- 푸터 시작 -->
<%@ include file="/WEB-INF/views/frame/footer.jsp" %>
<!-- 푸터 끝 -->
<script>


	$(document).ready(function () {});


	$('#reEmailSend').click(function() {
		
		$.ajax({
			
				url:'/nb/verify/reMailSend',
				type:'POST',
				data:{ email:'${reEmail}'},
				success: function (data) {
					if(data=='success'){
						alert('메일이 재전송되었습니다.!');
						location.href='${pageContext.request.contextPath}';
					}
				}
			
		});
	
	return false;
	
	});


</script>
</body>
</html>
