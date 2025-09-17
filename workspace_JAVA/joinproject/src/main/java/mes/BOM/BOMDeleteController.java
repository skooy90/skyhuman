package mes.BOM;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bom/delete")
public class BOMDeleteController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private BOMDAO bomDAO;
    
    public BOMDeleteController() {
        super();
        bomDAO = new BOMDAO();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 한글깨짐방지
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8;");
        
        try {
            String standardCode = request.getParameter("code");
            
            if (standardCode == null || standardCode.trim().isEmpty()) {
                response.sendRedirect(request.getContextPath() + "/bom");
                return;
            }
            
            // 라우팅의 모든 공정 삭제 (PROCESS 테이블에서)
            int result = bomDAO.deleteProcessesByStandardCode(standardCode);
            
            if (result > 0) {
                // 삭제 성공
                response.sendRedirect(request.getContextPath() + "/bom?message=delete_success");
            } else {
                // 삭제 실패
                response.sendRedirect(request.getContextPath() + "/bom?message=delete_failed");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/bom?message=delete_error");
        }
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}