<!-- 0524 fmt:requestEncoding (자바의 post 인코딩과 동일한 역할) -->
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
<fmt:requestEncoding value="UTF-8"/> <%--request.setCharacterEncoding()와 같은 역할--%>
	이름 : <c:out value="${param.name}"/>
</body>
</html>