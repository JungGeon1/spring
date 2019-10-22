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
 .wrap-loading div{ /*로딩 이미지*/
        position: fixed;
        top:50%;
        left:50%;
        margin-left: -21px;
        margin-top: -21px;
  }

 .display-none{ /*감추기*/
	 display:none;
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
	<td><h1>FIND ADMIN PASSWORD</h1><td>
</tr>

<tr>
	<td><input class="form-control textWidthLarge" type="text" id="admin_id" name="admin_id" required placeholder="아이디을 입력해 주세요"></td>
</tr>
<tr>
	<td><input class="form-control textWidthLarge" type="email" id="admin_email" name="admin_email" required placeholder="등록했던 이메일을 입력해 주세요"></td>
</tr>
<tr>
	<td><input  type="button"  class="btn btn-default btn-sm" onclick="checkId()"value="임시 비밀번호 전송" ></td>
</tr>


</table>

	
	
	
					
</div>							
								
									
								
	<!-- 비밀번호변경메일전송시 로딩화면 -->
	 <div class="wrap-loading display-none">

  		 <div><img src="/nb/images/loading1.gif" /></div>

	</div>							
									
							
</div>
<%@include file="/WEB-INF/views/frame/footer.jsp" %>
<script>
$(document).ready(function(){
	
	
})
    
// 아이디 유무 체크 및 임시 비밀번호 생성
function checkId() {
	
	if(confirm('메일로 임시 비밀번호를 전송하시겠습니까?')){
			//이메일유효성체크
			var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
	
			if ($('#admin_id').val().length < 1 ) {
				alert('아이디를 입력해주세요!');
				return false;
			}
			if(!exptext.test($('#admin_email').val())){
				
				alert('이메일 형식이 아닙니다');
				return false;
			}
			
				$.ajax({
					url : '/nb/findAccount/findAdminPwIdChk',
					data : {
						admin_id : $('#admin_id').val(),
						admin_email : $('#admin_email').val()						
					},
					type : 'post',
					error : function (error) {
						alert(error);
					},
					success : function(data) {
						//alert(data);
						if (data == 'success') {
						
							alert("이메일로 임시 비밀번호를 전송했습니다.\n로그인 후 변경해 주시기 바랍니다.");
							location.href='${pageContext.request.contextPath}/login/admin';
						} else {
							
							alert("관리자정보가 없거나 등록된 이메일이 일치하지 않습닏다.");
						
						}
					},beforeSend:function(){
				       // (이미지 보여주기 처리)
				        $('.wrap-loading').removeClass('display-none');
				    }
				    ,complete:function(){
				       // (이미지 감추기 처리)
				        $('.wrap-loading').addClass('display-none');
				        }
				});
				
				return false;
		}
}
		
</script>
</body>
</html>







	
	

