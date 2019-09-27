<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
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
<title>Insert title here</title>
<style>

#header {
	text-align: center;
}

#contents {
	width: 80%;
	margin: 0 auto;
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
}
</style>
</head>
<body>


	<%@include file="/WEB-INF/views/frame/header.jsp"%>


	<%@include file="/WEB-INF/views/frame/nav.jsp"%>

	<div id="contents">
		
		<a href="insert" class="btn btn-default btnWidth">INSERT</a>
		<div id="list">
		
			<table id="pageList" class="table table-hover">
				
			</table>
		</div>
		<div id="paging"></div>
	</div>
	
	<%@include file="/WEB-INF/views/frame/footer.jsp"%>
<script >




$(document).ready(function() {
	var p=1;
	pageList(p);
	paging(0);
});

function pageList(pNumber) {
	
	
	$.ajax({
		url : 'rest/pList?p='+pNumber+'&category=page',
		type: 'GET',
		error : function(error) {
			alert(error);
		},success : function(data){
			   var html = '';
			   html+='<tr><td>No</td><td>Name</td><td>Title(comment)</td><td>Date</td><td>Views</td></tr>';
			  		
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
	
	return false;
	
}
function paging(idx) {
	
	$.ajax({
		url:'rest/pCount?category=page',
		type:'GET',
		error : function (error) {
			alert(error);
		},success: function(data) {
			var endIdx='';
			var html = '';
			endIdx=idx+3<=data?idx+3:data;
			html+=' <nav>';
			html+=' <ul class="pagination">';
			html+='<li><a onclick="jumpDownPage('+idx+')"><</a></li>';
			//alert(data);
			for(var i=idx; i<endIdx;i++){
				
				html+='<li><a onclick="pageList('+(i+1)+');">'+(i+1)+'</a></li>';
			}
			if(idx>=data){
				jumpDownPage(idx);
			}
			html+='<li><a onclick="jumpUpPage('+idx+')">></a></li>';
			html+=' </ul class="pagination">';
			html+=' </nav>';
			$('#paging').html(html);
		}
		
	});
	
}

function jumpUpPage(idx) {
	idx+=3;
	pageList(idx+1);
	paging(idx);
}
function jumpDownPage(idx) {
	if(idx<1){
	return;
	}
	idx-=3;
	pageList(idx+1);
	paging(idx);
}

function cCount(idx) {
	var cCnt=0;
	$.ajax({
		url:'rest/comment/cCount/'+idx,
		type:'GET',
		async:false,
		error : function (error) {
			alert(error);
		},success: function(data) {
			cCnt=data;
			
		}
		
	});
	return cCnt;
}


//async:false-> 비동기 통신을 동기적으로 사요ㅕㅇ
</script>
</body>
</html>