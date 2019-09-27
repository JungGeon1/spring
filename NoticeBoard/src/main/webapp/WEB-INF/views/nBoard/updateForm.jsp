<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<!-- include summernote css/js-->
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css"
	rel="stylesheet">
<script
	src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
<script src="lang/summernote-ko-KR.js"></script>
<title>Insert title here</title>
<style>

#header {
	text-align: center;
}

.li {
	float: right;
	padding-right: 40px;
}

.both {
	clear: both;
}

#contents {
	width: 80%;
	margin-left: 50px;
}

#img {
	width: 500px;
}
</style>
</head>
<body>


	<%@include file="/WEB-INF/views/frame/header.jsp"%>


	<%@include file="/WEB-INF/views/frame/nav.jsp"%>

	<div id="contents">
		<input id="idx" type="text" value="${idx}" hidden="">
		<h1>UPDATE</h1>
		<!-- <form id="insertForm" enctype="multipart/form-data" method="post" action="rest"> -->
		<form id="updateForm">
			<table>
				<tr>
					<td><input type="text" id="category" name="category"
						value="page" hidden=""></td>
				</tr>

				<tr>

					<td><input type="text" id="u_id" name="u_id" required
						placeholder="작성자" readonly="readonly"></td>
				</tr>

				<tr>

					<td><input type="text" id="u_title" name="u_title" required
						placeholder="제목을 입력해주세요"></td>
				</tr>
				<tr>

					<td><textarea id="u_contents" name="u_contents"
							placeholder="내용을 입력해주세요"></textarea></td>
				</tr>
				<tr>

					<td><input type="file" id="u_image" name="u_image"></td>
				</tr>
				<tr>

					<td><input type="submit" value="OK"></td>
				</tr>
			</table>
		</form>

		<div class="img-wrap" id="img-wrap"></div>
	</div>
	<%@include file="/WEB-INF/views/frame/footer.jsp"%>
	<script>
		$(document).ready(function() {
			$('#u_contents').summernote({
				height : 300, // set editor height
				minHeight : null, // set minimum height of editor
				maxHeight : null, // set maximum height of editor
				focus : true, // set focus to editable area after initializing summernote
				lang : 'ko-KR', // 언어 세팅

			});

			var idx = $('#idx').val();
			getViewData(idx);

		})

		$("#u_image").change(function() {
			imgcheck(this);
			read(this);
		});
		function read(input) {

			if (input.files && input.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					$('#img').attr('src', e.target.result);
				}
				reader.readAsDataURL(input.files[0]);
			}
		}

		$('#updateForm').submit(function() {

			if (confirm('수정하시겠습니까?')) {
				var formData = new FormData(); // 파일 전송 -> FormData()활용
				formData.append('idx', $('#idx').val());
				formData.append('u_id', $('#u_id').val());
				formData.append('u_title', $('#u_title').val());
				formData.append('u_contents', $('#u_contents').val());
				formData.append('category', $('#category').val());

				if ($('#u_image')[0].files[0] != null) {
					//$('#u_image')[0].files[0]->파일객체
					formData.append('u_image', $('#u_image')[0].files[0]);
				}

				$.ajax({
					url : 'rest/update',
					type : 'post',
					data : formData,
					processData : false, //파일 전송 시 필수
					contentType : false, //파일 전송 시 필수
					success : function(data) {
						//alert(data);
						if (data == 'success') {
							alert('수정되었습니다');
							location.href = 'view?idx=' + $('#idx').val() + '';
						}
					}

				});

			}
			return false;
		})

		function imgcheck(obj) {
			var val = obj.value;
			var point = val.lastIndexOf('.');
			var temp_filetype = val.substring(point + 1, val.length);
			//인자값을 영문 대문자로 변경한다
			var filetype = temp_filetype.toUpperCase()

			if (filetype == 'JPG' || filetype == 'GIF' || filetype == 'BMP'
					|| filetype == 'PNG') {

				return true;
			} else {
				alert("이미지 파일(JPG, GIF, BMP,PNG)만 올릴 수 있습니다.");
				//파일폼 초기화
				obj.outerHTML = obj.outerHTML; //file 개체를 초기화하는 부분
				return false;
			}

		}
		function getViewData(idx) {

			$.ajax({
						url : 'rest/viewPage?category=page&idx=' + idx,
						type : 'GET',
						error : function(error) {
							alert(error);
						},
						success : function(data) {

							var img = '';
							img += '<h4>이미지 미리보기</h4>';
							$('#u_id').val(data.u_id);
							$('#u_title').val(data.u_title);
							//$('#u_contents').val(data.u_contents); 

							$('#u_contents').summernote('editor.insertText',
									data.u_contents);
							img += '<img id="img" src="uploadfile/'+data.u_image+'" alt="'+data.u_image+'">';

							$('#img-wrap').html(img);
						}

					});

			return false;

		}
	</script>
</body>
</html>










