<!-- 0517 request객체 + 사용자에게서 아이디,나이값 받아오기-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파라메타 읽기</title>
<script type="text/javascript" src="js/param.js"></script>
</head>
<body>
<!-- 		★get방식은 URL에 입력한 값이 나타난다 ParamServlet = URL명 (java파일) -->
<!-- 	<form method="get" action="ParamServlet" name="frm">
		<label>
		아이디 : <input type="text" name="id" id="id">
		</label><br>
		<label>
		나이 : <input type="text" name="age" id="age">
		</label>
		<br><br>
		<input type="submit" value="전송" onclick="return check();">
	</form>
	 -->
	 
<!-- 	 	★Post 방식은 java파일에서 꼭 인코딩을 해줘야 함 -->
		<form method="post" action="ParamServlet" name="frm">
		<label>
		아이디 : <input type="text" name="id" id="id">
		</label><br>
		<label>
		나이 : <input type="text" name="age" id="age">
		</label>
		<br><br>
		<input type="submit" value="전송" onclick="return check();">
	</form>
</body>
</html>