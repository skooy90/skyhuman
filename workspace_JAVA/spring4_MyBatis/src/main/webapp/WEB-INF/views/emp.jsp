<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> emp2 회원 목록 </title>
<style>
    body {
        font-family: "Segoe UI", Arial, sans-serif;
        background: #f8f9fa;
        margin: 20px;
        color: #333;
    }
    form {
        margin-bottom: 20px;
    }
    select, input[type="text"], input[type="submit"], button {
        padding: 6px 10px;
        margin: 5px 0;
        border: 1px solid #ccc;
        border-radius: 4px;
        font-size: 14px;
    }
    input[type="submit"], button {
        background: #007bff;
        color: white;
        border: none;
        cursor: pointer;
        transition: 0.2s;
    }
    input[type="submit"]:hover, button:hover {
        background: #0056b3;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        background: white;
        margin-top: 10px;
    }
    table th, table td {
        border: 1px solid #ddd;
        padding: 10px;
        text-align: center;
    }
    table th {
        background: #007bff;
        color: white;
    }
    table tr:nth-child(even) {
        background: #f2f2f2;
    }
    table tr:hover {
        background: #e9f3ff;
    }
    hr {
        margin: 20px 0;
        border: none;
        border-top: 1px solid #ddd;
    }
    a button {
        background: #28a745;
    }
    a button:hover {
        background: #1e7e34;
    }
    </style>
</head>

<body>
	
	
<!-- 	<div> -->
<!-- 		<form action="search" method="get"> -->
<!-- 		ename : <input type="text" name="ename"> <br> -->
<!-- 		job : <input type="text" name="job"> <br> -->
<!-- 		<input type="submit" value= "검색"> -->
<!-- 		</form> -->
<!-- 	</div> -->
	<div>
		<form action="search" method="get">
		<select name="type">
		<c:if test="${empDTO.type eq 1 }">
			<option value="1" selected="selected">ename</option>
		</c:if>
		<c:if test="${empDTO.type  ne 1 }">
			<option value="1">ename</option>
		</c:if>
		<c:if test="${empDTO.type eq 1 }">
			<option value="2" selected="selected" >job</option>
		</c:if>
		<c:if test="${empDTO.type  ne 1 }">
			<option value="2" >job</option>
		</c:if>
			<option value="3">ename 와 job</option>
			<option value="4">sal이하</option>
		</select>
		<input type="text" name="keyword" value="${empDTO.keyword} }"> <br>
		<input type="submit" value= "검색">
		</form>
	</div>
	<hr>
	<form action="choice" method="get">
	<table border=1>

		<tr>
		
			<th>선택</th>
			<th>empno</th>
			<th>ename</th>
			<th>sal</th>
			<th>job</th>
		</tr>	
		<c:if test="${empty list }">
			<tr>
				<td colspan="3">내역이 없습니다. </td>
			</tr>
		</c:if>
		<c:if test="${not empty list }">
			<c:forEach var="empDTO" items="${list}">
				<tr>
					<td>
						<input type="checkbox" name="empnos" value="${empDTO.empno }">
					</td>
					<td>${empDTO.empno }</td>
					<td><a href="empDetail?empno=${empDTO.empno}">${empDTO.ename }</a></td>
					<td>${empDTO.sal }</td>
					<td>${empDTO.job }</td>
				</tr>
				<tr>
				</tr>
			</c:forEach>
					<td><a href=join>가입하기</a></td>
			
		</c:if>
	
	</table>
	<input type="submit" value="선택 조회">		
	</form>
	
	
	
</body>
</html>