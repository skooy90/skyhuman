package cookie;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookies/set")
public class SetCookie extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답할때 한글깨짐 방징
		request.setCharacterEncoding("utf-8");		
		response.setContentType("text/html;charset=utf-8;");
		
		// 만료일이 있는 쿠키
		Cookie c1 = new Cookie("addr","천안시");
        //c1.setMaxAge(86400); //초단위
		c1.setMaxAge(10); //초단위
		response.addCookie(c1);
		
		// 만료일이 없는 쿠키
		// 세션쿠키 브라우저를 껏다 키면 사라짐
		// setMaxAge를 설정하지 않거나
		// setMAxAge(-1) 음수로 설정한다
		// 브라우저 메모리에만 저장된다
		// 즉, 모든 탭을 끄면 사라진다
		
		Cookie c2 = new Cookie("dinner", "회");
		c2.setMaxAge(-1);
		response.addCookie(c2);

		Cookie c3 = new Cookie("showPopup", "N");
		c3.setMaxAge(12);
		response.addCookie(c3);
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 응답할때 한글깨짐 방징
		request.setCharacterEncoding("utf-8");		
		response.setContentType("text/html;charset=utf-8;");
		
	}

}
