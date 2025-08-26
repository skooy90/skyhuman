package emp.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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

	// ==============================================================

	public List selectAllEmp() {
		List<EmpDTO> list = new ArrayList<EmpDTO>();

		// DB 접속
		Connection conn = getConn();

		try {
			// SQL 준비

			String sql = " select * from emp2";
			PreparedStatement ps = conn.prepareStatement(sql);

			// SQL 실행
			ResultSet rs = ps.executeQuery();

			// 결과 활용

			while (rs.next()) {
				EmpDTO dto = new EmpDTO();

				Integer empno = rs.getInt("empno");
				dto.setEmpno(empno);

				dto.setEname(rs.getString("ename"));
				dto.setSal(rs.getInt("sal"));

				list.add(dto);
			}
			;

		} catch (Exception e) {

			e.printStackTrace();

		}

		return list;
	}

	// 한명만 조회
	public EmpDTO selectOneEmp(EmpDTO empDTO) {
		EmpDTO resultDTO = null;

		// DB 접속
		Connection conn = getConn();

		try {
			// SQL 준비

			String sql = " select * from emp2";
			sql += " where empno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, empDTO.getEmpno());
			// SQL 실행
			ResultSet rs = ps.executeQuery();

			// 결과 활용

			// while(rs.next())
			if (rs.next()) {
				resultDTO = new EmpDTO();
				Integer empno = rs.getInt("empno");
				resultDTO.setEmpno(empno);

				resultDTO.setEname(rs.getString("ename"));
				resultDTO.setJob(rs.getString("job"));
				resultDTO.setMgr(rs.getInt("mgr"));
				resultDTO.setHiredate(rs.getDate("hiredate"));
				resultDTO.setSal(rs.getInt("sal"));
				resultDTO.setComm(rs.getInt("comm"));
				resultDTO.setDeptno(rs.getInt("deptno"));
			}
			;

		} catch (Exception e) {

			e.printStackTrace();

		}

		return resultDTO;
	}

	public int deleteEmp(EmpDTO empDTO) {

		int result = -1;
		
		try {
			// DB 접속
			Connection conn = getConn();

			// SQL 준비
			String sql = " delete emp2";
			sql += " where empno = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, empDTO.getEmpno());
			
			result = ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
	public int insertEmp(EmpDTO empDTO) {
		
		int result = -1;
		
		try {
			// DB 접속
			Connection conn = getConn();
			
			// SQL 준비
			String sql = " insert into emp2 (empno, ename ,job,mgr,hiredate,sal,comm,deptno) ";
			sql += " values(?, ? ,? ,? ,? ,? ,? ,? )";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, empDTO.getEmpno());
			ps.setString(2, empDTO.getEname());
			ps.setString(3, empDTO.getJob());
			ps.setInt(4, empDTO.getMgr());
			ps.setDate(5, empDTO.getHiredate());
			ps.setInt(6, empDTO.getSal());
			ps.setInt(7, empDTO.getComm());
			ps.setInt(8, empDTO.getDeptno());
			
			result = ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	public int updateEmp(EmpDTO empDTO) {
		
		int result = -1;
		
		try {
			// DB 접속
			Connection conn = getConn();
			
			// SQL 준비
			String sql = " update emp2 ";
				   sql += " set ename = ?,";
				   sql += " 	job = ?,";
				   sql += " 	mgr = ?,";
				   sql += " 	hiredate = ?,";
				   sql += " 	sal = ?,";
				   sql += " 	comm = ?,";
				   sql += " 	deptno = ?";
				   sql += " where empno = ?";
				   
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, empDTO.getEname());
			ps.setString(2, empDTO.getJob());
			ps.setInt(3, empDTO.getMgr());
			ps.setDate(4, empDTO.getHiredate());
			ps.setInt(5, empDTO.getSal());
			ps.setInt(6, empDTO.getComm());
			ps.setInt(7, empDTO.getDeptno());
			ps.setInt(8, empDTO.getEmpno());
			
			result = ps.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}

}
