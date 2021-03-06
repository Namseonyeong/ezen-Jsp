<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 삭제</title>
<link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<div id="wrap">
	<h1>상품 삭제 - 관리자 페이지</h1>
	<form method="post" action="productDelete.do">
	<input type="hidden" name="code" value="${product.code}">
	<table>
	<tr>
		<td style="width: 300px;">
			<c:choose>
				<c:when test="${empty product.pictureurl}">
					<img src="upload/no_image.jpg">
				</c:when>
				<c:otherwise>
					<img src="upload/${product.pictureurl}">
				</c:otherwise>
			</c:choose>
		</td>
		<td>
		<table>
			<tr>
				<th>상품명</th>
				<td>${product.name}</td>
			</tr>
			<tr>
				<th>가 &nbsp;격</th>
				<td>${product.price}원 </td>
			</tr>
			<tr>
				<th>설 &nbsp;명</th>
				<td>
					<div style="height:200px; width:100%;">
					${product.description}
					</div>
				</td>
			</tr>
		</table>
		</td>
	</tr>
	</table>
	<br>
	<div id="buttons">
		<input type="submit" value="삭제">
		<input type="button" value="목록" onclick="location.href='productList.do'">
	</div>
	</form>
	
	<script type="text/javascript" src="script/product.js"></script>
</div>
</body>
</html>






