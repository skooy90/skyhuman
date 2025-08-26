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

@WebServlet("/stats")
public class MovieStatsController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("영화 통계 - doGet 실행");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		MovSer movSer = new MovSer();
		
		// 통계 데이터 수집
		int totalCount = movSer.getTotalMovieCount();
		double avgRating = movSer.getAverageRating();
		MovieDTO highestRated = movSer.getHighestRatedMovie();
		List<MovieDTO> recentMovies = movSer.getRecentMovies();
		List<MovieDTO> highRatedMovies = movSer.getMoviesByRating(8.0);
		
		PrintWriter out = response.getWriter();
		
		// HTML 헤더
		out.println("<!DOCTYPE html>");
		out.println("<html lang='ko'>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
		out.println("<title>영화 통계 - 영화 관리 시스템</title>");
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
		out.println(".stats-grid { display: grid; grid-template-columns: repeat(auto-fit, minmax(250px, 1fr)); gap: 20px; margin-bottom: 40px; }");
		out.println(".stat-card { background: #f8f9fa; padding: 30px; border-radius: 15px; text-align: center; box-shadow: 0 5px 15px rgba(0,0,0,0.1); }");
		out.println(".stat-number { font-size: 3em; font-weight: bold; color: #667eea; margin-bottom: 10px; }");
		out.println(".stat-label { color: #666; font-size: 1.1em; }");
		out.println(".section { margin-bottom: 40px; }");
		out.println(".section h3 { color: #333; margin-bottom: 20px; font-size: 1.5em; }");
		out.println(".movie-grid { display: grid; grid-template-columns: repeat(auto-fill, minmax(250px, 1fr)); gap: 20px; }");
		out.println(".movie-card { background: #f8f9fa; border-radius: 10px; overflow: hidden; box-shadow: 0 5px 15px rgba(0,0,0,0.1); }");
		out.println(".movie-poster { width: 100%; height: 300px; object-fit: cover; }");
		out.println(".movie-info { padding: 15px; }");
		out.println(".movie-title { font-weight: bold; color: #333; margin-bottom: 5px; }");
		out.println(".movie-rating { color: #f39c12; font-weight: bold; }");
		out.println(".btn { display: inline-block; padding: 8px 16px; background: #667eea; color: white; text-decoration: none; border-radius: 20px; font-size: 14px; margin: 5px; }");
		out.println(".btn:hover { background: #5a6fd8; }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		
		out.println("<div class='container'>");
		out.println("<div class='header'>");
		out.println("<h1>📊 영화 통계</h1>");
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
		
		// 주요 통계 카드
		out.println("<div class='stats-grid'>");
		out.println("<div class='stat-card'>");
		out.println("<div class='stat-number'>" + totalCount + "</div>");
		out.println("<div class='stat-label'>총 영화 수</div>");
		out.println("</div>");
		
		out.println("<div class='stat-card'>");
		out.println("<div class='stat-number'>" + String.format("%.1f", avgRating) + "</div>");
		out.println("<div class='stat-label'>평균 평점</div>");
		out.println("</div>");
		
		if (highestRated != null) {
			out.println("<div class='stat-card'>");
			out.println("<div class='stat-number'>" + highestRated.getRating() + "</div>");
			out.println("<div class='stat-label'>최고 평점</div>");
			out.println("</div>");
		}
		
		out.println("<div class='stat-card'>");
		out.println("<div class='stat-number'>" + highRatedMovies.size() + "</div>");
		out.println("<div class='stat-label'>8점 이상 영화</div>");
		out.println("</div>");
		out.println("</div>");
		
		// 최고 평점 영화
		if (highestRated != null) {
			out.println("<div class='section'>");
			out.println("<h3>🏆 최고 평점 영화</h3>");
			out.println("<div class='movie-grid'>");
			out.println("<div class='movie-card'>");
			
			if (highestRated.getImg_url() != null && !highestRated.getImg_url().isEmpty()) {
				out.println("<img src='" + highestRated.getImg_url() + "' alt='" + highestRated.getTitle() + "' class='movie-poster'>");
			} else {
				out.println("<div style='width: 100%; height: 300px; background: #ddd; display: flex; align-items: center; justify-content: center;'>");
				out.println("<span style='color: #999;'>포스터 없음</span>");
				out.println("</div>");
			}
			
			out.println("<div class='movie-info'>");
			out.println("<div class='movie-title'>" + highestRated.getTitle() + "</div>");
			out.println("<div class='movie-rating'>평점: " + highestRated.getRating() + "점</div>");
			if (highestRated.getDirector() != null && !highestRated.getDirector().isEmpty()) {
				out.println("<div style='color: #666; font-size: 0.9em;'>감독: " + highestRated.getDirector() + "</div>");
			}
			out.println("<a href='detail?id=" + highestRated.getMovie_id() + "' class='btn'>상세보기</a>");
			out.println("</div>");
			out.println("</div>");
			out.println("</div>");
			out.println("</div>");
		}
		
		// 최근 추가된 영화
		if (!recentMovies.isEmpty()) {
			out.println("<div class='section'>");
			out.println("<h3>🆕 최근 추가된 영화</h3>");
			out.println("<div class='movie-grid'>");
			
			for (MovieDTO movie : recentMovies) {
				out.println("<div class='movie-card'>");
				
				if (movie.getImg_url() != null && !movie.getImg_url().isEmpty()) {
					out.println("<img src='" + movie.getImg_url() + "' alt='" + movie.getTitle() + "' class='movie-poster'>");
				} else {
					out.println("<div style='width: 100%; height: 300px; background: #ddd; display: flex; align-items: center; justify-content: center;'>");
					out.println("<span style='color: #999;'>포스터 없음</span>");
					out.println("</div>");
				}
				
				out.println("<div class='movie-info'>");
				out.println("<div class='movie-title'>" + movie.getTitle() + "</div>");
				if (movie.getRating() > 0) {
					out.println("<div class='movie-rating'>평점: " + movie.getRating() + "점</div>");
				}
				if (movie.getDate() != null) {
					out.println("<div style='color: #666; font-size: 0.9em;'>개봉일: " + movie.getDate() + "</div>");
				}
				out.println("<a href='detail?id=" + movie.getMovie_id() + "' class='btn'>상세보기</a>");
				out.println("</div>");
				out.println("</div>");
			}
			
			out.println("</div>");
			out.println("</div>");
		}
		
		// 고평점 영화들
		if (!highRatedMovies.isEmpty()) {
			out.println("<div class='section'>");
			out.println("<h3>⭐ 8점 이상 영화들</h3>");
			out.println("<div class='movie-grid'>");
			
			for (MovieDTO movie : highRatedMovies) {
				out.println("<div class='movie-card'>");
				
				if (movie.getImg_url() != null && !movie.getImg_url().isEmpty()) {
					out.println("<img src='" + movie.getImg_url() + "' alt='" + movie.getTitle() + "' class='movie-poster'>");
				} else {
					out.println("<div style='width: 100%; height: 300px; background: #ddd; display: flex; align-items: center; justify-content: center;'>");
					out.println("<span style='color: #999;'>포스터 없음</span>");
					out.println("</div>");
				}
				
				out.println("<div class='movie-info'>");
				out.println("<div class='movie-title'>" + movie.getTitle() + "</div>");
				out.println("<div class='movie-rating'>평점: " + movie.getRating() + "점</div>");
				if (movie.getDirector() != null && !movie.getDirector().isEmpty()) {
					out.println("<div style='color: #666; font-size: 0.9em;'>감독: " + movie.getDirector() + "</div>");
				}
				out.println("<a href='detail?id=" + movie.getMovie_id() + "' class='btn'>상세보기</a>");
				out.println("</div>");
				out.println("</div>");
			}
			
			out.println("</div>");
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
