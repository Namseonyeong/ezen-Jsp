<!-- 0518 회원가입 페이지 연습문제 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="join" action="ex1Servlet_sy" name="frm">
		<label> 이  름 <input type="text" name="name" id="name" checked>
		</label><br>
		<label> 주민등록번호 <input type="text" name="age1" id="age1" checked>-
						   <input type="text" name="age2" id="age2" checked>
		</label> <br>
		<label> 아이디 <input type="text" name="id" id="id" checked>
		</label> <br>
		<label> 비밀번호 <input type="text" name="password" id="password" checked>
		</label> <br>
		<label> 비밀번호 확인 <input type="text" name="password" id="password1" checked>
		</label> <br>
		<label> 이메일 <input type="text" name="email1" id="email1">@
					  <input type="text" name="email2" id="email2">
		<select id="emaillist" name="emaillist" size="1"> <!-- size는 콤보박스 -->
		<option value="nete.com">nete.com</option>
		<option value="daum.net">daum.net</option>
		<option value="naver.com">naver.com</option>
		</select>
		</label> <br>		
		<label> 우편번호 <input type="text" name="postalcode" id="postalcode">
		</label> <br>			
		<label> 주소 <input type="text" name="Address1" id="Address1"> <input type="text" name="Address2" id="Address2">
		</label> <br>	
		<label> 핸드폰번호 <input type="text" name="number" id="number">
		</label> <br>
		
		
		<label for="job">직업</label>
		<select id="job" name="job" size="1"> <!-- size는 콤보박스 -->
		<option value="">선택하세요</option>
		<option value="학생">학생</option>
		<option value="컴퓨터/인터넷">컴퓨터/인터넷</option>
		<option value="언론">언론</option>
		<option value="공무원">공무원</option>
		<option value="군인">군인</option>
		<option value="서비스업">서비스업</option>
		<option value="교육">교육</option>
		</select>
		<br><br>

		<label> 메일/SMS 정보 수신</label>
<!-- 		  checked:확인 / value:전송되는 값 / 같은 그룹에 있는 radio는 같은 이름 -->
			<input type="radio" name="chk_mail" value="yes" checked> 수신
			<input type="radio" name="chk_mail" value="no" > 수신거부<br><br>

		
		<label for="interest">관심분야</label>
		<input type="checkbox" name="item" value="생두">생두
			<input type="checkbox" name="item" value="원두">원두
			<input type="checkbox" name="item" value="로스팅">로스팅
			<input type="checkbox" name="item" value="핸드드립">핸드드립
			<input type="checkbox" name="item" value="에스프레소">에스프레소
			<input type="checkbox" name="item" value="창업">창업

			<br>
		
		
		<input type="submit" value="회원가입" onclick="return check();">
		<input type="submit" value="취소" onclick=";">
	</form>

</body>
</html>