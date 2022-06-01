<!-- 0520 게시글 처리 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
	form { 
	width: 700px;
	height: 700px;
	border: 1px solid gray;
	}
	</style>
</head>
<body>
<!-- 	자바빈 객체 생성 -->
    <jsp:useBean id="member" class="com.ezen.javabeans.BoardBean"/>
	

	

<jsp:useBean id="board" class="com.ezen.javabeans.BoardBean"/>
	
	<jsp:setProperty property="*" name="board"/>
	
	<h2>입력 완료된 정보</h2>
	<form method="post" action="04_boardWriteForm.jsp">
	<label for="">작성자 : </label>
	<jsp:getProperty property="name" name="board"/><br>
	<label for="">비밀번호 :</label>
	<jsp:getProperty property="pass" name="board"/><br>
	<label for="">이메일 :</label>
	<jsp:getProperty property="email" name="board"/><br>
	<label for="">글 제목 :</label>
	<jsp:getProperty property="title" name="board"/><br>
	<label for="">글 내용 :</label>
	<jsp:getProperty property="content" name="board"/><br>
		

		
		

	</form>

</body>
</html>