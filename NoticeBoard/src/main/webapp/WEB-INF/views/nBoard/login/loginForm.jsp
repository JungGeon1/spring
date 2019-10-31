<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>

<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/coming-sssoon.css" rel="stylesheet" />
<link href="<c:url value="/css/nbCss.css"/>" rel="stylesheet" />
<!-- 애니메이션css -->
<link href="<c:url value="/css/animation.css"/>" rel="stylesheet" />
<!--     Fonts     -->
<link href="https://fonts.googleapis.com/css?family=Lobster&display=swap"rel="stylesheet">
<link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Grand+Hotel&display=swap" rel="stylesheet">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />

<meta charset="UTF-8">

<title>Insert title here</title>
<style>


#leftBox {
	width: 750px;
	height: 710px;
	/* 	border: 1px solid #ddd; */
	float: left;
	text-align: center;
}

#formDiv {
	float: right;
	width: 550px;
	height: 710px;
	margin: 0 auto;
	padding-top:120px;
	/* 	border: 1px solid #ddd; */
	text-align: center;
	width: 550px;
	padding-left: 70px;
}

#formDiv td {
	padding: 10px;
}

#mainImg {
	width: 600px;
}
#contents2{
	width: 100%;
	height: 800px;

}#mainImgCmt{
   position: absolute;
         top:50%;
         left:50%;
         transform: translate(-50%, -50%);                                                                   
         font-size:5rem;
         color: white;
         z-index: 2;
         text-align: center;
}
#mainImg{
	width: 100%;
	height: 100%;
}

 .img{
        position: relative;
        background-image: url(/images/holiday2.jpg);                                                               
        height: 100vh;
        background-size: cover;
    }

    .img-cover{
       position: absolute;
       height: 100%;
       width: 100%;
       background-color: rgba(0, 0, 0, 0.2);                                                                 
       z-index:1;
    }

    .img .content{
         position: absolute;
         top:50%;
         left:50%;
         transform: translate(-50%, -50%);                                                                   
         color: white;
         z-index: 2;
         text-align: center;
    }
	.firstComment{
		font-size:15em;
	}
	.secondComment{
	    font-size:5em;
	}


#contents3{
	
	width: 95%;
	height: 600px;
	margin:0 auto;
}#contens3Cm{
	text-align: center;
	margin-top: 20px;
	margin-bottom: 20px;
}

.bestImg{
	
	width: 100%;
	height: 100%;
}
</style>
</head>
<body>


	<%@include file="/WEB-INF/views/frame/header.jsp"%>


	<%@include file="/WEB-INF/views/frame/nav.jsp"%>

	<div id="contents">
		<div id="content">
			<div id="leftBox">

				<img id="mainImg" class="slideRight" src="<c:url value="/images/car.png"/>">
			</div>
			<div id="formDiv">

				<form method="post" action="<c:url value="/login/loginReq"/>">
					<table>
						<tr>

							<td colspan="2"><h1>LOGIN</h1></td>
						</tr>
						<tr>
							<td>아이디(이메일)</td>
							<td><input class="form-control" type="email" id="nbm_id"
								name="nbm_id" required></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input class="form-control" type="password" id="nbm_pw"
								name="nbm_pw" required></td>
						</tr>


						<tr>
							<td></td>
						
							<td><input type="submit"style="float: right" class="btn btn-default" value="JOIN"></td>
						</tr>
						<tr>
							<td></td>
							<td>
								<%-- <a href="<c:url value="/findAccount/findId"/>">아이디</a> --%>
								<a href="<c:url value="/findAccount/findPw"/>">비밀번호 찾기</a>
								<br>
								<br>
							<a href="<c:url value="/regist"/>">아직 회원이 아니신가요?</a></td>
						</tr>
					</table>
				</form>


			</div>
		</div>
	</div>
	
	
	
	
	 <div class="img" style="background-image: url('<c:url value="/images/holiday2.jpg"/>');">
        <div class="content">
            <span class="firstComment">Hello!</span><br>
           	<span class="secondComment">Write your Trip record</span>
        </div>
        <div class="img-cover"></div>
    </div>
    
    
    
    
	<div id="contents3">
	  <div id="contens3Cm"><h1>Best Board Top 3</h1></div>
		<div class="row" id="top3Item">
  		<%-- 	<div class="col-sm-6 col-md-4">
    		 	<div class="thumbnail">
      				<img src="<c:url value="/images/holiday2.jpg"/>" alt="...">
      					<div class="caption">
        					<h3>Thumbnail label</h3>
      					    <p>여기 멋진여기 멋진!여기 멋진!여기 멋진!여기 멋진!여기 멋진여기 멋진!여기 멋진!여기 멋진!여기 멋진!여기 멋진!!!</p>
        					<p><a href="#" class="btn btn-primary" role="button">Button</a> </p>
     				   </div>
  				 </div>
 			</div>
 			
 			<div class="col-sm-6 col-md-4">
    			<div class="thumbnail">
      				<img src="<c:url value="/images/air.jpg"/>" alt="...">
      					<div class="caption">
        					<h3>Thumbnail label</h3>
      					    <p>여기 멋진여기 멋진!여기 멋진!여기 멋진!여asdfadfasdfasfafsdfasfsdfsdafadfadsfasd여기 멋진!여기 멋진!여기 멋진!여기 멋진!!!</p>
        					<p><a href="#" class="btn btn-primary" role="button">Button</a> </p>
     				   </div>
  				 </div>
 			</div>
 			
 			<div class="col-sm-6 col-md-4">
    			<div class="thumbnail">
      				<img src="<c:url value="/images/suje.jpg"/>" alt="...">
      					<div class="caption">
        					<h3>Thumbnail label</h3>
      					    <p>여기 멋진여기 멋진!여기 멋진!여기 멋진!여기 멋진!여기 멋진여기 멋진!여기 멋진!여기 멋진!여기 멋진!여기 멋진!!!</p>
        					<p><a href="#" class="btn btn-primary" role="button">Button</a> </p>
     				   </div>
  				 </div> 
 			</div> --%>
		</div>
</div>
	<%@include file="/WEB-INF/views/frame/footer.jsp"%>



<script>
	$(document).ready(function () {
		showReadCntList();
	});
	//contents3의 베스트 top3 리스트
	function showReadCntList() {

		$.ajax({
			url : 'start/mainBestList',
			type : 'GET',
			error : function(error) {
				alert(error);
			},
			success : function(data) {
				var html = '';
				var sunStrTitle='';
				

				for (var i = 0; i < data.length; i++) {
					html +='<div class="col-sm-6 col-md-4">';
					html +='<div class="thumbnail">';
					html +='<img class="bestImg" src="uploadfile/'+data[i].u_image+'" alt="'+data.u_image+'">';
					html +='<div class="caption">';
					html +='<h3>'+data[i].u_title+'</h3>';
					html +='<p>'+data[i].u_contents+'</p>';
					html +='<p><a href="/nb/view?category=page&idx=' + data[i].idx+ '" class="btn btn-primary" role="button">보러가기</a> </p>';
					html +='</div></div></div>';
				}

				$('#top3Item').html(html);
			}

		});

	}
	


</script>
</body>
</html>










