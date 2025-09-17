package movie.service;

import java.sql.Date;
import java.util.List;

import Movice.MovieDTO;
import movie.DAO.MovieDAO;

public class MovSer {
	
	MovieDAO movDAO = new MovieDAO();
	
	// 전체 영화 목록 조회
	public List<MovieDTO> getAllMov() {
		List<MovieDTO> list = movDAO.selectAllMov();
		return list;
	}
	
	// 영화 추가
	public int addMovie(String title, String imgUrl, String dateStr, String description, String genre, String director, double rating) {
		MovieDTO dto = new MovieDTO();
		dto.setTitle(title);
		dto.setImg_url(imgUrl);
		dto.setDate(Date.valueOf(dateStr));
		dto.setDescription(description);
		dto.setGenre(genre);
		dto.setDirector(director);
		dto.setRating(rating);
		
		return movDAO.insertMov(dto);
	}
	
	// 영화 검색
	public List<MovieDTO> searchMovies(String title) {
		return movDAO.searchByTitle(title);
	}
	
	// 영화 상세 조회
	public MovieDTO getMovieById(int movieId) {
		return movDAO.selectById(movieId);
	}
	
	// 영화 수정
	public int updateMovie(int movieId, String title, String imgUrl, String dateStr, String description, String genre, String director, double rating) {
		MovieDTO dto = new MovieDTO();
		dto.setMovie_id(movieId);
		dto.setTitle(title);
		dto.setImg_url(imgUrl);
		dto.setDate(Date.valueOf(dateStr));
		dto.setDescription(description);
		dto.setGenre(genre);
		dto.setDirector(director);
		dto.setRating(rating);
		
		return movDAO.updateMov(dto);
	}
	
	// 영화 삭제
	public int deleteMovie(int movieId) {
		return movDAO.deleteMov(movieId);
	}
	
	// 총 영화 수 조회
	public int getTotalMovieCount() {
		return movDAO.getTotalCount();
	}
	
	// 평점별 영화 조회
	public List<MovieDTO> getMoviesByRating(double minRating) {
		return movDAO.getMoviesByRating(minRating);
	}
	
	// 평균 평점 계산
	public double getAverageRating() {
		List<MovieDTO> allMovies = getAllMov();
		if (allMovies.isEmpty()) {
			return 0.0;
		}
		
		double totalRating = 0.0;
		int count = 0;
		
		for (MovieDTO movie : allMovies) {
			if (movie.getRating() > 0) {
				totalRating += movie.getRating();
				count++;
			}
		}
		
		return count > 0 ? totalRating / count : 0.0;
	}
	
	// 최고 평점 영화 조회
	public MovieDTO getHighestRatedMovie() {
		List<MovieDTO> allMovies = getAllMov();
		if (allMovies.isEmpty()) {
			return null;
		}
		
		MovieDTO highestRated = allMovies.get(0);
		for (MovieDTO movie : allMovies) {
			if (movie.getRating() > highestRated.getRating()) {
				highestRated = movie;
			}
		}
		
		return highestRated;
	}
	
	// 최근 개봉 영화 조회 (최근 3개)
	public List<MovieDTO> getRecentMovies() {
		List<MovieDTO> allMovies = getAllMov();
		if (allMovies.size() <= 3) {
			return allMovies;
		}
		
		return allMovies.subList(0, 3);
	}
}
