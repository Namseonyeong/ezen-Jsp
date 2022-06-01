<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.Calendar" %>
<%@ page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>page 지시자 import 속성</title>
</head>
<body>
	<%
		//Calender (클래스) - 상단의 import를 기재하여 사용
		
		Calendar date = Calendar.getInstance(); // 현재 시각을 얻는다
		// 원하는 형식으로 표현하기 위한 객체 생성
		SimpleDateFormat today = new SimpleDateFormat("yyyy년 MM월 dd일");
		SimpleDateFormat now = new SimpleDateFormat("hh시 mm분 ss초");
	%> 
	오늘은 <b><%= today.format(date.getTime()) %></b> 입니다.<br>
	지금 시각은 <b><%= now.format(date.getTime()) %></b> 입니다.
</body>
</html> 