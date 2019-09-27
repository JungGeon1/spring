<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<link href="css/bootstrap.css" rel="stylesheet" />
<link href="css/coming-sssoon.css" rel="stylesheet" />
<link href="<c:url value="/css/nbCss.css"/>" rel="stylesheet" />
<!--     Fonts     -->
<link href="https://fonts.googleapis.com/css?family=Lobster&display=swap" rel="stylesheet">
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
<title>Insert title here</title>
<style>

#header {
	text-align: center;
}




</style>
</head>
<body>


	<%@include file="/WEB-INF/views/frame/header.jsp"%>


	<%@include file="/WEB-INF/views/frame/nav.jsp"%>

	<div id="contents">
		<h2>MY PAGE</h2>
		<input id="id" type="text" value="${nbm_id}">
		

			<div ></div>
			
			<div >
				<button class="btn btn-default" onclick="location.href='/nb/updatePage?idx=${idx}'">수정</button>
				<button class="btn btn-default" onclick="deleteBoard()">삭제</button>
			</div>
		

	
	</div>

	<%@include file="/WEB-INF/views/frame/footer.jsp"%>
	<script>
		$(document).ready(function name() {

		
		});

		function getViewData(idx) {

			$.ajax({
						url : 'rest/viewPage?category=page&idx=' + idx,
						type : 'GET',
						error : function(error) {
							alert(error);
						},
						success : function(data) {
							var html = '';
							var img = '';
							html += '<div><h2>' + data.u_title + '</h2></div>';
							html += '<div><h3>' + data.u_id + '</h3></div>';
							html += '<div><h4>' + data.u_date + '</h4></div>';
							html += '<div><p>' + data.u_contents + '</p></div>';
							img += '<img class="img" src="uploadfile/'+data.u_image+'" alt="'+data.u_image+'">';
							$('#textBox').html(html);
							$('#imgBox').html(img);
						}

					});

			return false;

		}
		
		function deleteBoard() {

			var idx = $('#idx').val();
			if (confirm('삭제하시겠습니까')) {
				$.ajax({
					url : 'rest/delete/' + idx + '?category=page',
					type : 'delete',
					error : function(error) {
						alert(error);
					},
					success : function(data) {
						alert('삭제되었습니다. 리스트로 이동합니다.');
						location.href = '/nb/pageList';
					}

				});

			}
		}
		
		function insertComment() {
		if($('#commentText').val()==''){
			alert('댓글을 작성해주세요');
			return;
		}
			$.ajax({
					url:'rest/comment',
					type:'Post',
					data: {
						 n_id : $('#id').val(),
						 n_comment : $('#commentText').val(),
						 u_idx :$('#idx').val()
					},error : function(error) {
						alert(error);
					},
					success : function(data) {
						//alert(data);
						if(data=='success'){
							alert('댓글이 등록되었습니다.');
							commentList();
							$('#commentText').val(null);
						}
					}
			});
				
				return false;
			
		}
		
		

	
	</script>
</body>
</html>