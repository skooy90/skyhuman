<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="ctx" value="${pageContext.request.contextPath}" />
<link rel="stylesheet" href="${ctx}/Header_Side/style.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
 <div class="main-container">
        <nav class="sidebar">
            <ul>
                <li>
            <a href="${ctx}/dashboard" 
               class="${requestScope['javax.servlet.forward.servlet_path'] eq '/dashboard' ? 'active' : ''}">
                <i class="fas fa-chart-line"></i> 대시보드</a></li>
                <li>
            <a href="${ctx}/standardList" 
               class="${requestScope['javax.servlet.forward.servlet_path'] eq '/standardList' ? 'active' : ''}">
                <i class="fas fa-ruler-combined"></i> 기준 관리</a></li>
                <li>
            <a href="${ctx}/productionList" 
               class="${requestScope['javax.servlet.forward.servlet_path'] eq '/productionList' ? 'active' : ''}">
                <i class="fas fa-cogs"></i> 생산 관리</a></li>
                <li>
                <a href="${ctx}/workList"
                class="${requestScope['javax.servlet.forward.servlet_path'] eq '/workList' ? 'active' : ''}">
                <i class="fas fa-tasks"></i> 작업 관리</a></li>
				<li>
				<a href="${ctx}/qualityList"class="${requestScope['javax.servlet.forward.servlet_path'] eq '/qualityList' ? 'active' : ''}">
                <i class="fas fa-check-circle"></i> 품질 관리</a></li>
                <li>
                <a href="${ctx}/process" class="${requestScope['javax.servlet.forward.servlet_path'] eq '/process' ? 'active' : ''}"><i class="fas fa-project-diagram"></i> 공정 관리</a></li>
                <li>
                <a href="${ctx}/bom" class="${requestScope['javax.servlet.forward.servlet_path'] eq '/bom' ? 'active' : ''}"><i class="fas fa-clipboard-list"></i> BOM</a></li>
                <li>
                <a href="${ctx}/material" class="${requestScope['javax.servlet.forward.servlet_path'] eq '/material' ? 'active' : ''}"><i class="fas fa-box"></i> 자재 관리</a></li>
               <li>
            <a href="${ctx}/boardList" 
               class="${requestScope['javax.servlet.forward.servlet_path'] eq '/boardList' ? 'active' : ''}">
                <i class="fas fa-chalkboard"></i> 게시판</a></li>
                
                <c:if test="${authority == 'ADMIN'}">
                <li class="admin-section">
      				<div class="admin-title">관리자</div>
      				<ul class="admin-menu">
                        <li><a href="${ctx}/admin/users"><i class="fas fa-users"></i> 사용자 관리</a></li>
                        <li><a href="${ctx}/admin/boards"><i class="fas fa-file-alt"></i> 게시판 관리</a></li>
      				</ul>
    					</li>
                </c:if>
    					
    					
           	</ul>
           	
           	
           	
   		</nav>
</div>