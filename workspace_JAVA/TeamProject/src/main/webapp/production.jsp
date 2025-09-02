<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>MES - 생산 관리</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/src/Header_Sied/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/src/css/production.css">
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
</head>
<body>
    <!-- 헤더 -->
    <jsp:include page="/src/Header_Sied/header.jsp" />
    
    <div class="main-container">
        <!-- 사이드바 -->
        <jsp:include page="/src/Header_Sied/sidebar.jsp" />
        
        <!-- 메인 콘텐츠 영역 -->
        <div class="content-area">
            <h1>생산 관리</h1>
            
            <!-- 에러 메시지 표시 -->
            <c:if test="${not empty error}">
                <div class="error-message">
                    <strong>오류:</strong> ${error}
                </div>
            </c:if>

            <!-- 1. LOT 관리 섹션 -->
            <section class="lot-management-section">
                <h2>LOT 관리 현황</h2>
                <div class="section-header">
                    <div class="search-filter">
                        <input type="text" id="lotSearch" placeholder="LOT 번호 또는 제품명으로 검색...">
                        <select id="statusFilter">
                            <option value="">전체 상태</option>
                            <option value="IN_PROGRESS">진행중</option>
                            <option value="COMPLETED">완료</option>
                            <option value="QUALITY_CHECK">품질검사</option>
                            <option value="DELAYED">지연</option>
                        </select>
                        <button onclick="searchLots()">검색</button>
                    </div>
                    <div class="action-buttons">
                        <button class="btn-primary" onclick="openAddLotModal()">LOT 추가</button>
                        <button class="btn-secondary" onclick="exportLotData()">데이터 내보내기</button>
                    </div>
                </div>
                
                <div class="lot-table-container">
                    <table class="lot-table">
                        <thead>
                            <tr>
                                <th>작업지시 ID</th>
                                <th>제품 ID</th>
                                <th>계획 수량</th>
                                <th>실제 수량</th>
                                <th>진행률</th>
                                <th>계획 시작일</th>
                                <th>상태</th>
                            </tr>
                        </thead>
                        <tbody id="lotTableBody">
                            <c:choose>
                                <c:when test="${not empty inProgressLots}">
                                    <c:forEach var="lot" items="${inProgressLots}">
                                        <c:set var="progress" value="${lot.plannedQuantity > 0 ? (lot.actualQuantity / lot.plannedQuantity * 100) : 0}" />
                                        <tr>
                                            <td>${lot.workOrderId}</td>
                                            <td>${lot.productId}</td>
                                            <td>${lot.plannedQuantity}</td>
                                            <td>${lot.actualQuantity}</td>
                                            <td>
                                                <div class="progress-bar">
                                                    <div class="progress-fill" style="width:${progress}%"></div>
                                                </div>
                                            </td>
                                            <td><fmt:formatDate value="${lot.plannedStartDate}" pattern="yyyy-MM-dd"/></td>
                                            <td>
                                                <span class="status-badge ${lot.status == 'IN_PROGRESS' ? 'status-in-progress' : (lot.status == 'COMPLETED' ? 'status-completed' : (lot.status == 'DELAYED' ? 'status-delayed' : 'status-quality-check'))}">
                                                    ${lot.status}
                                                </span>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <tr>
                                        <td colspan="7" style="text-align:center;color:#777;">표시할 LOT 데이터가 없습니다.</td>
                                    </tr>
                                </c:otherwise>
                            </c:choose>
                        </tbody>
                    </table>
                </div>
            </section>
            
            <!-- 2. 공정 관리 섹션 -->
            <section class="process-management-section">
                <h2>공정별 상세 현황</h2>
                <div class="process-cards">
                    <c:choose>
                        <c:when test="${not empty processProgress}">
                            <c:forEach var="proc" items="${processProgress}">
                                <div class="process-card">
                                    <h3>${proc.processName}</h3>
                                    <div class="process-info">
                                        <p>작업지시 ID: <span class="lot-count">${proc.workOrderId}</span></p>
                                        <p>상태: <span class="progress-rate">${proc.status}</span></p>
                                        <p>시작: <span class="eta"><fmt:formatDate value="${proc.startTime}" pattern="MM-dd HH:mm"/></span></p>
                                    </div>
                                    <div class="process-status ${proc.status == 'IN_PROGRESS' ? 'warning' : (proc.status == 'COMPLETED' ? 'normal' : 'waiting')}">
                                        ${proc.status}
                                    </div>
                                </div>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <div style="color:#777;">표시할 공정 데이터가 없습니다.</div>
                        </c:otherwise>
                    </c:choose>
                </div>
            </section>
            
            <!-- 3. 설비 및 작업자 관리 섹션 -->
            <section class="equipment-worker-section">
                <h2>설비 및 작업자 현황</h2>
                
                <!-- 설비 현황 -->
                <div class="equipment-status">
                    <h3>설비 현황</h3>
                    <table class="equipment-table">
                        <thead>
                            <tr>
                                <th>설비 ID</th>
                                <th>설비명</th>
                                <th>가동 상태</th>
                                <th>OEE</th>
                                <th>마지막 점검일</th>
                                <th>작업</th>
                            </tr>
                        </thead>
                        <tbody id="equipmentTableBody">
                            <!-- 설비 데이터가 동적으로 로드됩니다 -->
                        </tbody>
                    </table>
                </div>
                
                <!-- 작업자 현황 -->
                <div class="worker-status">
                    <h3>작업자 현황</h3>
                    <table class="worker-table">
                        <thead>
                            <tr>
                                <th>작업자 ID</th>
                                <th>이름</th>
                                <th>현재 공정</th>
                                <th>숙련도</th>
                                <th>근무조</th>
                            </tr>
                        </thead>
                        <tbody id="workerTableBody">
                            <c:choose>
                                <c:when test="${not empty workerStatus}">
                                    <c:forEach var="w" items="${workerStatus}">
                                        <tr>
                                            <td>${w.workerId}</td>
                                            <td>${w.workerName}</td>
                                            <td>${w.currentProcess}</td>
                                            <td>${w.skillLevel}</td>
                                            <td>${w.workShift}</td>
                                        </tr>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <tr>
                                        <td colspan="5" style="text-align:center;color:#777;">표시할 작업자 데이터가 없습니다.</td>
                                    </tr>
                                </c:otherwise>
                            </c:choose>
                        </tbody>
                    </table>
                </div>
            </section>
        </div>
    </div>
    
    <!-- LOT 추가 모달 -->
    <div id="addLotModal" class="modal">
        <div class="modal-content">
            <span class="close">&times;</span>
            <h2>새 LOT 추가</h2>
            <form id="addLotForm">
                <div class="form-group">
                    <label for="productSelect">제품 선택:</label>
                    <select id="productSelect" name="productId" required>
                        <option value="">제품을 선택하세요</option>
                        <c:forEach var="product" items="${productList}">
                            <option value="${product.productId}">${product.productName}</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="quantity">생산 수량:</label>
                    <input type="number" id="quantity" name="quantity" min="1" required>
                </div>
                <div class="form-group">
                    <label for="workerSelect">담당 작업자:</label>
                    <select id="workerSelect" name="workerId" required>
                        <option value="">작업자를 선택하세요</option>
                        <c:forEach var="worker" items="${workerStatus}">
                            <option value="${worker.workerId}">${worker.workerName} (${worker.skillLevel})</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="startDate">시작 예정일:</label>
                    <input type="datetime-local" id="startDate" name="startDate" required>
                </div>
                <div class="form-actions">
                    <button type="submit" class="btn-primary">LOT 생성</button>
                    <button type="button" class="btn-secondary" onclick="closeAddLotModal()">취소</button>
                </div>
            </form>
        </div>
    </div>
    
    <script src="${pageContext.request.contextPath}/src/js/production.js"></script>
</body>
</html>
