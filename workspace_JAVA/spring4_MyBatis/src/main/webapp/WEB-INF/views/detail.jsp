<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emp2 상세 정보</title>
</head>
<body>

	<table border=1>

		<tr>
			<td>empno : ${empDTO.empno }</td> <br>
			<td>ename : ${empDTO.ename }</td> <br>
			<td>sal : ${empDTO.sal }</td>
		</tr>
		
	</table>
			<a href="modify?empno=${empDTO.empno}">수정</a>
			<a href="delete?empno=${empDTO.empno}">삭제</a>


</body>
</html>