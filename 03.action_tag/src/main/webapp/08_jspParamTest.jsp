<!-- 0519 param 태그 연습  -->
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import = "java.net.URLEncoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String userType = request.getParameter("user_type");

	
	System.out.println("id = " + id);
	System.out.println("pwd = " + pwd);
	System.out.println("user_type = " + userType);
	
	if (userType.equals("user")) {
%>
		<jsp:forward page="08_userMain.jsp">
			<jsp:param name ="user_name" value='<%= URLEncoder.encode("김고객", "UTF-8")%>'/>
		</jsp:forward>
<%	
	} else {
%>  	
		<jsp:forward page="08_managerMain.jsp">
			<jsp:param name ="user_name" value='<%= URLEncoder.encode("박관리", "UTF-8")%>'/>
		</jsp:forward>
<%
	}	
%>

			
</body>
</html>