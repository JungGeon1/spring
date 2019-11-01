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
<meta charset="UTF-8">
<title>start</title>
<style type="text/css">

	.contentBox{
		width: 1200px;
		margin: 0 auto;
		margin-top: 50px;
	}

	th{
		text-align: center;
	}
	#tableList td{
		padding: 10px;
		text-align: center;
		border-bottom: 1px solid #ddd;
	}#boardReInsertBox{
	
		display: none;
	}#boardUpdateBox{
	
		display: none;
	}#boardDeleteBox{
	
		display: none;
	}#adminInsertBox{
		display: none;
	}#boardInsertBox{
		display: none;
	}.board{
		width: 1200px;
		margin: 0 auto;
	}.table{
		width: 100%;
	}.btnBox{
		float:right;
		text-align: center;
		margin-bottom: 50px;
	}.textArea{
		width: 400px;
		height: 200px;
	}
</style>
</head>
<body>
<div class="contentBox">
	<div class="btnBox">
		<button class="btn btn-primary" onclick="adminForm()">관리자 추가</button>
		<button class="btn btn-primary" onclick="boardForm()">글쓰기</button>
	</div>
	<div id="adminInsertBox">
		<form id="insert">
			<table>
				<thead>
				<tr>
					
					<th colspan="2"><h3>관리자 추가</h3></th>
				</tr>
				</thead>
				<tbody>
				
				<tr>
					<td>아이디:</td>
					<td><input id="a_id" name="a_id" type="text"></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input id="a_pw" name="a_pw" type="text"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="ok"></td>
				</tr>
				</tbody>
				<tfoot></tfoot>
			</table>
		</form>
	</div>
	
	<div id="boardInsertBox">
		<form id="boardInsert">
			<table>
				<thead>
				<tr>
					
					<th colspan="2"><h3>게시판 추가</h3></th>
				</tr>
				</thead>
				<tbody>
				<tr>
					<td>작성자:</td>
					<td><input id="b_id" name="b_id" type="text"></td>
				</tr>
				<tr>
					<td>글제목:</td>
					<td><input id="b_title" name="b_title" type="text"></td>
				</tr>
				<tr>
					<td>글내용:</td>
					<td><textarea id="b_contents" name="b_contents" class="textArea"></textarea></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="ok"></td>
				</tr>
				</tbody>
				<tfoot></tfoot>
			</table>
		</form>
	
	</div>
	
	<div id="boardReInsertBox">
		<form id="boardReInsert">
			<table>
				<thead>
				<tr>
					<th colspan="2"><h3>답글입력</h3></th>
				</tr>
				</thead>
				<tbody>
				<tr>
					<td>원글번호:</td>
					<td><input id="o_no" name="o_no" type="text"></td>
				</tr>
				<tr>
					<td>작성자:</td>
					<td><input id="rb_id" name="b_id" type="text"></td>
				</tr>
				<tr>
					<td>글제목:</td>
					<td><input id="rb_title" name="b_title" type="text"></td>
				</tr>
				<tr>
					<td>글내용:</td>
					<td><textarea id="rb_contents" name="b_contents" class="textArea"></textarea></td>
					
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="ok"></td>
				</tr>
				</tbody>
				<tfoot></tfoot>
			</table>
		</form>
	
	</div>
	<div id="boardUpdateBox">
		<form id="boardUpdate">
			<table>
				<thead>
				<tr>
					<th colspan="2"><h3>게시글수정</h3></th>
				</tr>
				</thead>
				<tbody>
				<tr>
					<td>글번호:</td>
					<td><input id="up_idx" name="b_idx" type="text" readonly="readonly"></td>
				</tr>
				<tr>
					<td>작성자:</td>
					<td><input id="up_id" name="b_id" type="text" readonly="readonly"></td>
				</tr>
				<tr>
					<td>글제목:</td>
					<td><input id="up_title" name="b_title" type="text"></td>
				</tr>
				<tr>
					<td>글내용:</td>
					<td><textarea id="up_contents" name="b_contents" class="textArea"></textarea></td>
					
				</tr>
				<tr>
					<td>비밀번호:</td>
					<td><input id="up_pw" name="b_pw" type="password"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="ok"></td>
				</tr>
				</tbody>
				<tfoot></tfoot>
			</table>
		</form>
	
	</div>
	<div id="boardDeleteBox">
		<form id="boardDelete">
			<table>
				<thead>
				<tr>
					<th colspan="2"><h3>게시글삭제</h3></th>
				</tr>
				</thead>
				<tbody>
				<tr>
					<td>글 번호:</td>
					<td><input id="del_idx" name="b_idx" type="text" readonly="readonly"></td>
				</tr>
				<tr>
					<td>작성자:</td>
					<td><input id="del_id" name="b_id" type="text" readonly="readonly"></td>
				</tr>
				<tr>
					<td>글 제목:</td>
					<td><input id="del_title" name="b_idx" type="text" readonly="readonly"></td>
				</tr>
				
				<tr>
					<td>비밀번호:</td>
					<td><input id="del_pw" name="b_pw" type="password"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="ok"></td>
				</tr>
				</tbody>
				<tfoot></tfoot>
			</table>
		</form>
	
	</div>
	<div class="board">
	<table class="table table-hover">

      <caption><h1>BOARD</h1></caption>
   	 	 <colgroup>
			<col style="width: 60px;"/>
			<col/>
			<col style="width: 160px;" />
			<col style="width: 160px;"/>
			<col style="width: 200px;"/>
		</colgroup>
      <thead>
        <tr>
			<th>No.</th>
			<th>Title.</th>
			<th>Id.</th>
			<th>Date.</th>
			<th>답글</th>
       </tr>
      </thead>
      <tbody id="tableList">
      </tbody>
      <tfoot>
        <tr>
          <td colspan="2">Table Foot</td>
        </tr>
      </tfoot>
    </table>
	
	</div>
</div>
<script type="text/javascript">
	
		$(document).ready(function () {
			getList();
			
		});
	//관리자 추가 폼	
	function adminForm() {
		if($('#adminInsertBox').is(":visible")){
		     // display : none가 아닐 경우
			$('#adminInsertBox').css('display','none');
			return;
		}else{
		
			$('#adminInsertBox').css('display','block');
		}	
	}	
	//관리자 추가	
	$('#insert').submit(function () {
		var param=$('#insert').serialize();
		$.ajax({
			
			url : '${pageContext.request.contextPath}/insert',
		 	type : 'post',
		 	data : param,
		 	error : function (error) {
				alert(error);
			},success : function (data) {
				alert(data);
				if($('#adminInsertBox').is(":visible")){
				     // display : none가 아닐 경우
					$('#adminInsertBox').css('display','none');
				}
			}						
		});		
	});
	//게시판 추가 폼	
	function boardForm() {
		if($('#boardInsertBox').is(":visible")){
		     // display : none가 아닐 경우
			$('#boardInsertBox').css('display','none');
			return;
		}else{
		
			$('#boardInsertBox').css('display','block');
		}	
	}
	//게시판 추가
	$('#boardInsert').submit(function() {
		var param= $('#boardInsert').serialize();
		
		$.ajax({
			
			url : '${pageContext.request.contextPath}/boardInsert',
			type: 'post',
			data : param,
			error : function (error) {
				alert(error)
			},success : function (data) {
				//alert(data);
				$('#boardInsert')[0].reset();
				getList();
				if($('#boardInsertBox').is(":visible")){
				     // display : none가 아닐 경우
					$('#boardInsertBox').css('display','none');
				}
			}
						
		});				
		return false;
	});
	//원글의 idx값 바인딩
	function reBoard(idx){
		$('#o_no').val(idx);
		
		
		if($('#boardReInsertBox').is(":visible")){
		     // display : none가 아닐 경우
			$('#boardReInsertBox').css('display','none');
			return;
		}else{
		
			$('#boardReInsertBox').css('display','block');
		}		
	}
	//답글게시판 추가
	$('#boardReInsert').submit(function() {
		var param= $('#boardReInsert').serialize();
		
		$.ajax({
			
			url : '${pageContext.request.contextPath}/boardReInsert',
			type: 'post',
			data : param,
			error : function (error) {
				alert(error)
			},success : function (data) {
				//alert(data);
				getList();
				$('#boardReInsert')[0].reset();
			
				
				if($('#boardDeleteBox').is(":visible")){
				     // display : none가 아닐 경우
					$('#boardDeleteBox').css('display','none');
				
				}
			}						
		});
		return false;
	});
	
	
	
	//리스트봅아오기
	function getList() {
	$.ajax({
			
			url : '${pageContext.request.contextPath}/boardList',
			type: 'get',
			error : function (error) {
				alert(error)
			},success : function (data) {
				var html='';
				var boardCnt=allBoardCnt();
				var sp=' '; 
				//alert(boardCnt);
				for(var i=0;i<data.length;i++){
					
					//alert(data[i].b_depth*15);
				html +='<tr>';
				html +='<td>'+(boardCnt-i)+'</td>';
				html +='<td style="text-align:left"><a href="/tb/viewPage?idx='+data[i].b_idx+'">'
						+data[i].b_title+'&nbsp;&nbsp;&nbsp;&nbsp;['+data[i].b_commentCnt+']'
						+'&nbsp;&nbsp;&nbsp;&nbsp;['+data[i].b_rBoard+']</a></td>';			
				html +='<td>'+data[i].b_id+'</td>';
				html +='<td>'+data[i].b_date+'</td>';
				html +='<td><div class="btn-group btn-group-sm" role="group" aria-label="...">';
				html +='<button class="btn btn-default" onclick="reBoard('+data[i].b_idx+')">답글</button>'
				html +='<button class="btn btn-default" onclick="updateBoard('+data[i].b_idx+')">수정</button>'
				html +='<button class="btn btn-default" onclick="delBoard('+data[i].b_idx+')">삭제</button></div></td>';
				html +='</tr>';
				}
				$('#tableList').html(html);
			}	
			
		});
	}
	//총게시판 갯수가져오기
	function allBoardCnt() {
		var boardCnt='';
			$.ajax({
			
					url : '${pageContext.request.contextPath}/allBoardCnt',
					type: 'get',
					async: false,
					error : function (error) {
						alert(error)
					},success : function (data) {
						boardCnt=data;
						
					}	
			
		});
			return boardCnt;
	}
	
//수정 폼 출력 및 기존정보 바인딩	
function updateBoard(idx) {
		if($('#boardUpdateBox').is(":visible")){
			$('#boardUpdateBox').css('display','none');
			return;
		}else{
		
			$('#boardUpdateBox').css('display','block');
			$.ajax({
				url : '${pageContext.request.contextPath}/boardInfo/'+idx,
				type: 'get',
				async: false,
				error : function (error) {
					alert(error)
				},success : function (data) {
					//alert(data.b_id);
					$('#up_idx').val(data.b_idx);
					$('#up_id').val(data.b_id);
					$('#up_title').val(data.b_title);
					$('#up_contents').val(data.b_contents);
				}	
												
			});
		}
	}
	
	
//게시글 수정
$('#boardUpdate').submit(function() {
	var param= $('#boardUpdate').serialize();
	
	$.ajax({
		
		url : '${pageContext.request.contextPath}/boardUpdate',
		type: 'post',
		data : param,
		error : function (error) {
			alert(error)
		},success : function (data) {
			alert(data);
			
			getList();
			
			$('#boardUpdate')[0].reset();
			
			if($('#boardUpdateBox').is(":visible")){
			     // display : none가 아닐 경우
				$('#boardUpdateBox').css('display','none');
			
			}
		}
		
		
	});
	
	return false;
	
});
//삭제폼 출력 및 바인딩	
function delBoard(idx){
	if($('#boardDeleteBox').is(":visible")){
	     // display : none가 아닐 경우
		$('#boardDeleteBox').css('display','none');
		return;
	}else{
	
		$('#boardDeleteBox').css('display','block');
		
		$.ajax({

			url : '${pageContext.request.contextPath}/boardInfo/'+idx,
			type: 'get',
			async: false,
			error : function (error) {
				alert(error)
			},success : function (data) {
				//alert(data.b_id);
				$('#del_idx').val(data.b_idx);
				$('#del_id').val(data.b_id);
				$('#del_title').val(data.b_title);
			}	
											
		});
	}
		
}
//게시글 삭제
$('#boardDelete').submit(function() {
	
	var param= $('#boardDelete').serialize();
	$.ajax({
		
		url : '${pageContext.request.contextPath}/boardDelete',
		type: 'post',
		data : param,
		error : function (error) {
			alert(error)
		},success : function (data) {
			alert(data);
			
			getList();
			
			$('#boardDelete')[0].reset();
			
			if($('#boardDeleteBox').is(":visible")){
			     // display : none가 아닐 경우
				$('#boardDeleteBox').css('display','none');
			
			}
		}
		
		
	});
	
	
	
	return false;
	
});
	
	</script>
</body>
</html>