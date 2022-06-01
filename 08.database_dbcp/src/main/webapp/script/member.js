/**
 *  0525 로그인시에 ID와 PW 체크
 login.jsp의 아이디와 pw의 id값 들고오기 
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


/*
회원가입시 필수입력 및 암호일치여부
 */
function joinCheck() {
	var name = document.getElementById("name").value;
	var userid = document.getElementById("userid").value;
	var pwd = document.getElementById("pwd").value;
	var pwd_chk = document.getElementById("pwd_check").value;
	var reid = document.getElementById("reid").value;
	
	if (name == "") {
		alert("이름은 필수입력 항목입니다.");
		document.getElementByid("name").focus();
		return false;
	}
	
	if (userid == "") {
		alert("사용자 아이디는 필수입력 항목입니다.");
		document.getElementById("userid").focus();
		return false;
	}
	
	if (pwd == "") {
		alert("암호는 필수입력 항목입니다.");
		document.getElementById("pwd").focus();
		return false;
	}
	
	if (pwd_chk == "") {
		alert("암호 확인은 필수입력 항목입니다.");
		document.getElementById("pwd_check").focus();
		return false;
	}
	
	if (pwe != pwd_chk) {
		alert("암호가 일치하지 않습니다. 다시 입력해 주세요.")
		document.getElementById("pwd").focus();
		return false;
	}
	
	if (reid == "") {
		alert("아이디 중복체크를 하지 않았습니다.")
		document.getElementById("userid").focus();
		return false;
	}
	
	return true;
	
}

/*
회원가입시 사용자 ID가 이미 사용중인지 확인
 */

function idCheck(){
	var userid = document.getElementById("userid").value;
	
	if (userid == "") {
		alert("사용자 아이디를 입력해 주세요.");
		 document.getElementById("userid").forus();
		 return false;
	}
	
	var url = "idCheck.do?userid="+userid;
	
	//팝업창 열기 . 새창열기 blank
	window.open(url, "_blank_", "toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=450, height=200")
	
}

function idok() {
	// opener: 회원가입 화면, document, self : 아이디 중복체크 화면 (팝업창)

/*	opener.frm.userid.value = document.frm.userid.value;
	opener.frm.reid.value = document.frm.userid.value;
	self.close();
	*/
	opener.document.getElementById("userid").value=document.getElementById("userid").value;
	opener.document.getElementById("reid").value=document.getElementById("userid").value;
	self.close();

	
}








