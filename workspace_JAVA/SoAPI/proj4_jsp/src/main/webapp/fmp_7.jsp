<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	숫자랑 날짜를 포매팅 해주는 거 <br>
	new Date() : <%= new Date() %>
	
	<hr>
	
	<fmt:formatDate
		value="<%= new Date() %>"
		pattern="yyyy년 MM월 dd일 a HH시 mm분 ss.SSS초 "/>
</body>
</html>