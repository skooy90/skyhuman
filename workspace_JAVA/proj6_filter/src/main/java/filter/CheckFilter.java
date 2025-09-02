package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/*")
public class CheckFilter implements Filter {

    public CheckFilter() {
    	System.out.println("필터 생성자 실행");
    }

	public void destroy() {
		System.out.println("필터 소멸자");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		// 실행 전 시계 보기
		long before = System.currentTimeMillis();
		
		System.out.println("실행 전");
		
		request.setCharacterEncoding("utf-8");
		// 모든 것을 html로 응답하기 떄문에 여기에 어울리지 않는다
		// json 같은 것은 json으로 응답해야 한다.
//		response.setContentType("text/html; charset=utf-8");
		// 실제 사용가 원하는 일
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String path = req.getServletPath();
		System.out.println(path);
		// 로그인 없이 가는 곳
		// 세션 없이 접근 허용
		// 사용자가 실제 원했던 일1
		if(isExclude(path)) {
			System.out.println("세션 없이 진행");
			chain.doFilter(request, response);
		}else {
			// 로그인 필수
//			HttpSession sess = req.getSession(false);
//			if(sess == null) {
//				// 로그인 페이지로 보내기
//				
//			}
			// 사용자가 실제 원했던 일2
			HttpSession sess = req.getSession();
			String isLogin = (String) sess.getAttribute("login");
			if("Y".equals(isLogin)) {
				chain.doFilter(request, response);				
			}else{
				System.out.println("세션이 없어서 통과 못함");
				resp.sendRedirect(req.getContextPath()+"/login.html");
			}
		
		}
		
		
		
		//--------------------------------------------------------
//		chain.doFilter(request, response);
		System.out.println("실행 후");
		// 실행 후 시간 보기
		long after = System.currentTimeMillis();
		System.out.println("걸린 시간 : " + (after - before));
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("생성자 실행 후 바로 실행");
		
	}
		
	private boolean isExclude(String path) {
		boolean result = false;
		
		if(	   path.equals("/login.html") 
			|| path.equals("/login")
			|| path.startsWith("/assets")
			|| path.startsWith("/all")
			// indexof도 가능한데 포함된 모든 글자가 나와 startWith가 좋다
		) {
			result = true;
		}
		
		return result;
	}

}
