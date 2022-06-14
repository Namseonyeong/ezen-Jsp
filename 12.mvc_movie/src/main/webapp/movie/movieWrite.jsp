<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 등록</title>
<link rel="stylesheet" href="css/movie.css">
<script src="script/movie.js"></script>
</head>
<body>
	<div id="wrap" align="center">
	<h1>영화 등록</h1>
		<form enctype="multipart/form-data" method="post" action="MovieServlet" name="frm">
		<%-- 위문장의 action이 post방식으로 가기때문에 바로 밑문장(input)을 따로 작성 --%>
		<input type="hidden" name="command" value="movie_write"> 
		   <table>
		   <%-- 등록할땐 code값은 시퀀스 테이블에 자동으로 들어가기때문에 작성 안해도됨 --%>
		      <tr>
		         <th> 제  목 </th>
		         <td><input type="text" name="mtitle" id="mtitle" size="60"></td>
		      </tr> 
		      <tr>
		        <th> 가  격  </th>
		        <td><input type="text" name="price" id="price" size="60"> 원</td>
		      </tr>
		      <tr>
		        <th> 감  독  </th>
		        <td><input type="text" name="director" id="director" size="60"></td>
		      </tr>
		      <tr>
		        <th> 배  우  </th>
		        <td><input type="text" name="actor" id="actor" size="60"></td>
		      </tr>
		      <tr>
		         <th> 설  명 </th> 
		         <td><textarea cols="70" rows="10" name="synopsis" id="synopsis"></textarea></td>
		      </tr>
		      <tr>
		         <th> 사 진</th>
		         <td>
		            <input type="file" name="poster" ><br>
		        </td>
		      </tr>  
		   </table>
		   <br>
		   <input type="submit" value="확인"  onclick="return movieCheck()">
		   <input type="reset" value="취소">
		   <input type="button" value="목록" onclick="location.href='MovieServlet?command=movie_list'" >
		</form>
	</div>
</body>
</html>