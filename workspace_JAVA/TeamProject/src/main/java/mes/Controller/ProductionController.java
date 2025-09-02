package mes.Controller;

import mes.DAO.*;
import mes.DTO.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.*;

/**
 * 생산 관리 컨트롤러
 * MES 시스템의 생산 현황, LOT 관리, 공정 진행상황 등을 담당
 */
@WebServlet("/production/*")
public class ProductionController extends HttpServlet {
    
    private ProductionDAO productionDAO;
    private WorkOrderDAO workOrderDAO;
    private WorkOrderProcessDAO workOrderProcessDAO;
    private WorkerDAO workerDAO;
    
    @Override
    public void init() throws ServletException {
        productionDAO = new ProductionDAO();
        workOrderDAO = new WorkOrderDAO();
        workOrderProcessDAO = new WorkOrderProcessDAO();
        workerDAO = new WorkerDAO();
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String pathInfo = request.getPathInfo();
        
        try {
            if (pathInfo == null || pathInfo.equals("/") || pathInfo.equals("")) {
                // 생산 관리 메인 페이지
                loadProductionOverview(request);
                request.getRequestDispatcher("/production.jsp").forward(request, response);
            } else if (pathInfo.equals("/lots")) {
                // 진행중인 LOT 목록 조회
                loadInProgressLots(request, response);
            } else if (pathInfo.equals("/processes")) {
                // 공정 진행상황 조회
                loadProcessProgress(request, response);
            } else if (pathInfo.equals("/workers")) {
                // 작업자 현황 조회
                loadWorkerStatus(request, response);
            } else if (pathInfo.equals("/products")) {
                // 제품 목록 조회
                loadProductList(request, response);
            } else if (pathInfo.equals("/today")) {
                // 오늘의 생산량 조회
                loadTodayProduction(request, response);
            } else {
                // 404 에러
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "요청 처리 중 오류가 발생했습니다: " + e.getMessage());
            request.getRequestDispatcher("/production.jsp").forward(request, response);
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String pathInfo = request.getPathInfo();
        
        try {
            if (pathInfo.equals("/lot/create")) {
                // 새 LOT 생성
                createNewLot(request, response);
            } else if (pathInfo.equals("/process/start")) {
                // 공정 시작
                startProcess(request, response);
            } else if (pathInfo.equals("/process/complete")) {
                // 공정 완료
                completeProcess(request, response);
            } else if (pathInfo.equals("/worker/assign")) {
                // 작업자 할당
                assignWorker(request, response);
            } else {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"error\": \"" + e.getMessage() + "\"}");
        }
    }
    
    /**
     * 생산 관리 메인 페이지 데이터 로드
     */
    private void loadProductionOverview(HttpServletRequest request) {
        try {
            // 1. 진행중인 LOT 목록
            List<WorkOrderDTO> inProgressLots = productionDAO.getInProgressLots();
            request.setAttribute("inProgressLots", inProgressLots);
            
            // 2. 공정 진행상황
            List<WorkOrderProcessDTO> processProgress = productionDAO.getProcessProgress();
            request.setAttribute("processProgress", processProgress);
            
            // 3. 작업자 현황
            List<WorkerDTO> workerStatus = workerDAO.getAllWorkers();
            request.setAttribute("workerStatus", workerStatus);
            
            // 4. 제품 목록
            List<ProductDTO> productList = productionDAO.getAllProducts();
            request.setAttribute("productList", productList);
            
            // 5. 오늘의 생산량
            int todayProduction = productionDAO.getTodayProductionQuantity();
            request.setAttribute("todayProduction", todayProduction);
            
            // 6. 공정별 생산 현황
            List<Map<String, Object>> processStatus = productionDAO.getProcessStatus();
            request.setAttribute("processStatus", processStatus);
            
            // 7. 디버깅용: 모든 WORK_ORDER 데이터 조회
            System.out.println("=== 디버깅: 모든 WORK_ORDER 데이터 ===");
            List<WorkOrderDTO> allLots = productionDAO.getAllWorkOrdersForDebug();
            System.out.println("=== 디버깅 완료 ===");
            
            // 디버깅 로그
            System.out.println("생산 관리 페이지 데이터 로드 완료:");
            System.out.println("- 진행중인 LOT: " + (inProgressLots != null ? inProgressLots.size() : 0) + "개");
            System.out.println("- 공정 진행: " + (processProgress != null ? processProgress.size() : 0) + "개");
            System.out.println("- 작업자 현황: " + (workerStatus != null ? workerStatus.size() : 0) + "개");
            System.out.println("- 제품 목록: " + (productList != null ? productList.size() : 0) + "개");
            System.out.println("- 오늘의 생산량: " + todayProduction);
            
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "데이터 로드 중 오류가 발생했습니다: " + e.getMessage());
            System.err.println("데이터 로드 오류: " + e.getMessage());
        }
    }
    
    /**
     * 진행중인 LOT 목록 조회 (AJAX)
     */
    private void loadInProgressLots(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        try {
            List<WorkOrderDTO> lots = productionDAO.getInProgressLots();
            
            // JSON 형태로 응답
            response.setContentType("application/json;charset=UTF-8");
            StringBuilder json = new StringBuilder();
            json.append("{\"success\":true,\"data\":[");
            
            for (int i = 0; i < lots.size(); i++) {
                WorkOrderDTO lot = lots.get(i);
                json.append("{");
                json.append("\"workOrderId\":").append(lot.getWorkOrderId()).append(",");
                json.append("\"productId\":").append(lot.getProductId()).append(",");
                json.append("\"plannedQuantity\":").append(lot.getPlannedQuantity()).append(",");
                json.append("\"actualQuantity\":").append(lot.getActualQuantity()).append(",");
                json.append("\"status\":\"").append(lot.getStatus()).append("\",");
                json.append("\"plannedStartDate\":\"").append(lot.getPlannedStartDate()).append("\"");
                json.append("}");
                
                if (i < lots.size() - 1) {
                    json.append(",");
                }
            }
            
            json.append("]}");
            response.getWriter().write(json.toString());
            
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"success\":false,\"error\":\"" + e.getMessage() + "\"}");
        }
    }
    
    /**
     * 공정 진행상황 조회 (AJAX)
     */
    private void loadProcessProgress(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        try {
            List<WorkOrderProcessDTO> processes = productionDAO.getProcessProgress();
            
            response.setContentType("application/json;charset=UTF-8");
            StringBuilder json = new StringBuilder();
            json.append("{\"success\":true,\"data\":[");
            
            for (int i = 0; i < processes.size(); i++) {
                WorkOrderProcessDTO process = processes.get(i);
                json.append("{");
                json.append("\"workOrderProcessId\":").append(process.getWorkOrderProcessId()).append(",");
                json.append("\"workOrderId\":").append(process.getWorkOrderId()).append(",");
                json.append("\"processName\":\"").append(process.getProcessName()).append("\",");
                json.append("\"status\":\"").append(process.getStatus()).append("\",");
                json.append("\"startTime\":\"").append(process.getStartTime()).append("\"");
                json.append("}");
                
                if (i < processes.size() - 1) {
                    json.append(",");
                }
            }
            
            json.append("]}");
            response.getWriter().write(json.toString());
            
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"success\":false,\"error\":\"" + e.getMessage() + "\"}");
        }
    }
    
    /**
     * 작업자 현황 조회 (AJAX)
     */
    private void loadWorkerStatus(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        try {
            List<WorkerDTO> workers = workerDAO.getAllWorkers();
            
            response.setContentType("application/json;charset=UTF-8");
            StringBuilder json = new StringBuilder();
            json.append("{\"success\":true,\"data\":[");
            
            for (int i = 0; i < workers.size(); i++) {
                WorkerDTO worker = workers.get(i);
                json.append("{");
                json.append("\"workerId\":").append(worker.getWorkerId()).append(",");
                json.append("\"workerName\":\"").append(worker.getWorkerName()).append("\",");
                json.append("\"currentProcess\":\"").append(worker.getCurrentProcess()).append("\",");
                json.append("\"skillLevel\":\"").append(worker.getSkillLevel()).append("\",");
                json.append("\"workShift\":\"").append(worker.getWorkShift()).append("\"");
                json.append("}");
                
                if (i < workers.size() - 1) {
                    json.append(",");
                }
            }
            
            json.append("]}");
            response.getWriter().write(json.toString());
            
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"success\":false,\"error\":\"" + e.getMessage() + "\"}");
        }
    }
    
    /**
     * 제품 목록 조회 (AJAX)
     */
    private void loadProductList(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        try {
            List<ProductDTO> products = productionDAO.getAllProducts();
            
            response.setContentType("application/json;charset=UTF-8");
            StringBuilder json = new StringBuilder();
            json.append("{\"success\":true,\"data\":[");
            
            for (int i = 0; i < products.size(); i++) {
                ProductDTO product = products.get(i);
                json.append("{");
                json.append("\"productId\":").append(product.getProductId()).append(",");
                json.append("\"productName\":\"").append(product.getProductName()).append("\",");
                json.append("\"productType\":\"").append(product.getProductType()).append("\",");
                json.append("\"unit\":\"").append(product.getUnit()).append("\"");
                json.append("}");
                
                if (i < products.size() - 1) {
                    json.append(",");
                }
            }
            
            json.append("]}");
            response.getWriter().write(json.toString());
            
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"success\":false,\"error\":\"" + e.getMessage() + "\"}");
        }
    }
    
    /**
     * 오늘의 생산량 조회 (AJAX)
     */
    private void loadTodayProduction(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        try {
            int todayProduction = productionDAO.getTodayProductionQuantity();
            
            response.setContentType("application/json;charset=UTF-8");
            String json = "{\"success\":true,\"data\":{\"todayProduction\":" + todayProduction + "}}";
            response.getWriter().write(json);
            
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"success\":false,\"error\":\"" + e.getMessage() + "\"}");
        }
    }
    
    /**
     * 새 LOT 생성
     */
    private void createNewLot(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        try {
            // 파라미터 받기
            int productId = Integer.parseInt(request.getParameter("productId"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int workerId = Integer.parseInt(request.getParameter("workerId"));
            String startDate = request.getParameter("startDate");
            
            // TODO: 실제 LOT 생성 로직 구현
            // 현재는 성공 응답만 반환
            
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write("{\"success\":true,\"message\":\"LOT가 성공적으로 생성되었습니다.\"}");
            
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"success\":false,\"error\":\"" + e.getMessage() + "\"}");
        }
    }
    
    /**
     * 공정 시작
     */
    private void startProcess(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        try {
            int workOrderProcessId = Integer.parseInt(request.getParameter("workOrderProcessId"));
            
            boolean result = workOrderProcessDAO.startProcess(workOrderProcessId);
            
            response.setContentType("application/json;charset=UTF-8");
            if (result) {
                response.getWriter().write("{\"success\":true,\"message\":\"공정이 시작되었습니다.\"}");
            } else {
                response.getWriter().write("{\"success\":false,\"error\":\"공정 시작에 실패했습니다.\"}");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"success\":false,\"error\":\"" + e.getMessage() + "\"}");
        }
        

    }
    
    /**
     * 공정 완료
     */
    private void completeProcess(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        try {
            int workOrderProcessId = Integer.parseInt(request.getParameter("workOrderProcessId"));
            Double actualQuantity = Double.parseDouble(request.getParameter("actualQuantity"));
            Double actualTime = Double.parseDouble(request.getParameter("actualTime"));
            
            boolean result = workOrderProcessDAO.completeProcess(workOrderProcessId, actualQuantity, actualTime);
            
            response.setContentType("application/json;charset=UTF-8");
            if (result) {
                response.getWriter().write("{\"success\":true,\"message\":\"공정이 완료되었습니다.\"}");
            } else {
                response.getWriter().write("{\"success\":false,\"error\":\"공정 완료에 실패했습니다.\"}");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"success\":false,\"error\":\"" + e.getMessage() + "\"}");
        }
    }
    
    /**
     * 작업자 할당
     */
    private void assignWorker(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        try {
            int workerId = Integer.parseInt(request.getParameter("workerId"));
            String currentProcess = request.getParameter("currentProcess");
            
            boolean result = workerDAO.updateWorkerProcess(workerId, currentProcess);
            
            response.setContentType("application/json;charset=UTF-8");
            if (result) {
                response.getWriter().write("{\"success\":true,\"message\":\"작업자가 성공적으로 할당되었습니다.\"}");
            } else {
                response.getWriter().write("{\"success\":false,\"error\":\"작업자 할당에 실패했습니다.\"}");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().write("{\"success\":false,\"error\":\"" + e.getMessage() + "\"}");
        }
    }
}
