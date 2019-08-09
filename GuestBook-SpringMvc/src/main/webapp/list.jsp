<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<style>
div {
	border: 2px solid #666;
	width: 200px;
}

a {
	cusor: pointer;
}
a {
   text-decoration: none;
   color: black;
}

a:hover {
   background-color: black;
   color: white;
}

div {
   padding:10px;
   border: 1px solid #DDD;
   width: 200px;
   margin-bottom: 10px;
}

#page {
   padding:5px;
   border: 0;
   text-align: center;
}

#page a {
   display: inline-block;
   padding: 0 5px 0 0;
   cursor: pointer;
}

#wrap {
   border: 0;
   margin: auto;
}
</style>
</head>
<body>


	<H1>방명록</H1>

	<DIV style="text-align: right;">
		<a href="guest/writeForm">글쓰기</a>
	</DIV>


	<div id="list"></div>
	<div id="page"></div>

</body>


<script>
	$(document).ready(function() {

		page(1);

	});

	function page(num) {
		$.ajax({
			url : 'guest/listJson',
			type : 'get',
			data : {
				page : num
			},
			success : function(data) {
				//alert(data);
				//console.log(data);
				//alert(data.messageTotalCount);
				//alert(JSON.stringify(data));
				var output = '';
				var list = data.messageList;
				for (var i = 0; i < list.length; i++) {
					var id = list[i].id;
					var guestName = list[i].guestName;
					var message = list[i].message;

					output += '<div>\n';
					output += '메세지번호:' + id + '<br>\n';
					output += '손님이름:' + guestName + '<br>\n';
					output += '메세지:' + message + '\n';
					output += '</div>\n';

				}
				var paging = '';
				for (var j = 1; j < data.pageTotalCount + 1; j++) {

					paging += ' <span class="paging"><a onclick="page(' + j + ')">' + j + '</a></span> ';

				}
				//alert(output);
				//alert(paging);
				$('#list').html(output);
				$('#page').html(paging);
			}
		});

	}
</script>
</html>