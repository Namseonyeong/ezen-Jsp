<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>당신이 선택한 항목입니다.</h3>
	<hr>
	<c:forEach var="item" items="${paramValues.interest}" varStatus="status">
	${item}
	<c:if test="${not status.last}">,</c:if>
	</c:forEach>
</body>
</html>