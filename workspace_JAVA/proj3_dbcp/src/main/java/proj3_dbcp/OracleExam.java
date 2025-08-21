package proj3_dbcp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;

@WebServlet("/db")
public class OracleExam {

	public static void main(String[] args) {
		
		System.out.println("그냥 들이대 ");
		
		String url = "jdbc:oracle:thin:@125.181.132.133:51521:xe";
		String user = "scott4_3";
		String password = "tiger";
		String driver = "oracle.jdbc.driver.OracleDriver";

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			
			// Oracle 드라이버 로딩 
			// Class.forName : String을 이용해서 class생성
			Class.forName(driver);
			
			// DB 접속
			conn = DriverManager.getConnection(url, user, password);
			
			// SQL 준비
			String query  = "select * from emp";
			
			ps = conn.prepareStatement(query);
			
			//실행 및 결과 확보
			rs = ps.executeQuery();
			
			// 결과 활용 
			// rs.next(); : 다음 줄이 있는가??
			// next 가 실행된 이후 rs 변수는 한 줄로 변경 됨
			// 커서가 다음 줄로 이동된다
			
//			if( rs.next() ) {
//				int empno = rs.getInt("empno");
//				System.out.println("첫번째 empno : " + empno);
//				
//				String ename  = rs.getString("ename");
//				System.out.println("첫번째 nname: " + ename);
//				
//			}
//			if( rs.next() ) {
//				int empno = rs.getInt("empno");
//				System.out.println("두번째 empno : " + empno);
//				
//				String ename  = rs.getString("ename");
//				System.out.println("두번째 nname: " + ename);
//				
//			}
			while(rs.next()) {
				// 전달인자로 컬럼명 (대소문자 구분없음)
				int empno = rs.getInt("empno");
				System.out.print( empno + ",");
				
				String ename  = rs.getString("ename");
				System.out.println(ename);
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn != null) {				
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
		}

	}

}
