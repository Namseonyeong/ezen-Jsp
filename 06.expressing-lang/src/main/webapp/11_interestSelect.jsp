<!-- 0523 c:choose 구현 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
span {
	color: blue;
}
</style>
</head>
<body>
	<h3>당신이 좋아하는 운동은</h3>
	<c:choose>
		<c:when test="${param.interest==1}">
			<span>수영</span>
		</c:when>
		<c:when test="${param.interest==2}">
			<span>헬스</span>
		</c:when>
		<c:when test="${param.interest==3}">
			<span>골프</span>
		</c:when>
	</c:choose>
</body>
</html>