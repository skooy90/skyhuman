package todo.DAO;

import java.io.ObjectInputStream.GetField;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import todo.DTO.TodoDTO;

// DAO : Data Access Object 
public class TodoDAO {

	// tbl_todo 의 모든 항목을 돌려주는 메소드
	// 메소드 명 : selectAll
	// 전달인자 : 없음
	// 리턴타입 : List<TodoDTO>

	public List<TodoDTO> selectAll() {

		List<TodoDTO> list = new ArrayList<TodoDTO>();

		try {

			Connection conn = getConnection();

			// SQL 준비
			String query = "select * from tbl_todo";

			PreparedStatement ps = conn.prepareStatement(query);

			// 실행 및 결과 확보
			ResultSet rs = ps.executeQuery();
			// select 만 executeQuery로 실행한다.

			while (rs.next()) {
				// 전달인자로 컬럼명 (대소문자 구분없음)
				int tno = rs.getInt("tno");
				String title = rs.getString("title");
				Date duedate = rs.getDate("duedate");
				int finished = rs.getInt("finished");

				System.out.println("title : " + title);

				// 한개 세트 아이디어만 구상
//				Map map = new HashMap();
//				map.put("tno", tno);
//				map.put("title", title);
//				map.put("duedate", duedate);
//				map.put("finished", finished);
//				list.add(map);

				TodoDTO tododto = new TodoDTO();
				tododto.setTno(tno);
				tododto.setTitle(title);
				tododto.setDuedate(duedate);
				tododto.setFinished(finished);
				list.add(tododto);

			}

			rs.close();
			ps.close();
			conn.close(); // 커넥션 풀로 반환
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	// ================================================================

	Connection getConnection() {
		Connection conn = null;
		try {
			// JNDI 방식으로
			// context.xml에 있는 DB정보를 가져온다
			Context ctx = new InitialContext();
			// 커넥션 풀 관리자
			DataSource dataFactory = (DataSource) ctx.lookup("java:/comp/env/jdbc/oracle");

			// DB 접속
			conn = dataFactory.getConnection();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// ===============================================================

	// 자료 삽입
	// 메소드명 : insert
	// 전달인자 : TodoDTO
	// 리턴 타입 : int -> insert된 행의 수

	public int insert(TodoDTO dto) {
		int result = -1;
		try {
			// 접속
			Connection conn = getConnection();

			// SQL 준비
			String query = "insert into ";
			query += "tbl_todo(tno, title,duedate,finished) ";
			// query += "values (seq_tbl_todo.nextval,
			// '"+dto.getTitle()+"','"+dto.getDuedate()+"', "+dto.getFinished()+")";
			query += "values (seq_tbl_todo.nextval, ?, ?, ?)"; // 변수 방식

			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, dto.getTitle());
			ps.setDate(2, dto.getDuedate());
			ps.setInt(3, dto.getFinished());

			// SQL 실행 및 결과 확보
			// select 느 : executeQuery();
			// select 외 실행 : executeUpdate(); 로 실행

			result = ps.executeUpdate();
			// 결과 활용
			System.out.println(result + "행 이(가) 삽입되었습니다.");
			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	// =============================================
	public int delete(TodoDTO dto) {
		int result = -1;

		try {
			// 접속
			Connection conn = getConnection();

			// SQL 준비
			String query = " delete tbl_todo";
			query += " where tno = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, dto.getTno());

			result = ps.executeUpdate();

			ps.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

	public TodoDTO selectTodo(TodoDTO dto) {
		TodoDTO resultDTO = null;
		// DB접속
		Connection conn = getConnection();
		// SQL 문 작성
		String sql = "select * from tbl_todo where tno = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			// 실행하고 결과확보
			ps = conn.prepareStatement(sql);
			// ?에 채우기 위한 작업
			ps.setInt(1, dto.getTno());
			rs = ps.executeQuery();
			// 결과 활용
			while (rs.next()) {
				resultDTO = new TodoDTO();
				int tno = rs.getInt("tno");
				resultDTO.setTno(tno);
				resultDTO.setTitle(rs.getString("title"));
				resultDTO.setDuedate(rs.getDate("duedate"));
				resultDTO.setFinished(rs.getInt("finished"));

			}
			ps.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultDTO;
	}

	public int updateTodo(TodoDTO dto) {
		int result = -1;
		try {
			// DB접속
			Connection conn = getConnection();
			// SQL 문 작성
			String query = " update tbl_todo";
				query += " set title = ?,"; 
				query += " 		duedate = ?,"; 
				query += " 		finished = ?"; 
				query += " where tno = ?"; 
				  PreparedStatement ps = conn.prepareStatement(query);
				  ps.setString(1, dto.getTitle());
				  ps.setDate(2, dto.getDuedate());
				  ps.setInt(3, dto.getFinished());
				  ps.setInt(4, dto.getTno());
				  
				  result = ps.executeUpdate();
				  System.out.println(result + " 행 이(가) 업데이트 되었습니다.");
				  
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
