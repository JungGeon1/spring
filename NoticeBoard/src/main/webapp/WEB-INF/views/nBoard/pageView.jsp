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



.li {
	float: right;
	padding-right: 40px;
}

.both {
	clear: both;
}

.boardBox {
	width: 900px;
	height: 500px;
	background-color: #ddd;
	margin: 0 auto;
	overflow: scroll;
}

.boardinner {
	width: 380px;
	height: 450px;
	float: left;
	margin-left: 10px;
}

.boardinnerImg {
	width: 380px;
	height: 450px;
}

.img {
	width: 380px;
	height: 380px;
	margin-top: 35px;
	margin-left: 50px;
}

.wordBreak {
	word-break: break-all;
}

.commetBox {
	width: 900px;
	background-color: #ddd;
	margin: 0 auto;
	margin-top: 5px;
	
}.reCommetBox {
	width: 900px;
	background-color: #ddd;
	margin: 0 auto;
    display: none; 
    border: 1px solid white;
}

.btnBox {
	width: 900px;
	background-color: #ddd;
	margin: 0 auto;
}.left{
	float: right;
	padding-right: 55px;
}.right{
	float: right;
	
}.comment{
	width: 900px;
	margin: 0 auto;
	border-bottom : 1px solid white;
	margin-bottom: 5px;
	
}

#commentText {
	margin-left: 15px;
	width: 90%;
	display: inline;
	width: 90%;
}.reCommentText {
	margin-left: 15px;
	width: 80%;
	display: inline;
	
}.cmtBtnBox{
	margin-top: 5px;
}#viewBtnBox{
	display: none;
}
</style>
</head>
<body>


	<%@include file="/WEB-INF/views/frame/header.jsp"%>


	<%@include file="/WEB-INF/views/frame/nav.jsp"%>

	<div id="contents">
		<input id="idx" type="text" value="${idx}" hidden="">
		<input id="id" type="text" value="${nbm_id}" hidden="" readonly="readonly">
		<div class="boardBox">

			<div class="boardinner wordBreak" id="textBox"></div>
			<div class="boardinner" id="imgBox"></div>
			<div class="both left" id="viewBtnBox"> 
				<button class="btn btn-default" onclick="location.href='/nb/updatePage?idx=${idx}'">수정</button>
				<button class="btn btn-default" onclick="deleteBoard()">삭제</button>
			</div>
		</div>

		<div class="commetBox">
			
			<input type="text" placeholder="댓글을 입력해 주세요" class="form-control" id="commentText">
			<button class="btn btn-default" onclick="insertComment()">OK</button>
			<div id="commentList"></div>
			
		</div>
	</div>

	<%@include file="/WEB-INF/views/frame/footer.jsp"%>
	<script>
		$(document).ready(function name() {

			var idx = $('#idx').val();
			viewsUp(idx);
			getViewData(idx);
			commentList()
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
							
							if(data.u_id=='${nbm_id}'){
								$('#viewBtnBox').css('display','block');
							}
							
							$('#textBox').html(html);
							$('#imgBox').html(img);
						}

					});

			return false;

		}
		function viewsUp(idx) {

			$.ajax({
				url : 'rest/viewUp/' + idx,
				type : 'put',
				error : function(error) {
					alert(error);
				},
				success : function(data) {
					//alert(data);
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
		function insertReComment(n_idx) {
			
			if($('#'+n_idx+'reCommentText').val()==''){
				alert('답글을 작성해주세요');
				return;
			}
		
			$.ajax({
					url:'rest/comment/re',
					type:'Post',
					data: {
						u_idx :$('#idx').val(),
						n_id : $('#id').val(),
						n_comment : $('#'+n_idx+'reCommentText').val(),
						n_grpno : $('#'+n_idx+'n_grpno').val(),
						n_grpord: $('#'+n_idx+'n_grpord').val(),
						n_depth :$('#'+n_idx+'n_depth').val()
					
					},error : function(error) {
						alert(error);
					},
					success : function(data) {
						//alert(data);
						if(data=='success'){
							alert('댓글이 등록되었습니다.');
							commentList();
							$('#reCommentText').val(null);
							reCmClose(n_idx);
						}
					}
			});
				
				return false;
			
		}
		function reComment(n_idx) {
			
			$('#'+n_idx+'').css('display','block');
			 return false;
			
		} function reCmClose(n_idx) {
			
			$('#'+n_idx+'').css('display','none');
			return false;
		
	} 
		
		function deleteCm(n_idx) {
			
			if(confirm('삭제하시겠습니까?')){
				$.ajax({
					url:'rest/comment/cDelete/'+n_idx,
					type:'delete',
					error : function(error) {
						alert(error);
					},
					success : function(data) {
						//alert(data);
						if(data=='success'){
							alert('댓글이 삭제되었습니다.');
							commentList();
							
						}
					}
				});
				
				return false;
				
			}
			
		}
		
		
		function commentList() {
			$.ajax({
					url:'rest/comment/cList/'+$('#idx').val(),
					type:'get',
					error : function(error) {
						alert(error);
					},
					success : function(data) {
						//alert(data.length);
						
						
						var html='';
						
						for(var i=0; i<data.length;i++){
							
						
							
						html +='<div class="comment">';	
						html += '<div><span>' + data[i].n_id + '</span>';
						html += '<span class="right">' + data[i].n_date + '</span></div>';
						html += '<div class="cmtBtnBox">' + data[i].n_comment;
						html += '<button class="right " onclick="reComment('+data[i].n_idx+')">Recm</button>';
						if(data[i].n_id=='${nbm_id}'){
						html +='<button class="right" onclick="deleteCm('+data[i].n_idx+')" >Del</button>'
						}
						html +='</div>';
						html +='</div>';
						//------------------------------------------
						html+='<div class="reCommetBox" id="'+data[i].n_idx+'">';
						html+='	<input type="text" value="'+data[i].n_grpno+'"   id="'+data[i].n_idx+'n_grpno" hidden>';
						html+='	<input type="text" value="'+data[i].n_grpord+'" id="'+data[i].n_idx+'n_grpord"  hidden>';
						html+='	<input type="text" value="'+data[i].n_depth+'" id="'+data[i].n_idx+'n_depth" hidden>';
						html+='	<input type="text" placeholder="답글을 입력해 주세요" class="form-control reCommentText" id="'+data[i].n_idx+'reCommentText">';
						html+='<button class="btn btn-default" id="closeBtn" onclick="reCmClose('+data[i].n_idx+')">cancle</button><button class="btn btn-default" onclick="insertReComment('+data[i].n_idx+')">OK</button>';
						html+='</div>';
						}
					$('#commentList').html(html);
				}
				
				
				
			});
		}

	
	</script>
</body>
</html>