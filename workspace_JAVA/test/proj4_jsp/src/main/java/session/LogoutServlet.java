package session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession();
		
		// 로그아웃 함수 세션 만료
		// 지금 당장 세션이 지워지는건 아니다
		// - 응답 도중에 세션이 지워진다
		sess.invalidate();
		
		// 이 위치에서 getAttribute 가능함

		
		
	}


}
