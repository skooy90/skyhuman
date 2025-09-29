<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emp2 가입하기</title>
</head>
<body>

	<form action="joinEmp2" method="post">
	<table border=1>
			<tr>ename :<input type="text" name="ename"> </tr> 
			<tr>job :<input type="text" name="job"> </tr> 
			<tr>mgr :<input type="text" name="mgr"> </tr> 
			<tr>hiredate :<input type="text" name="hiredate"> </tr>
			<tr>sal :<input type="text" name="sal"> </tr> 
			<tr>comm :<input type="text" name="comm"> </tr> 
			<tr>deptno :<input type="text" name="deptno"> </tr> 
			<tr> <input type="submit" value="가입하기"> </tr>
	</table>
	</form>



</body>
</html>