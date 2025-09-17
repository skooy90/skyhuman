<!-- html 주석 -->
<%-- jsp 주석 --%>


<!-- 디렉티브 태그 @가 있는 태그  -->
<%-- 
	"<%@로 시작한는 태그  
	1. page 
	2. include
--%>

<%@ page 
	language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    
    import="java.util.List"
    import="java.util.Map"
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload= function () {
		console.log('include의 스크립트로 인해 이거 안나옴')
	}
</script>
</head>
<body>
	<%@include file="header.jsp" %>

	<h1>jsp.jsp</h1>
	
	
	<!-- 스크립틀릿Scriotlet -->
	<%
		// 여기는 java 땅입니다.
		System.out.println("자동완성");
		out.println("<strong>놀랍게도</strong>");
	%>
	<strong>강한글씨 강글</strong>
	
	<table border=1>
		<% for(int i = 0; i<5; i++){%>	
			<tr>
				<td>제목</td>
				<td>내용</td>
			</tr>
		<%}%>
	</table>
	
	<%
		
		int a = 3;	
		String name =request.getParameter("name");
		
	%>
	
	여기서 a : <% out.print(a); %> <br>
	여기서 name :  <% out.print(name); %><br>

	<%-- 표현식 --%>
	
	<%= a %><br>
	<%= name %><br>
	
	<%-- 선언문  필드 영역으로 빠진다--%>
	<%!
		String title = "F1";
		String getTitle(){
			return this.title;
		}
	%>
	
	<% for(int i =2; i<=9; i++){
			out.print(a +"*"+ i +"="+ (a*i) );
			out.print("<br>");
	}%>

	
	
</body>
</html>
















