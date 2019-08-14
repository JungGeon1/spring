<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="nav">
	<ul>
		<li><a href="<c:url value='/' />">홈</a></li>
		
		
		<c:if test="${loginInfo eq null}">
		<li><a href="<c:url value='/member/login' />">로그인 </a></li>
		</c:if>
		<c:if test="${loginInfo ne null}">
		<li><a href="<c:url value='/member/logout' />">로그아웃 </a></li>
		</c:if>
		<li><a href="<c:url value='/member/regist' />">회원가입</a></li>
		<li><a href="<c:url value='/member/mypage' />">MyPage</a></li>
														
		<li><a href="<c:url value='/member/memberList' />">회원리스트</a></li>
		<li><a href="<c:url value='/member/memberListJson' />">회원리스트제이슨</a></li>
		<li><a href="<c:url value='/member/memberListJson2' />">회원리스트제이슨엔띠띠</a></li>
		<%-- <li><a href="<c:url value='/member/logout.do' />">LOGOUT</a></li> --%>
	</ul>
	<%-- <ul>
		<li><a href="${pageContext.request.contextPath}">홈</a></li>
		<li><a href="${pageContext.request.contextPath}/member/login.jsp">로그인 </a></li>
		<li><a href="${pageContext.request.contextPath}/member/memberRegForm.jsp">회원가입</a></li>
		<li><a href="${pageContext.request.contextPath}/member/myPage.jsp">MyPage</a></li>
		<li><a href="${pageContext.request.contextPath}/member/memberList.jsp">회원리스트</a></li>
		<li><a href="${pageContext.request.contextPath}/member/logout.jsp">LOGOUT</a></li>
	</ul> --%>
</div>