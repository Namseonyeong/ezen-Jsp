<!-- 0524 fmt:formtDate :날짜와 시간을 형식에 표현 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="now" value="<%= new java.util.Date() %>"/>
	\${now} : ${now}<br>
<!-- 	value=now(현재시간) type date=날짜, time:시간, both:날짜,시간 -->
	날짜 표시 : <fmt:formatDate value="${now}" type="date"/> <br>
	시간 표시 : <fmt:formatDate value="${now}" type="time"/> <br>
	날짜, 시간 표시 : <fmt:formatDate value="${now}" type="both"
					dateStyle="long" timeStyle="long"/> <br>
<!-- 	dateStyle="long" timeStyle="long" , short, medium, full 등은 표시되는 형식 -->
	pattern 사용 : <fmt:formatDate value="${now}" pattern="yyyy년 MM월 dd일 hh시 mm분 ss초"/>
</body>
</html>