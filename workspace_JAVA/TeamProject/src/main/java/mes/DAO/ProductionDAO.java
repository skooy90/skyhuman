package mes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mes.DTO.ProductDTO;
import mes.DTO.WorkOrderDTO;
import mes.DTO.WorkOrderProcessDTO;
import util.DBManager;

/**
 * 생산 관련 데이터 접근 객체
 * MES 시스템의 생산 현황, LOT 관리, 공정 진행상황 등을 담당
 */
public class ProductionDAO {
    
    /**
     * 진행중인 LOT 목록 조회
     * @return 진행중인 LOT 목록
     */
    public List<WorkOrderDTO> getInProgressLots() {
        List<WorkOrderDTO> lots = new ArrayList<>();
        
        try (Connection conn = new DBManager().getConn()) {
            String sql = "SELECT wo.WORK_ORDER_ID, wo.ORDER_ID, wo.PRODUCT_ID, " +
                        "wo.WORK_ORDER_NO, wo.WORK_ORDER_TYPE, wo.PLANNED_QUANTITY, " +
                        "wo.ACTUAL_QUANTITY, wo.PRIORITY, wo.STATUS, " +
                        "wo.PLANNED_START_DATE, wo.PLANNED_END_DATE, " +
                        "wo.ACTUAL_START_DATE, wo.ACTUAL_END_DATE, " +
                        "wo.CREATED_BY, wo.CREATED_AT, wo.UPDATED_AT, " +
                        "p.PRODUCT_NAME " +
                        "FROM WORK_ORDER wo " +
                        "LEFT JOIN PRODUCT p ON wo.PRODUCT_ID = p.PRODUCT_ID " +
                        "WHERE wo.STATUS = 'IN_PROGRESS' " +
                        "ORDER BY wo.PLANNED_START_DATE DESC";
            
            System.out.println("SQL 쿼리: " + sql);
            System.out.println("DB 연결 성공: " + (conn != null));
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
                int count = 0;
                while (rs.next()) {
                    count++;
                    WorkOrderDTO lot = new WorkOrderDTO();
                    lot.setWorkOrderId(rs.getInt("WORK_ORDER_ID"));
                    lot.setOrderId(rs.getInt("ORDER_ID"));
                    lot.setProductId(rs.getInt("PRODUCT_ID"));
                    lot.setWorkOrderNo(rs.getString("WORK_ORDER_NO"));
                    lot.setWorkOrderType(rs.getString("WORK_ORDER_TYPE"));
                    lot.setPlannedQuantity(rs.getDouble("PLANNED_QUANTITY"));
                    lot.setActualQuantity(rs.getDouble("ACTUAL_QUANTITY"));
                    lot.setPriority(rs.getString("PRIORITY"));
                    lot.setStatus(rs.getString("STATUS"));
                    lot.setPlannedStartDate(rs.getDate("PLANNED_START_DATE"));
                    lot.setPlannedEndDate(rs.getDate("PLANNED_END_DATE"));
                    lot.setActualStartDate(rs.getDate("ACTUAL_START_DATE"));
                    lot.setActualEndDate(rs.getDate("ACTUAL_END_DATE"));
                    lot.setCreatedBy(rs.getInt("CREATED_BY"));
                    lot.setCreatedAt(rs.getDate("CREATED_AT"));
                    lot.setUpdatedAt(rs.getDate("UPDATED_AT"));
                    
                    lots.add(lot);
                }
                System.out.println("조회된 LOT 수: " + count);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("진행중인 LOT 조회 중 오류가 발생했습니다.", e);
        }
        
        return lots;
    }
    
    /**
     * 공정별 진행상황 조회
     * @return 공정 진행상황 목록
     */
    public List<WorkOrderProcessDTO> getProcessProgress() {
        List<WorkOrderProcessDTO> processes = new ArrayList<>();
        
        try (Connection conn = new DBManager().getConn()) {
            String sql = "SELECT wop.WORK_ORDER_PROCESS_ID, wop.WORK_ORDER_ID, " +
                        "wop.PROCESS_SEQUENCE, wop.PROCESS_NAME, wop.PROCESS_CODE, " +
                        "wop.PLANNED_QUANTITY, wop.ACTUAL_QUANTITY, wop.STANDARD_TIME, " +
                        "wop.ACTUAL_TIME, wop.EQUIPMENT_ID, wop.EQUIPMENT_NAME, " +
                        "wop.PROCESS_PARAMETERS, wop.STATUS, wop.START_TIME, " +
                        "wop.END_TIME, wop.CREATED_AT, " +
                        "wo.WORK_ORDER_NO, p.PRODUCT_NAME " +
                        "FROM WORK_ORDER_PROCESS wop " +
                        "LEFT JOIN WORK_ORDER wo ON wop.WORK_ORDER_ID = wo.WORK_ORDER_ID " +
                        "LEFT JOIN PRODUCT p ON wo.PRODUCT_ID = p.PRODUCT_ID " +
                        "WHERE wop.STATUS IN ('IN_PROGRESS', 'PLANNED') " +
                        "ORDER BY wop.PROCESS_SEQUENCE, wop.START_TIME";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
                while (rs.next()) {
                    WorkOrderProcessDTO process = new WorkOrderProcessDTO();
                    process.setWorkOrderProcessId(rs.getInt("WORK_ORDER_PROCESS_ID"));
                    process.setWorkOrderId(rs.getInt("WORK_ORDER_ID"));
                    process.setProcessSequence(rs.getInt("PROCESS_SEQUENCE"));
                    process.setProcessName(rs.getString("PROCESS_NAME"));
                    process.setProcessCode(rs.getString("PROCESS_CODE"));
                    process.setPlannedQuantity(rs.getDouble("PLANNED_QUANTITY"));
                    process.setActualQuantity(rs.getDouble("ACTUAL_QUANTITY"));
                    process.setStandardTime(rs.getDouble("STANDARD_TIME"));
                    process.setActualTime(rs.getDouble("ACTUAL_TIME"));
                    process.setEquipmentId(rs.getString("EQUIPMENT_ID"));
                    process.setEquipmentName(rs.getString("EQUIPMENT_NAME"));
                    process.setProcessParameters(rs.getString("PROCESS_PARAMETERS"));
                    process.setStatus(rs.getString("STATUS"));
                    process.setStartTime(rs.getDate("START_TIME"));
                    process.setEndTime(rs.getDate("END_TIME"));
                    process.setCreatedAt(rs.getDate("CREATED_AT"));
                    
                    processes.add(process);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("공정 진행상황 조회 중 오류가 발생했습니다.", e);
        }
        
        return processes;
    }
    
    /**
     * 제품 목록 조회
     * @return 제품 목록
     */
    public List<ProductDTO> getAllProducts() {
        List<ProductDTO> products = new ArrayList<>();
        
        try (Connection conn = new DBManager().getConn()) {
            String sql = "SELECT PRODUCT_ID, PRODUCT_NAME, PRODUCT_TYPE, UNIT, DESCRIPTION " +
                        "FROM PRODUCT " +
                        "ORDER BY PRODUCT_TYPE, PRODUCT_NAME";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
                while (rs.next()) {
                    ProductDTO product = new ProductDTO();
                    product.setProductId(rs.getInt("PRODUCT_ID"));
                    product.setProductName(rs.getString("PRODUCT_NAME"));
                    product.setProductType(rs.getString("PRODUCT_TYPE"));
                    product.setUnit(rs.getString("UNIT"));
                    product.setDescription(rs.getString("DESCRIPTION"));
                    
                    products.add(product);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("제품 목록 조회 중 오류가 발생했습니다.", e);
        }
        
        return products;
    }
    
    /**
     * 오늘의 생산량 조회
     * @return 오늘의 생산량
     */
    public int getTodayProductionQuantity() {
        try (Connection conn = new DBManager().getConn()) {
            String sql = "SELECT NVL(SUM(wo.ACTUAL_QUANTITY), 0) " +
                        "FROM WORK_ORDER wo " +
                        "WHERE wo.STATUS = 'COMPLETED' " +
                        "AND TRUNC(wo.ACTUAL_END_DATE) = TRUNC(SYSDATE)";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            if (rs.next()) {
                return rs.getInt(1);
            }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("오늘의 생산량 조회 중 오류가 발생했습니다.", e);
        }
        
        return 0;
    }
    
    /**
     * 공정별 생산 현황 조회
     * @return 공정별 생산 현황
     */
    public List<Map<String, Object>> getProcessStatus() {
        List<Map<String, Object>> processStatus = new ArrayList<>();
        
        try (Connection conn = new DBManager().getConn()) {
            String sql = "SELECT wp.PROCESS_NAME, COUNT(*) as TOTAL_PROCESSES, " +
                        "AVG(CASE WHEN wp.STATUS = 'COMPLETED' THEN 1 ELSE 0 END) * 100 as COMPLETION_RATE " +
                        "FROM WORK_ORDER_PROCESS wp " +
                        "JOIN WORK_ORDER wo ON wp.WORK_ORDER_ID = wo.WORK_ORDER_ID " +
                        "WHERE wo.PLANNED_START_DATE BETWEEN SYSDATE - 7 AND SYSDATE " +
                        "GROUP BY wp.PROCESS_NAME " +
                        "ORDER BY wp.PROCESS_NAME";
            
            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {
                
                while (rs.next()) {
                    Map<String, Object> status = new HashMap<>();
                    status.put("processName", rs.getString("PROCESS_NAME"));
                    status.put("totalProcesses", rs.getInt("TOTAL_PROCESSES"));
                    status.put("completionRate", rs.getDouble("COMPLETION_RATE"));
                    
                    processStatus.add(status);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("공정별 생산 현황 조회 중 오류가 발생했습니다.", e);
        }
        
        return processStatus;
    }
    
    /**
     * 디버깅용: 모든 WORK_ORDER 데이터 조회
     */
    public List<WorkOrderDTO> getAllWorkOrdersForDebug() {
        List<WorkOrderDTO> lots = new ArrayList<>();
        
        try (Connection conn = new DBManager().getConn()) {
            String sql = "SELECT wo.WORK_ORDER_ID, wo.ORDER_ID, wo.PRODUCT_ID, " +
                        "wo.WORK_ORDER_NO, wo.WORK_ORDER_TYPE, wo.PLANNED_QUANTITY, " +
                        "wo.ACTUAL_QUANTITY, wo.PRIORITY, wo.STATUS, " +
                        "wo.PLANNED_START_DATE, wo.PLANNED_END_DATE, " +
                        "wo.ACTUAL_START_DATE, wo.ACTUAL_END_DATE, " +
                        "wo.CREATED_BY, wo.CREATED_AT, wo.UPDATED_AT, " +
                        "p.PRODUCT_NAME " +
                        "FROM WORK_ORDER wo " +
                        "LEFT JOIN PRODUCT p ON wo.PRODUCT_ID = p.PRODUCT_ID " +
                        "ORDER BY wo.WORK_ORDER_ID";
            
            System.out.println("디버깅 SQL: " + sql);
            
            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {
                
                int count = 0;
                while (rs.next()) {
                    count++;
                    WorkOrderDTO lot = new WorkOrderDTO();
                    lot.setWorkOrderId(rs.getInt("WORK_ORDER_ID"));
                    lot.setOrderId(rs.getInt("ORDER_ID"));
                    lot.setProductId(rs.getInt("PRODUCT_ID"));
                    lot.setWorkOrderNo(rs.getString("WORK_ORDER_NO"));
                    lot.setWorkOrderType(rs.getString("WORK_ORDER_TYPE"));
                    lot.setPlannedQuantity(rs.getDouble("PLANNED_QUANTITY"));
                    lot.setActualQuantity(rs.getDouble("ACTUAL_QUANTITY"));
                    lot.setPriority(rs.getString("PRIORITY"));
                    lot.setStatus(rs.getString("STATUS"));
                    lot.setPlannedStartDate(rs.getDate("PLANNED_START_DATE"));
                    lot.setPlannedEndDate(rs.getDate("PLANNED_END_DATE"));
                    lot.setActualStartDate(rs.getDate("ACTUAL_START_DATE"));
                    lot.setActualEndDate(rs.getDate("ACTUAL_END_DATE"));
                    lot.setCreatedBy(rs.getInt("CREATED_BY"));
                    lot.setCreatedAt(rs.getDate("CREATED_AT"));
                    lot.setUpdatedAt(rs.getDate("UPDATED_AT"));
                    
                    lots.add(lot);
                    
                    System.out.println("LOT " + count + ": ID=" + lot.getWorkOrderId() + 
                                     ", STATUS=" + lot.getStatus() + 
                                     ", PRODUCT=" + lot.getWorkOrderNo());
                }
                System.out.println("총 조회된 LOT 수: " + count);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("디버깅 조회 중 오류: " + e.getMessage());
        }
        
        return lots;
    }
}
