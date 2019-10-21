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
<title>Insert title here</title>
<style>

#header {
	text-align: center;
}

#contents {
	width: 80%;
	margin: 0 auto;
	overflow: hidden;
}


.both {
	clear: both;
}

#list {
	width: 100%;
}

table {
	width: 100%;
	
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
	bottom: 40px;
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
		<c:if test="${nbm_id ne null}">
			<a href="insert" class="btn btn-default btnWidth">INSERT</a>
		</c:if>
		<div id="list">
		
			<table id="pageList" class="table table-hover">
				
			</table>
		</div>
		<div>
			<select  class="form-control displayInline sSelectWidth" name="stype" id="stype">
				<option value="id">E-Mail</option>
				<option value="title">Title</option>
				<option value="date">Date</option>
			</select>
			<input  class="form-control displayInline sTextWidth" type="text" name="keyword" id="keyword"> 
			<button  class="btn btn-default displayInline sBtntWidth"  id="searchBtn" onclick="search()" >검색</button>
		</div>
		<div id="paging"></div>
		<div class="slideLeft">
			<img class="carImg"  src="<c:url value="/images/car.png"/>">
			<span class="todayBoard" id="todayBoard"></span>
			<span class="totalBoard" id="totalBoard"></span>
		</div>
	</div>
	
	<%@include file="/WEB-INF/views/frame/footer.jsp"%>
<script >



// 파일 로드시 리스트출려이랑 페이지네이션 실행
$(document).ready(function() {
	var p=1;
	pageList(p);
	paging(1);
	totalBoardCnt();
	todayBoardCnt();
	
});
//검색시 검색조건에 따라 리스트랑 페이지네이션 재실행
function search() {
	pageList(1);
	paging(1);
	totalBoardCnt();
	todayBoardCnt();
	
}
//리스트출력
function pageList(pNumber) {
	
	
	$.ajax({
		url : 'rest/pList?p='+pNumber+'&category=page&stype='+$('#stype').val()+'&keyword='+$('#keyword').val(),
		type: 'GET',
		error : function(error) {
			alert(error);
		},success : function(data){
			   var html = '';
			   html+='<tr><td>No</td><td>E-Mail</td><td>Title(comment)</td><td>Date</td><td>Views</td></tr>';
			  		
                for(var i=0; i<data.length;i++){
                	
                    html += '<tr>';
                    html += '<td>'+(data[i].pListCnt-i)+'</td>';
                    html += '<td>'+data[i].u_id+'</td>';
                    html += '<td><a href="/nb/view?idx='+data[i].idx+'" >'+data[i].u_title+'</a>  ('+cCount(data[i].idx)+')</td>';
         	        html += '<td>'+data[i].u_date+'</td>';
                    html += '<td>'+data[i].u_readcount+'</td>';
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
			url : 'rest/pCount?category=page&stype=' + $('#stype').val()
					+ '&keyword=' + $('#keyword').val(),
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
					html += '<li><a onclick="jumpDownPage(' + idx
							+ ')"><</a></li>';
				}
				//alert(data);
				for (var i = idx; i < endIdx; i++) {

					html += '<li><a onclick="pageList(' + i + ');">' + i
							+ '</a></li>';
				}
				//ex)1+2<=총페이지 
				if (idx + 2 <= data) {
					html += '<li><a onclick="jumpUpPage(' + idx
							+ ')">></a></li>';
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
	//댓글 갯수출력 -- 값을 반환해야하기떄문에 동기방식으로 변경
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

	//총 보드수
	function totalBoardCnt() {

		$.ajax({
			url : 'rest/totalBoardCnt',
			type : 'GET',
			error : function(error) {
				//alert(error);
			},
			success : function(data) {
				//alert(data);
				var html = '';
				html += '그동안 쌓인 보드 수 : ';
				html += data;

				$('#totalBoard').html(html);
			}

		});
	}
	//오늘작성한 보드수
	function todayBoardCnt() {

		$.ajax({
			url : 'rest/todayBoardCnt',
			type : 'GET',
			error : function(error) {
				//alert(error);
			},
			success : function(data) {
				//alert(data);
				var html = '';
				html += '오늘 추가된 보드 수 : ';
				html += data;

				$('#todayBoard').html(html);
			}

		});
	}

	//async:false- 비동기 통신을 동기적으로 사요ㅕㅇ
</script>
</body>
</html>