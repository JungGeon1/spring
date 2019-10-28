<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<link href="https://fonts.googleapis.com/css?family=Lobster&display=swap" rel="stylesheet">
<link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.css" rel="stylesheet">
 <link href="https://fonts.googleapis.com/css?family=Grand+Hotel&display=swap" rel="stylesheet">
 <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0'name='viewport' />
<meta name="viewport" content="width=device-width" />
<meta charset="UTF-8">
<title>Admin Board</title>
<style>

#header {
	text-align: center;
}

#contents {
	width: 80%;
	margin: 0 auto;
	overflow: hidden;
	height:900px;
	margin-top: 50px;
}


.both {
	clear: both;
}

#list {
	width: 100%;
}

table {
	width: 100%;
	text-align: center;
	
}
td {
	padding: 3px 10px;
	border: 1px solid #999;
}
#paging{
	width:250px;
	margin: 0 auto;
}.btnWidth{
	width: 100%;
}.displayInline{
	display: inline;
}
.sSelectWidth{
	width: 17%;
}
.sTextWidth{
	width: 70%;
}
.sBtntWidth{
	width: 12%;
}.carImg{
	width: 300px;
	position: relative;
	bottom: 70px;
}.todayBoard{
	
	font-size: 3em;
	text-align: center;
	

}
.totalBoard{
	font-size: 3em;
	text-align: center;
	margin-left: 100px;

}
</style>
</head>
<body>


	<%@include file="/WEB-INF/views/frame/header.jsp"%>


	<%@include file="/WEB-INF/views/frame/nav.jsp"%>

	<div id="contents">
		<c:if test="${admin_id ne null}">
			<a href="<c:url value="/adminBoard/adminInsertForm"/>" class="btn btn-default btnWidth">INSERT</a>
		</c:if>
		
		<div id="list">
		
			<table id="pageList" class="table table-hover">
				
			</table>
		</div>
		<div>
			<select  class="form-control displayInline sSelectWidth" name="stype" id="stype">
				<option value="id">ID</option>
				<option value="title">Title</option>
				<option value="date">Date</option>
			</select>
			<input  class="form-control displayInline sTextWidth" type="text" name="keyword" id="keyword"> 
			<button  class="btn btn-default displayInline sBtntWidth"  id="searchBtn" onclick="search()" >검색</button>
		</div>
		<div id="paging"></div>
		<div class="slideLeft">
			<img class="carImg"  src="<c:url value="/images/car.png"/>">
		</div>
	</div>
	
	<%@include file="/WEB-INF/views/frame/footer.jsp"%>
<script >



// 파일 로드시 리스트출려이랑 페이지네이션 실행
$(document).ready(function() {
	var p=1;
	pageList(p);
	paging(1);
	
	
});


//검색시 검색조건에 따라 리스트랑 페이지네이션 재실행
function search() {
	pageList(1);
	paging(1);

	
}
//리스트출력
function pageList(pNumber) {
	
	
	$.ajax({
		url : '${pageContext.request.contextPath}/adminBoard/list?p='+pNumber+'&stype='+$('#stype').val()+'&keyword='+$('#keyword').val(),
		type: 'GET',
		error : function(error) {
			alert(error);
		},success : function(data){
			   var html = '';
			   
			   html+='<tr><td>No</td><td>ID</td><td>Title</td><td>Date</td><td>Views</td>';
			   html+='<c:if test="${admin_id ne null}"><td>DELETE</td></c:if></tr>'		
                for(var i=0; i<data.length;i++){
              
                    html += '<tr>';
                    html += '<td>'+(data[i].listIdx-i)+'</td>';
                    html += '<td>'+data[i].adminBoard_id+'</td>';
                    html += '<td><a href="${pageContext.request.contextPath}/adminBoard/adminBoardView?idx='+data[i].adminBoard_idx+'" >'+data[i].adminBoard_title+'</a></td>';
         	        html += '<td>'+data[i].adminBoard_date+'</td>';
                    html += '<td>'+data[i].adminBoard_views+'</td>';
                    html += '<c:if test="${admin_id ne null}"><td><button onclick="adminDelete('+data[i].adminBoard_idx+')" class="adminBtnRight btn btn-default btn-sm">관리자삭제</button></td></c:if>';
                    html += '</tr>\n';
                }
                
                $('#pageList').html(html);
		}
		
	});
	// 호출시 리다이렉트되는것을 막기위한 false
	return false;
	 
	}
	//페이징 
	function paging(idx) {

		$.ajax({
			url : '${pageContext.request.contextPath}/adminBoard/pCount?category=page&stype=' + $('#stype').val() + '&keyword=' + $('#keyword').val(),
			type : 'GET',
			error : function(error) {
				alert(error);
			},
			success : function(data) {
				//data=총 페이지수
				//idx=시작페이지 번호 ex) 1, 4, 7 
				var endIdx = '';
				var html = '';
				//마지막페이지는 기존페이제 3을 더했을경우가 총페이보다 크면 총페이지수를 출력한다
				endIdx = idx + 3 <= data ? idx + 3 : data + 1;
				html += ' <nav>';
				html += ' <ul class="pagination">';
				if (idx != 1) {
					html += '<li><a onclick="jumpDownPage(' + idx+ ')"><</a></li>';
				}
				//alert(data);
				for (var i = idx; i < endIdx; i++) {

					html += '<li><a onclick="pageList(' + i + ');">' + i+ '</a></li>';
				}
				//ex)1+2<=총페이지 
				if (idx + 2 < data) {
					html += '<li><a onclick="jumpUpPage(' + idx + ')">></a></li>';
				}

				html += ' </ul class="pagination">';
				html += ' </nav>';
				$('#paging').html(html);
			}

		});

	}
	//페이지 이동버튼 3개기준
	function jumpUpPage(idx) {
		idx += 3;
		pageList(idx);
		paging(idx);

	}
	function jumpDownPage(idx) {
		/* if(idx==1){
		return;
		} */
		idx -= 3;
		pageList(idx);
		paging(idx);

	}
	

	//관리자게시글 삭제
	function adminDelete(idx) {
		
		if(confirm('관리자의 권한으로 삭제하시겠습니까?.')){
			$.ajax({
				
				url : '${pageContext.request.contextPath}/adminBoard/adminBoardDelete',
				type : 'post',
				data : {
					idx : idx,
				
				},error : function (data) {
					alert(data);
				},success : function (data) {
					//alert(data);
					
					if(data=='success'){
						
						alert('삭제되었습니다.');
						location.href='${pageContext.request.contextPath}/adminBoard';
					}
				}
				
			});
			
		}
		
	}
	
	//async:false- 비동기 통신을 동기적으로 사요ㅕㅇ
</script>
</body>
</html>