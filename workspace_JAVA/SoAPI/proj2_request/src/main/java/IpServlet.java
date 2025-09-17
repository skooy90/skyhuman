

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class IpServlet
 */



//@WebServlet("/ip")
public class IpServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/ip doGet 실행");
		
		String ip = request.getRemoteAddr();
		System.out.println("ip : " + ip);
		
		// 접근 method 확인
		System.out.println("getMethod : " + request.getMethod());
		
		// 접근 주소 전체 . 단 , 쿼리스트링 제외 
		System.out.println("getRequseURL : " + request.getRequestURL());
		
		// 쿼리스트링만 따로가져오기ㅏ
		
		System.out.println("getQueryString : " + request.getQueryString());
		
		// ip, port, 쿼리스트링을 제외한 주소
		System.out.println("getRequestURI : " + request.getRequestURI());
		
		// 프로젝트를 구분하는 주소
		System.out.println("getContextPath : " + request.getContextPath());
		
		// 서블릿 주소만
		System.out.println("getServletPath : " + request.getServletPath());
	}


}
