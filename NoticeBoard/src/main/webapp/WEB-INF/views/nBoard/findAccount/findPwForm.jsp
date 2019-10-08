<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>

<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.js" ></script>

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
#header {
	text-align: center;
}


.textWidthLarge{

width: 100%;
}

.findPwBox{
width: 800px;
height: 100%;
margin: 0 auto;
text-align: center;
}

.findPwTable{
margin: 0 auto;
}

td{
	padding: 5px;
} 
</style>
</head>
<body>


<%@include file="/WEB-INF/views/frame/header.jsp" %>


<%@include file="/WEB-INF/views/frame/nav.jsp" %>	

<div id="contents">

	
<div class="findPwBox">								

									
<table class="findPwTable">
<tr>
	<td><h1>FIND PASSWORD</h1><td>
</tr>
<tr>
	<td><input class="form-control textWidthLarge" type="text" id="nbm_name" name="nbm_name" required placeholder="이름을 입력해 주세요"><td>
</tr>
<tr>
	<td><input class="form-control textWidthLarge" type="email" id="nbm_id" name="nbm_id" required placeholder="아이디(이메을)을 입력해 주세요"><td>
</tr>
<tr>
	<td><input  type="button"  class="btn btn-default btn-sm" onclick="checkId()"value="임시 비밀번호 전송" ><td>
</tr>


</table>

	
	
	
					
</div>							
								
									
								
								
									
							
</div>
<%@include file="/WEB-INF/views/frame/footer.jsp" %>
<script>
$(document).ready(function(){
	
	
})
    
// 아이디 유무 체크 및 임시 비밀번호 생성
function checkId() {
			//이메일유효성체크
			var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
			var checkName = RegExp(/^[가-힣a-zA-Z]+$/); // 이름: 한글,영문만 가능
			// 이름 유효성 검사
		
			var id = $('#nbm_id').val();
			
			if (id.length < 1 ) {
				alert('아이디를 입력해주세요!');
				return false;
			}
			if(!exptext.test(id)){
				
				alert('이메일 형식이 아닙니다');
				return false;
			}
			
			if (!checkName.test($('#nbm_name').val())) {
				alert('[이름] 한글,영문만 가능');
			
				return false;
			}
 
			
			
			else {
				$.ajax({
					url : '/nb/findAccount/findPwIdChk',
					data : {
						nbm_id : $('#nbm_id').val(),
						nbm_name : $('#nbm_name').val()
						
					},
					type : 'post',
					error : function (error) {
						alert(error);
					},
					success : function(data) {
						//alert(data);
						if (data == 'success') {
						
							alert("아이디(이메일)로 임시 비밀번호를 전송했습니다.");
							loacation.href='${pageContext.request.contextPath}/login';
						} else {
							
							alert("가입정보가 없습니다.");
						
						}
					}
				});
			}
	return false;
		}
</script>
</body>
</html>







	
	

