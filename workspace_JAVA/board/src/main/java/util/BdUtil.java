package util;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BdUtil {
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
}
