<!-- 0524 상품정보 관리 페이지 (정보 입력받아 DB저장) 연습문제 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
label {
	display: inline-block;
	width: 75px;
}
.content {
	border : 1px #0000ff;
}
</style>
</head>
<body>
	<h2>정보 입력 폼</h2>
	<form method="get" action="itemWrite.jsp">
		<label>상품명</label> <input type="text" name="pname" size="20"><br>
		<label>가격</label> <input type="text" name="price" size="20"><br>
		<label id=a>설명</label>
		<textarea name="desc" rows="10" cols="50"></textarea>
		<br><br> 
		<input type="submit" value="전송">
		<input type="reset" value="취소">

	</form>

</body>
</html>