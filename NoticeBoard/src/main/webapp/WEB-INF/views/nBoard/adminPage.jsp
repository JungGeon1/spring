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
	clear: both;
}

.adminBtnRight {
	position: relative;
	left: 200px;
}
.btnRight {
	position: relative;
	left: 280px;
}

.pwWidth {
	width: 330px;
	display: inline;
}.btnWidth{
	width:130px;
}.adminPwWidth {
	width: 580px;
	display: inline;
}


#idChangeBox{
	display: none;

}#pwChangeBox{

	display: none;
	
}
#pwCheck{
	display: none;
}
#pwCheck2{
	display: none;
}
#idCheck{
	display: none;
}
.gbItemWidth{
	width: 360px;
	float: left;
	

}.top{

	margin-top: 15px;
}#empowerPwBox{
	
	display: none;
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
				<div class="btn-group top">
					<button class="btn btn-default btn-group-sm btnWidth" onclick="idChangeBox()">아이디변경</button>
					<button class="btn btn-default btn-group-sm btnWidth" onclick="pwChangeBox()">비밀번호변경</button>
					<button class="btn btn-default btn-group-sm btnWidth" onclick="createAdmin()">관리자추가</button>
				</div>
				<div id="idChangeBox">
				<br>
					<input id="idOrg" type="text" class="form-control pwWidth" placeholder="기존 아이디 입력해 주세요">
					<input id="admin_id" type="text" class="form-control pwWidth top" placeholder=" 새 아이디를 입력해 주세요">
				<br>
					<span id="idSpan"></span>
					<input type="checkbox" id="idCheck">
					
				<br>
					<button class="btn btn-default btn-group-xs" onclick="idChange()">Change</button>
				</div>
				<div id="pwChangeBox">
					<br>
					<input id="pwOrg" type="password" class="form-control pwWidth" placeholder="기존 비밀번호를 입력해 주세요">
					<input id="admin_pw" type="password" class="form-control pwWidth top" placeholder=" 새 비밀번호를 입력해 주세요">
					<input id="admin_pw2" type="password" class="form-control pwWidth top" placeholder=" 비밀번호를 다시 입력해 주세요"><br>
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
					<div id="empowerPwBox">
						<input id="newAdminIdx" type="text" hidden="">
						<input id="empowerPw" type="password" class="form-control adminPwWidth" placeholder="비밀번호를 입력해 주세요">
						<button class="btn btn-default btn-group-xs" onclick="empowerAdmin()">OK</button>
						<button class="btn btn-default btn-group-xs" onclick="empowerPwClose()">CANCLE</button>
					</div>
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
			getViewData();
			//관리자
			adminList();
			//회원
			memberList();
			
		});
	// 세션에 올라가있는 아이디를 키워드로 회원 정보를 뿌려준다
		function getViewData() {
			var rank='';
			$.ajax({
				url : 'adminPage/adminInfo?admin_id=${admin_id}',
				type : 'GET',
				error : function(error) {
					alert(error);
				},
				success : function(data) {
					rank=data.admin_rank;
					var html = '';

					html += '<div class="infoItem">관리자번호 : ' + data.admin_idx
							+ '</div>';
					html += '<div class="infoItem">관리자이름 :' + data.admin_name
							+ '</div>';
					html += '<div class="infoItem">아이디 : ' + data.admin_id
							+ '</div>';
					html += '<div class="infoItem">가입날짜 :' + data.admin_date
							+ '</div>';
					if(data.admin_rank==1){		
					html += '<div class="infoItem">관리등급 :  Administrator </div>';
					}else{
					html += '<div class="infoItem">관리등급 :  Assistant </div>';
						
					}
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
				$('#idChangeBox').css('display','none');
				$('#pwChangeBox').css('display','block');
		
			}
		}
	//아이디 변경 폼 출력
	function idChangeBox() {
			
			if($('#idChangeBox').is(":visible")){
			     // display : none가 아닐 경우
				$('#idChangeBox').css('display','none');
				return;
			}else{
				$('#pwChangeBox').css('display','none');
				$('#idChangeBox').css('display','block');
		
			}
		}
	
	
	// 아이디 확인
	$('#admin_id').focusout(
			function() {
				var checkId = /^[a-zA-Z]*$/;

				// 아이디 유효성검사
				if (!checkId.test($('#admin_id').val())&& $('#admin_id').val().length > 1) {
					$('#idSpan').html('[아이디] 영문만');
					$('#idSpan').css('color', 'red');
					$('#idCheck').prop('checked', false);

				}
				if (checkId.test($('#admin_id').val())
						&& $('#admin_id').val().length > 1) {
					$('#idSpan').html('');
					$('#idCheck').prop('checked', true);
				}
			});
	
	//아이디변경
	function idChange() {
		if (!$('#idCheck').prop('checked')) {
			alert('아이디가 양식과 다릅니다.');
			return false;
		}

		if (confirm('아이디를 변경하시겠습니까?')) {
			$.ajax({
						url : 'adminPage/idChange',
						type : 'post',
						data : {
							admin_id : '${admin_id}',
							oldId: $('#idOrg').val(),
							newId: $('#admin_id').val()
						},
						error : function(error) {
							alert(error);
						},
						success : function(data) {
							if (data == 'success') {
								alert('아이디가 변경되었습니다.');
								location.href = '${pageContext.request.contextPath}/logout';
							} else {
								alert('기존 아이디가 일치하지 않습니다.');

							}
						}

					});

		}
		
		
	}
	
	
	
	

	// 비밀번호 재입력 시 일치하는지 확인
	$('#admin_pw2, #admin_pw').focusout(
			function() {
				var checkPw = RegExp(/^(?=.*[0-9])((?=.*\W)).{5,7}$/); // 비밀번호: 숫자 5글자~7글자 미만, 숫자만

				if ($('#admin_pw').val() == $('#admin_pw2').val()
						&& $('#admin_pw').val().length > 1) {
					$('#pwSpan').html('');
					$('#pwCheck').prop('checked', true);
				}
				if ($('#admin_pw').val() != $('#admin_pw2').val()
						&& $('#admin_pw').val().length > 1) {
					$('#pwSpan').html('비밀번호 불일치');
					$('#pwSpan').css('color', 'red');
					$('#pwSpan').focus();
					$('#pwCheck').prop('checked', false);
				}

				// 비밀번호 유효성 검사
				if (!checkPw.test($('#admin_pw').val())
						&& $('#admin_pw').val().length > 1) {
					$('#pwSpan2').html(
							'[비밀번호] 숫자 5~7자리 미만 ,최소 1개의  특수문자 포함');
					$('#pwSpan2').css('color', 'red');
					$('#pwCheck2').prop('checked', false);

				}
				if (checkPw.test($('#admin_pw').val())
						&& $('#admin_pw').val().length > 1) {
					$('#pwSpan2').html('');
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
						url : 'adminPage/pwChange',
						type : 'post',
						data : {
							admin_id : '${admin_id}',
							oldPw: $('#pwOrg').val(),
							newPw: $('#admin_pw').val()
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
						//alert(data.length);		
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
							/* 등급이1인 관리자만 관리자 삭제가능 */
							if(adminRankchk()==1&&data[i].admin_id!='${admin_id}'){
							html += '<button class="adminBtnRight btn btn-default btn-xs" onclick="deleteAdmin('
									+ data[i].admin_idx + ') ">DELETE</button>';
							html += '<button title="통합관리자의 권한을 위임합니다." class="adminBtnRight btn btn-default btn-xs" onclick="empowerForm('
								+ data[i].admin_idx + ') ">EMPOWER</button>';
							}
							html += '</div>\n';
						}

						$('#adminList').html(html);
					}

				});

		}

		function adminRankchk() {
			var rank = '';
			$.ajax({
				url : 'adminPage/adminInfo?admin_id=${admin_id}',
				type : 'GET',
				async : false,
				error : function(error) {
					alert(error);
				},
				success : function(data) {
					rank = data.admin_rank;

				}
			});
			return rank;
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
								html += 'Verify : ' + data[i].nbm_verify
										+ ' </span>'

								html += '<button class="btnRight btn btn-default btn-xs" onclick="deleteMember('
										+ data[i].nbm_idx
										+ ') ">DELETE</button>';

								html += '</div>\n';
							}

							$('#memberList').html(html);
						}

					});

		}
		//회원삭제
		function deleteMember(nbm_idx) {

			if (confirm('' + nbm_idx + '번 회원을 영멸시킬까요?')) {
				$.ajax({
							url : '${pageContext.request.contextPath}/adminPage/memberDelete/'
									+ nbm_idx,
							type : 'post',
							error : function(error) {
								alert(error);
							},
							success : function(data) {
								alert('삭제되었습니다.');
								location.href = '/nb/adminPage';
							}

						});

			}
		}
		//관리자 삭제
		function deleteAdmin(admin_idx) {

			if (confirm('' + admin_idx + '번 관리자를 영멸시킬까요?')) {
				$.ajax({
							url : '${pageContext.request.contextPath}/adminPage/adminDelete/'
									+ admin_idx,
							type : 'post',
							error : function(error) {
								alert(error);
							},
							success : function(data) {
								alert('삭제되었습니다.');
								location.href = '/nb/adminPage';
							}

						});

			}
		}
		//회원생성페이지로이동
		function createAdmin() {
			location.href = '${pageContext.request.contextPath}/firstAdmin/createAdmin';
		}
		
		
		
		//권한인계 비밀번호 입력창 
		function empowerForm(newAdminIdx) {
			if(confirm('권한 인계입니다.\n인계를 진행하시려면 비밀번호를 입력해 주세요.')){
				$('#empowerPwBox').css('display','block');
				$('#newAdminIdx').val(newAdminIdx);
			
			}
			
		}
		//궈한인계 비밀번호 입력창 닫기
		function empowerPwClose() {
			$('#empowerPwBox').css('display','none');
			$('#newAdminIdx').val('');
		}
		
		//권한인계
		function empowerAdmin() {
			if(confirm('권한을 인계하시겠습니까?\n(확인시 인계가 진행됩니다.)')){
			$.ajax({
				
				url:'${pageContext.request.contextPath}/adminPage/adminEmpower',
				type:'post',
				data:{
					oldAdminId : '${admin_id}',
					oldAdminPw : $('#empowerPw').val(),
					newAdminIdx : $('#newAdminIdx').val(),
					
				},
				error : function (data) {
					alert(data);
				},
				success : function (data) {
					if(data=='success'){
						alert(newAdminIdx+'번 관리자가 통합 관리자가로 변경되었습니다.');
						location.href = '${pageContext.request.contextPath}/logout';
					}
				}
				
			});
		}	
	}
	</script>
</body>
</html>