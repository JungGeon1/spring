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
<meta name="viewport" content="width=device-width" />
<meta charset="UTF-8">

<title>Insert title here</title>
<style>

#leftBox {
	width: 550px;
	height: 710px;
	/* 	border: 1px solid #ddd; */
	float: left;
	text-align: center;
}

#formDiv {
	float: right;
	width: 600px;
	height: 710px;
	margin: 0 auto;
	/* 	border: 1px solid #ddd; */
	
	width: 550px;
	padding-left: 70px;
}

#formDiv td {
	padding: 10px;
	
}

#mainImg {
	width: 600px;
}#readCountBox{
	clear:both;
	/* border: 1px solid #ddd; */
	width: 600px;
	height:  400px;
	text-align: center;

}#readCntList{
	width:100%;
	font-size: 2em;
}.readCntItem{

}

.readCntTitle{

width:360px;
height: 60px;
overflow: hidden

}#mainImg {
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
         z-index: 1;
         text-align: center;
}
#mainImg{
	width: 100%;
	height: 100%;
	cursor: pointer;
	
	z-index: 2;
}
#light{
display:none;
position: absolute;
z-index: 1;
width: 500px;
top :380px;
left: -100px;
cursor: pointer;
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
         top:40%;
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
	<img id="light" class="stretchLeft" onclick="goMclick()" src="<c:url value="/images/light.png"/>">
	<div id="contents">
		<div id="content">
			<div id="leftBox">
			
				<img id="mainImg" onclick="light()" src="<c:url value="/images/car.png"/>">
			</div>
			<div id="formDiv">

				
				<div class="page-header">
 					 <h1>${nbm_id} <small>계정로 로그인 하셨습니다.</small></h1>
				</div>
				<div class="slideExpandUp" id="readCountBox">
					<h1>Views Top 3</h1>
					<div>
						<table id="readCntList"></table>
					</div>
				</div>

			</div>
		</div>
	</div>
		 <div  class="img" style="background-image: url('<c:url value="/images/people.jpg"/>');">
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
	
		$(document).ready(function() {
			showReadCntList();
			showBestList() ;
		})
		//조회수 탑 3 가져오기
		function showReadCntList() {

			$.ajax({
				url : '${pageContext.request.contextPath}/myPage/readCntList?&nbm_id=${nbm_id}',
				type : 'GET',
				error : function(error) {
					alert(error);
				},
				success : function(data) {
					var html = '';
					var sunStrTitle='';
					html+='<tr><td>Views</td><td>Title</td><td>Image</td></tr>';

					for (var i = 0; i < data.length; i++) {
						sunStrTitle=changeDate(data[i].u_title);
						html += '<tr>\n';
						html += '<td>' + data[i].u_readcount + '</td> ';
						html += '<td class="readCntTitle"><a title="'+data[i].u_title+'" href="/nb/view?idx=' + data[i].idx+ '" >' + sunStrTitle + '</a></td> ';
						if (data[i].u_image == 'NO_IMAGE.png') {
							html += '<td>  X ';
						} else {
							html += '<td>  O ';
						}
							html += '</td></tr>\n';
					}

					$('#readCntList').html(html);
				}

			});

		}
	//타이틀 칸의 글자를 14자리까지 잘라준다	
	function changeDate(data) {
		var date = data.substr(0,14);
		return date;
		}
	//contents3의 베스트 top3 리스트
	function showBestList() {

		$.ajax({
			url : '${pageContext.request.contextPath}/start/mainBestList',
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
					html +='<img class="bestImg" src="${pageContext.request.contextPath}/uploadfile/'+data[i].u_image+'" alt="'+data.u_image+'">';
					html +='<div class="caption">';
					html +='<h3>'+data[i].u_title+'</h3>';
					html +='<p>'+data[i].u_contents+'</p>';
					html +='<p><a href="/nb/view?idx=' + data[i].idx+ '" class="btn btn-primary" role="button">보러가기</a> </p>';
					html +='</div></div></div>';
				}

				$('#top3Item').html(html);
			}

		});
	}
	
	//자동차 불키기
	function light() {
		var windowWidth = $( window ).width();
		//alert(windowWidth);
		
		if(windowWidth<1840){
			
			alert('불을 킬 공간이 없어요..! 창을 키워주세요!');
			return ;
		}
		if($('#light').is(":visible")){
		     // display : none가 아닐 경우
			$('#light').css('display','none');
			return;
		}else{
			$('#light').css('display','inline');
			
	
		}
	}
	$(window).resize(function (){
		  // width값을 가져오기
		  var width_size = window.outerWidth;
		  
		  // 1840이하인지 if문으로 확인
		  //1840이하면 자동차 불 이미지를 제거
		  if (width_size <= 1900) {
			 
					$('#light').css('display','none');
				
				}
		  
		})


	function goMclick() {
		
		window.open('http://www.toursoft.co.kr/'); 

		
	}
	</script>
</body>
</html>









