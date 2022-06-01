/**
 * 5/18 param에 유효성확인 추가
 jsp 파일에서 값이 id의 값에 잘 들어갔는지 확인하는 용도...?
 */
 
 
 // JSP파일(다큐먼트) 내에서 id를 가지고 요소를 찾는 내용
 // value =""-내용이 비어있으면 / alert : 경고메세지 / inNaN :숫자가 아니면
 function check() {
	if (document.getElementById("id").value=="") {
		alert("아이디를 입력해주세요.");
		document.getElementById("id").focus(); // ID 입력창에 입력대기하도록 함
		return false;
	} else if (document.getElementById("age").value=="") {
		alert("나이를 입력해 주세요.");
		document.getElementById("age").focus();
		return false;
	} else if  (isNaN(document.getElementById("age").value)) {
		alert("숫자를 입력해 주세요.");
		document.getElementById("age").focus();
		return false;
	}
	return true;
}