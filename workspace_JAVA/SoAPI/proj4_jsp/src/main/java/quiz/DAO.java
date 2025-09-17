package quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;


public class DAO {
	// BD 접속
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
		
		
		//////////////////////////
		//list
		public List selectAllID() {
			List<DTO> list = new ArrayList<DTO>();
			// DB연결
			Connection conn = getConn();
			
			try {
			//SQL 준비	
				String sql = " select * from emp2";
				PreparedStatement ps = conn.prepareStatement(sql);
				
			// SQL 실행
				ResultSet rs = ps.executeQuery();
			// SQL 결과 활용
				
				while(rs.next()) {
					DTO dto = new DTO();
					dto.setEmpno(rs.getInt("empno"));
					dto.setEname(rs.getString("ename"));
					dto.setJob(rs.getString("job"));
					
					list.add(dto);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			return list;
		}
		// 한명만 조회
		public DTO selectID(DTO dTO) {
			DTO resultDTO = null;

			// DB 접속
			Connection conn = getConn();

			try {
				// SQL 준비

				String sql = " select * from emp2";
				sql += " where empno = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, dTO.getEmpno());
				// SQL 실행
				ResultSet rs = ps.executeQuery();

				// 결과 활용

				// while(rs.next())
				if (rs.next()) {
					resultDTO = new DTO();
					Integer empno = rs.getInt("empno");
					resultDTO.setEmpno(empno);

					resultDTO.setEname(rs.getString("ename"));
					resultDTO.setJob(rs.getString("job"));
				};

			} catch (Exception e) {

				e.printStackTrace();

			}

			return resultDTO;
		}
}
