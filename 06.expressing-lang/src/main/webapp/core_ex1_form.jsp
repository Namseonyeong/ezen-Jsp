<!-- 0523 연산자를 클릭하여 c:if문으로 처리 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="core_ex1_test.jsp">
	<label for="op">연산자를 선택하세요:</label>
	<select name="operator" id="op">
		<option value="+">+</option>
		<option value="-">-</option>
		<option value="*">*</option>
		<option value="/">/</option>
	</select>
	<br><br>
	<label for="">두 수를 입력하세요:</label><br>
	숫자1: <input type="number" name="num1" id="num1"><br>
	숫자2: <input type="number" name="num2" id="num2">
	<br>
	<input type="submit" value="전송">
	</form>
</body>
</html>