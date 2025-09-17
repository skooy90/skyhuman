<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>생산관리</title>
<link rel="stylesheet" href="css/style.css">
<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<style>
.container {
    max-width: 1000px;
    margin: 20px auto;
    padding: 30px;
    background-color: #ffffff;
    border-radius: 8px;
    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
    overflow-x: auto;
}
h1 {
    text-align: center;
}

.controls {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 20px;
}

.search-form {
    display: flex;
    gap: 10px;
}

.search-input {
    padding: 10px;
    border: 1px solid #ccc;
    border-radius: 4px;
    font-size: 1em;
}

.btn {
    padding: 10px 15px;
    border: none;
    border-radius: 4px;
    cursor: pointer;
    font-size: 1em;
}

.btn-primary {
    background-color: #007bff;
    color: white;
}

.btn-success {
    background-color: #28a745;
    color: white;
}

table {
    width: 100%;
    min-width: 900px; 
    border-collapse: collapse;
    margin-bottom: 30px;
}

th, td {
    border: 1px solid #e9ecef;
    padding: 12px;
    text-align: center;
    vertical-align: middle;
    white-space: nowrap; /* 글자 줄바꿈 방지 */
}

th, td {
    min-width: 100px;
}

th {
    background-color: #e9ecef;
    font-weight: bold;
    color: #495057;
    white-space: nowrap; /* 텍스트 줄바꿈 방지 */
}

td {
    white-space: nowrap; /* 텍스트 줄바꿈 방지 */
}

tr:nth-child(even) {
    background-color: #f8f9fa;
}

.action-links a {
    text-decoration: none;
    color: #007bff;
    margin-right: 10px;
}

.action-links a:hover {
    text-decoration: underline;
}

.chart-container {
    max-width: 600px;
    margin: 20px auto;
}

th, td {
    min-width: 100px; /* 최소 열 너비 설정 */
}

th:nth-child(1), td:nth-child(1) { width: 10%; } /* 생산번호 */
th:nth-child(2), td:nth-child(2) { width: 10%; } /* 제품코드 */
th:nth-child(3), td:nth-child(3) { width: 12%; } /* 생산 시작일 */
th:nth-child(4), td:nth-child(4) { width: 12%; } /* 생산 종료일 */
th:nth-child(5), td:nth-child(5) { width: 10%; } /* 생산 목표량 */
th:nth-child(6), td:nth-child(6) { width: 10%; } /* 생산 완료량 */
th:nth-child(7), td:nth-child(7) { width: 10%; } /* 담당자 */
th:nth-child(8), td:nth-child(8) { width: 12%; } /* 생성일 */
th:nth-child(9), td:nth-child(9) { width: 12%; } /* 수정일 */
th:nth-child(10), td:nth-child(10) { width: 12%; } /* 관리 */
</style>
</head>
<body>
    <jsp:include page="../../Header_Sied/header.jsp" />
    <div class="main-container">
        <jsp:include page="../../Header_Sied/sidebar.jsp" />
        <div class="content-area">
            <div class="container">
                <h1>생산관리</h1>
                <div class="controls">
                    <div class="search-form">
                        <input type="text" class="search-input" placeholder="생산번호 또는 제품코드 검색">
                        <button type="button" class="btn btn-primary">검색</button>
                    </div>
                    <a href="production_form.jsp" class="btn btn-success">생산 등록</a>
                </div>
                <table>
                    <thead>
                        <tr>
                            <th>생산번호</th>
                            <th>제품코드</th>
                            <th>생산 시작일</th>
                            <th>생산 종료일</th>
                            <th>생산 목표량</th>
                            <th>생산 완료량</th>
                            <th>담당자</th>
                            <th>생성일</th>
                            <th>수정일</th>
                            <th>관리</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>PRD-001</td>
                            <td>P-001</td>
                            <td>2025-09-01</td>
                            <td>2025-09-05</td>
                            <td>100</td>
                            <td>80</td>
                            <td>김철수</td>
                            <td>2025-08-30</td>
                            <td>2025-09-02</td>
                            <td class="action-links"><a href="#">수정</a><a href="#">삭제</a></td>
                        </tr>
                        <tr>
                            <td>PRD-002</td>
                            <td>M-101</td>
                            <td>2025-09-02</td>
                            <td>2025-09-06</td>
                            <td>200</td>
                            <td>150</td>
                            <td>이영희</td>
                            <td>2025-08-31</td>
                            <td>2025-09-03</td>
                            <td class="action-links"><a href="#">수정</a><a href="#">삭제</a></td>
                        </tr>
                        <tr>
                            <td>PRD-003</td>
                            <td>R-505</td>
                            <td>2025-09-03</td>
                            <td>2025-09-07</td>
                            <td>500</td>
                            <td>300</td>
                            <td>박민수</td>
                            <td>2025-09-01</td>
                            <td>2025-09-03</td>
                            <td class="action-links"><a href="#">수정</a><a href="#">삭제</a></td>
                        </tr>
                    </tbody>
                </table>
                <div class="chart-container">
                    <canvas id="productionChart"></canvas>
                </div>
            </div>
        </div>
    </div>
    <script>
        const ctx = document.getElementById('productionChart').getContext('2d');
        const productionChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: ['PRD-001', 'PRD-002', 'PRD-003'],
                datasets: [
                    {
                        label: '생산 목표량',
                        data: [100, 200, 500],
                        backgroundColor: 'rgba(54, 162, 235, 0.5)',
                        borderColor: 'rgba(54, 162, 235, 1)',
                        borderWidth: 1
                    },
                    {
                        label: '생산 완료량',
                        data: [80, 150, 300],
                        backgroundColor: 'rgba(75, 192, 192, 0.5)',
                        borderColor: 'rgba(75, 192, 192, 1)',
                        borderWidth: 1
                    }
                ]
            },
            options: {
                scales: {
                    y: {
                        beginAtZero: true,
                        title: {
                            display: true,
                            text: '수량'
                        }
                    },
                    x: {
                        title: {
                            display: true,
                            text: '생산번호'
                        }
                    }
                },
                plugins: {
                    legend: {
                        position: 'top'
                    },
                    title: {
                        display: true,
                        text: '생산 목표량 vs 완료량'
                    }
                }
            }
        });
    </script>
</body>
</html>