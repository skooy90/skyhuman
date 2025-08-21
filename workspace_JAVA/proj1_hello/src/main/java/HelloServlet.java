

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */

//@WebServlet("/hello.html")
@WebServlet("/hello.human")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServlet() {
        super();
        System.out.println("Hello Servlet 생성");
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("<h1>Served</h1> at: ")
//    	.append(request.getContextPath());
    	
    	// 들어오고 나갈때 다 한글 패치를 해야한다
    	response.setContentType("text/html; charset=utf-8");
    	
    	PrintWriter out = response.getWriter();
    	
    	out.println("<h1>");
    	out.println("Hello Servlet 한굴");
    	out.println("</h1>");
    	
    	// 값이 바뀌면서 계속 화면이 바뀌니깐 동적 데이터다~~~
    	for(int i = 0; i<10; i++) {
    		if(Math.random() < 0.5 ) {    			
    			out.print(i);
    			out.print("<br>");
    		}
    	}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
