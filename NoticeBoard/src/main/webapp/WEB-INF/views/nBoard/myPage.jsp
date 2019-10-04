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
<title>Insert title here</title>
<style>
#header {
	text-align: center;
}

#contents {
	text-align: center;
	padding-top: 40px;
	height: 700px;
	margin-bottom: 20px;
}

.content{
	width: 1600px;
	height: 100%;
	margin: 0 auto; 
}
 #leftBox{
 	width: 790px;
	float: left; 
 }
 #rightBox{
 	width: 790px;
 	float: right;
 } 
#infoBox {
	margin: 0 auto;
	width: 400px;
	text-align: left;
}

.infoItem {
	margin-bottom: 5px;
	font-size: 1.2em;
}

#boardInfo span {
	padding: 40px;
	font-size: 1.3em;
}

#pageList {
	width: 750px;
	margin: 0 auto;
	padding-left: 15px;
	height: 200px;
	overflow: scroll;
	text-align: left;
}

#scrollList {
	width: 750px;
	margin: 0 auto;
	padding-left: 15px;
	height: 200px;
	overflow: scroll;
	text-align: left;
}

.delteBoxWidth {
	width: 150px;
}

#boardInfo {
	padding: 50px;
}

.scrollItem {
	width: 730px;
	margin-bottom: 5px;
}

.pageItem {
	margin-bottom: 5px;
}

.btnRight {
	position: relative;
	left: 280px;
}

.pwWidth {
	width: 330px;
	display: inline;
}.btnWidth{

	width:200px;

}


#pwBox{
	display: none;

}#pwChangeBox{

	display: none;
	
}
#pwCheck{
	display: none;
}
#pwCheck2{
	display: none;
}.gbItemWidth{
	width: 360px;
	float: left;
	overflow: hidden;

}
</style>
</head>
<body>


	<%@include file="/WEB-INF/views/frame/header.jsp"%>


	<%@include file="/WEB-INF/views/frame/nav.jsp"%>

	<div id="contents">
		<div class="content">
		<h1>MY PAGE</h1>
		<div id="leftBox">
			<h2>MY INFO</h2>
			<div id="infoBox">
				<div id="info"></div>
				<div class="btn-group">
					<button class="btn btn-default btn-group-sm btnWidth" onclick="pwChangeBox()">비밀번호변경</button>
					<button class="btn btn-default btn-group-sm btnWidth" onclick="signOut()">회원탈퇴</button>
				</div>
				<div id="pwBox">
					<br>	
					<input id="id" type="text" value="${nbm_id}" hidden="">
					<input id="pw" type="password" class="form-control pwWidth" placeholder="비밀번호를 입력해 주세요">
					
					<button class="btn btn-default btn-group-sm" onclick="deleteMember()">BYE</button>
				</div>
				<div id="pwChangeBox">
					<br>
					<input id="pwOrg" type="password" class="form-control pwWidth" placeholder="기존 비밀번호를 입력해 주세요">
					<input id="pwChagne1" type="password" class="form-control pwWidth" placeholder=" 새 비밀번호를 입력해 주세요">
					<input id="pwChagne2" type="password" class="form-control pwWidth" placeholder=" 비밀번호를 다시 입력해 주세요"><br>
					<span id="pwSpan"></span>
					<span id="pwSpan2"></span> 
					<input type="checkbox" id="pwCheck">
					<input type="checkbox" id="pwCheck2">
					<br>
					<button class="btn btn-default btn-group-xs" onclick="pwChange()">Change</button>
				</div>
			</div>
			<h2>MY BOARD</h2>
			<div id="boardInfo"></div>
		</div>
		<div id="rightBox">
			<div id="boardBox">

				<div id="boardList">
					<h3>PHOTO BOARD</h3>
					<div id="pageList"></div>
					<h3>GUEST BOARD</h3>
					<div id="scrollList"></div>
				</div>
			</div>
		</div>
	</div>
</div>	
	<%@include file="/WEB-INF/views/frame/footer.jsp"%>
	<script>
		$(document).ready(function name() {
			//기본정보
			getViewData();
			//작성한 게시판 정보	
			showBoardInfo();
			//포토게시판에대한 정보
			showPageList();
			//스크롤게시판에대한 정보
			showScrollList();
		});
	// 세션에 올라가있는 아이디를 키워드로 회원 정보를 뿌려준다
		function getViewData() {

			$.ajax({
				url : 'myPage/view?nbm_id=${nbm_id}',
				type : 'GET',
				error : function(error) {
					alert(error);
				},
				success : function(data) {
					var html = '';

					html += '<div class="infoItem">회원번호 : ' + data.nbm_idx
							+ '</div>';
					html += '<div class="infoItem">회원이름 :' + data.nbm_name
							+ '</div>';
					html += '<div class="infoItem">아이디 : ' + data.nbm_id
							+ '</div>';
					html += '<div class="infoItem">주소 :' + data.nbm_address
							+ '</div>';
					html += '<div class="infoItem">가입날짜 :' + data.nbm_date
							+ '</div>';
					html += '<div class="infoItem">메일인증 : ' + data.nbm_verify
							+ '</div>';
					$('#info').html(html);

				}

			});

			return false;

		}
	//회원탈퇴 폼 출력
		function signOut() {
			
			if($('#pwBox').is(":visible")){
			     // display : none가 아닐 경우
				$('#pwBox').css('display','none');
				return;
			}
			else{
				
				$('#pwChangeBox').css('display','none');
				if(confirm('탈퇴하시겠습니까?')){
					
					$('#pwBox').css('display','block');
				}
			}
		
			
		}
	//회워탈퇴
		function deleteMember() {

			if (confirm('확인을 누를 시 탈퇴처리가 진행됩니다.')) {
				$.ajax({
							url : 'myPage/delete',
							type : 'post',
							data : {
								nbm_id : $('#id').val(),
								nbm_pw : $('#pw').val()
							},
							error : function(error) {
								alert(error);
							},
							success : function(data) {
								if (data == 'success') {
									alert('탈퇴되었습니다.');
									location.href = '${pageContext.request.contextPath}/login';
								} else {
									alert('비밀번호가 일치하지 않습니다.');

								}
							}

						});

			}
		}
	//비밀번호 변경 폼 출력
	function pwChangeBox() {
			
			if($('#pwChangeBox').is(":visible")){
			     // display : none가 아닐 경우
				$('#pwChangeBox').css('display','none');
				return;
			}else{
				$('#pwBox').css('display','none');
				$('#pwChangeBox').css('display','block');
		
			}
		}
		

	// 비밀번호 재입력 시 일치하는지 확인
	$('#pwChagne1, #pwChagne2').focusout(function() {
		var checkPw = RegExp(/^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{4,10}$/); // 비밀번호: 영문 4글자~10글자 미만, 최소 1개의 숫자 또는 특수문자 포함

		if ($('#pwChagne1').val() == $('#pwChagne2').val()&&$('#pwChagne1').val().length>1) {
			$('#pwSpan').html('비밀번호 일치');
			$('#pwSpan').css('color', 'green');
			$('#pwCheck').prop('checked', true);
		} if ($('#pwChagne1').val() != $('#pwChagne2').val()&&$('#pwChagne1').val().length>1){
			$('#pwSpan').html('비밀번호 불일치');
			$('#pwSpan').css('color', 'red');
			$('#pwSpan').focus();
			$('#pwCheck').prop('checked', false);
		}
		
		// 비밀번호 유효성 검사
		if (!checkPw.test($('#pwChagne1').val())&&$('#pwChagne1').val().length>1) {
			$('#pwSpan2').html('[비밀번호] 영문 4글자~10글자 미만, 최소 1개의 숫자 또는 특수문자 포함');
			$('#pwSpan2').css('color', 'red');
			$('#pwCheck2').prop('checked', false);
			
		}if(checkPw.test($('#pwChagne1').val())&&$('#pwChagne1').val().length>1) {
			$('#pwSpan2').html('[비밀번호] 안전한 비밀번호입니다.');
			$('#pwSpan2').css('color', 'green');
			$('#pwCheck2').prop('checked', true);
		}
	});

	//비밀번호변경
	function pwChange() {
		if (!$('#pwCheck').prop('checked')) {
			alert('비밀번호가 일치하지 않습니다.');
			return false;
		}if (!$('#pwCheck2').prop('checked')) {
			alert('비밀번호가  양식과 다른 형식입니다.');
			return false;
		}

		if (confirm('비밀번호를 변경하시겠습니까?')) {
			$.ajax({
						url : 'myPage/pwChange',
						type : 'post',
						data : {
							nbm_id : '${nbm_id}',
							oldPw: $('#pwOrg').val(),
							newPw: $('#pwChagne1').val()
						},
						error : function(error) {
							alert(error);
						},
						success : function(data) {
							if (data == 'success') {
								alert('비밀번호가 변경되었습니다.');
								location.href = '${pageContext.request.contextPath}/logout';
							} else {
								alert('기존 비밀번호가 일치하지 않습니다.');

							}
						}

					});

		}
		
		
	}
	
	
//게시글정보 출력
		function showBoardInfo() {
			$.ajax({
				url : 'myPage/showBoardInfo?nbm_id=${nbm_id}',
				type : 'GET',
				error : function(error) {
					alert(error);
				},
				success : function(data) {
					var html = '';

					html += '<span>TotalBoardCount : ' + data.totalBoardCnt
							+ ' </span>';
					html += '<span>PhotoBoardCount : ' + data.pageBoardCnt
							+ ' </span><br>';
					html += '<span>GusetBoardCount : ' + data.scrollBoardCnt
							+ ' </span>';
					html += '<span>TotalCommentCount: ' + data.selectTotalCmCnt
							+ ' </span>';

					$('#boardInfo').html(html);
				}

			});

		}

	//포토게시판에대한 정보출력
		function showPageList() {

			$.ajax({
				url : 'myPage/mypageList?category=page&nbm_id=${nbm_id}',
				type : 'GET',
				error : function(error) {
					alert(error);
				},
				success : function(data) {
					var html = '';

					for (var i = 0; i < data.length; i++) {

						html += '<div class="pageItem">\n';
						html += 'No : ' + data[i].idx + ' ';
						html += 'Title: <a href="/nb/view?idx=' + data[i].idx
								+ '" >' + data[i].u_title + '</a> ';
						html += 'CommentCount : ' + cCount(data[i].idx) + ' ';
						if (data[i].u_image == 'NO_IMAGE.png') {
							html += 'Image : X ';
						} else {
							html += 'Image : O ';
						}
						html += 'Date : ' + data[i].u_date + '';
						html += '</div>\n';
					}

					$('#pageList').html(html);
				}

			});

		}

		//방명록에대한 정보 출력	
		function showScrollList() {

			$.ajax({
						url : 'myPage/mypageList?category=scroll&nbm_id=${nbm_id}',
						type : 'GET',
						error : function(error) {
							alert(error);
						},
						success : function(data) {
							var html = '';

							for (var i = 0; i < data.length; i++) {

								html += '<div class="scrollItem">\n<span class="gbItemWidth">';
								html += 'No : ' + data[i].idx + ' ';
								html += 'Title : ' + data[i].u_title + ' ';
								html += 'Date : ' + data[i].u_date + '</span>';
								html += '<button class="btnRight btn btn-default btn-xs" onclick="deleteBoard('
										+ data[i].idx + ') ">DELETE</button>';

								html += '</div>\n';
							}

							$('#scrollList').html(html);
						}

					});

		}
//댓글 갯수들정보를 출력 반환을 위해 동기식으로 설정 
		function cCount(idx) {
			var cCnt = 0;
			$.ajax({
				url : 'rest/comment/cCount/' + idx,
				type : 'GET',
				async : false,
				error : function(error) {
					alert(error);
				},
				success : function(data) {
					cCnt = data;

				}

			});
			return cCnt;
		}
//방멸록 삭제
		function deleteBoard(idx) {

			if (confirm('' + idx + '번 글을 삭제하시겠습니까?')) {
				$.ajax({
					url : 'rest/delete/' + idx + '?category=scroll',
					type : 'delete',
					error : function(error) {
						alert(error);
					},
					success : function(data) {
						alert('삭제되었습니다.');
						location.href = '/nb/myPage';
					}

				});

			}
		}
	</script>
</body>
</html>