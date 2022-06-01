<!-- 0524 fmt:requestEncoding (자바의 post 인코딩과 동일한 역할) -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="23_setEncoding.jsp">
		<input type="text" name="name" id="name">
		<input type="submit" value="전송">
	</form>
</body>
</html>