/**
 * 
 */
function movieCheck() {
	// 제목, 감독, 배우 필수입력 확인.
	var title = document.getElementById("mtitle").value;
	var director = document.getElementById("director").value;
	var actor = document.getElementById("actor").value;
	
	
	if (title == "") {
		alert("제목을 입력해 주세요");
		document.getElementById("mtitle").focus();
		return false;
	}
	
	if (director == "") {
		alert("감독명을 입력해 주세요");
		document.getElementById("director").focus();
		return false;
	}
	
	if (actor == "") {
		alert("배우명을 입력해 주세요");
		document.getElementById("actor").focus();
		return false;
	}
	
	return true;
}