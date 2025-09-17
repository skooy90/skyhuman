<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 로그인</title>
<style>
    body {
        font-family: Arial, sans-serif;
        max-width: 600px;
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
    .form-group {
        margin-bottom: 20px;
    }
    label {
        display: block;
        margin-bottom: 5px;
        font-weight: bold;
        color: #555;
    }
    input[type="text"], input[type="number"] {
        width: 100%;
        padding: 10px;
        border: 1px solid #ddd;
        border-radius: 5px;
        font-size: 16px;
        box-sizing: border-box;
    }
    .btn {
        background-color: #007bff;
        color: white;
        padding: 12px 30px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
        width: 100%;
    }
    .btn:hover {
        background-color: #0056b3;
    }
    .message {
        padding: 15px;
        margin: 20px 0;
        border-radius: 5px;
        text-align: center;
        font-weight: bold;
    }
    .success {
        background-color: #d4edda;
        color: #155724;
        border: 1px solid #c3e6cb;
    }
    .error {
        background-color: #f8d7da;
        color: #721c24;
        border: 1px solid #f5c6cb;
    }
    .user-info {
        background-color: #e7f3ff;
        padding: 15px;
        border-radius: 5px;
        margin: 20px 0;
        border-left: 4px solid #007bff;
    }
    .logout-btn {
        background-color: #dc3545;
        color: white;
        padding: 8px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        text-decoration: none;
        display: inline-block;
        margin-top: 10px;
    }
    .logout-btn:hover {
        background-color: #c82333;
    }
</style>
</head>
<body>
    <div class="container">
        <h1>사원 로그인 시스템</h1>
        
        <!-- 메시지 표시 -->
        <c:if test="${not empty message}">
            <div class="message ${message.contains('성공') ? 'success' : 'error'}">
                ${message}
            </div>
        </c:if>
        
        <!-- 로그인된 사용자 정보 표시 -->
        <c:if test="${not empty sessionScope.loginUser}">
            <div class="user-info">
                <h3>로그인된 사용자 정보</h3>
                <p><strong>사원번호:</strong> ${sessionScope.loginEmpno}</p>
                <p><strong>이름:</strong> ${sessionScope.loginEname}</p>
                <p><strong>직책:</strong> ${sessionScope.loginUser.job}</p>
                <a href="logout" class="logout-btn">로그아웃</a>
            </div>
        </c:if>
        
        <!-- 로그인 폼 -->
        <c:if test="${empty sessionScope.loginUser}">
            <form action="login" method="post">
                <div class="form-group">
                    <label for="empno">사원번호:</label>
                    <input type="number" id="empno" name="empno" 
                           value="${dto.empno}" required>
                </div>
                
                <div class="form-group">
                    <label for="ename">이름:</label>
                    <input type="text" id="ename" name="ename" 
                           value="${dto.ename}" required>
                </div>
                
                <button type="submit" class="btn">로그인</button>
            </form>
        </c:if>
        
        <!-- 전체 사원 목록 링크 -->
        <c:if test="${not empty sessionScope.loginUser}">
            <div style="text-align: center; margin-top: 20px;">
                <a href="list" style="color: #007bff; text-decoration: none;">
                    전체 사원 목록 보기
                </a>
            </div>
        </c:if>
    </div>
</body>
</html>