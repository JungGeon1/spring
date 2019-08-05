<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>파일 업로드</h1>
	<h3>
	학번: ${sno}<br>
	리포트: ${fileName}(${fileSize}byte)
	
	
	</h3>
	<hr>
	<h1>커맨드로 한파일 업로드</h1>
	<h3>
	학번: ${report.sno}<br>
	리포트: ${report.fileName}(${report.fileSize}byte)
	사진:<br>
	<img src="<c:url value="/uploadfile" />/${report.fileName}" style="width: 500px;">
	
	</h3>
</body>
</html>