<!-- 0523 연산자를 클릭하여 c:if문으로 처리 -->
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
	<c:set var="op" value="${param.operator}"/>
	<c:set var="num1" value="${param.num1}"/>
	<c:set var="num2" value="${param.num2}"/>
	
	<b>입력 값: </b>${num1}, ${num2}<br>
	<c:if test="${op == '+'}">
		<b>계산 결과: </b>${num1} + ${num2} = ${num1 + num2}<br>
	</c:if>
	<c:if test="${op == '-'}">
		<b>계산 결과: </b>${num1} - ${num2} = ${num1 - num2}<br>
	</c:if>
	<c:if test="${op == '*'}">
		<b>계산 결과: </b>${num1} * ${num2} = ${num1 * num2}<br>
	</c:if>
	<c:if test="${op == '/'}">
		<b>계산 결과: </b>${num1} / ${num2} = ${num1 / num2}<br>
	</c:if>
</body>
</html>