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
<link href="<c:url value="/css/default.css"/>" rel="stylesheet" />
<meta charset="UTF-8">
<title>start</title>
<style type="text/css">
.search{
	width: 900px;
	margin: 0 auto;
	border: 2px solid #ddd;
	margin-top: 30px;
}
.contents {
	width: 900px;
	margin: 0 auto;
	border: 2px solid #ddd;
	margin-top: 30px;
}.listContents{
	width: 900px;
	margin: 50px auto;
	
}.editBtnBox{
	width: 900px;
	margin: 0 auto;
	text-align: right;
	margin-top: 20px;
}.tableMargin {
	margin: 0 auto;
}

td {
	border: 1px solid #ddd;
	text-align: center;
	padding: 10px;
}

th {

	border: 1px solid #ddd;
	text-align: center;
	padding: 10px;
}
</style>
</head>
<body>
	<header></header>
	<%@ include file="/WEB-INF/views/frame/nav.jsp" %>


	<!-- 조회화면 -->
	<div class="search">
		<form id="search">
			<table>
			<caption>
				<h1>Subject Score</h1>
			</caption>
			<colgroup>
				<col style="width : 300px">
				<col style="width : 300px">
				<col style="width : 300px">
			</colgroup>
			<thead></thead>
			<tbody>
				<tr>
					<td>
						<select id="year" name="score_year"></select>
					</td>
					<td>
						<select name="score_semester">
						 <option selected value="1">1학기</option>
						 <option value="2">2학기</option>
						</select>
					</td>
					<td>
						<input type="submit" value="조회">
					</td>
				</tr>
			</tbody>
			<tfoot></tfoot>
			</table>
		</form>	
	</div>

	<!-- 응시자 과목수 평균 -->
	<div class="contents">
			<table class="tableMargin">
				<caption>
				</caption>
				<colgroup>
					<col style="width : 300px">
					<col style="width : 300px">
					<col style="width : 300px">
				</colgroup>
				<thead>
					<tr>
						<th>총응시자</th>
						<th>과목수</th>
						<th>평균</th>
					</tr>
				</thead>
				<tbody id="totalInfo">			
				</tbody>
				<tfoot></tfoot>
			</table>		
	</div>
	
	<!-- 리스트 -->
	<div class="listContents">
		<form id="editScore">
			<table>
				<caption></caption>
				<colgroup>
				
					<col style="width : 100px">
					<col style="width : 200px">
					<col style="width : 150px">
					<col style="width : 150px">
					<col style="width : 100px">
					<col style="width : 100px">
					<col style="width : 100px">
				</colgroup>
				<thead>
					<tr>
						<th>순위</th>
						<th>이름</th>
						<th>총점</th>
						<th>평균</th>
						<th>과목수</th>
						<th>점유순위</th>
						<th>점유율</th>
					</tr>
				</thead>
				<tbody id="scoreList">
				</tbody>
			</table>
		</form>
	</div>
	
	<footer></footer>
	<script type="text/javascript">
		$(document).ready(function() {
			var thisYear = new Date().getFullYear();
			yearOption(thisYear);
			totalInfo();
			searchList();
			
		});

		//년도 셀렉트창 값
		function yearOption(thisYear) {

			for (var i = 1990; i <= thisYear; i++) {
				if (i == thisYear) {
					$("#year").append("<option selected value='"+i+"'>" + i+ "</option>");
				}
				//년도가 올해면 default값으로 설정
				else {
					$("#year").append("<option value='"+i+"'>" + i + "</option>");
				}
			}

		}
		
		function getScoreList() {
			
			$.ajax({
				url : '${pageContext.request.contextPath}/scoreList',
				type : 'GET',
				error : function error(data) {
					alert(data);
				},success : function (data) {
					//alert(data[0].score_id);
					var html ='';
					for (var i=0; i<data.length;i++){
					
						
						html += '<tr>';
						html += '<td>'+data[i].score_rownum+'</td>';
						html += '<td>'+data[i].score_id+'</td>';
						html += '<td>'+data[i].score_year+'</td>';
						html += '<td>'+data[i].score_semester+'</td>';
						html += '<td>'+data[i].score_subject+'</td>';
						html += '<td>'+data[i].score_score+'</td>';
						html += '</tr>';
					}
					$('#scoreList').html(html);
				}
				
				
			});
			
		}
		
		
		
	$('#search').submit(function () {
			totalInfo();
			searchList();
			totalInfo();
			return false;
	});	
	//토탈정보	
	function totalInfo() {
		
		var param=$('#search').serialize();
		
		$.ajax({
			url : '${pageContext.request.contextPath}/totalInfo',
			type : 'GET',
			data : param,
			error : function (error) {
				alert(error);
			},success : function (data) {
				var html=  '';
				 html += '<tr>';
				 html += '<td>'+data.score_totalCnt+'&nbsp;&nbsp;명</td>';
				 html += '<td>'+data.score_totalsubject+'&nbsp;&nbsp;개</td>';
				 html += '<td>'+data.score_totalavg+'&nbsp;&nbsp;점</td>';
				 html += '</tr>'; 
				
				 
				 $('#totalInfo').html(html);
			}
			
			
			
			
		});
	}
	
function totalInfo() {
		
		var param=$('#search').serialize();
		
		$.ajax({
			url : '${pageContext.request.contextPath}/subjectInfo',
			type : 'GET',
			data : param,
			error : function (error) {
				alert(error);
			},success : function (data) {
				var html=  '';
			
				alert(data[0].score_kor);
			}
			
			
			
			
		});
	}
	
	//리스트
	function searchList() {
		
		var param=$('#search').serialize();
		
		$.ajax({
			url : '${pageContext.request.contextPath}/searchList',
			type : 'GET',
			data : param,
			error : function (error) {
				alert(error);
			},success : function (data) {
				var html=  '';
			
				if(data.length<1){
					 html += '<tr>';
					 html += '<td colspan="7"><b style="color : red">응시 결과가 없습니다.</b></td>';
					 html += '</tr>'; 
					
				}else{
					for(var i=0; i<data.length;i++){
					 html += '<tr>';
					 html += '<td>'+data[i].score_rownum+'</td>';
					 html += '<td>'+data[i].score_id+'</td>';
					 html += '<td>'+data[i].score_totalscore+'</td>';
					 html += '<td>'+data[i].score_totalavg+'</td>';
					 html += '<td>'+data[i].score_subjectcnt+'</td>';
					 html += '<td>'+data[i].score_rank+'</td>';
					 html += '<td>'+data[i].score_share+'</td>';
					 html += '</tr>'; 
					 
					}
				}
				 
				 $('#scoreList').html(html);
			}
		});
	}
		

	
	


	
	</script>
</body>
</html>