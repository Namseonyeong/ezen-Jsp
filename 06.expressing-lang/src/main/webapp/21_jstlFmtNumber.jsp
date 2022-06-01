<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>숫자 형식 변환</h3>
	<fmt:formatNumber value="1234567.89"/><br>
	<fmt:formatNumber value="0.5" type="percent"/><br>
	<fmt:setLocale value="en_US"/> <%--로케일 코드--%>
	<fmt:formatNumber value="10000" type="currency" currencySymbol="￦"/><br> 
	<fmt:formatNumber value="123456789.123" pattern="#,#00.0#"/>
</body>
</html>