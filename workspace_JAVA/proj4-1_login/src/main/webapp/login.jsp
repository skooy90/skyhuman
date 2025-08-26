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

	<form method="post" action="loginCheck">
		id : <input type="text" name="ename"> <br> pw : <input
			type="text" name="empno"> <br> <input type="submit"
			value="로그인"> <br>
	</form>

	<c:if test = "${param.msg eq 1 }">
	<span style="color: red"> 
		아이디 또는 패스워드를 확인해주세요		
	</span>
	</c:if>

</body>
</html>