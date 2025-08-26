package movie.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Movice.MovieDTO;
import movie.service.MovSer;

@WebServlet("/list")
public class MovLisCon extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("영화 목록 조회 - doGet 실행");
		request.setCharacterEncoding("utf-8");		
		// 응답할때 한글깨짐 방지
		response.setContentType("text/html;charset=utf-8;");
		
		MovSer movSer = new MovSer();
		List<MovieDTO> list = movSer.getAllMov();
		
		PrintWriter out = response.getWriter();
		
		// HTML 헤더
		out.println("<!DOCTYPE html>");
		out.println("<html lang='ko'>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
		out.println("<title>영화 목록 - 영화 관리 시스템</title>");
		out.println("<style>");
		out.println("* { margin: 0; padding: 0; box-sizing: border-box; }");
		out.println("body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); min-height: 100vh; padding: 20px; }");
		out.println(".container { max-width: 1200px; margin: 0 auto; background: white; border-radius: 15px; box-shadow: 0 20px 40px rgba(0,0,0,0.1); overflow: hidden; }");
		out.println(".header { background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); color: white; padding: 30px; text-align: center; }");
		out.println(".header h1 { font-size: 2.5em; margin-bottom: 10px; }");
		out.println(".nav { background: #f8f9fa; padding: 20px; border-bottom: 1px solid #e9ecef; }");
		out.println(".nav ul { list-style: none; display: flex; justify-content: center; gap: 30px; }");
		out.println(".nav a { text-decoration: none; color: #495057; font-weight: 600; padding: 10px 20px; border-radius: 25px; transition: all 0.3s ease; }");
		out.println(".nav a:hover { background: #667eea; color: white; transform: translateY(-2px); }");
		out.println(".content { padding: 40px; }");
		out.println(".movie-grid { display: grid; grid-template-columns: repeat(auto-fill, minmax(300px, 1fr)); gap: 30px; margin-top: 30px; }");
		out.println(".movie-card { background: #f8f9fa; border-radius: 15px; overflow: hidden; box-shadow: 0 10px 20px rgba(0,0,0,0.1); transition: transform 0.3s ease; }");
		out.println(".movie-card:hover { transform: translateY(-5px); }");
		out.println(".movie-poster { width: 100%; height: 400px; object-fit: cover; }");
		out.println(".movie-info { padding: 20px; }");
		out.println(".movie-title { font-size: 1.3em; font-weight: bold; color: #333; margin-bottom: 10px; }");
		out.println(".movie-details { color: #666; margin-bottom: 5px; }");
		out.println(".movie-rating { color: #f39c12; font-weight: bold; }");
		out.println(".btn { display: inline-block; padding: 8px 16px; background: #667eea; color: white; text-decoration: none; border-radius: 20px; font-size: 14px; margin: 5px; }");
		out.println(".btn:hover { background: #5a6fd8; }");
		out.println(".btn-danger { background: #e74c3c; }");
		out.println(".btn-danger:hover { background: #c0392b; }");
		out.println(".stats { background: #f8f9fa; padding: 20px; border-radius: 10px; margin-bottom: 30px; text-align: center; }");
		out.println(".stats h3 { color: #667eea; margin-bottom: 10px; }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<div class='container'>");
		out.println("<div class='header'>");
		out.println("<h1>🎬 영화 목록</h1>");
		out.println("</div>");
		
		out.println("<div class='nav'>");
		out.println("<ul>");
		out.println("<li><a href='index.html'>홈</a></li>");
		out.println("<li><a href='list'>영화 목록</a></li>");
		out.println("<li><a href='add.html'>영화 추가</a></li>");
		out.println("<li><a href='search'>영화 검색</a></li>");
		out.println("<li><a href='stats'>통계</a></li>");
		out.println("</ul>");
		out.println("</div>");
		
		out.println("<div class='content'>");
		
		// 통계 정보 표시
		int totalCount = movSer.getTotalMovieCount();
		double avgRating = movSer.getAverageRating();
		MovieDTO highestRated = movSer.getHighestRatedMovie();
		
		out.println("<div class='stats'>");
		out.println("<h3>📊 영화 통계</h3>");
		out.println("<p>총 영화 수: " + totalCount + "편 | 평균 평점: " + String.format("%.1f", avgRating) + "점");
		if (highestRated != null) {
			out.println(" | 최고 평점: " + highestRated.getTitle() + " (" + highestRated.getRating() + "점)");
		}
		out.println("</p>");
		out.println("</div>");
		
		if (list.isEmpty()) {
			out.println("<div style='text-align: center; padding: 50px;'>");
			out.println("<h3>등록된 영화가 없습니다.</h3>");
			out.println("<p>첫 번째 영화를 추가해보세요!</p>");
			out.println("<a href='add.html' class='btn'>영화 추가하기</a>");
			out.println("</div>");
		} else {
			out.println("<div class='movie-grid'>");
			
			for(MovieDTO movie : list) {
				out.println("<div class='movie-card'>");
				
				// 포스터 이미지
				if (movie.getImg_url() != null && !movie.getImg_url().isEmpty()) {
					out.println("<img src='" + movie.getImg_url() + "' alt='" + movie.getTitle() + "' class='movie-poster'>");
				} else {
					out.println("<div style='width: 100%; height: 400px; background: #ddd; display: flex; align-items: center; justify-content: center;'>");
					out.println("<span style='color: #999;'>포스터 없음</span>");
					out.println("</div>");
				}
				
				out.println("<div class='movie-info'>");
				out.println("<div class='movie-title'>" + movie.getTitle() + "</div>");
				
				if (movie.getDirector() != null && !movie.getDirector().isEmpty()) {
					out.println("<div class='movie-details'>감독: " + movie.getDirector() + "</div>");
				}
				
				if (movie.getGenre() != null && !movie.getGenre().isEmpty()) {
					out.println("<div class='movie-details'>장르: " + movie.getGenre() + "</div>");
				}
				
				if (movie.getDate() != null) {
					out.println("<div class='movie-details'>개봉일: " + movie.getDate() + "</div>");
				}
				
				if (movie.getRating() > 0) {
					out.println("<div class='movie-rating'>평점: " + movie.getRating() + "점</div>");
				}
				
				if (movie.getDescription() != null && !movie.getDescription().isEmpty()) {
					String shortDesc = movie.getDescription().length() > 100 ? 
						movie.getDescription().substring(0, 100) + "..." : movie.getDescription();
					out.println("<div class='movie-details' style='margin-top: 10px; font-style: italic;'>" + shortDesc + "</div>");
				}
				
				out.println("<div style='margin-top: 15px;'>");
				out.println("<a href='detail?id=" + movie.getMovie_id() + "' class='btn'>상세보기</a>");
				out.println("<a href='edit?id=" + movie.getMovie_id() + "' class='btn'>수정</a>");
				out.println("<a href='delete?id=" + movie.getMovie_id() + "' class='btn btn-danger' onclick='return confirm(\"정말 삭제하시겠습니까?\")'>삭제</a>");
				out.println("</div>");
				
				out.println("</div>");
				out.println("</div>");
			}
			
			out.println("</div>");
		}
		
		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("영화 목록 조회 - doPost 실행");
		doGet(request, response);
	}
}
