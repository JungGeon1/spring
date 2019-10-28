<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="<c:url value="/js/bootstrap.min.js"/>" type="text/javascript"></script>
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
<meta charset="UTF-8">

<!-- include summernote css/js-->
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>

<title>ADMIN BOARD INSERT</title>
<style>
#header {
	text-align: center;
}

.both {
	clear: both;
}

#contents {
	width: 80%;
	margin-left: 50px;
}

.btnWidth {
	width: 100%;
}

#insertBox {
	float: left;
}

.content {
	width: 1800px;
	height: 100%;
	margin: 0 auto;
}
</style>
</head>
<body>


	<%@include file="/WEB-INF/views/frame/header.jsp"%>


	<%@include file="/WEB-INF/views/frame/nav.jsp"%>

	<div id="contents">
		<div class="content">
			<div id="insertBox">
				<h1>ADMIB BOARD INSERT</h1>
				<!-- <form id="insertForm" enctype="multipart/form-data" method="post" action="rest"> -->
				<form id="insertForm">
					<table>


						<tr>

							<td><input type="text" class="form-control"
								id="adminBoard_id" name="adminBoard_id" required
								placeholder="작성자" value="${admin_id}" readonly="readonly">
							</td>
						</tr>
						<tr>

							<td><input type="text" class="form-control"
								id="adminBoard_email" name="adminBoard_email"
								readonly="readonly"></td>
						</tr>
						<tr>

							<td><input type="text" class="form-control"
								id="adminBoard_title" name="adminBoard_title" required
								placeholder="제목을 입력해주세요"></td>
						</tr>

						<tr>

							<td><textarea id="adminBoard_content"
									name="adminBoard_content" required placeholder="내용을 입력해주세요"></textarea></td>
						</tr>
						<tr>

							<td><input type="file" id="adminBoard_file"
								name="adminBoard_file"></td>
						</tr>
						<tr>

							<td><input type="submit" class="btn btn-default btnWidth"
								value="OK"></td>
						</tr>
					</table>
				</form>
			</div>


		</div>


	</div>

	<%@include file="/WEB-INF/views/frame/footer.jsp"%>
	<script>
		$(document).ready(function() {
			//에디터툴 -> 사진업로드 가능하게 수정예정
			$('#adminBoard_content').summernote({
				height : 300,
				width : 700, // set editor height
				minHeight : null, // set minimum height of editor
				maxHeight : null, // set maximum height of editor
				focus : true, // set focus to editable area after initializing summernote
				lang : 'ko-KR', // 언어 세팅

			});
			//이베일 바인딩
			bindingEmail();

		})

		//게시글 등록				 
		$('#insertForm').submit(function() {
			var formData = new FormData(); // 파일 전송 -> FormData()활용

			formData.append('adminBoard_id', $('#adminBoard_id').val());
			formData.append('adminBoard_title', $('#adminBoard_title').val());
			formData.append('adminBoard_content', $('#adminBoard_content').val());
			formData.append('adminBoard_email', $('#adminBoard_email').val());
		
			if ($('#adminBoard_file')[0].files[0] != null) {
				//$('#adminBoard_file')[0].files[0]->파일객체
				formData.append('adminBoard_file', $('#adminBoard_file')[0].files[0]);
			}

			$.ajax({
				url : '${pageContext.request.contextPath}/adminBoard/insert',
				type : 'post',
				data : formData,
				processData : false, //파일 전송 시 필수
				contentType : false, //파일 전송 시 필수
				success : function(data) {

					if (data == 'success') {
						alert('게시글이 작성되었습니다. 리스트로 이동합니다');
						location.href = '${pageContext.request.contextPath}/adminBoard'
					}
				}

			});
			return false;
		})

		//이메일값 바인딩용				 
		function bindingEmail() {
			$.ajax({
				url : '${pageContext.request.contextPath}/adminPage/adminInfo?admin_id=${admin_id}',
				type : 'get',
				error : function (data) {
					alert(data);
				},
				success : function(data) {
						$('#adminBoard_email').val(data.admin_email);
				
					}
				});

			}

		
	</script>
</body>
</html>










