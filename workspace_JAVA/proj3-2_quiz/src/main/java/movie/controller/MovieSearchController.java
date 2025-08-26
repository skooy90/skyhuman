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

@WebServlet("/search")
public class MovieSearchController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("영화 검색 - doGet 실행");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String searchTitle = request.getParameter("title");
		
		PrintWriter out = response.getWriter();
		
		// HTML 헤더
		out.println("<!DOCTYPE html>");
		out.println("<html lang='ko'>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
		out.println("<title>영화 검색 - 영화 관리 시스템</title>");
		out.println("<style>");
		out.println("* { margin: 0; padding: 0; box-sizing: border-box; }");
		out.println("body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); min-height: 100vh; padding: 20px; }");
		out.println(".container { max-width: 1200px; margin: 0 auto; background: white; border-radius: 15px; box-shadow: 0 20px 40px rgba(0,0,0,0.1); overflow: hidden; }");
		out.println(".header { background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); color: white; padding: 30px; text-align: center; }");
		out.println(".nav { background: #f8f9fa; padding: 20px; border-bottom: 1px solid #e9ecef; }");
		out.println(".nav ul { list-style: none; display: flex; justify-content: center; gap: 30px; }");
		out.println(".nav a { text-decoration: none; color: #495057; font-weight: 600; padding: 10px 20px; border-radius: 25px; transition: all 0.3s ease; }");
		out.println(".nav a:hover { background: #667eea; color: white; transform: translateY(-2px); }");
		out.println(".content { padding: 40px; }");
		out.println(".search-form { background: #f8f9fa; padding: 30px; border-radius: 10px; margin-bottom: 30px; text-align: center; }");
		out.println(".search-input { width: 60%; padding: 12px 20px; border: 2px solid #e9ecef; border-radius: 25px; font-size: 16px; margin-right: 10px; }");
		out.println(".search-input:focus { outline: none; border-color: #667eea; }");
		out.println(".btn { display: inline-block; padding: 12px 30px; background: #667eea; color: white; text-decoration: none; border: none; border-radius: 25px; font-weight: 600; font-size: 16px; cursor: pointer; }");
		out.println(".btn:hover { background: #5a6fd8; }");
		out.println(".movie-grid { display: grid; grid-template-columns: repeat(auto-fill, minmax(300px, 1fr)); gap: 30px; margin-top: 30px; }");
		out.println(".movie-card { background: #f8f9fa; border-radius: 15px; overflow: hidden; box-shadow: 0 10px 20px rgba(0,0,0,0.1); transition: transform 0.3s ease; }");
		out.println(".movie-card:hover { transform: translateY(-5px); }");
		out.println(".movie-poster { width: 100%; height: 400px; object-fit: cover; }");
		out.println(".movie-info { padding: 20px; }");
		out.println(".movie-title { font-size: 1.3em; font-weight: bold; color: #333; margin-bottom: 10px; }");
		out.println(".movie-details { color: #666; margin-bottom: 5px; }");
		out.println(".movie-rating { color: #f39c12; font-weight: bold; }");
		out.println(".no-results { text-align: center; padding: 50px; color: #666; }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<div class='container'>");
		out.println("<div class='header'>");
		out.println("<h1>🔍 영화 검색</h1>");
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
		
		// 검색 폼
		out.println("<div class='search-form'>");
		out.println("<form method='get' action='search'>");
		out.println("<input type='text' name='title' class='search-input' placeholder='영화 제목을 입력하세요' value='" + (searchTitle != null ? searchTitle : "") + "'>");
		out.println("<button type='submit' class='btn'>검색</button>");
		out.println("</form>");
		out.println("</div>");
		
		// 검색 결과 표시
		if (searchTitle != null && !searchTitle.trim().isEmpty()) {
			MovSer movSer = new MovSer();
			List<MovieDTO> searchResults = movSer.searchMovies(searchTitle.trim());
			
			if (searchResults.isEmpty()) {
				out.println("<div class='no-results'>");
				out.println("<h3>검색 결과가 없습니다.</h3>");
				out.println("<p>'<strong>" + searchTitle + "</strong>'에 대한 검색 결과를 찾을 수 없습니다.</p>");
				out.println("<p>다른 키워드로 검색해보세요.</p>");
				out.println("</div>");
			} else {
				out.println("<h3 style='margin-bottom: 20px; color: #333;'>검색 결과 (" + searchResults.size() + "편)</h3>");
				out.println("<div class='movie-grid'>");
				
				for (MovieDTO movie : searchResults) {
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
					out.println("</div>");
					
					out.println("</div>");
					out.println("</div>");
				}
				
				out.println("</div>");
			}
		} else {
			out.println("<div class='no-results'>");
			out.println("<h3>영화를 검색해보세요</h3>");
			out.println("<p>위의 검색창에 영화 제목을 입력하고 검색 버튼을 클릭하세요.</p>");
			out.println("</div>");
		}
		
		out.println("</div>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
