<!-- 0518 radio 전송방식 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="RadioServlet">
<!-- 		form 안에 input, submit이 들어가야함 -->
		<label> 메일 수신여부    
<!-- 		  checked:확인 / value:전송되는 값 / 같은 그룹에 있는 radio는 같은 이름 -->
			<input type="radio" name="chk_mail" value="yes" checked> 수신
			<input type="radio" name="chk_mail" value="no" > 수신거부<br><br>
		</label>
		<label> 성별    
<!-- 		  checked:확인 / value:전송되는 값 / 같은 그룹에 있는 radio는 같은 이름 -->
			<input type="radio" name="gender" value="남자" checked > 남자
			<input type="radio" name="gender" value="여자" > 여자<br><br>
		</label>
		<label>가입 인사를 적어주세요 : <br>
			<textarea rows="5" cols="30" name="content" id="content"></textarea>
		</label>
		<br><br>
		<input type="submit" value="전송">
	</form>
</body>
</html>