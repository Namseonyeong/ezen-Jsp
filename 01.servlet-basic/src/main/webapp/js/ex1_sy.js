/**
 * 5/18 ex1에 유효성확인 추가
 jsp 파일에서 값이 id의 값에 잘 들어갔는지 확인하는 용도...?
 */
 
 
 // JSP파일(다큐먼트) 내에서 id를 가지고 요소를 찾는 내용
 // value =""-내용이 비어있으면 / alert : 경고메세지 / inNaN :숫자가 아니면
function check() {
	if (document.getElementById("name").value == "") {
		alert("이름을 입력해주세요.");
		document.getElementById("name").focus(); // ID 입력창에 입력대기하도록 함
		return false;
	} else if (document.getElementById("age1, age2").value == "") {
		alert("주민번호를 입력해 주세요.");
		document.getElementById("age1, age2").focus();
		return false;
	} else if (document.getElementById("id").value == "") {
		alert("아이디를 입력해 주세요.");
		document.getElementById("age1, age2").focus();
		return false;
	} else if (document.getElementById("password").value == "") {
				{ if (password != password1) {
			out.print("비밀번호가 같지 않습니다.");
		} else {
			out.print("비밀번호 : " + password + "<br>");
		}
	 }
		
		alert("비밀번호를 입력해 주세요.");
		document.getElementById("password").focus();
		return false;



	} else if (isNaN(document.getElementById("age").value)) {
		alert("숫자를 입력해 주세요.");
		document.getElementById("age").focus();
		return false;
	}
	return true;
}