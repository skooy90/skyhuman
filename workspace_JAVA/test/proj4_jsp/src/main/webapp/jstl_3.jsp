<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@	page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSTL</h1>
	<%
	int a = 10;
	%>
	<c:set var="b" value="10" />
	<c:set var="a" value="10" />

	scope : page -> request -> session -> application 살아있는 순서
	<br>
	<c:set var="a1" value="10" scope="page" />
	scope 생략하면 page
	<br>


	<c:set var="game" value="LOL" scope="page" />
	<c:set var="game" value="마비노기" scope="request" />
	<c:set var="game" value="서든어택" scope="session" />
	<c:set var="game" value="세븐나이츠" scope="application" />

	\${ game } : ${ game }
	<br> pageScope : ${ pageScope.game }
	<br> pageScope : ${ requestScope.game }
	<br> pageScope : ${ sessionScope.game }
	<br> pageScope : ${ applicationScope.game }
	<br>


	<%-- <jsp:forward page="jstl_4-1.jsp"/> --%>

	<hr>

	<c:if test="true">
		항상 참 <br>
	</c:if>

	<c:if test="${ a eq 10 }">
		a는 10이 맞습니다
	</c:if>
	<c:if test="${ not(a eq 10) }">
		a는 10이 아닙니다.
	</c:if>
	<br>
	<c:choose>
		<c:when test="a eq 8">
			a는 8입니다
		</c:when>
		<c:when test="a eq 9">
			a는 9입니다
		</c:when>
		<c:otherwise>
			a는 뭘까용~?
		</c:otherwise>
	</c:choose>
	<hr>

	<br>

	<%
	List list = new ArrayList();
	for (int i = 0; i < 4; i++) {
		Map map = new HashMap();
		map.put("title", "노래" + i);
		map.put("singer", "가수" + i);

		list.add(map);
	}
	%>
	<c:set var="list" value="<%=list%>" />
	그냥 첫번째 제목 : ${list[0].title}
	<br> items
	<br>
	<c:forEach var="song" items="${list}">
		title : ${song.title } <br>
		singer : ${song.singer} <br>
	</c:forEach>
	<hr>
	bdgin, end
	<br>
	<c:forEach var="i" begin="0" end="5">
		${i},${list[i].title } <br>
	</c:forEach>
	<hr>
	step
	<br>
	<c:forEach var="i" begin="0" end="5" step="2">
		${i},${list[i].title } <br>
	</c:forEach>

	<hr>
	varStatus
	<br>

	<c:forEach var="i" begin="0" end="9" step="2" varStatus="loop">
		${i} <br>
		<c:if test="${not loop.last }">
		,
		</c:if>
		loop.index : ${loop.index } <br>
		loop.count : ${loop.count } <br>
		loop.first : ${loop.first } <br>
		loop.last : ${loop.last } <br>
		<br>
		</c:forEach>

		<c:forEach var="song" items="${list}" begin="1" end="10"
			varStatus="loop">
			song.title ${loop.count} : ${song.title } <br>
		</c:forEach>

		<hr>
		
		<c:forEach var="gu" begin="2" end="9">
		<c:if test="${gu != 5 }">
			<c:forEach var="gu2" begin="1" end="9">
				${gu} * ${gu2} = ${gu * gu2} <br>
			</c:forEach>
			<br>
		</c:if>
		</c:forEach>
		
		<hr>
		
		c:url <br>
		사용 이우 <br>
		1. 영어나 숫자 외 한글이나 특수 문자를 enconding 해줌 <br>
		2. context path 자동 추가 (/proj4_jsp) <br>
		3. 쿠키 금지일 때 ";jsessionid =" 를 자동으로 붙여줌
		
		<c:url var="url1" value="/jsp_1.jsp">
			<c:param name ="name" value="vvvv" />
		</c:url>
		
		<a href = "${url1 }" target=_blank>jsp_1.jsp</a> <br>
		
		<hr>
		param.addr : ${param.addr }<br>
		innerHTML 같은놈
		c:out :::::::::::::::::
		<c:out value="${param.addr }" /> <br>
		
		sql인젝션의 공격을 막을 수 있다.
		특수문자를 치환해서 문자 그 자체로 출력
		innerTEXT 같은놈
		<!-- 
			< : &lt;
			> : &gt;
		   " ": &nbsp; ( 공백 )
		   &  : &amp; 
		 --> 
		 
		
		
		
</body>
</html>