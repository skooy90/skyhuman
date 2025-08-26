package quiz;

import java.io.IOException;
import java.io.PrintWriter;

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

		System.out.println("/login doGet 실행");
		
		// 로그인 페이지로 이동
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");

		System.out.println("/login doPost 실행");
		
		// 파라미터 받기
		String strEmpno = request.getParameter("empno");
		String ename = request.getParameter("ename");
		
		int empno = 0;
		try {
			if (strEmpno != null && !strEmpno.trim().isEmpty()) {
				empno = Integer.parseInt(strEmpno);
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		// DTO 생성 및 데이터 설정
		DTO dto = new DTO();
		dto.setEmpno(empno);
		dto.setEname(ename);
		
		// Service를 통한 로그인 처리
		service loginService = new service();
		DTO resultDTO = loginService.getID(dto);
		
		if (resultDTO != null) {
			// 로그인 성공
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", resultDTO);
			session.setAttribute("loginEmpno", resultDTO.getEmpno());
			session.setAttribute("loginEname", resultDTO.getEname());
			
			request.setAttribute("message", "로그인 성공!");
			request.setAttribute("dto", resultDTO);
		} else {
			// 로그인 실패
			request.setAttribute("message", "로그인 실패! 사원번호와 이름을 확인하세요.");
			request.setAttribute("dto", dto);
		}
		
		// 결과 페이지로 포워딩
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}
}
