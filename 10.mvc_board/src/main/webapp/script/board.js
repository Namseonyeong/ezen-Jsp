/**
 *  0530 게시글 등록시에 필수입력사항 체크
 */
 function boardCheck() {
   var name = document.getElementById("name").value;
   var pass = document.getElementById("pass").value;
   var title = document.getElementById("title").value;
   
   if (name == ""){
      alert("작성자를 입력해 주세요.");
      document.getElementById("name").focus();
      return false;
   }
   
   if (pass == ""){
      alert("비밀번호를 입력해 주세요.");
      document.getElementById("pass").focus();
      return false;
   }
   
   if (title == ""){
      alert("제목을 입력해 주세요.");
      document.getElementById("title").focus();
      return false;
   }
   
   return true;
}

function open_win(url, name) {
	
	//url = BoardServlet?command=board_check_pass_form&num=?
	// name : 'update', 'delete' 버튼 업데이트로 들어왔느냐, 삭제로 들어왔느냐로 구분
	var popupWidth = 500;
	var popupHeight = 200;
	var popupX = (window.screen.width / 2) - (popupWidth / 2);
	//만들 팝업창 width 크기의 2/1 크기만큼 보정값으로 해주었음 
	var popupY = (window.screen.height / 2) - (popupHeight / 2);
	window.open(url, name, "width=500, height=200, left=popupX, top=popupY")
	
	
	window.open(url, name, "width=500, height=200");
}

function passCheck() {
	var pass = document.getElementById("pass").value;
	
	//pass의 값이 빈 문자열이면
	if (pass == "") {
		alert("비밀번호를 입력하세요");
		document.getElementById("pass").focus();
		return false;
	}
	
	return true;
}












