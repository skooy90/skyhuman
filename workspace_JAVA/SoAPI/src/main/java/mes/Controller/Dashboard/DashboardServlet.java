// src/main/java/mes/Controller/Dashboard/DashboardServlet.java
package mes.Controller.Dashboard;

import mes.DAO.BoardManagementDAO;
import mes.DAO.ProductionDAO;
import mes.DAO.WorkDAO;
import mes.DAO.QualityDAO;
import mes.DTO.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.IOException;
import java.util.*;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
  @Override protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    // 1) 생산: 최근 8개 생산 Target vs Completed
    req.setAttribute("prodTvc", ProductionDAO.getInstance().findLastNForChart(8));
    // 2) 금일 생산량(완료수량 합계)
    req.setAttribute("todayProduction", ProductionDAO.getInstance().sumCompletedToday());
    // 3) 작업: 최근 8개 작업 Qty vs Completed
    req.setAttribute("workQvc", WorkDAO.getInstance().findLastNForChart(8));
//    [추가] 작업 진행률용 숫자 지표
    int workTotal = WorkDAO.getInstance().sumQuantity();   // 전체 작업량
    int workDone  = WorkDAO.getInstance().sumCompleted();  // 완료량
    int workRemain = Math.max(0, workTotal - workDone);
    double workRate = workTotal > 0 ? (workDone * 100.0 / workTotal) : 0.0;

    req.setAttribute("workTotal", workTotal);
    req.setAttribute("workDone",  workDone);
    req.setAttribute("workRemain", workRemain);
    req.setAttribute("workRate",  workRate);
    // 4) 품질: 제품별 불량 수량 Top5
    req.setAttribute("defectTop", QualityDAO.getInstance().sumDefectByProductTopN(5));
    // 5) 품질: 제품별 불량률 Top5 (불량 / (양품+불량))
    req.setAttribute("defectRateTop", QualityDAO.getInstance().defectRateByProductTopN(5));

    // 6) 공지
    req.setAttribute("notices", BoardManagementDAO.getInstance().selectLatestNotices(5));

    req.getRequestDispatcher("/jsp/Dashboard/dashboard.jsp").forward(req, resp);
  }
}
