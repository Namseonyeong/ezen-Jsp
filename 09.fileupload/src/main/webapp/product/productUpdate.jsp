<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 수정</title>
<link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<div id="wrap">
	<h1>상품 수정 - 관리자 페이지</h1>
	<form method="post" enctype="multipart/form-data" action="productUpdate.do">
	<input type="hidden" name="code" value="${product.code}">
	<input type="hidden" name="noupdateImg" value="${product.pictureurl}">
	<table>
	<tr>
		<td>
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
				<td> <input type="text" name="name" value="${product.name}" id="name" size="50"> </td>
			</tr>
			<tr>
				<th>가 &nbsp;격</th>
				<td> <input type="text" name="price" value="${product.price}" id="price"> </td>
			</tr>
			<tr>
				<th>사 &nbsp;진</th>
				<td>
					<input type="file" name="pictureurl" id="prod_image"><br>
					(주의사항: 이미지를 변경하고자할 때만 선택하세요)
				</td>
			</tr>
			<tr>
				<th>설 &nbsp;명</th>
				<td>
					<textarea row="8" cols="50" name="description" id="description">${product.description}</textarea>
				</td>
			</tr>
		</table>
		</td>
	</tr>
	</table>
	<br>
	<div id="buttons">
		<input type="submit" value="수정" onclick="return productCheck()">
		<input type="reset" value="다시작성">
		<input type="button" value="목록" onclick="location.href='productList.do'">
	</div>
	</form>
	
	<script type="text/javascript" src="script/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="script/product.js"></script>
</div>
</body>
</html>






