package emp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import emp.DTO.EmpDTO;

public class EmpDAO {

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
	//////////////////////
	
	// 리턴 내용
	// 회원이라면 회원 EmpDTO
	// 비회원이라면 null
	public EmpDTO getEmp(EmpDTO dto) {
		EmpDTO resultDTO = null;
		
		// DB 접속
		Connection conn = getConn();

		// sql 준비
			String sql = " select * from emp2";
				   sql += " where empno= ? and ename=? " ;
			try {

				PreparedStatement ps = conn.prepareStatement(sql);
				ps.setInt(1, dto.getEmpno());
				ps.setString(2, dto.getEname());
				
				// 실행
				
				ResultSet rs = ps.executeQuery();
				resultDTO.setEmpno(1);
				// 결과 활용
				if(rs.next()) {
					resultDTO.setEmpno(rs.getInt("empno"));
					resultDTO.setEname(rs.getString("ename"));
					resultDTO.setJob(rs.getString("job"));
					resultDTO.setMgr(rs.getInt("mgr"));
					
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return resultDTO;
	}

}
