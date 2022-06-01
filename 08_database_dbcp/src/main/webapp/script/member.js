/**
 *  0525 로그인시에 ID와 PW 체크
 */
 function loginCheck() {
	var userid = document.getElementById("userid").value; // 로그인시 id 변수선언
	var userpwd = document.getElementById("userpwd").value; // 로그인시 pw 변수선언
	
	if (userid == "") {
		alert("아이디를 입력해주세요");
		document.getElementById("userid").focus();
		return false;
	}
	
	if (userpwd == "") {
		alert("비밀번호를 입력해주세요");
		document.getElementById("userpwd").focus();
		return false;
	}
	
	return true;
}