<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><tiles:insertAttribute name="title"/></title>
<style type="text/css">
    div{
        border : 1px solid red;
        box-sizing: border-box;
    }
    .main_wrapper{
        display: flex;
        flex-direction: row;
        width: 100%;
    }
    /* 사이드바 2 비율 */
    .main_wrapper > .side{
        flex: 2;
    }
    /* 콘텐츠 8 비율 */
    .content{
        flex: 8;
        padding-left: 0.5%;
        padding-right: 0.5%;
    }

    /* 모바일 대응 (가로폭 768px 이하일 때 세로 배치) */
    @media screen and (max-width: 768px) {
        .main_wrapper{
            flex-direction: column;
        }
        .side, .content{
            flex: none;   /* 비율 무시하고 위아래로 */
            width: 100%;
            padding: 2% 0; /* 여백 조금 주기 */
        }
    }
</style>
</head>
<body>

    <!-- header -->
    <header>
    	<tiles:insertAttribute name="header"/>
    </header>
    
    <!-- main start -->
    <section class="main_wrapper">
    
        <!-- side -->
        <aside class="side">
            <tiles:insertAttribute name="side"/>
        </aside>
        
        <!-- content -->
        <article class="content">
            <tiles:insertAttribute name="content"/>
        </article>
    
    </section>
    <!-- main end -->
    
    <!-- footer -->
    <footer>
		<tiles:insertAttribute name="footer"/>
	</footer>

</body>
</html>
