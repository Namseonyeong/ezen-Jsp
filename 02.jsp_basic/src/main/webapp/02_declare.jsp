<!-- 0518 자바 선언문  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP 선언문</title>
</head>
<body>
	<!-- HTML의 주석 /브라우저에서 F12하면 보인다 -->
	<%-- JSP의 선언문 /브라우저에서 F12하면 안보인다--%>
	<%-- JSP의 선언문 : 공통적으로 사용하는 변수, 메소드를 주로 사용--%>
	<%!
		String str = "안녕하세요!";
		
		int a = 5, b = -5;		
		//절대값을 반환하는 메소드
		public int abs(int n) {
			if(n<0) {
				n = -n;
			}
			return n;
		}
	%>
	<%-- JSP의 스크립트릿 : 로컬변수와 같다고 생각하면 된다. 이곳에서만 사용 가능  --%>
	<%
		out.print(str + "<br>");
		out.print(a + "의 절대값 = " + abs(a) + "<br>");
		out.print(b + "의 절대값 = " + abs(b) + "<br>");
	%>
</body>
</html>