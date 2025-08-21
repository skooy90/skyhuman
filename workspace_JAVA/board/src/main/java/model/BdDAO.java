package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BdDAO {
	private Connection getConn() {
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
	public List selectAllBoard() {
		List<BdDTO> list = new ArrayList<BdDTO>();
		
		Connection conn = getConn();
		try {
			String sql = " select * from board2";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			// 결과 활용
			while(rs.next()) {
				BdDTO dto = new BdDTO();
				
				dto.setBid(rs.getInt("bid")); 
				dto.setBtitle(rs.getString("btitle"));
				dto.setBwriter(rs.getString("bwriter"));
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}
}
