<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="<c:url value="/js/bootstrap.min.js"/>" type="text/javascript"></script>
<link href="<c:url value="/css/bootstrap.css"/>" rel="stylesheet" />
<link href="<c:url value="/css/coming-sssoon.css"/>" rel="stylesheet" />
<link href="<c:url value="/css/default.css"/>" rel="stylesheet" />
<meta charset="UTF-8">
<title>start</title>
<style type="text/css">

.contents {
	width: 900px;
	height: 400px;
	margin: 0 auto;
	border: 2px solid #ddd;
	margin-top: 30px;
}.listContents{
	width: 900px;
	margin: 0 auto;
	margin-bottom: 50px;
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
}.background{
	background-color: black;
}
</style>
</head>
<body>
	<header></header>
	<%@include file="/WEB-INF/views/frame/nav.jsp"%>
	
	<div class="contents">
		<form id="insertScore">

			<table class="tableMargin">
				<caption><h1>Subject Score</h1></caption>
				<colgroup>
					<col style="width: 200px">
					<col style="width: 200px">
					<col style="width: 200px">
					<col style="width: 200px">
				</colgroup>
				<thead>

				</thead>
				<tbody>
					<tr>
						<td><b>ID</b></td>
						<td><input type="text" name="score_id"></td>
						<td>
							<select id="year" name="score_year"></select>
						</td>
						<td>
							<select name="score_semester">
								<option selected value="1">1학기</option>
								<option value="2">2학기</option>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="2"><b>과목명</b></td>
						<td colspan="2"><b>점수</b></td>
					</tr>
					<tr>
						<td colspan="2">
							<select name="score_subject">
								<option selected value="국어">국어</option>
								<option value="영어">영어</option>
								<option value="수학">수학</option>
								<option value="사회">사회</option>
								<option value="과학">과학</option>
							</select>
						</td>
						<td colspan="2">
							<input id="score_score" name="score_score" type="text" value="0">
						</td>
					</tr>
					<tr>
						<td colspan="4"><input class="btn btn-primary  btn-sm" type="submit" value="입력"></td>
					</tr>
				</tbody>
				<tfoot></tfoot>
			</table>
		</form>
	</div>
	<div class="editBtnBox">
		<button id="editFromBtn" onclick="editForm()">수정하기</button>
		<!-- <button id="findBtn" onclick="find()">20</button>
		<button id="findBtn" onclick="findx()">20x</button> -->
	</div>
	<div class="listContents">
		<form id="editScore">
			<table>
				<caption><h3>Subject List</h3></caption>
				<colgroup>
				
					<col style="width : 100px">
					<col style="width : 200px">
					<col style="width : 200px">
					<col style="width : 100px">
					<col style="width : 200px">
					<col style="width : 100px">
					
				</colgroup>
				<thead>
					<tr>
						<th>글번호</th>
						<th>이름</th>
						<th>년도</th>
						<th>학기</th>
						<th>과목</th>
						<th>점수</th>
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
			getScoreList();
			//editForm();
			//$('input[name=score_score]').css('background-color','black');	
			
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
		
		$('#insertScore').submit(function() {
			var regexp = /^[0-9]*$/
			v = $('#score_score').val();
			if( !regexp.test(v) ) {
					alert("숫자만 입력하세요");
					$('#score_score').val(v.replace(regexp,''));
					return;

			}else if($('#score_score').val()>100){
				
				
			
			}else{
			
			var param = $('#insertScore').serialize();
			$.ajax({

				url : '${pageContext.request.contextPath}/insertScore',
				type : 'POST',
				data : param,
				error : function(error) {
					alert(error);
				},
				success : function(data) {
					alert(data);
					getScoreList() ;

				}
			});
			
			}
			return false;
			
		});
		
		
		
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
	function editForm() {
		
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
					html += '<td><input name="list['+i+'].score_idx" type="text" hidden value="'+data[i].score_idx+'">'+data[i].score_rownum+'</td>';
					html += '<td><input name="list['+i+'].score_id" style="width : 150px" type="text" value="'+data[i].score_id+'"></td>';
					html += '<td><input name="list['+i+'].score_year" style="width : 150px" type="text" value="'+data[i].score_year+'"></td>';
					html += '<td><input name="list['+i+'].score_semester" style="width : 50px" type="text" value="'+data[i].score_semester+'"></td>';
					html += '<td><input name="list['+i+'].score_subject" style="width : 150px" type="text" value="'+data[i].score_subject+'"></td>';
					html += '<td><input name="list['+i+'].score_score" style="width : 50px" type="text" value="'+data[i].score_score+'"></td>';
					html += '</tr>';
					
				}
					html += '<tr>';
					html += '<td colspan="6">';
					html += '<button>수정</button>';
					html += '</td>';
					html += '</tr>';
				$('#scoreList').html(html);
			}
			
			
		});
		
		return false;
	}
	
/* 	html+='<select name="list['+i+'].score_semester">';
	html+='<option selected value="1">1학기</option>';
	html+='<option value="2">2학기</option>';
	html+='</select>';
	 */
	
	
	
	$('#editScore').submit(function() {
	
		var param = $('#editScore').serialize();
		$.ajax({

			url : '${pageContext.request.contextPath}/editScore',
			type : 'POST',
			data : param,
			error : function(error) {
				alert(error);
			},
			success : function(data) {
				alert(data+'개수정');
				getScoreList();

			}
		});
		
	
		return false;
		
	});
	
		function find() {

		//alert($("input[name=s_score]").length);
		 
		$("input[name=score_score]").each(function () {
			if($(this).val()==20){
				$(this).parent().parent().css('background-color','red');	
			}
		});
	
	}
	
	
	function findx() {
		$("input[name=score_score]").each(function () {
			if($(this).val()==20){
				$(this).parent().parent().css('background-color','');	
			}
		});
		
	}
	
	</script>
</body>
</html>