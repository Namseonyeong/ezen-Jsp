<!-- 0520 세션을 이용한 로그인처리 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	session.invalidate(); // 세션 제거
%>
  <!-- 	로그아웃 경고창  -->
<script type="text/javascript">  
	alert("로그아웃 되었습니다!");
	// 로그인 폼으로 이동 : 특별한 데이터가 없어서 바로 loginForm으로 이동가능 함
	location.href="08_loginForm.jsp"; 
</script>
</body>
</html>