<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>

<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.js" ></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<link href="css/bootstrap.css" rel="stylesheet" />
<link href="css/coming-sssoon.css" rel="stylesheet" />
<link href="<c:url value="/css/nbCss.css"/>" rel="stylesheet" />
<!--     Fonts     -->
<link href="https://fonts.googleapis.com/css?family=Lobster&display=swap" rel="stylesheet">
<link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.css" rel="stylesheet">
 <link href="https://fonts.googleapis.com/css?family=Grand+Hotel&display=swap" rel="stylesheet">
 <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'name='viewport' />
<meta name="viewport" content="width=device-width" />
<meta charset="UTF-8">

<!-- include summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
<script src="lang/summernote-ko-KR.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<title>Insert title here</title>
<style>
#header {
	text-align: center;
}
.formTable{
	margin: 0 auto;
}
#formDiv {
	margin-top: 50px;
	
}#pwCheck{
display: none;
}#idCheck{
display: none;
}
.textWidth{

width: 200px;
}.textWidthLarge{

width: 325px;
}
td{
	padding: 5px;
}
</style>
</head>
<body>


<%@include file="/WEB-INF/views/frame/header.jsp" %>


<%@include file="/WEB-INF/views/frame/nav.jsp" %>	

<div id="contents">

<div id="formDiv">	
								
							<form id="regForm" class="form-inline" role="form">
								<table class="formTable">
									<tr>
									
									<td><h1>REGIST</h1></td>
									</tr>
									<tr>
										<td>아이디(이메일)</td>
										<td><input class="form-control textWidthLarge" type="email" id="nbm_id" name="nbm_id" required></td>
									</tr>	
									<tr>
										<td>
										<input  type="button" onclick="checkId()"value="중복체크">
										<input type="checkbox" id="idCheck">
										
										</td>
										<td><span id="checkIdSpan"></span></td>
									</tr>
									
									<tr>
										<td>비밀번호</td>
										<td><input class="form-control textWidthLarge" type="password" id="nbm_pw" name="nbm_pw" required></td>
									</tr>
									<tr>
										<td>비밀번호 확인</td>
										<td><input class="form-control textWidthLarge" type="password" id="nbm_pw2" name="nbm_pw2" required><br>
											<span id="pwSpan"></span> <span id="pwSpan2"></span> <input
											type="checkbox" id="pwCheck"></td>
									</tr>
									<tr>
										<td>이름</td>
										<td><input class="form-control textWidthLarge" type="text" id="nbm_name" name="nbm_name" required>
											<span id="nameSpan"></span></td>
									</tr>
									<tr>
										<td>주소</td>
										<td>
										
											<input type="text" class="form-control textWidth" id="postcode"  name="postcode" placeholder="우편번호" required>
											<input type="button" onclick="execDaumPostcode()" value="우편번호 찾기" class="btn btn-default">
											<br>
											<input type="text" class="form-control textWidthLarge" id="address" name="address"  placeholder="주소" required><br>
											<input type="text" class="form-control textWidthLarge" id="detailAddress" name="detailAddress" placeholder="상세주소" required>
										<!-- <input class="form-control" type="text" id="address" name="address" required> -->
										</td>
									</tr>
									
									<tr>
										<td colspan="3"><input type="submit" style="float: right" class="btn btn-default" value="JOIN"></td>
									</tr>
								</table>
							</form>
					</div>
								
</div>
<%@include file="/WEB-INF/views/frame/footer.jsp" %>
<script>
$(document).ready(function(){
	
	
})
    


		


			
		
			// 비밀번호 재입력 시 일치하는지 확인
			$('#nbm_pw2, #nbm_pw').focusout(function() {
				var checkPw = RegExp(/^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{4,10}$/); // 비밀번호: 영문 4글자~10글자 미만, 최소 1개의 숫자 또는 특수문자 포함

				if ($('#nbm_pw').val() == $('#nbm_pw2').val()&&$('#nbm_pw').val().length>1) {
					$('#pwSpan').html('비밀번호 일치');
					$('#pwSpan').css('color', 'green');
					$('#pwCheck').prop('checked', true);
				} if ($('#nbm_pw').val() != $('#nbm_pw2').val()&&$('#nbm_pw').val().length>1){
					$('#pwSpan').html('비밀번호 불일치');
					$('#pwSpan').css('color', 'red');
					$('#pwSpan').focus();
					$('#pwCheck').prop('checked', false);
				}
				
				
				// 비밀번호 유효성 검사
				if (!checkPw.test($('#nbm_pw').val())&&$('#nbm_pw').val().length>1) {
					$('#pwSpan2').html('[비밀번호] 영문 4글자~10글자 미만, 최소 1개의 숫자 또는 특수문자 포함');
					$('#pwSpan2').css('color', 'red');
					$('#pwCheck').prop('checked', false);
					
				}if(checkPw.test($('#nbm_pw').val())&&$('#nbm_pw').val().length>1) {
					$('#pwSpan2').html('[비밀번호] 안전한 비밀번호입니다.');
					$('#pwSpan2').css('color', 'green');
					$('#pwCheck').prop('checked', true);
				}
			});

			$('#regForm').submit(function() {

				if (!$('#idCheck').prop('checked')) {
					alert('아이디 중복 체크를 해주세요!');
					return false;
				}
				if (!$('#pwCheck').prop('checked')) {
					alert('비밀번호가 일치하지 않거나 양식과 다른 형식입니다.');
					return false;
				}

				var checkName = RegExp(/^[가-힣a-zA-Z]+$/); // 이름: 한글,영문만 가능
				// 이름 유효성 검사
				if (!checkName.test($('#nbm_name').val())) {
					$('#nameSpan').html('[이름] 한글,영문만 가능');
					$('#nameSpan').css('color', 'red');
					$('#nbm_name').focus();
					return false;
				}

				
				$.ajax({
					url : 'rest/member/regist',
					type : 'POST',
					data : $('#regForm').serialize(),
					error : function(error) {
						alert(error);
					},success : function(data) {
						//alert(data);
						if(data=='success'){
							
						alert('이메일로 인증키를 발송하였습니다. 인증 후 사용해주세요!');
						
						location.href='/nb/login';
						}
					}
				});
				//$('#regForm').reset();
				return false;
			});
		
		
		// 주소 API
		function execDaumPostcode() {
			new daum.Postcode({
						oncomplete : function(data) {
							// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

							// 각 주소의 노출 규칙에 따라 주소를 조합한다.
							// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
							var addr = ''; // 주소 변수

							//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
							if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
								addr = data.roadAddress;
							} else { // 사용자가 지번 주소를 선택했을 경우(J)
								addr = data.jibunAddress;
							}

							// 우편번호와 주소 정보를 해당 필드에 넣는다.
							document.getElementById('postcode').value = data.zonecode;
							document.getElementById("address").value = addr;
							// 커서를 상세주소 필드로 이동한다.
							document.getElementById("detailAddress")
									.focus();
						}
					}).open();
		}

		// 중복 아이디 체크
		function checkId() {
			//이메일유효성체크
			var exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
			var id = $('#nbm_id').val();
			if (id.length < 1) {
				alert('아이디를 입력해주세요!');
			} else {
				$.ajax({
					url : 'rest/member/idChk?nbm_id='+$('#nbm_id').val(),
					type : 'GET',
					error : function (error) {
						alert(error);
					},
					success : function(data) {
						//alert(data);
						if (data == 'success'&&exptext.test(id)) {
							$('#checkIdSpan').html("사용 가능한 아이디");
							$('#checkIdSpan').css('color', 'green');
							$('#idCheck').prop('checked', true);
						} else {
							$('#checkIdSpan').html("사용 불가능한 아이디(이미 사용중이거나 이메일 형식이 아닙니다.)");
							$('#checkIdSpan').css('color', 'red');
							$('#idCheck').prop('checked', false);
						}
					}
				});
			}
	return false;
		}
</script>
</body>
</html>







	
	

