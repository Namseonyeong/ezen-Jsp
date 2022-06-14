<!-- 0602 영화목록  -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<div id="wrap" >
<h1>게시글 리스트</h1>
<table>
	<tr>
		<td colspan="5" style="border: white; text-align:right;">
			<a href="BoardServlet?command=board_write_form">게시글 등록</a>
		</td>
	</tr>
	<tr>
		<th>제목</th><th>감독</th><th>배우</th><th>가격</th><th>수정</th><th>삭제</th>
	</tr>
	<c:forEach var="movie" items="${movid_list}">
		<tr>
			<td>${movie.num}</td>
			<td><a href="MovieServlet?command=movie_view&num=${movie.num}">${movie.title}</a></td>
			<td>${movie.name}</td>
			<td><fmt:formatDate value="${movie.writedate}"/> </td>
			<td>${movie.readcount}</td>
		</tr>
	</c:forEach>
</table>
</div>
</body>
</html>