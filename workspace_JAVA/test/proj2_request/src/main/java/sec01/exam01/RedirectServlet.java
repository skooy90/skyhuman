package sec01.exam01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RedirectServlet doGet 실행");
		// 항상 첨에 입력을 해야 한다. 
		// 요청 할때 한글 꺠짐 방지
		request.setCharacterEncoding("utf-8");
		
		// 응답할때 한글깨짐 방징
		response.setContentType("text/html;charset=uft-8;");
			
		
		
		String text = request.getParameter("text");
		System.out.println("text : " + text);
		
		response.sendRedirect("/proj2_request/anotherServlet");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RedirectServlet doPost 실행");
		request.setCharacterEncoding("utf-8");
		
		// 응답할때 한글깨짐 방징
		response.setContentType("text/html;charset=uft-8;");

		
		
		String text = request.getParameter("text");
		System.out.println("text : " + text);
		
		response.sendRedirect("/proj2_request/anotherServlet");
		
		
	}

}
