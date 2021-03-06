<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 전체 목록</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
<div id="wrap">
<h1>상품 리스트 - 관리자 페이지</h1>
<table>	
	<tr>
		<td colspan="5" style="text-align: right; border:white;">
			<a href="productWrite.do">상품 등록</a>
		</td>
	</tr>
	<tr>
		<th>번호</th>
		<th>이름</th>
		<th>가격</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
	<c:forEach var="product" items="${productList}">
	<tr>
		<td class="item">${product.code}</td>
		<td>${product.name}</td>
		<td class="item">${product.price}원</td>
		<td class="item">
			<a href="productUpdate.do?code=${product.code}">상품 수정</a>
		</td>
		<td class="item">
			<a href="productDelete.do?code=${product.code}">상품 삭제</a>
		</td>
	</tr>
	</c:forEach>
</table>
</div>
</body>
</html>