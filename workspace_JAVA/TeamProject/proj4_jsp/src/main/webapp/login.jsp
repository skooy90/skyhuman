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
	
	<h1>login page</h1>
	<form method="post" action="/proj4_jsp/login">
	EMPNO : <input type="text" name="empno"> <br>
	EMPNAME : <input type="text" name="ename"> <br>
	<input type="submit" name="log" value="로그인"> 
	</form>
	<form action="/proj4_jsp/bepage.jsp">
	<input type="submit" name="log" value="비회원 로그인"> 
	</form>
	
	
	<table border=1>
	<c:forEach var="dto" items="${ list }">
	<tr><td>empno</td><td>	${ dto.empno}</td>
	<tr><td>ename</td><td>${ dto.ename}</td>
	<tr><td>job</td><td>${ dto.job}</td><tr>
	</c:forEach>
	</table>





</body>
</html>