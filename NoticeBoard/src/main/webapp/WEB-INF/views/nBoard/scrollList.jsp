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
<!-- include summernote css/js-->
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.8/summernote.js"></script>
<script src="lang/summernote-ko-KR.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

#contentswrap {
width: 100%;
height: 100%:

}
#contents {
	width: 60%;
	margin: 0 auto;
	height: 100%;
	 
}

.li {
	float: right;
	padding-right: 40px;
}

.both {
	clear: both;
}

.itemBox{
	width: 100%;
	word-break: break-all;
	border-bottom  :2px solid #ddd;
	/* background-color: #ddd; */
	margin :0 auto;
	margin-bottom: 20px;
	padding: 20px;
	
}
.btnWidth{
width: 100%;
}
#MOVE_TOP{
	color :#f39c12;
  	text-decoration: none;
    position: fixed;
    right: 2%;
    bottom: 30px;
    display: none;
    font-size:80px;  
 
}#updateBox{
display: none;
}#insertBox{
display: none;
}#insertClose{
display: none;
}#updateClose{
display: none;
}
#lodingBox{

	text-align: center;
	display: none;
}
</style>
</head>
<body>


	<%@include file="/WEB-INF/views/frame/header.jsp"%>


	<%@include file="/WEB-INF/views/frame/nav.jsp"%>

<div id="contentswrap">
<div id="contents">
		
<c:if test="${nbm_id  ne null}">
	<button id="insetBtn" class="btn btn-default btnWidth">INSERT</button>
</c:if>
	<button id="insertClose" class="btn btn-default btnWidth" >IN_CANCLE</button>
	<button id="updateClose" class="btn btn-default btnWidth">UP_CANCLE</button>


<div id="insertBox">
	<form id="insertForm">
		<table>
			<tr>
				<td><input type="text"  id="category" name="category" value="${category}" hidden> </td>
			</tr>
			
			<tr>
				
				<td><input type="text"  id="u_id" name="u_id" class="form-control" required placeholder="작성자" value="${nbm_id}" readonly="readonly"> </td>
			</tr>
			
			<tr>
				
				<td><input type="text" id="u_title" name="u_title" class="form-control" required placeholder="제목을 입력해주세요"> </td>
			</tr>
			<tr>
				
				<td><textarea id="u_contents"  name="u_contents" placeholder="내용을 입력해주세요"></textarea></td>
			</tr>
			
			<tr>
				<td><input type="submit" class="btn btn-default btnWidth" value="OK"> </td>
			</tr>
		</table>
	</form>
	
</div>
<div id="updateBox">
<h1>UPDATE</h1>

<form id="updateForm">
		
		<table>
			<tr>
				<td><input id="up_idx" name="idx" type="text" class="form-control" readonly="readonly" ></td>
			</tr>
			<tr>
				<td><input type="text"  id="up_category" name="category" value="${category}" hidden=""> </td>
			</tr>
			
			<tr>
				
				<td><input type="text"  id="up_id" class="form-control" name="u_id" required placeholder="작성자"  readonly="readonly"> </td>
			</tr>
			
			<tr>
				
				<td><input type="text" id="up_title" class="form-control" name="u_title" required placeholder="제목을 입력해주세요"> </td>
			</tr>
			<tr>
				
				<td><textarea id="up_contents" name="u_contents" placeholder="내용을 입력해주세요"></textarea></td>
			</tr>
			
			<tr>
				 <td><input type="submit" class="btn btn-default btnWidth" value="OK"> </td>
			</tr>
		</table>
	</form>
</div>	
	
		<div id="scrollList"></div>
			<div id="lodingBox" >
				<img alt="lonig" width="100px;" src="/nb/images/loding.gif">
			</div>



		
</div>
</div>
	<%@include file="/WEB-INF/views/frame/footer.jsp"%>
	<a id="MOVE_TOP" href="#">TOP</a>
<script>



$(document).ready(function(){
	var p=1;
	var totalPage=paging();
	scrollList(p);
	//무한스크롤 이벤트	
	
	        $(window).scroll(function(){
	            let $window = $(this);
	            let scrollTop = $window.scrollTop();
	            let windowHeight = $window.height();
	            let documentHeight = $(document).height();
	            
	            console.log("documentHeight:" + documentHeight + " | scrollTop:" + scrollTop + " | windowHeight: " + windowHeight );
	            
	            
	            if( scrollTop + windowHeight + 30 > documentHeight && p<=totalPage){
	            	$('#lodingBox').css('display','block');
	            	setTimeout(function(){
	            			p++;
	            			$('#lodingBox').css('display','none');
	            			scrollList(p); 
	            		}, 2000);
	            
	            	
	            }
	        });
	       

	
	
	
	
	
		$('#u_contents').summernote({
	         height: 300,                 // set editor height
	         minHeight: null,             // set minimum height of editor
	         maxHeight: null,             // set maximum height of editor
	         focus: true,                  // set focus to editable area after initializing summernote
	         lang: 'ko-KR', // 언어 세팅
	         
	    
	 });
		 $('#up_contents').summernote({
	         height: 300,                 // set editor height
	         minHeight: null,             // set minimum height of editor
	         maxHeight: null,             // set maximum height of editor
	         focus: true,                  // set focus to editable area after initializing summernote
	         lang: 'ko-KR', // 언어 세팅
	         
	    
	 });
	
});
	/* 스크롤 top 이벤트 */
	$(window).scroll(function (){
		if($(this).scrollTop()>500){
			$('#MOVE_TOP').fadeIn();
		}else{
			$('#MOVE_TOP').fadeOut();
		}
	});	
	$('#MOVE_TOP').click(function() {
		$('html,body').animate({
			scrollTop :0
		},500);
		return false;
	});
	//전체 페이지 갯수 가져오기
	function paging() {
		var totalPage=0;
		$.ajax({
			url:'${pageContext.request.contextPath}/rest/pCount?category=${category}&stype=&keyword=',
			type:'GET',
			//페이지값리턴을 위해 동기로 변경
			async:false,
			error : function (error) {
				alert(error);
			},success: function(data) {
				totalPage=data;
			}
			
		});
		return totalPage;
	}	
//페이지번호로 해당 페이지의 리스트를 뿌려준다	
function scrollList(pNumber) {

	$.ajax({
		url : '${pageContext.request.contextPath}/rest/pList?p='+pNumber+'&category=${category}&stype=&keyword=',
		type: 'GET',
		error : function(error) {
			alert(error);
		},success : function(data){
			   var html = '';
			  
			  		
                for(var i=0; i<data.length;i++){
                	html += '<div class="itemBox wordBreak">';
                    html += '<div>No. '+(data[i].pListCnt-i)+'</div>';                
                    html += '<div>Id. '+data[i].u_id+'</div>';              
                    html += '<div>Title. '+data[i].u_title+'</div>';                  
         	        html += '<div>Date. '+data[i].u_date+'</div>';
         	        html += '<div>Contents. '+data[i].u_contents+'</div>';
           	        html += '<c:if test="${admin_id ne null}"><div><button onclick="adminDelete('+data[i].idx+')" class="adminBtnRight btn btn-default btn-sm">괸리자 삭제</button></div></c:if>'

         	      if(data[i].u_id=='${nbm_id}'){
         	        html += '<div><button class="btn btn-default btnWidth" onclick="update('+data[i].idx+')">UPDATE</button><button class="btn btn-default btnWidth" onclick="deleteBoard('+data[i].idx+') ">DELETE</button></div>';
         	      }  
         	      
         	      html += '</div>';
                }
                
                $('#scrollList').append(html);
		}
		
	});
	
	return false;
	
}
//버튼들을 바꿔준다
$('#insetBtn').click(function () {
	$('#insertBox').css('display','block');
	$('#insertClose').css('display','block');
	$('#insetBtn').css('display','none');
});

$('#insertClose').click(function () {
	$('#insertBox').css('display','none');
	$('#insertClose').css('display','none');
	$('#insetBtn').css('display','block');
	
});
$('#updateClose').click(function () {
	$('#updateBox').css('display','none');
	$('#updateClose').css('display','none');
	$('#insetBtn').css('display','block');
	
});
// 게시글 입력
$('#insertForm').submit(function() {
	var formData = new FormData();

	formData.append('u_id', $('#u_id').val());
	formData.append('u_title', $('#u_title').val());
	formData.append('u_contents', $('#u_contents').val());
	formData.append('category', $('#category').val());
	$.ajax({
		url:'rest',
		type:'post',
		data : formData,
		processData : false, //파일 전송 시 필수
		contentType : false, //파일 전송 시 필수
		success : function (data) {
			alert('등록되었습니다.');
			location.href = '/nb/scrollList?category=${category}';
		
		}
		
		
	});
	return false;
})
//게시글 삭제
	function deleteBoard(idx) {

		
			if (confirm('삭제하시겠습니까')) {
				$.ajax({
					url : '${pageContext.request.contextPath}/rest/delete/' + idx,
					type : 'delete',
					error : function(error) {
						alert(error);
					},
					success : function(data) {
						alert('삭제되었습니다.');
						location.href = '/nb/scrollList?category=${category}';
					}

				});

			}
		}
//게시글 수정		
$('#updateForm').submit(function() {

	if (confirm('수정하시겠습니까?')) {
		var formData = new FormData(); // 파일 전송 -> FormData()활용
		formData.append('idx', $('#up_idx').val());
		formData.append('u_id', $('#up_id').val());
		formData.append('u_title', $('#up_title').val());
		formData.append('u_contents', $('#up_contents').val());
		formData.append('category', $('#up_category').val());

		

		$.ajax({
			url : '/nb/rest/update',
			type : 'post',
			data : formData,
			processData : false, //파일 전송 시 필수
			contentType : false, //파일 전송 시 필수
			erorr : function (error) {
				alert(error);
			},
			success : function(data) {
				//alert(data);
				if (data == 'success') {
					alert('수정되었습니다');
					location.href = '/nb/scrollList?category=${category}';
				}else{
					alert('실패');
				}
			}

		});

	}
	return false;
})		
//수정할 글의 정보를 바인딩
function update(idx) {

			$.ajax({
						url : '${pageContext.request.contextPath}/rest/viewPage?category=${category}l&idx=' + idx,
						type : 'GET',
						error : function(error) {
							alert(error);
						},
						success : function(data) {
							$('#insetBtn').css('display','none');
							$('#updateClose').css('display','block');
							$('#updateBox').css('display','block');
								
							
							$('#up_id').val(data.u_id);
							$('#up_title').val(data.u_title);
							//$('#u_contents').val(data.u_contents); 
							$('#up_contents').summernote('editor.insertText',data.u_contents);
							$('#up_idx').val(data.idx);
							
							$('html,body').animate({
								scrollTop :0
							},500);
						}

					});

			return false;

		}
	//관리자 권한으로 삭제
function adminDelete(idx) {
	if(confirm('관리자의 권한으로 삭제하시겠습니까?.')){
		$.ajax({
			
			url : '${pageContext.request.contextPath}/adminBoard/boardDelete',
			type : 'post',
			data : {
				idx : idx,
				category : '${category}',
			
			},error : function (data) {
				alert(data);
			},success : function (data) {
				//alert(data);
				
				if(data=='success'){
					
					alert('삭제되었습니다.');
					location.href='${pageContext.request.contextPath}/scrollList?category=${category}';
				}
			}
			
		});
		
	}
	
}	
//async:false-> 비동기 통신을 동기적으로 사요ㅕㅇ
</script>
</body>
</html>