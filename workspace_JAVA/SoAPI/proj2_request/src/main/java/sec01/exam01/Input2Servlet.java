package sec01.exam01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Input2Servlet")
public class Input2Servlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("CaclServlet의 doGet 실행");
		String num1 = request.getParameter("num1");
		String num2 = request.getParameter("num2");
		try {
			int n1 = Integer.parseInt(num1);
			int n2 = Integer.parseInt(num2);
			int n3 = n1 + n2;
			System.out.println(n3);
			
			request.setAttribute("number3", n3);
			
			int n4 = (Integer)request.getAttribute("number3");
			
			System.out.println("n4 : " + n4);
			
			request.getRequestDispatcher("/WEB-INF/view/calc/inputResult.jsp").forward(request, response);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
