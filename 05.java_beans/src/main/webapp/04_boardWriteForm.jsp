<!-- 0520 게시글 입력, 게시글 처리 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style>
table {
	border-collapse: collapse;
}

 label { 
	display: inline-block; 
	width: 70px; 
	font-weight: bold; 
 	background-color: gray; 
 	text-align : center;
 	border-bottom: 1px solid white;
 	
 }
 #story 

</style>
</head>
<body>

	
    	<h2>게시판 글쓰기</h2>
		<form method="post" action="04_boardWrite.jsp">
			<label class=all>작성자</label> <input type="text" name="name"
				id="name" size="20"><br> <label class=all>비밀번호</label>
			<input type="text" name="pass" id="pass" size="20"><br>
			<label class=all>이메일</label> <input type="text" name="email"
				id="email" size="20"><br> <label class=all>글 제목</label>
			<input type="text" name="title" id="title" size="20"><br>
			<label id="story">글 내용</label>
			<textarea rows="20" cols="60" name="content" id="content"></textarea>
		<textarea name="content" rows="10" cols="50"></textarea>
			<div>
				<input type="submit" value="등록"> &nbsp; &nbsp; <input
					type="reset" value="다시작성">
			</div>


		</form>
</body>
</html>