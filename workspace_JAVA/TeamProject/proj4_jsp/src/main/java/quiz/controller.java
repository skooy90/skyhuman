package quiz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/login")
public class controller extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		System.out.println("doGet 실행");
		int empno = 0;

		// 파라메터 empno를 int로 형변환
		try {
			String strEmpno = request.getParameter("empno");
			if (strEmpno != null) {
				empno = Integer.parseInt(strEmpno);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			
			DTO dTO = new DTO();
			dTO.setEmpno(empno);
			
			service service = new service();
			List<DTO> list = service.getAllID();
			
			request.setAttribute("list", list);
			
			RequestDispatcher dis = request.getRequestDispatcher("login.jsp");
			dis.forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("post 실행");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		
		int empno = 0;
		String ename ="";
		PrintWriter o = response.getWriter();

		// 파라메터 empno를 int로 형변환
		try {
			String strEmpno = request.getParameter("empno");
			ename = request.getParameter("ename");
			if (strEmpno != null) {
				empno = Integer.parseInt(strEmpno);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			
			DTO dTO = new DTO();
			dTO.setEmpno(empno);
			
			service service = new service();
			DTO dto = service.getID(dTO);
			
			if(dto.getJob().equals("MANAGEG") && dto.getEname().equals("song")) {
				// 기존 세션이 없으면 새로 만들어 주고
				// 있으면 그걸 가져옴
				HttpSession hses = request.getSession();

				// 기존 세션이 없으면 null
				// 있으면 그걸 가져옴
				// HttpSession hses = request.getSession(false);
				
				hses.setAttribute("k", "v");
				
				String id = hses.getId();
				
				
				System.out.println("getId : " + id);
				
				boolean fi = hses.isNew();
				
				System.out.println("New??" + fi);
				
				hses.setAttribute("userRole", "admin");
				hses.setAttribute("userName", dto.getEname());

				o.println("관리자 페이지");					
				
			}else if(dto != null) {
				if (dto.getEname().equals(ename)) {
					o.println("회원 페이지");					
				}else {
					o.println("이름 틀림");
				}
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
