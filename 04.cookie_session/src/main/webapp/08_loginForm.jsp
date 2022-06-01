<!-- 0520 세션을 이용한 로그인처리 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 레이블 크기 맞추기 -->
<style>
	label { 
		display: inline-block;
		width: 80px;
	}
</style>
</head>
<body>
	
	<form method="post" action="08_testLogin.jsp">
		<label for="id"> 아이디 : </label>
		<input type="text" name="id" id="id"> <br>
		<label for="pwd"> 암  호 : </label>
		<input type="password" name="pwd" id="pwd"> <br>
		<input type="submit" value="로그인">


	</form>
	

</body>
</html>