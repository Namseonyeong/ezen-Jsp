<!-- 0523 c태그 자바 for문과 같은 속성의 c:forEach -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String[] movieList = {"타이타닉", "범죄의 도시", "닥터 스트레인지", "킹콩", "파칭코"};
	pageContext.setAttribute("movieList", movieList);
%>
<c:forEach var="movie" items="${movieList}">
${movie}<br>
</c:forEach>

<!-- varStatus 사용하는 forEach -->
<c:forEach var="movie" items="${movieList}" varStatus="status">
	${status.index} &nbsp; <%-- 배열의 인덱스와 같은 의미 --%>
	${status.count} &nbsp; <%-- 반복 횟수 --%>
	${movie}<br>
</c:forEach>

<!-- varStatus의 first, last 마지막 단어에는 , 안찍기 -->
<c:forEach var="movie" items="${movieList}" varStatus="status">
	${movie}
	<c:if test="${not status.last}">,</c:if>
</c:forEach> <br><br>

<!-- begin, end, step 속성을 가진 forEach -->
<!-- var: 변수, begin:시작값, end:끝값 step:반복마다 증가값 -->
<c:forEach var="i" begin="1" end="10" step="2">
 ${i}<br>
</c:forEach>



</body>
</html>