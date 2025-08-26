package session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/Session")
public class SessionServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 기존 세션이 없으면 새로 만들어 주고
		// 있으면 그걸 가져옴
		HttpSession hses = request.getSession();

		// 기존 세션이 없으면 null
		// 있으면 그걸 가져옴
		// HttpSession hses = request.getSession(false);
		
		hses.setAttribute("k", "v");
		
		String id = hses.getId();
		
		
		System.out.println("getId : " + id);
		
		boolean fi = hses.isNew();
		
		System.out.println("New??" + fi);
		
		
		String userid =  request.getParameter("id");
		if("admin".equals(userid)) {
			hses.setAttribute("login", true);
			hses.setAttribute("userId", userid);
		}else if("admin2".equals(userid)) {
			hses.setAttribute("login", true);
			hses.setAttribute("userId", userid);
			hses.setAttribute("level", "1");
			
		}
		
		
	}


}
