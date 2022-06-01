<!-- 0519 액션태그 forward -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>액션 태그 : jsp:forward</title>
</head>
<body bgcolor="red">
<!-- 		URL은 그대로지만 forward로 yellow를 불러왔기때문에 yellow가 호출됨 -->
	이 파일은 red.jsp입니다. forward가 표시되면 이 페이지는 표시되지 않습니다.
	<jsp:forward page="07_yellow.jsp"></jsp:forward>

</body>
</html>