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
}.insetChkBox{
	width: 800px;
	margin: 0 auto;
	margin-top: 50px;
	text-align: center;
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
						<td><input type="text" name="score_id" id="score_id"></td>
						<td>
							<select id="year" name="score_year"></select>
						</td>
						<td>
							<select name="score_semester" id="score_semester">
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
							<select name="score_subject" id="score_subject">
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
		<div class="insetChkBox">
			<input type="checkbox" hidden="" id="insertScoreChk">
			<span id="insertScoreCmt">점수 입력 확인</span>
		</div>
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
		
			

			$('#score_id').focusout(function insertScorechk(){

				var param = $('#insertScore').serialize();
				 $.ajax({
					 
					 url   : '${pageContext.request.contextPath}/insertScoreChk',
					 type  : 'get',
					 data  :  param,
					 error : function (error) {
						alert(error);	
					},
					 success : function (data) {
						//alert(data);
						if(data<1){
							$('#insertScoreChk').prop('checked',true);
							$('#insertScoreCmt').html('지원 가능한 과목입니다');
							$('#insertScoreCmt').css('color','green');
							
						}else{
							$('#insertScoreChk').prop('checked',false);
							$('#insertScoreCmt').html('이미 지원한 과목입니다.');
							$('#insertScoreCmt').css('color','red');
						}
					}
				 });
			});
			
			$('#score_semester').on('change',function insertScorechk() {

				var param = $('#insertScore').serialize();
				 $.ajax({
					 
					 url   : '${pageContext.request.contextPath}/insertScoreChk',
					 type  : 'get',
					 data  :  param,
					 error : function (error) {
						alert(error);	
					},
					 success : function (data) {
						//alert(data);
						if(data<1){
							$('#insertScoreChk').prop('checked',true);
							$('#insertScoreCmt').html('지원 가능한 과목입니다');
							$('#insertScoreCmt').css('color','green');
							
						}else{
							$('#insertScoreChk').prop('checked',false);
							$('#insertScoreCmt').html('이미 지원한 과목입니다.');
							$('#insertScoreCmt').css('color','red');
						}
					}
				 });
				 return false;
			});
			
			
			$('#score_subject').on('change',function insertScorechk() {

				var param = $('#insertScore').serialize();
				 $.ajax({
					 
					 url   : '${pageContext.request.contextPath}/insertScoreChk',
					 type  : 'get',
					 data  :  param,
					 error : function (error) {
						alert(error);	
					},
					 success : function (data) {
						//alert(data);
						if(data<1){
							$('#insertScoreChk').prop('checked',true);
							$('#insertScoreCmt').html('지원 가능한 과목입니다');
							$('#insertScoreCmt').css('color','green');
							
						}else{
							$('#insertScoreChk').prop('checked',false);
							$('#insertScoreCmt').html('이미 지원한 과목입니다.');
							$('#insertScoreCmt').css('color','red');
						}
					}
				 });
				 return false;
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
			
			
		
			


});

	
		
		
		$('#insertScore').submit(function() {
					
					if($('#insertScoreChk').prop('checked')){
							
							//alert('asdf');						
							var param = $('#insertScore').serialize();
							$.ajax({
				
								url : '${pageContext.request.contextPath}/insertScore',
								type : 'POST',
								data : param,
								error : function(error) {
									alert(error);
								},
								success : function(data) {
									//alert(data);
									getScoreList() ;
									$('#insertScoreCmt').html('점수가 입력되었습니다.');
									$('#insertScoreCmt').css('color','green');
				
								}
							});
						
						}else{
							
							alert('이미 지원한 과목입니다');
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
					html += '<td><input name="list['+i+'].score_idx" type="text" hidden value="'+data[i].score_idx+'">'+data[i].score_rownum+'';
					html += '<input id="list['+i+'].editChk" name="list['+i+'].editChk" type="checkbox" value="chk"></td>';
					html += '<td><input name="list['+i+'].score_id" style="width : 150px" type="text" value="'+data[i].score_id+'"></td>';
					html += '<td><input name="list['+i+'].score_year" style="width : 150px" type="text" value="'+data[i].score_year+'"></td>';
					html += '<td><input name="list['+i+'].score_semester" style="width : 50px" type="text" value="'+data[i].score_semester+'"></td>';
				/* 		html+=	'<td>';
						html+=	'<select name="list['+i+']score_semester" id="score_semester'+i+'">';
						html+=	'<option value="1">1학기</option>';
						html+=	'<option value="2">2학기</option>';
						if(data[i].score_semester){
							
							
						} */
						html+=	'</select>';
						html+=	'</td>';
					html += '<td><input name="list['+i+'].score_subject" style="width : 150px" type="text" value="'+data[i].score_subject+'"></td>';
					html += '<td><input name="list['+i+'].score_score" style="width : 50px" type="text" value="'+data[i].score_score+'"></td>';
					html += '</tr>';
					
				}
					html += '<tr>';
					html += '<td>';						
					html += '<input type="checkbox" id="allChk" onchange="allCheck()">';
					html += '</td>';
					html += '<td colspan="5">';
					html += '</td>';
					html += '</tr>';
					html += '<tr>';
					html += '<td colspan="6">';
					html += '<button onclick="updateScore()">수정</button>';
					html += '<button onclick="deleteScore()">삭제</button>';
					html += '</td>';
					html += '</tr>';
				$('#scoreList').html(html);
			

			}
			
			
		});
		
		return false;
	}
 
	 
	
	function allCheck(){
		
		if($('#allChk').prop("checked")) { 
			 $("#scoreList input[type=checkbox]").prop("checked",true); 
		} else { 
			 $("#scoreList input[type=checkbox]").prop("checked",false); 
		}  
	};
	
	
	function updateScore() {
	
		var param = $('#editScore').serialize();
		$.ajax({

			url : '${pageContext.request.contextPath}/updateScore',
			type : 'POST',
			data : param,
			error : function(error) {
				alert(error);
			},
			success : function(data) {
				alert(data+'개 수정');
				getScoreList();

			} 
		});
		return false;
	};
	
	
	function deleteScore() {
		
		var param = $('#editScore').serialize();
		$.ajax({

			url : '${pageContext.request.contextPath}/deleteScore',
			type : 'POST',
			data : param,
			error : function(error) {
				alert(error);
			},
			success : function(data) {
				alert(data+'개 삭제');
				getScoreList();

			}
		});
		return false;
	};
	 
	
	
		
/* 		function find() {

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
		
	} */
	
	</script>
</body>
</html>