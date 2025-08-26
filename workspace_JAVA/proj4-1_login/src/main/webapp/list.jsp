<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	dto : ${dto} \${empty dto } : ${empty dto }
	<c:if test="${empty dto }">
		<c:redirect url="login.jsp" />
	</c:if>
	
	<h1>회원 목록</h1>
	
	<c:if test = "${dto.job eq 'SALESMAN' }">
	[관리자]
	</c:if>
	${dto.ename } 님 반갑습니다. <br>
	
	
</body>
</html>