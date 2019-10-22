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

<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#header {
	text-align: center;
}

.formTable {
	margin: 0 auto;
}

#formDiv {
	margin-top: 50px;
}



.textWidth {
	width: 200px;
}

.textWidthLarge {
	width: 325px;
}

td {
	padding: 5px;
}

.display-none { /*감추기*/
	display: none;
}

.center {
	text-align: center;
}

.chkBoxDisplay{
	display: none;
}
</style>
</head>
<body>


	<%@include file="/WEB-INF/views/frame/header.jsp"%>


	<%@include file="/WEB-INF/views/frame/nav.jsp"%>

	<div id="contents">

		<div id="formDiv">

			<form id="createForm" class="form-inline" role="form">
				<table class="formTable">
					<tr>

						<td colspan="2" class="center"><h1>CREATE ADMIN</h1></td>
					</tr>
					<tr>
						<td>아이디</td>
						<td><input class="form-control textWidthLarge" type="text"
							id="admin_id" name="admin_id" required></td>
					</tr>
					<tr>
						<td>
							<div>
								<input  type="button"  class="btn btn-default btn-xs" onclick="idChk()"value="IDCHECK">
							</div>
						</td>
						<td>
							<input type="checkbox" id="idOverlap" class="chkBoxDisplay">
						</td>
					</tr>
					<tr>
						<td><input type="checkbox" id="idCheck" class="chkBoxDisplay"></td>
						<td><span id="checkIdSpan"></span></td>
					</tr>


					<tr>
						<td>비밀번호</td>
						<td><input class="form-control textWidthLarge"
							type="password" id="admin_pw" name="admin_pw" required></td>
					</tr>
					<tr>
						<td>비밀번호 확인</td>
						<td>
						<input class="form-control textWidthLarge"type="password" id="admin_pw2" name="admin_pw2" required>
						<br>
						<span id="pwSpan"></span> <span id="pwSpan2"></span> 
						<input	type="checkbox" id="pwCheck" class="chkBoxDisplay"> 
						<input type="checkbox"	id="pwCheck2" class="chkBoxDisplay">
						</td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input class="form-control textWidthLarge" type="text"
							id="admin_name" name="admin_name" required>
					</tr>
					<tr>
						<td><input type="checkbox" id="nameCheck" class="chkBoxDisplay"></td>
						<td><span id="nameSpan"></span></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input class="form-control textWidthLarge" type="email" 
							id="admin_email" name="admin_email" required placeholder="계정 분실시 사용할 이메일">
					</tr>
					<tr>
						<td><input type="checkbox" id="emailCheck" class="chkBoxDisplay"></td>
						<td><span id="emailSpan"></span></td>
					</tr>

					<tr>
						<td colspan="2"><div class="center">
								<input type="submit" class="btn btn-default" value="CREATE">
							</div></td>
					</tr>
				</table>
			</form>
		</div>


	</div>



	<%@include file="/WEB-INF/views/frame/footer.jsp"%>
	<script>
		$(document).ready(function() {
			adminList();

		})

		// 아이디 확인
		$('#admin_id').focusout(
				function() {
					
					var checkId = RegExp(/^(?=.*[a-zA-Z]).{5,12}$/);;
					
					// 아이디 유효성검사
					if (!checkId.test($('#admin_id').val())&& $('#admin_id').val().length > 1) {
						$('#checkIdSpan').html('[아이디] 5자리 이상 12자리 이하 영문만');
						$('#checkIdSpan').css('color', 'red');
						$('#idCheck').prop('checked', false);

					}
					if (checkId.test($('#admin_id').val())
							&& $('#admin_id').val().length > 1) {
						$('#checkIdSpan').html('');
						$('#idCheck').prop('checked', true);
					}
				
				});

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

		// 이름
		$('#admin_name').focusout(
				function() {
					var checkName = RegExp(/^[가-힣a-zA-Z]+$/); //영어 한글만 가능

					// 이름 유효성검사
					if (!checkName.test($('#admin_name').val())
							&& $('#admin_name').val().length > 1) {
						$('#nameSpan').html('[이름] 영문 및 한글만');
						$('#nameSpan').css('color', 'red');
						$('#nameCheck').prop('checked', false);

					}
					if (checkName.test($('#admin_name').val())
							&& $('#admin_name').val().length > 1) {
						$('#nameSpan').html('');
						$('#nameCheck').prop('checked', true);
					}
				});
		
		// 이메일
		  	
		$('#admin_email').focusout(
				function() {
					var exptext = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i; //이메일 형식만 가능

					// 이름 유효성검사
					if (!exptext.test($('#admin_email').val())&& $('#admin_email').val().length > 1) {
						$('#emailSpan').html('[이메일] 이메일형식만');
						$('#emailSpan').css('color', 'red');
						$('#emailCheck').prop('checked', false);

					}
					if (exptext.test($('#admin_email').val())
							&& $('#admin_email').val().length > 1) {
						$('#emailSpan').html('');
						$('#emailCheck').prop('checked', true);
					}
				});
		
		
		
		
		

		//회원가입 
		$('#createForm').submit(
						function() {

							if (!$('#idCheck').prop('checked')) {
								alert('아이디를 확인해주세요.');
								return false;
							}if (!$('#idOverlap').prop('checked')) {
								alert('중복체크를 해주세요.');
								return false;
							}
							if (!$('#pwCheck').prop('checked')) {
								alert('비밀번호가 일치하지 않습니다.');
								return false;
							}
							if (!$('#pwCheck2').prop('checked')) {
								alert('비밀번호가  양식과 다른 형식입니다.');
								return false;
							}
							if (!$('#nameCheck').prop('checked')) {
								alert('이름이 양식과 다른 형식입니다.');
								return false;
							}if (!$('#emailCheck').prop('checked')) {
								alert('이메일 형식이 아닙니다.');
								return false;
							}

							$.ajax({
										url : '${pageContext.request.contextPath}/firstAdmin/createAdmin',
										type : 'POST',
										data : $('#createForm').serialize(),
										error : function(error) {
											alert(error);
										},
										success : function(data) {
											//alert(data);
											if (data == 'success') {

												alert('관리자 계정이 생성되었습니다.');
												
												location.href = '/nb/login/admin';
											}
											if (data == 'fail') {

												alert('생성에 문제가 있습니다.');

											}
										}

									});
							//$('#regForm').reset();
							return false;
						});

		//최초 관리자 생성인지체크->최초 관리자일경우 아이디에 admin을 넣어주고 수정불가
		function adminList() {

			$.ajax({
				url : '${pageContext.request.contextPath}/firstAdmin/adminChk',
				type : 'GET',
				error : function(error) {
					alert(error);
				},
				success : function(data) {

					//alert(data.length);
					if (data.length < 1) {
						alert("최초 관리자 아이디는 'admin'으로 생성됩니다.후에 변경하시기 바랍니다.");
						var html = '';
						$('#admin_id').val('admin');
						$('#admin_id').attr("readonly", true);
						$('#idCheck').prop('checked', true);

					}
				}
			});

		}
		
	//중복체크	
	function idChk() {

		if($('#admin_id').val().length<1){
			alert('아이디를 입력해주세요');	
			return;
		}
		
			$.ajax({
				url : '${pageContext.request.contextPath}/adminPage/adminInfo?admin_id='+$('#admin_id').val(),
				type : 'GET',
				error : function(error) {
					alert(error);
				},
				success : function(data) {
					//alert(data.admin_id);
					if(data.admin_id!=null){
						$('#checkIdSpan').html('[아이디] 이미 존재합니다');
						$('#checkIdSpan').css('color', 'red');
						$('#idOverlap').prop('checked', false);
						
					}
					else{
						$('#checkIdSpan').html('');
						$('#idOverlap').prop('checked', true);
						alert('사용가능한 아이디 입니다.');
						
					}
					
				}
			});
			return false;
		}		
	</script>
</body>
</html>










