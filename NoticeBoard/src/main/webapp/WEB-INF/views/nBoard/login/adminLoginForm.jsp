<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/coming-sssoon.css" rel="stylesheet" />
<link href="<c:url value="/css/nbCss.css"/>" rel="stylesheet" />
<!-- 애니메이션css -->
<link href="<c:url value="/css/animation.css"/>" rel="stylesheet" />
<!--     Fonts     -->
<link href="https://fonts.googleapis.com/css?family=Lobster&display=swap"rel="stylesheet">
<link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Grand+Hotel&display=swap" rel="stylesheet">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />

<meta charset="UTF-8">

<title>Insert title here</title>
<style>


#leftBox {
	width: 550px;
	height: 710px;
	/* 	border: 1px solid #ddd; */
	float: left;
	text-align: center;
}

#formDiv {
	float: right;
	width: 550px;
	height: 710px;
	margin: 0 auto;
	padding-top:120px;
	/* 	border: 1px solid #ddd; */
	text-align: center;
	width: 550px;
	padding-left: 70px;
}

#formDiv td {
	padding: 10px;
}

#mainImg {
	width: 600px;
}

#mainImg{
	width: 100%;
	height: 100%;
}

 

</style>
</head>
<body>


	<%@include file="/WEB-INF/views/frame/header.jsp"%>


	<%@include file="/WEB-INF/views/frame/nav.jsp"%>

	<div id="contents">
		<div id="content">
			<div id="leftBox">

				<img id="mainImg" class="slideRight" src="<c:url value="/images/car.png"/>">
			</div>
			<div id="formDiv">

				<form method="post" action="<c:url value="/login/adminLoginReq"/>">
					<table>
						<tr>

							<td colspan="2"><h1>ADMIN LOGIN</h1></td>
						</tr>
						<tr>
							<td>아이디(이메일)</td>
							<td><input class="form-control" type="text" id="admin_id" name="admin_id" required></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input class="form-control" type="password" id="admin_pw" name="admin_pw" required></td>
						</tr>


						<tr>
							<td></td>
						
							<td><a href="<c:url value="/findAccount/findPw"/>">비밀번호 찾기</a>
							<input type="submit"style="float: right" class="btn btn-default" value="JOIN"></td>
						</tr>
					
					</table>
				</form>


			</div>
		</div>
	</div>
	
	

	<%@include file="/WEB-INF/views/frame/footer.jsp"%>



<script>
	
	


</script>
</body>
</html>










