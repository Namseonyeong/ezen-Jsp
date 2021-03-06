<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록</title>
<link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<div id="wrap">
	<h1>상품 등록 - 관리자 페이지</h1>
	<form method="post" enctype="multipart/form-data" action="productWrite.do">
	<table>
		<tr>
			<th>상품명</th>
			<td> <input type="text" name="name" id="name" size="50"> </td>
		</tr>
		<tr>
			<th>가 &nbsp;격</th>
			<td> <input type="text" name="price" id="price"> </td>
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
				<textarea row="8" cols="50" name="description" id="description"></textarea>
			</td>
		</tr>
	</table>
	<br>
	<div id="buttons">
		<input type="submit" value="등록" onclick="return productCheck()">
		<input type="reset" value="취소">
		<input type="button" value="목록" onclick="location.href='productList.do'">
	</div>
	</form>
	
	<script type="text/javascript" src="script/product.js"></script>
</div>
</body>
</html>






