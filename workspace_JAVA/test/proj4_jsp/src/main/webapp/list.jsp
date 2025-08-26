<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 목록</title>
<style>
    body {
        font-family: Arial, sans-serif;
        max-width: 800px;
        margin: 50px auto;
        padding: 20px;
        background-color: #f5f5f5;
    }
    .container {
        background-color: white;
        padding: 30px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }
    h1 {
        color: #333;
        text-align: center;
        margin-bottom: 30px;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }
    th, td {
        padding: 12px;
        text-align: left;
        border-bottom: 1px solid #ddd;
    }
    th {
        background-color: #007bff;
        color: white;
        font-weight: bold;
    }
    tr:hover {
        background-color: #f5f5f5;
    }
    .btn {
        background-color: #007bff;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        text-decoration: none;
        display: inline-block;
        margin: 5px;
    }
    .btn:hover {
        background-color: #0056b3;
    }
    .btn-danger {
        background-color: #dc3545;
    }
    .btn-danger:hover {
        background-color: #c82333;
    }
    .header-actions {
        text-align: right;
        margin-bottom: 20px;
    }
    .no-data {
        text-align: center;
        padding: 50px;
        color: #666;
        font-style: italic;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>사원 목록</h1>
        
        <div class="header-actions">
            <a href="login" class="btn">로그인 페이지로</a>
        </div>
        
        <c:if test="${empty empList}">
            <div class="no-data">
                등록된 사원이 없습니다.
            </div>
        </c:if>
        
        <c:if test="${not empty empList}">
            <table>
                <thead>
                    <tr>
                        <th>사원번호</th>
                        <th>이름</th>
                        <th>직책</th>
                        <th>관리</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="emp" items="${empList}">
                        <tr>
                            <td>${emp.empno}</td>
                            <td>${emp.ename}</td>
                            <td>${emp.job}</td>
                            <td>
                                <a href="detail?empno=${emp.empno}" class="btn">상세보기</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </c:if>
    </div>
</body>
</html>

