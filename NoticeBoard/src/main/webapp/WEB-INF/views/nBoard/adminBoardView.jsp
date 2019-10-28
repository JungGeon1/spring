<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="<c:url value="/js/bootstrap.min.js"/>"
	type="text/javascript"></script>
<link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet" />
<link href="<c:url value="/css/coming-sssoon.css"/>" rel="stylesheet" />
<link href="<c:url value="/css/nbCss.css"/>" rel="stylesheet" />
<!--     Fonts     -->
<link
	href="https://fonts.googleapis.com/css?family=Lobster&display=swap"
	rel="stylesheet">
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.css"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Grand+Hotel&display=swap"
	rel="stylesheet">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />
<meta charset="UTF-8">
<title>Admin View Page</title>
<style>
.wordBreak {
	word-break: break-all;
}



.infoBox {
	width: 800px;
	height: 100%;
	margin: 0 auto;
	text-align: center;
}

.infoTable {
	margin: 0 auto;
}

.textWidthChatBox {
	width: 800px;
	height: 450px;
	border-left: 2px solid #ddd;
	border-right: 2px solid #ddd;
	padding: 15px;
	text-align: left
	
}

.textWidthLarge {
	width: 100%;
}.fileDown {
	width: 100%;
}

.center{
	text-align: center;
}.right{
	text-align: right;
}

td {
	padding: 5px;
}
</style>
</head>
<body>


	<%@include file="/WEB-INF/views/frame/header.jsp"%>


	<%@include file="/WEB-INF/views/frame/nav.jsp"%>

	<div id="contents">
		<div class="infoBox">

			<input type="text" id="idx" value="${idx}" hidden >
			<table class="infoTable">
				<tr>
					<td><h1>ADMIN NOTICE</h1></td>
				</tr>
				<tr>
					<td>
						<div class="textWidthChatBox" id="info_box">
							<div class="fileDown right">
								<div class="btn-group ">
									<button type="button" class="btn btn-default  btn-xs dropdown-toggle" data-toggle="dropdown" aria-expanded="false"> 첨부파일 <span class="caret"></span>
									</button>
									<ul class="dropdown-menu" role="menu">
										<li class="center" id="fileDown"><!-- 파일들어갈자리 --> </li>
									</ul>
								</div>
							</div>
							<div class="a_title both" id="a_title">Title. </div>
							<div class="a_date" id="a_date">Date. </div>
							<div class="a_id" id="a_id">AdminId. </div>
							<div class="a_email" id="a_email">AdminE_mail. </div>
							<div class="a_content" id="a_content">content.</div>
							<p id="a_content_in"></p>
						</div>
					</td>
				</tr>

			</table>
		</div>
	</div>

	<%@include file="/WEB-INF/views/frame/footer.jsp"%>
	<script>
		$(document).ready(function name() {

			var idx = $('#idx').val();
			//viewsUp(idx);
			getViewData(idx);

		});
		//뿌려줄 관리자 게시판 정보
		function getViewData(idx) {

			$.ajax({
						url : '${pageContext.request.contextPath}/adminBoard/boardViewInfo?idx='+ idx,
						type : 'GET',
						error : function(error) {
							alert(error);
						},
						success : function(data) {
							
							var title='';
							var date='';
							var id='';
							var email='';
							var content='';
							var file='';
							//alert(data.adminBoard_id);
							title += data.adminBoard_title;
							date += data.adminBoard_date;
							id += data.adminBoard_id;
							email += data.adminBoard_email;
							content += data.adminBoard_content;
							if(data.adminBoard_file!=null){
							file += '<a href="${pageContext.request.contextPath}/fileDown?fileName='+data.adminBoard_file+'" >'+data.adminBoard_file+'</a>';
							}else{
							file +='No File';								
							}
							$('#a_title').append(title);
							$('#a_date').append(date);
							$('#a_id').append(id);
							$('#a_email').append(email);
							$('#a_content').append(content);
							//여기는 값을 아예 바꿔줘야하므로  html
							$('#fileDown').html(file);
						}

					});

			return false;

		}
		//조회수를 올려준다-> 본인글이면 조회수가 안올라가게 수정 예정
		function viewsUp(idx) {

			$.ajax({
				url : '${pageContext.request.contextPath}/adminBoard/viewsUp/'+ idx,
				type : 'post',
				error : function(error) {
					alert(error);
				},
				success : function(data) {
					//alert(data);
				}

			});

			return false;
		}
		
		//파일다운로드
		function fileDown() {
			var fileName=$('#fileDown').val();
			
			$.ajax({
				url : '${pageContext.request.contextPath}/fileDown?fileName='+ fileName,
				type : 'post',
				error : function(error) {
					alert(error);
				},
				success : function(data) {
					//alert(data);
				}
			});
		}
	</script>
</body>
</html>