package movie.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import movie.service.MovSer;

@WebServlet("/add")
public class MovieAddController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("영화 추가 - doPost 실행");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// 폼 데이터 받기
		String title = request.getParameter("title");
		String imgUrl = request.getParameter("img_url");
		String dateStr = request.getParameter("date");
		String description = request.getParameter("description");
		String genre = request.getParameter("genre");
		String director = request.getParameter("director");
		String ratingStr = request.getParameter("rating");
		
		// 기본값 설정
		if (imgUrl == null) imgUrl = "";
		if (description == null) description = "";
		if (genre == null) genre = "";
		if (director == null) director = "";
		
		double rating = 0.0;
		if (ratingStr != null && !ratingStr.isEmpty()) {
			try {
				rating = Double.parseDouble(ratingStr);
			} catch (NumberFormatException e) {
				rating = 0.0;
			}
		}
		
		MovSer movSer = new MovSer();
		int result = movSer.addMovie(title, imgUrl, dateStr, description, genre, director, rating);
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html lang='ko'>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
		out.println("<title>영화 추가 결과 - 영화 관리 시스템</title>");
		out.println("<style>");
		out.println("* { margin: 0; padding: 0; box-sizing: border-box; }");
		out.println("body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); min-height: 100vh; padding: 20px; }");
		out.println(".container { max-width: 600px; margin: 0 auto; background: white; border-radius: 15px; box-shadow: 0 20px 40px rgba(0,0,0,0.1); overflow: hidden; }");
		out.println(".header { background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); color: white; padding: 30px; text-align: center; }");
		out.println(".content { padding: 40px; text-align: center; }");
		out.println(".result { margin: 30px 0; padding: 20px; border-radius: 10px; }");
		out.println(".success { background: #d4edda; color: #155724; border: 1px solid #c3e6cb; }");
		out.println(".error { background: #f8d7da; color: #721c24; border: 1px solid #f5c6cb; }");
		out.println(".btn { display: inline-block; padding: 12px 30px; background: #667eea; color: white; text-decoration: none; border-radius: 25px; font-weight: 600; margin: 10px; }");
		out.println(".btn:hover { background: #5a6fd8; }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<div class='container'>");
		out.println("<div class='header'>");
		out.println("<h1>영화 추가 결과</h1>");
		out.println("</div>");
		
		out.println("<div class='content'>");
		
		if (result > 0) {
			out.println("<div class='result success'>");
			out.println("<h3>✅ 영화가 성공적으로 추가되었습니다!</h3>");
			out.println("<p>영화 제목: " + title + "</p>");
			out.println("</div>");
		} else {
			out.println("<div class='result error'>");
			out.println("<h3>❌ 영화 추가에 실패했습니다.</h3>");
			out.println("<p>다시 시도해주세요.</p>");
			out.println("</div>");
		}
		
		out.println("<div style='margin-top: 30px;'>");
		out.println("<a href='list' class='btn'>영화 목록 보기</a>");
		out.println("<a href='add.html' class='btn'>영화 추가하기</a>");
		out.println("<a href='index.html' class='btn'>홈으로</a>");
		out.println("</div>");
		
		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET 요청시 추가 폼으로 리다이렉트
		response.sendRedirect("add.html");
	}
}
