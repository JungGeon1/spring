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


#boardInfo span {
	padding: 40px;
	font-size: 1.3em;
}

#adminList {
	width: 750px;
	margin: 0 auto;
	padding-left: 15px;
	height: 200px;
	overflow: scroll;
	text-align: left;
}

#memberList {
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

.adminItem {
	width: 730px;
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
		<h1>ADMIN PAGE</h1>
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
		
		</div>
		<div id="rightBox">
			<div id="boardBox">

				<div id="boardList">
					<h3>ADMIN LIST</h3>
					<div id="adminList"></div>
					<h3>MEMBER LIST</h3>
					<div id="memberList"></div>
				</div>
			</div>
		</div>
	</div>
	 
</div>	
	<%@include file="/WEB-INF/views/frame/footer.jsp"%>
	<script>
		$(document).ready(function name() {
			//기본정보
			//getViewData();
		
			//관리자
			adminList();
			//회원
			memberList();
			
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
	
	
	//관리자 리스트
	function adminList() {

		$.ajax({
					url : '${pageContext.request.contextPath}/adminPage/adminList',
					type : 'GET',
					error : function(error) {
						alert(error);
					},
					success : function(data) {
						var html = '';

						for (var i = 0; i < data.length; i++) {

							html += '<div class="adminItem">\n<span class="gbItemWidth">';
							html += 'No : ' + data[i].admin_idx + ' ';
							html += 'Id : ' + data[i].admin_id + ' ';
							html += 'Name : ' + data[i].admin_name + ' ';
							
							if(data[i].admin_rank==0){
							html += 'Rank : Assistant  </span>';
							}else{
							html += 'Rank : Administrator  </span>';
							}
							html += '<button class="btnRight btn btn-default btn-xs" onclick="deleteMember('
									+ data[i].idx + ') ">DELETE</button>';

							html += '</div>\n';
						}

						$('#adminList').html(html);
					}

				});

	}
	//회원 리스트
	function memberList() {

		$.ajax({
					url : '${pageContext.request.contextPath}/adminPage/memberList',
					type : 'GET',
					error : function(error) {
						alert(error);
					},
					success : function(data) {
						var html = '';

						for (var i = 0; i < data.length; i++) {

							html += '<div class="adminItem">\n<span class="gbItemWidth">';
							html += 'No : ' + data[i].nbm_idx + ' ';
							html += 'Id : ' + data[i].nbm_id + ' ';
							html += 'Name : ' + data[i].nbm_name + ' ';
							html += 'Verify : '+data[i].nbm_verify+' </span>'
							
						
							html += '<button class="btnRight btn btn-default btn-xs" onclick="deleteMember('
									+ data[i].nbm_idx + ') ">DELETE</button>';

							html += '</div>\n';
						}

						$('#memberList').html(html);
					}

				});

	}

	

	

//회원강퇴
		function deleteMember(nbm_idx) {

			if (confirm('' + nbm_idx + '번 회원을 영멸시킬까요?')) {
				$.ajax({
					url : '${pageContext.request.contextPath}/adminPage/memberDelete/'+nbm_idx,
					type : 'post',
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