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

	<table border=1>
	<tr><td>empno</td><td>ename</td><td>job</td><td>mgr</td><td>hiredate</td>
		<td>sal</td><td>comm</td><td>deptno</td>
	<c:forEach var="dto" items="${ list }">
	<tr><td>${ dto.empno}</td>
	<td>${ dto.ename}</td>
	<td>${ dto.job}</td>
	<td>${ dto.mgr}</td>
	<td>${ dto.hiredate}</td>
	<td>${ dto.sal}</td>
	<td>${ dto.comm}</td>
	<td>${ dto.deptno}</td></tr>
	</c:forEach>
	</table>
	${dTO} <br>
	
	<!-- Math.ceil은 오름 처리임  -->
	<!-- Math.floor은 내림 처리임  -->
	
	<< 이전 1 2 3 4 5 다음 >>

	


</body>
</html>