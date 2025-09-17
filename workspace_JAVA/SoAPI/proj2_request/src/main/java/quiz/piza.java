package quiz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/piza")
public class piza extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8;");
		
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("페페로니", 10000);
		map.put("뿔감자", 20000);
		map.put("파인애플", 30000);
		
		
		Map<String, Integer> map2 = new HashMap<String, Integer>();
		map2.put("M", 10000);
		map2.put("L", 20000);
		map2.put("XL", 30000);
		
		
		
		String menu = request.getParameter("menu");
		String size =request.getParameter("size");
		String toping[] =request.getParameterValues("toping");
		String tx =request.getParameter("tx1");
		
		
		PrintWriter out = response.getWriter();
		out.println("<h1>메뉴 : " + menu+ "</h1>");
		out.println("<h1>사이즈 : " +size + "</h1>");
		
		out.println("<h1>토핑 : "+"</h1>");
		if ( toping != null) {
		for ( String tp : toping) {
				out.print("<strong>"+tp + " , </strong>");				
			}
		}
		
		out.println("<h1> 요청사항 : "+tx+"</h1>");
		
		
		
	
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
