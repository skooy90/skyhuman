package movie.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import Movice.MovieDTO;

public class MovieDAO {
	// DB 접속
	private Connection getConn() {
		Connection conn = null;

		try {
			// JNDI : 글씨로 자원을 가져오는 방식
			Context ctx = new InitialContext();
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");
			conn = dataFactory.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}
	// ==============================================================
	
	// 전체 영화 목록 조회
	public List<MovieDTO> selectAllMov() {
		List<MovieDTO> list = new ArrayList<MovieDTO>();
		// DB연결
		Connection conn = getConn();
		
		try {
		//SQL 준비	
			String sql = "SELECT * FROM movie ORDER BY movie_id DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			
		// SQL 실행
			ResultSet rs = ps.executeQuery();
		// SQL 결과 활용
			
			while(rs.next()) {
				MovieDTO dto = new MovieDTO();
				dto.setMovie_id(rs.getInt("movie_id"));
				dto.setTitle(rs.getString("title"));
				dto.setImg_url(rs.getString("img_url"));
				dto.setDate(rs.getDate("open_date"));
				dto.setDescription(rs.getString("description"));
				dto.setGenre(rs.getString("genre"));
				dto.setDirector(rs.getString("director"));
				dto.setRating(rs.getDouble("rating"));
				
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	// 영화 추가
	public int insertMov(MovieDTO movDTO) {
		int result = -1;
		// DB 접속
		Connection conn = getConn();

		try {
			// SQL 준비 
			String sql = "INSERT INTO movie (movie_id, title, img_url, open_date, description, genre, director, rating)";
				   sql += " VALUES (seq_mid.nextval, ?, ?, ?, ?, ?, ?, ?)";
				   
				   PreparedStatement ps = conn.prepareStatement(sql);
				   ps.setString(1, movDTO.getTitle());
				   ps.setString(2, movDTO.getImg_url());
				   ps.setDate(3, movDTO.getDate());
				   ps.setString(4, movDTO.getDescription());
				   ps.setString(5, movDTO.getGenre());
				   ps.setString(6, movDTO.getDirector());
				   ps.setDouble(7, movDTO.getRating());
			// 실행
				   result = ps.executeUpdate();
			// 활용
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// 영화 검색 (제목으로)
	public List<MovieDTO> searchByTitle(String title) {
		List<MovieDTO> list = new ArrayList<MovieDTO>();
		Connection conn = getConn();
		
		try {
			String sql = "SELECT * FROM movie WHERE title LIKE ? ORDER BY movie_id DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%" + title + "%");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				MovieDTO dto = new MovieDTO();
				dto.setMovie_id(rs.getInt("movie_id"));
				dto.setTitle(rs.getString("title"));
				dto.setImg_url(rs.getString("img_url"));
				dto.setDate(rs.getDate("open_date"));
				dto.setDescription(rs.getString("description"));
				dto.setGenre(rs.getString("genre"));
				dto.setDirector(rs.getString("director"));
				dto.setRating(rs.getDouble("rating"));
				
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
	// 영화 상세 조회 (ID로)
	public MovieDTO selectById(int movieId) {
		MovieDTO dto = null;
		Connection conn = getConn();
		
		try {
			String sql = "SELECT * FROM movie WHERE movie_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, movieId);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				dto = new MovieDTO();
				dto.setMovie_id(rs.getInt("movie_id"));
				dto.setTitle(rs.getString("title"));
				dto.setImg_url(rs.getString("img_url"));
				dto.setDate(rs.getDate("open_date"));
				dto.setDescription(rs.getString("description"));
				dto.setGenre(rs.getString("genre"));
				dto.setDirector(rs.getString("director"));
				dto.setRating(rs.getDouble("rating"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return dto;
	}
	
	// 영화 수정
	public int updateMov(MovieDTO movDTO) {
		int result = -1;
		Connection conn = getConn();
		
		try {
			String sql = "UPDATE movie SET title=?, img_url=?, open_date=?, description=?, genre=?, director=?, rating=? WHERE movie_id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, movDTO.getTitle());
			ps.setString(2, movDTO.getImg_url());
			ps.setDate(3, movDTO.getDate());
			ps.setString(4, movDTO.getDescription());
			ps.setString(5, movDTO.getGenre());
			ps.setString(6, movDTO.getDirector());
			ps.setDouble(7, movDTO.getRating());
			ps.setInt(8, movDTO.getMovie_id());
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	// 영화 삭제
	public int deleteMov(int movieId) {
		int result = -1;
		Connection conn = getConn();
		
		try {
			String sql = "DELETE FROM movie WHERE movie_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, movieId);
			
			result = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	// 통계 정보 조회
	public int getTotalCount() {
		int count = 0;
		Connection conn = getConn();
		
		try {
			String sql = "SELECT COUNT(*) FROM movie";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return count;
	}
	
	// 평점별 영화 조회
	public List<MovieDTO> getMoviesByRating(double minRating) {
		List<MovieDTO> list = new ArrayList<MovieDTO>();
		Connection conn = getConn();
		
		try {
			String sql = "SELECT * FROM movie WHERE rating >= ? ORDER BY rating DESC";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setDouble(1, minRating);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				MovieDTO dto = new MovieDTO();
				dto.setMovie_id(rs.getInt("movie_id"));
				dto.setTitle(rs.getString("title"));
				dto.setImg_url(rs.getString("img_url"));
				dto.setDate(rs.getDate("open_date"));
				dto.setDescription(rs.getString("description"));
				dto.setGenre(rs.getString("genre"));
				dto.setDirector(rs.getString("director"));
				dto.setRating(rs.getDouble("rating"));
				
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}
	
}
