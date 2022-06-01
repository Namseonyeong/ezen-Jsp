<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- cset에 속성 설정방법1 -->
<!-- pageContext.setAttribute("msg", "Hello"); 와 같은 의미임 -->
<c:set var="msg" value="Hello"/>
\${msg} : ${msg} <br>
<!-- cset에 속성 설정방법2 -->
<c:set var="age"/>
25
\${age} : ${age} <br>

<!-- c.set으로 자바빈 객체 생성하기 -->
<c:set var="member" value="<%=new com.ezen.javabean.MemberBeans()%>" />

<!-- 자바빈 객체에 멤버값 설정하기 -->
<c:set target="${member}" property="name" value="이순신"/>
<c:set target="${member}" property="userid">
sslee 
</c:set>

<!-- 자바빈 객체의 내용 출력 -->
${member}

<!-- 계산 결과의 저장 -->
<c:set var="sum" value="${ 10 + 20 }"/>
sum의 내용은 ${sum} <br>
<c:set var="flag" value="${ 20 > 20 }"/>
flat의 내용은 ${flag} <br>


<!-- 설정된 변수 값 제거  -->
<c:remove var="age" />
\${age}=${age}






</body>
</html>