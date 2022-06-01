<!-- 0523 c:forEach end,begin, step 예제 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table th {
	width: 80px;
}

table td {
	text-align: center;
}
</style>

</head>
<body>
	<h3>JSTL forEach 연습</h3>
	<c:forEach begin="1" end="10" var="cnt" varStatus="status">
	${cnt}
	<c:if test="${not status.last}">,</c:if>
	</c:forEach>
	<br>
	<br>
	<table border="1">
		<tr>
			<th>index</th>
			<th>count</th>
			<th>cnt</th>
		</tr>
		<c:forEach begin="7" end="10" var="cnt" varStatus="status">
			<tr>
				<td>${status.index}</td>
				<td>${status.count}</td>
				<td>${cnt}</td>
			</tr>
		</c:forEach>

	</table>
	<br>
	<br>
	<table border="1">
		<tr>
			<th>index</th>
			<th>count</th>
			<th>cnt</th>
		</tr>
		<c:forEach begin="1" end="10" step="2" var="cnt" varStatus="status">
			<tr>
				<td>${status.index}</td>
				<td>${status.count}</td>
				<td>${cnt}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>