<!-- 0524 c:out = value 속성에 지정한 문자열 혹은 변수의 내용 출력 -->
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
	<c:set var="age" value="30"/>
	<c:out value="${age}">
	10
	</c:out>
	
</body>
</html>