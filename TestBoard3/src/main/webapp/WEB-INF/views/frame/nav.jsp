<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
	<nav class="navBar">
		<ul>	
			<li class="floatLeft"><a href="<c:url value="/board"/>">게시판</a></li>
			<li class="floatLeft"><a href="<c:url value="/subjectScore"/>">성적입력 및 수정</a></li>
			<li class="floatLeft"><a href="<c:url value="/totalScore"/>">성적 조회</a></li>
		</ul>
	</nav>