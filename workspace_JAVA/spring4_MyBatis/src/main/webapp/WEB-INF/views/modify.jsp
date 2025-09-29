<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emp2 수정하기</title>
</head>
<body>

	<form action="updateEmp2" method="post">
	
			empno : ${empDTO.empno}
			<input type="hidden" name="empno" value="${empDTO.empno}">
			ename :<input type="text" name="ename" value="${empDTO.ename}">
			job :<input type="text" name="job" value="${empDTO.job}">
			mgr :<input type="text" name="mgr" value="${empDTO.mgr}">
			hiredate :<input type="text" name="hiredate" value="${empDTO.hiredate}">
			sal :<input type="text" name="sal" value="${empDTO.sal}">
			comm :<input type="text" name="comm" value="${empDTO.comm}"> 
			deptno :<input type="text" name="deptno" value="${empDTO.deptno}"> 
			<input type="submit" value="수정하기">
	
	</form>



</body>
</html>