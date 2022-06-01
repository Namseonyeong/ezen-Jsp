<!-- 0520 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>pwd 쿠키 삭제</h3>
<%
// --> new 라고 객체를 새로 생성한 이유는 쿠키데이터를 저장할 메모리를 생성하기 위해.
// --> Remove 에서 new("1","") 는 객체를 새로생성하는게 아니고 new("1") 값을 찾아오라는 뜻.
// -->("pwd",""): "," 이전은 값이 같은데 그 이후에 값이 있으면 그값을 저장후 갱신,
//               없으면 다음줄로 넘어가서 "," 앞에 해당하는 값의 안에 정보를 수정하거나 삭제.

// 	삭제할때 ""안에 공백을 넣지말고 붙여서 쓸것, 공백이 들어가면 오류
// -->("pwd",""): "," 이전은 값이 같은데 그 이후에 값이 있으면 그값을 저장후 갱신,
//      없으면 다음줄로 넘어가서 "," 앞에 해당하는 값의 안에 정보를 수정하거나 삭제.
	Cookie c = new Cookie("pwd", "");
	c.setMaxAge(0); 
	response.addCookie(c);
	// --> new를 하고 add를 안하면 저장이 안됨.
%>
<a href="02_getCookies.jsp">쿠키 목록 확인</a>

</body>
</html>