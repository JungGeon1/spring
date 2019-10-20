<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div id="nav">
	
	<ul class="nav nav-tabs" role="navigation">
		
		<%-- <li role="presentation" id="nav2"><a href="<c:url value="/start"/>" title="로그인 후 이용 가능합니다">MAIN</a></li> --%>
		<c:if test="${admin_id eq null}">
		<li role="presentation" id="nav1"><a href="<c:url value="/myPage/start"/>" title="로그인 후 이용 가능합니다">START</a></li>
		</c:if>
		<li role="presentation" id="nav2"><a href="<c:url value="/pageList"/>" title="로그인 후 이용 가능합니다">PHOTO BOARD</a></li>
		<li role="presentation" id="nav3"><a href="<c:url value="/chat"/>" >CHATTING</a></li>
		<li role="presentation" id="nav3"><a href="<c:url value="/scrollList"/>" >GUEST BOOK</a></li>
		<li role="presentation" id="nav4"><a href="<c:url value="/youTube"/>">SEARCH VOIDEO</a></li>
		<li role="presentation" class="dropdown" id="dropDown">
  		  <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-expanded="false">SIGN <span class="caret"></span> </a>
 			<ul class="dropdown-menu" role="menu">
 				
 				<c:if test="${admin_id eq null}">	
 				<c:if test="${nbm_id eq null}">
     		 		<li><a href="<c:url value="/regist"/>">회원가입</a></li>
     		 	</c:if>
     		 		<c:if test="${nbm_id eq null}">
     		 			<li><a href="<c:url value="/login"/>">로그인</a></li>
     		 		</c:if>
     		 		<c:if test="${nbm_id  ne null}">
     		 			<li><a href="<c:url value="/myPage"/>">마이페이지</a></li>
     		 		</c:if>
     		 		<c:if test="${nbm_id  ne null}">
     		 			<li><a href="<c:url value="/logout"/>">로그아웃</a></li>
     		 		</c:if>
     		 	</c:if>
     		 	
     		 	
     		 	<c:if test="${nbm_id eq null}">	
     		 		<c:if test="${admin_id eq null}">
     		 			<li><a href="<c:url value="/login/admin"/>">관리자로그인</a></li>
     		 		</c:if>
     		 		<c:if test="${admin_id  ne null}">
     		 			<li><a href="<c:url value="/adminPage"/>">관리자페이지</a></li>
     		 		</c:if>
       		 		<c:if test="${admin_id  ne null}">
     		 			<li><a href="<c:url value="/logout"/>">로그아웃</a></li>
     		 		</c:if>
     		 		
     		 	</c:if>
    		</ul>
 		</li>
		
	</ul>
	
	
	
</div>