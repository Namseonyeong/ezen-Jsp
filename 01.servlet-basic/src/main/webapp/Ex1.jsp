<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서블릿 개요 연습문제</title>
<style>
	* {
		margin: 0;
		padding: 0;
	}
	body {
		margin-top: 10px;
	}
	#container {
		margin: 0 auto;
		padding: 10px;
		width: 700px;
		border: 1px solid #ccc;
	}
	label {
		display: inline-block;
		width: 150px;
	}
	span {
		display: inline-block;
		width: 10px;
		color: #ff0000;
	}
	#buttons {
		text-align:center;
	}
</style>
<script>
function do_select() {
	var domain = document.getElementById("domain_list").value;
	
	document.getElementById("domain").value=domain;
}
</script>
</head>
<body>
	<div id="container">
	<form method="post" action="Ex1Servlet">
		<label for="name">이름</label>
		<span>*</span>
		<input type="text" name="name" id="name" size="12" required>
		<br>
		<label for="jumin1">주민등록번호</label>
		<span>*</span>
		<input type="text" name="jumin1" id="jumin1" size="12" required>-
		<input type="text" name="jumin2" id="jumin2" size="12" required>
		<br>
		<label for="id">아이디</label>
		<span>*</span>
		<input type="text" name="id" id="id" size="12" required>
		<br>
		<label for="pwd">비밀번호</label>
		<span>*</span>
		<input type="password" name="password" id="pwd">
		<br>
		<label for="pwd_confirm">비밀번호 확인</label>
		<span>*</span>
		<input type="password" name="confirm" id="pwd_confirm">
		<br>
		<label for="email">이메일</label>
		<span> </span>
		<input type="text" name="email_id" id="email_id">@
		<input type="text" name="domain" id="domain">
		<select id="domain_list" onchange="return do_select();">
			<option value="daum.net">daum.net</option>
			<option value="naver.com">naver.com</option>
			<option value="nate.com">nate.com</option>
			<option value="gmail.com">gmail.com</option>
		</select>
		<br>
		<label for="zipcode">우편번호</label>
		<span> </span>
		<input type="text" name="zipcode" id="zipcode">
		<br>
		<label for="address">주소</label>
		<span> </span>
		<input type="text" name="addr1">
		<input type="text" name="addr2">
		<br>
		<label for="phone">핸드폰번호</label>
		<span> </span>
		<input type="tel" name="phone" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}">
		<br>
		<label for="job">직업</label>
		<span> </span>
		<select id="job" name="job" size="3">
			<option value="학생">학생</option>
			<option value="컴퓨터/인터넷">컴퓨터/인터넷</option>
			<option value="언론">언론</option>
			<option value="공무원">공무원</option>
			<option value="군인">군인</option>
			<option value="서비스업">서비스업</option>
			<option value="교육">교육</option>
		</select>
		<br>
		<label>메일 수신여부:</label>
		<span> </span><input type="radio" name="chk_mail" value="yes" checked>수신
		<input type="radio" name="chk_mail" value="no">수신거부
		<br>
		<label for="">관심분야</label>
		<span> </span>
		<input type="checkbox" name="interest" id="item1" value="생두">생두
		<input type="checkbox" name="interest" id="item2" value="원두">원두
		<input type="checkbox" name="interest" id="item3" value="로스팅">로스팅
		<input type="checkbox" name="interest" id="item4" value="핸드드립">핸드드립
		<input type="checkbox" name="interest" id="item5" value="에스프레소">에스프레소
		<input type="checkbox" name="interest" id="item6" value="창업">창업
		<br><br>
		
		<div id="buttons">
			<input type="submit" value="회원가입">
			<input type="reset" value="취소">
		</div>
	</form>
	</div>
</body>
</html>