<!-- 0519 param 태그 연습  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form method="post" action="08_jspParamTest.jsp">
		<label> 
		아이디 : <input type="text" name="id" >
		</label><br>
		<label> 
		암  호 : <input type="password" name="pwd">
		</label><br><br>
		<input type="radio" name="user_type" value="user" checked> 사용자
		<input type="radio" name="user_type" value="Manager"> 관리자
		<br><br>
		<input type="submit" value="로그인">

			
	</form>
</body>
</html>