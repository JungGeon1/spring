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
	.view{
		width: 1000px;
		height:300px;
		margin: 0 auto;
		border: 1px solid #ddd;
	}.center{
	
		text-align: center;
	}.commentBox {
	width: 1000px;
	margin: 0 auto;
	margin-top: 5px;
	}.commentListBox{
	width: 1000px;
	margin: 0 auto;
	margin-top: 5px;
	}.commentList{
	width: 1000px;
	margin: 0 auto;
	}.center{
	 text-align: center;
	}	#commentList td{
		padding: 10px;
		text-align: center;
		border-bottom: 1px solid #ddd;
	}#reCommentBox{
		display: none;
		
	}#commentUpdatetBox{
		display: none;
	}#commentDeleteBox{
		display: none;
	}
</style>
</head>
<body>
<div class="contentBox">

	
	<input type="text" value="${idx}" hidden="hidden">
	<h2 class="center">ViewPage</h2>
	<section class="view">
	<p id="v_idx"><b>번호&nbsp;:&nbsp;&nbsp;</b></p>
	<p id="v_id"><b>작성자&nbsp;:&nbsp;&nbsp;</b></p>
	<p id="v_title"><b>제목 &nbsp;:&nbsp;&nbsp;</b></p>
	<p id="v_date"><b>작성날짜 &nbsp;:&nbsp;&nbsp;</b></p>
	<p id="v_contents"><b>내용 &nbsp;:&nbsp;&nbsp;</b></p>
	</section>
	<div class="commentBox">
		<form id="commentInsert">
			<input type="text" name="c_bIdx" id="c_bIdx" hidden="" value="${idx}">
			<input type="text" style="width: 95px; height:40px;" placeholder="아이디"  name="c_id" id="c_id">
			<input type="text" style="width: 800px; height:40px;" placeholder="댓글을 입력해 주세요"  name="c_comment" id="comment">
			<button style="width: 95px ; height:40px;">OK</button>
		</form>
	</div>
	<div class="commentListBox">
	<table class="table table-hover">

      <caption>Board</caption>
   	 	 <colgroup>
			<col style="width: 120px;"/>
			<col  />
			<col style="width: 160px;"/>
			<col style="width: 200px;"/>
		</colgroup>
      <thead>
        <tr>
			<th class="center">Id.</th>
			<th class="center">Comment.</th>
			<th class="center">Date.</th>
			<th class="center">답글</th>
       </tr>
      </thead>
      <tbody id="commentList">
      </tbody>
      <tfoot>
       	<tr class="reCommentBox" id="reCmtBox">
			<td colspan="4">
				
			</td>
		</tr>
      </tfoot>
    </table>
	</div>
	<div id="reCommentBox" class="commentBox">
		<div id="reCommentText" style="margin-bottom: 20px;"></div>
		<form id="reCommentInsert">
			<input type="text" name="c_bIdx"   value="${idx}" hidden="">
			<input type="text" name="o_no" id="o_no" hidden="" >
			<input type="text" style="width: 95px; height:40px;" placeholder="아이디"  name="c_id">
			<input type="text" style="width: 800px; height:40px;" placeholder="답글을 입력해 주세요"  name="c_comment" >
			<button style="width: 95px ; height:40px;">OK</button>
		</form>
	</div>
	<div id="commentUpdatetBox" class="commentBox">
		<div id="commentUpdateText" style="margin-bottom: 20px;"></div>
		<form id="commentUpdate">
			<input type="text" name="c_idx" id="up_idx" hidden="" >
			<input type="text" style="width: 95px; height:40px;" placeholder="아이디" readonly="readonly" id="up_id" name="c_id">
			<input type="text" style="width: 700px; height:40px;"  name="c_comment" id="up_comment" >
			<input type="password" style="width: 95px; height:40px;"  name="c_pw" placeholder="PassWord">
			<button style="width: 95px ; height:40px;">OK</button>
		</form>
	</div>
	<div id="commentDeleteBox" class="commentBox">
		<div id="commentDeleteText" style="margin-bottom: 20px;"></div>
		<form id="commentDelete">
			<input type="text" name="c_idx" id="del_idx" hidden="" >
			<input type="text" style="width: 95px; height:30px;" placeholder="아이디" readonly="readonly" id="del_id" name="c_id">
			<input type="password" style="width: 130px; height:30px;"  name="c_pw" placeholder="PassWord">
			<button style="width: 65px ; height:30px;">OK</button>
		</form>
	</div>

</div>
<script type="text/javascript">
	
		$(document).ready(function () {
			getViewInfo();
			getList();
			
		});
	
		
		function getViewInfo() {
			
			$.ajax({

				url : '${pageContext.request.contextPath}/boardInfo/${idx}',
				type: 'get',
				async: false,
				error : function (error) {
					alert(error)
				},success : function (data) {
					//alert(data.b_id);
					$('#v_idx').append(data.b_idx);
					$('#v_id').append(data.b_id);
					$('#v_title').append(data.b_title);
					$('#v_date').append(data.b_date);
					$('#v_contents').append(data.b_contents);
				
				}	
												
			});
			
			
		}
		//댓글입력
		$('#commentInsert').submit(function() {
			var param= $('#commentInsert').serialize();
			
			$.ajax({
				
				url : '${pageContext.request.contextPath}/commentInsert',
				type: 'post',
				data : param,
				error : function (error) {
					alert(error)
				},success : function (data) {
					//alert(data);
					getList();
					
					}
							
			});				
			return false;
		});
		//원글의 idx값 바인딩
		function reComment(idx){
			$('#o_no').val(idx);
			if($('#reCommentBox').is(":visible")){
			     // display : none가 아닐 경우
				$('#reCommentBox').css('display','none');
				return;
			}else{
			
				$('#reCommentBox').css('display','block');
				$.ajax({
					url : '${pageContext.request.contextPath}/commentInfo/'+idx,
					type: 'get',
					async: false,
					error : function (error) {
						alert(error)
					},success : function (data) {
						var html='';
						html+=''+data.c_id+'님의&nbsp';
						html+=''+data.c_comment+'에&nbsp';
						html+='답글을 작성합니다.'
						$('#reCommentText').html(html);
					}	
													
				});
			}		
		}
		
		
		//답글 추가
		$('#reCommentInsert').submit(function() {
			var param= $('#reCommentInsert').serialize();
			
			$.ajax({
				
				url : '${pageContext.request.contextPath}/commentReInsert',
				type: 'post',
				data : param,
				error : function (error) {
					alert(error)
				},success : function (data) {
					//alert(data);
					getList();
					$('#reCommentInsert')[0].reset();
				
					
					if($('#reCommentBox').is(":visible")){
					     // display : none가 아닐 경우
						$('#reCommentBox').css('display','none');
					
					}
				}						
			});
			return false;
		});
		
		
		
		//리스트봅아오기
		function getList() {
		$.ajax({
				
				url : '${pageContext.request.contextPath}/commentList/${idx}',
				type: 'get',
				error : function (error) {
					alert(error)
				},success : function (data) {
					var html='';
					
		
					for(var i=0;i<data.length;i++){
						
					html +='<tr>';
					html +='<td>'+data[i].c_id+'</td>';
					html +='<td style="text-align:left">'+data[i].c_comment+'</td>';	
					html +='<td>'+data[i].c_date+'</td>';
					html +='<td><div class="btn-group btn-group-xs" role="group" aria-label="...">';
					html +='<button class="btn btn-default" onclick="reComment('+data[i].c_idx+')">답글</button>';
					html +='<button class="btn btn-default" onclick="updateComment('+data[i].c_idx+')">수정</button>';
					html +='<button class="btn btn-default" onclick="delcomment('+data[i].c_idx+')">삭제</button></div></td>';
					html +='</tr>';
					
				
					}
					$('#commentList').html(html);
				}	
				
			});
		}
		
	
		
		
		
		
		
		
	//수정 폼 출력 및 기존정보 바인딩	
	function updateComment(idx) {
		if($('#commentUpdatetBox').is(":visible")){
		     // display : none가 아닐 경우
			$('#commentUpdatetBox').css('display','none');
			return;
		}else{
		
			$('#commentUpdatetBox').css('display','block');
			$.ajax({
				url : '${pageContext.request.contextPath}/commentInfo/'+idx,
				type: 'get',
				async: false,
				error : function (error) {
					alert(error)
				},success : function (data) {
					var html='';
					html+=''+data.c_id+'&nbsp;님의&nbsp;';
					html+=''+data.c_comment+'&nbsp;댓글';
					html+='을 수정합니다.'
					$('#commentUpdateText').html(html);
					$('#up_idx').val(data.c_idx);
					$('#up_id').val(data.c_id);
					$('#up_comment').val(data.c_comment);
				}	
												
			});
		}
		}
		
		
	//게시글 수정
	$('#commentUpdate').submit(function() {
		var param= $('#commentUpdate').serialize();
		
		$.ajax({
			
			url : '${pageContext.request.contextPath}/commentUpdate',
			type: 'post',
			data : param,
			error : function (error) {
				alert(error)
			},success : function (data) {
				alert(data);
				
				getList();
				
				$('#commentUpdate')[0].reset();
				
				if($('#commentUpdatetBox').is(":visible")){
				     // display : none가 아닐 경우
					$('#commentUpdatetBox').css('display','none');
				
				}
			}
			
			
		});
		
		return false;
		
	});
	//삭제폼 출력 및 바인딩	
	function delcomment(idx){
		if($('#commentDeleteBox').is(":visible")){
		     // display : none가 아닐 경우
			$('#commentDeleteBox').css('display','none');
			return;
		}else{
		
			$('#commentDeleteBox').css('display','block');
			
			$.ajax({

				url : '${pageContext.request.contextPath}/commentInfo/'+idx,
				type: 'get',
				async: false,
				error : function (error) {
					alert(error)
				},success : function (data) {
					var html='';
					html+=''+data.c_id+'&nbsp;님의&nbsp;';
					html+=''+data.c_comment+'&nbsp;댓글';
					html+='을 삭제합니다.'
					$('#commentDeleteText').html(html);
					$('#del_idx').val(data.c_idx);
					$('#del_id').val(data.c_id);
				
				}	
												
			});
		}
			
	}
	//게시글 삭제
	$('#commentDelete').submit(function() {
		if(confirm('삭제하시겠습니까?')){
		var param= $('#commentDelete').serialize();
		$.ajax({
			
			url : '${pageContext.request.contextPath}/commentDelete',
			type: 'post',
			data : param,
			error : function (error) {
				alert(error)
			},success : function (data) {
				alert(data);
				
				getList();
				
				$('#commentDelete')[0].reset();
				
				if($('#commentDeleteBox').is(":visible")){
				     // display : none가 아닐 경우
					$('#commentDeleteBox').css('display','none');
				
					}
				}
			
			
			});
		return false;
		}else{			
		return;
		}		
		
	});
	</script>
</body>
</html>