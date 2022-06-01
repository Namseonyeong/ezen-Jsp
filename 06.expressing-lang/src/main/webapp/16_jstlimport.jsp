<!-- 0523 c:import를 이용하여 다른 페이지 내용을 포함시키기 ＊변수에 넣어서 여러번 사용 가능 -->
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
	<c:import url="02_elOperator.jsp" var="data"/>
~<br>
~<br>
~<br>
~<br>
~<br>
${data}
~<br>
~<br>
~<br>
~<br>
~<br>


</body>
</html>