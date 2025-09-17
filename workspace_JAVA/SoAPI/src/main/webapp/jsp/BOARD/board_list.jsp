<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
    String ctx = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판 - MES 시스템</title>
    <link rel="stylesheet" href="<%=ctx%>/Header_Side/style.css">
    <link rel="stylesheet" href="<%=ctx%>/css/admin/admin_common.css">
</head>
<body>
    <jsp:include page="../../Header_Side/header.jsp" />
    <jsp:include page="../../Header_Side/sidebar.jsp" />
    
    <div class="admin-page-container">
        <div class="admin-content">
            <div class="page-header">
                <h1 class="page-title">게시판</h1>
            </div>

            <!-- 검색 영역 -->
            <div class="search-section">
                <form method="GET" action="<%=ctx%>/boardList" class="search-form">
                    <select name="searchType" class="search-select">
                        <option value="all" ${searchType == 'all' ? 'selected' : ''}>전체</option>
                        <option value="title" ${searchType == 'title' ? 'selected' : ''}>제목</option>
                        <option value="content" ${searchType == 'content' ? 'selected' : ''}>내용</option>
                        <option value="writer" ${searchType == 'writer' ? 'selected' : ''}>작성자</option>
                    </select>
                    <input type="text" name="keyword" class="search-input" 
                           placeholder="검색어를 입력하세요" value="${keyword}">
                    <button type="submit" class="btn btn-secondary">검색</button>
                    <a href="<%=ctx%>/boardWrite" class="btn btn-primary">글쓰기</a>
                </form>
            </div>

            <!-- 카테고리 필터 -->
            <div class="category-filter">
                <a href="<%=ctx%>/boardList" class="category-btn ${empty category ? 'active' : ''}">전체</a>
                <a href="<%=ctx%>/boardList?category=공지사항" class="category-btn ${category == '공지사항' ? 'active' : ''}">공지사항</a>
                <a href="<%=ctx%>/boardList?category=일반게시판" class="category-btn ${category == '일반게시판' ? 'active' : ''}">일반게시판</a>
                <a href="<%=ctx%>/boardList?category=Q&A" class="category-btn ${category == 'Q&A' ? 'active' : ''}">Q&A</a>
            </div>

            <!-- 게시글 목록 테이블 -->
            <div class="table-container">
                <table class="admin-table">
                        <thead>
                            <tr>
                                <th class="col-no">번호</th>
                                <th class="col-category">카테고리</th>
                                <th class="col-title">제목</th>
                                <th class="col-writer">작성자</th>
                                <th class="col-date">작성일</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:choose>
                                <c:when test="${empty boardList}">
                                    <tr>
                                        <td colspan="5" class="no-posts">
                                            등록된 게시글이 없습니다.
                                        </td>
                                    </tr>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach var="board" items="${boardList}">
                                        <tr class="board-row">
                                            <td class="col-no">${board.postNo}</td>
                                            <td class="col-category">
                                                <span class="category-badge category-${board.boCategory == '공지사항' ? 'notice' : board.boCategory == '일반게시판' ? 'general' : 'qna'}">
                                                    ${board.boCategory}
                                                </span>
                                            </td>
                                            <td class="col-title">
                                                <a href="<%=ctx%>/boardDetail?postNo=${board.postNo}" class="title-link">
                                                    ${board.boTitle}
                                                </a>
                                            </td>
                                            <td class="col-writer">${board.boWriter}</td>
                                            <td class="col-date">
                                                <fmt:formatDate value="${board.boCreationDate}" pattern="yyyy-MM-dd"/>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                        </tbody>
                    </table>
                </div>

            <!-- 페이지네이션 -->
            <div class="pagination">
                <c:if test="${currentPage > 1}">
                    <a href="<%=ctx%>/boardList?page=${currentPage - 1}&searchType=${searchType}&keyword=${keyword}&category=${category}" 
                       class="page-btn">이전</a>
                </c:if>
                
                <span class="current-page">${currentPage}</span>
                
                <c:if test="${not empty boardList && boardList.size() >= 10}">
                    <a href="<%=ctx%>/boardList?page=${currentPage + 1}&searchType=${searchType}&keyword=${keyword}&category=${category}" 
                       class="page-btn">다음</a>
                </c:if>
            </div>
        </div>
    </div>

    <script>
        // 메시지 표시
//         <c:if test="${not empty success}">
//             alert('${success}');
//         </c:if>
//         <c:if test="${not empty error}">
//             alert('${error}');
//         </c:if>

        // 검색 폼 제출 시 빈 검색어 처리
        document.querySelector('.search-form').addEventListener('submit', function(e) {
            const keyword = document.querySelector('input[name="keyword"]').value.trim();
            if (keyword === '') {
                e.preventDefault();
                alert('검색어를 입력해주세요.');
            }
        });
    </script>
</body>
</html>
