package emp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import emp.DTO2.EmpDTO;
import emp.service.EmpService;

@WebServlet("/list")
public class EmpListController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
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
			
			
			String sPagePerRows = request.getParameter("size");
			String sPage = request.getParameter("page");
			
			// 기본값 설정
			int pagePerRows = 10;
			int page = 1;
			try {				
			pagePerRows = Integer.parseInt(sPagePerRows);
			}catch (Exception e) {
				e.printStackTrace();
			}
			try {
				page = Integer.parseInt(sPage);
			} catch (Exception e) {
				e.printStackTrace();
			}
			EmpDTO dTO = new EmpDTO();
			dTO.setPagePerRows(pagePerRows);
			dTO.setPage(page);
			
			
			dTO.setEmpno(empno);
			
			EmpService service = new EmpService();
//			List<EmpDTO> list = service.getAllEmp();
			List<EmpDTO> list = service.getPageEmp(dTO);
			
			request.setAttribute("list", list);
			request.setAttribute("dTO", dTO);
			
			RequestDispatcher dis = request.getRequestDispatcher("paging.jsp");
			dis.forward(request, response);
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
}
