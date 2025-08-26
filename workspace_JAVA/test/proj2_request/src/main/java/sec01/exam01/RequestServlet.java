package sec01.exam01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/req")
public class RequestServlet extends HttpServlet {

	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 할때 한글 꺠짐 방지
		request.setCharacterEncoding("utf-8");
		
		// 응답할때 한글깨짐 방징
		response.setContentType("text/html;charset=uft-8;");
		System.out.println("/req doGet 실행");
		
		// getParameter
		// 전달받은 파라메터의 key를 적어서 해당 값을 얻어오기 
		
		String num1 = request.getParameter("num1");
		System.out.println("num1 : " + num1);
		
		// 없으면 null 이다
		
		String num2 = request.getParameter("num2");
		System.out.println("num2 : " + num2);

		String pw = request.getParameter("pw");
		System.out.println("pw : " + pw);
		
		String check = request.getParameter("check");
		System.out.println("check : " + check);
		
		String[] chs = request.getParameterValues("check");
		System.out.println("checks : " + chs);
		if(chs != null) {
			for(String chk : chs) {
				System.out.println(chk);
			}
		}
		
		System.out.println("hidden1 : "+ request.getParameter("hidden1"));
		System.out.println("btn1 : "+ request.getParameter("btn1"));
		System.out.println("btn2 : "+ request.getParameter("btn2"));
		
		System.out.println("radio1 : "+ request.getParameter("radio1"));
		System.out.println("date1 : "+ request.getParameter("date1"));
		System.out.println("number1 : "+ request.getParameter("number1"));
		System.out.println("div1 : "+ request.getParameter("div1"));
		System.out.println("select1 : "+ request.getParameter("select1"));
		System.out.println("textarea1 : "+ request.getParameter("textarea1"));
		
		response.getWriter().println("{\"k\":123}");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/req doPost 실행");
		
		System.out.println("num2 : "+ request.getParameter("num2"));
		response.getWriter().println("{\"k\":4567}");
		
	}

}
