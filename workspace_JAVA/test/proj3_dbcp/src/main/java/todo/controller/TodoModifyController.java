package todo.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.DTO.TodoDTO;
import todo.service.TodoService;

@WebServlet("/modify")
public class TodoModifyController extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		TodoDTO todoDTO = new TodoDTO();
		
		String str_tno = request.getParameter("tno");
		int tno = Integer.parseInt(str_tno);
		todoDTO.setTno(tno);
		
		TodoService todoService = new TodoService();
		TodoDTO todoDTO2 = todoService.getLisTodo(todoDTO);
		
		PrintWriter out = response.getWriter();
		out.println("<form method ='post' action='modify'>");
		
		out.println(" tno : " + todoDTO2.getTno() + "<br>");
		out.println(" title : <input type='text' name='title' value='" + todoDTO2.getTitle() + "'><br>");
		out.println(" Duedate : <input type='date' name='Duedate' value='" + todoDTO2.getDuedate() + "'><br>");
		out.println(" Finished : <input ='number' name = 'finished' value='" + todoDTO2.getFinished() + "'><br>");
		out.println(" <input type = 'hidden' name='tno' value='"+ todoDTO2.getTno() + "'>");
		out.println(" <input type = 'submit' value='수정하기'>");
		out.println(" <a href='todo'><button type = 'button'>목록으로</button></a>");
		out.println("</form>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8;");
		
		String tno = request.getParameter("tno");
		String title = request.getParameter("title");
		String duedate = request.getParameter("Duedate");
		String finished = request.getParameter("finished");
		
		TodoDTO todoDTO = new TodoDTO();
		todoDTO.setTno(Integer.parseInt(tno));
		todoDTO.setTitle(title);
		todoDTO.setDuedate(Date.valueOf(duedate));
		todoDTO.setFinished(Integer.parseInt(finished));
		
		TodoService todoService = new TodoService();
		int result = todoService.modifyTodo(todoDTO);
		System.out.println("업테이트 결과 : "+ result);
		
		response.sendRedirect("todo?command=detail&tno="+tno);
		
	}

}
