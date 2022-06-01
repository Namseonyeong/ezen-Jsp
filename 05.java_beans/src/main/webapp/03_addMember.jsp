<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	label {
		display : inline-block;
		width: 70px;
		font-weight: bold;
	}
</style>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");
	
	
%>
<!-- 자바빈 객체 생성 -->
	<jsp:useBean id="member" class="com.ezen.javabeans.MemberBeans"/>
	
<!-- property에 + 를 써주면 화면의 각 필드의 내용이 자바빈의 필드에 자동 저장됨 -->
	<jsp:setProperty property="*" name="member"/>
	
	<h3>입력 완료된 회원정보</h3>
	<label for="">이름</label>
	<jsp:getProperty property="name" name="member"/><br>
	<label for="">아이디</label>
	<jsp:getProperty property="userid" name="member"/><br>
	<label for="">별명</label>
	<jsp:getProperty property="nickname" name="member"/><br>
	<label for="">비밀번호</label>
	<jsp:getProperty property="pwd" name="member"/><br>
	<label for="">이메일</label>
	<jsp:getProperty property="email" name="member"/><br>
	<label for="">전화번호</label>
	<jsp:getProperty property="phone" name="member"/><br>
	
	
	
	
	
</body>
</html>