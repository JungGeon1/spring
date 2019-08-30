
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

<meta
	content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'
	name='viewport' />
<meta name="viewport" content="width=device-width" />
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<title>Time Lapse</title>

<link href="css/bootstrap.css" rel="stylesheet" />
<link href="css/coming-sssoon.css" rel="stylesheet" />

<!--     Fonts     -->
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.css"
	rel="stylesheet">
<link href='http://fonts.googleapis.com/css?family=Grand+Hotel'
	rel='stylesheet' type='text/css'>

<style>
.formBlock {
	margin: 15px;
}

#formDiv {
	margin: 0 auto;
	width: 50%;
}
</style>

</head>

<body>
	<!-- nav 시작 -->
	<%@include file="frame/nav.jsp"%>
	<!-- nav 끝 -->


	<div class="main" style="background-image: url('images/backgroud.jpg')">
		<div class="cover black" data-color="white"></div>

		<!-- context시작 -->
		<div class="container">
			<h1 class="logo cursive">Login</h1>
			<br>
			<div class="content">
				<h4 class="motto">로그인 해주세요</h4>
				<div class="subscribe">
					<!--<h5 class="info-text">
                        Join the waiting list for the beta. We keep you posted.
                    </h5>-->

					<div id="formDiv">
							<form id="form" class="form-inline" role="form">
								<table>
									<tr>
										<td>아이디</td>
										<td><input type="email" id="id" name="id" required></td>
									</tr>
									<tr>
										<td>비밀번호</td>
										<td><input type="password" id="pw" name="pw" required></td>
									</tr>
									<tr>
										<td colspan="2"><input type="submit" value="LOGIN!"></td>
									</tr>
								</table>
							</form>
							<span id="span"></span>
					</div>
				</div>
			</div>
		</div>
		<!-- context끝 -->

		<!-- footer 시작 -->
		<%@include file="frame/footer.jsp"%>
		<!-- footer 끝 -->
	</div>
	
	<script>
        $(document).ready(function() {
            $('#form').submit(function() {

                var id = $('#id').val();

                $.ajax({
                    url: 'http://localhost:9090/ps/members/login',
                    type: 'POST',
                    data: $('#form').serialize(),
                    success: function(data) {
                        alert(data.view);
                        alert(data.id);
                        if (data.view == 'success') {
                            //인증처리됨 -> 메인화면으로
                            alert('인증되었습니다!');
                            
                            $.ajax({
                            	url: "http://localhost:9090/psClient/loginProcess.jsp",
                            	data: {
                            		id: data.id
                            	},
                            	type: 'GET'
                            });
                           	
                            /* Swal.fire('인증되었습니다!')*/
                            location.href = "http://localhost:9090/psClient/index.jsp";
                            //location.href = "main.html";
                        }
                        if (data.view == 'undefined') {
                            //미인증 회원 -> 이메일 다시 보내기
                            var chk = confirm('미인증 상태입니다, 인증키를 다시 보내시겠습니까?');
                            if (chk) {
                                $.ajax({
                                    url: 'http://localhost:9090/ps/members/verify/resend',
                                    data: {
                                        id: id
                                    },
                                    type: 'GET',
                                    success: function(data) {
                                        if (data == 'success') {
                                            $('#span').html("인증키 재전송 완료, 이메일을 통해 인증해주세요!");
                                            $('#span').css('color', 'green');
                                        } else {
                                            $('#span').html("인증키 재전송 실패ㅠㅜ");
                                            $('#span').css('color', 'red');
                                        }
                                    }
                                });
                            }
                        }
                        if (data.view == 'loginfail') {
                            //로그인 실패
                            alert('로그인 실패, 다시 로그인해주세요!');
                            location.replace("http://localhost:9090/psClient/login.jsp");
                            //location.replace("login.html");
                        }
                    }
                });
                return false;
            });
        });
    </script>
</body>
<script src="js/jquery-1.10.2.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
</html>