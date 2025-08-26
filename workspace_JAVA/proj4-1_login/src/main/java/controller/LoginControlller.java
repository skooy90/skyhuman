package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import emp.DAO.EmpDAO;
import emp.DTO.EmpDTO;

@WebServlet("/loginCheck")
public class LoginControlller extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		System.out.println("doPost 실행");
		int empno = 0;

		String strEmpno = request.getParameter("empno"); // pw
		String Ename = request.getParameter("ename"); // id
		System.out.println("pppp");
		System.out.println(strEmpno != null);
		try {
			if (strEmpno != null) {
				empno = Integer.parseInt(strEmpno);
				
				EmpDTO dto = new EmpDTO();
				dto.setEname(Ename);
				dto.setEmpno(empno);
				
				
				//BD 연결함
				EmpDAO dao = new EmpDAO();
				EmpDTO resultDTO = dao.getEmp(dto);
				// 로그인 성공 여부 판단
				System.out.println("qqqq");
				if(resultDTO == null) {
					
					// 비회원
					// 로그인 페이지로
					response.sendRedirect("login.jsp?msg=1");
				}else {
					// 회원
					HttpSession sess = request.getSession();
					sess.setAttribute("dto", resultDTO);
					response.sendRedirect("list");
					
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		

	}

}
