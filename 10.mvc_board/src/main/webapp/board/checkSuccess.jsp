<!-- 0530 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>게시글 수정 또는 삭제화면 이동</h3>
	<script>
		// 비밀번호 확인화면의 이름에 따라서 요청을 다르게 처리 
		if(window.name == "update"){
			window.opener.parent.location.href
			="BoardServlet?command=board_update_form&num=${param.num}";
		} else if (window.name == "delete"){
			window.opener.parent.location.href
			="BoardServlet?command=board_delete&num=${param.num}";
			alert("삭제되었습니다");
		}
		window.close();
	</script>
</body>
</html>