<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<script src="https://code.jquery.com/jquery-1.12.4.js" ></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<!-- 소켓연결 -->
<script src="http://localhost:82/socket.io/socket.io.js"></script>
<link href="css/bootstrap.css" rel="stylesheet" />
<link href="css/coming-sssoon.css" rel="stylesheet" />
<link href="<c:url value="/css/nbCss.css"/>" rel="stylesheet" />
<!--     Fonts     -->
<link href="https://fonts.googleapis.com/css?family=Lobster&display=swap" rel="stylesheet">
<link href="http://netdna.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.css" rel="stylesheet">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="UTF-8">



<title>Insert title here</title>
<style>
#header {
	text-align: center;
}

.chatBox{
width: 800px;
height: 100%;
margin: 0 auto;
text-align: center;
}

.chattingTable{
margin: 0 auto;
}
.textWidthChatBox{

width: 800px;
height: 450px;
border: 2px solid #ddd;
overflow: scroll;
text-align: left;
padding: 5px;
}
.textWidthLarge{
width: 100%;
}



td{
	padding: 5px;
} 

</style>
</head>
<body>


<%@include file="/WEB-INF/views/frame/header.jsp" %>


<%@include file="/WEB-INF/views/frame/nav.jsp" %>

<div id="contents">

	
<div class="chatBox">								

									
<table class="chattingTable">
<tr>
	<td><h1>CHATTING</h1><td>
</tr>
<tr>
	<td><div class="textWidthChatBox" id="chat_box"></div><td>
</tr>
<tr>
	<td><input class="form-control textWidthLarge" type="text" id="msg"  required placeholder="내용을 입력해 주세요"><td>
</tr>
<tr>
	<td><input  type="button"  class="btn btn-default btn-sm" id="msg_process" value="전송" ><td>
</tr>


</table>

	
</div>							
								
</div>

<%@include file="/WEB-INF/views/frame/footer.jsp" %>
<script>
$(document).ready(function(){
    var socket = io("http://localhost:82");
    
    
    userJoin();
    
  //접속했을 떄
    function userJoin() {
	  if('${admin_id}'!=''){ 
		  socket.emit("userJoin", '${admin_id}관리자님이 접속하셨습니다.');
		  }else{
    	   socket.emit("userJoin", '${nbm_id}님이 접속하셨습니다.');
    }
}
    
    //msg에서 키를 누를떄
    $("#msg").keydown(function(key){
        //해당하는 키가 엔터키(13) 일떄
        if(key.keyCode == 13&&$("#msg").val()!=''){
            //msg_process를 클릭해준다.
            msg_process.click();
        }
    });
    
    //msg_process를 클릭할 때
    $("#msg_process").click(function(){
        //소켓에 send_msg라는 이벤트로 input에 #msg의 벨류를 담고 보내준다.
         socket.emit("send_msg", $("#msg").val());
        //#msg에 벨류값을 비워준다.
        $("#msg").val("");
    });
    
    
    //소켓 서버로 부터 userJoin을 통해 이벤트를 받을 경우 
    socket.on('userJoin', function(msg) {
        //div 태그를 만들어 텍스트를 msg로 지정을 한뒤 #chat_box에 추가를 시켜준다.
       	//alert(msg);
        var html=''
 		html+='<div>'+msg+'</div>';
        $("#chat_box").append(html);
        
    });
    //소켓 서버로 부터 send_msg를 통해 이벤트를 받을 경우 
    socket.on('send_msg', function(msg) {
        //div 태그를 만들어 텍스트를 msg로 지정을 한뒤 #chat_box에 추가를 시켜준다.
       	//alert(msg);
        var html=''
        html+='<div>';
        
        if('${admin_id}'!=''){ 
        html+='<h6>${admin_id}관리자님</h6>'
        }else{
        html+='<h6>${nbm_id}님</h6>'
        }
        html+='<class="textWidthLarge" div>'+msg+'</div>';
        html+='</div>';
        $("#chat_box").append(html);
        //$('<div></div>').text(msg).appendTo("#chat_box");
    });




});

 


</script>
</body>
</html>







	
	

