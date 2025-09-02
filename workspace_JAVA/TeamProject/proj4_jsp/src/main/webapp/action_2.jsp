<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
<%-- 	<jsp:include page="jsp.jsp?name=ecoding"></jsp:include> --%>
	<jsp:include page="jsp_1.jsp">
		<jsp:param name="name"  value="abcd" />
	</jsp:include>
<%-- 		<jsp:param name="name"  value="abcd"></jsp:param> --%>

	<jsp:forward page="header.jsp" />
</body>
</html>