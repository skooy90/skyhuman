package mes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mes.DTO.WorkOrderDTO;
import util.DBManager;

/**
 * 작업지시 관련 데이터 접근 객체
 * MES 시스템의 작업지시 관리, 상태 변경 등을 담당
 */
public class WorkOrderDAO {
    
    /**
     * 모든 작업지시 조회
     * @return 작업지시 목록
     */
    public List<WorkOrderDTO> getAllWorkOrders() {
        List<WorkOrderDTO> workOrders = new ArrayList<>();
        
        try (Connection conn = new DBManager().getConn()) {
            String sql = "SELECT wo.WORK_ORDER_ID, wo.ORDER_ID, wo.PRODUCT_ID, " +
                        "wo.WORK_ORDER_NO, wo.WORK_ORDER_TYPE, wo.PLANNED_QUANTITY, " +
                        "wo.ACTUAL_QUANTITY, wo.PRIORITY, wo.STATUS, " +
                        "wo.PLANNED_START_DATE, wo.PLANNED_END_DATE, " +
                        "wo.ACTUAL_START_DATE, wo.ACTUAL_END_DATE, " +
                        "wo.CREATED_BY, wo.CREATED_AT, wo.UPDATED_AT, " +
                        "p.PRODUCT_NAME, o.QUANTITY as ORDER_QUANTITY " +
                        "FROM WORK_ORDER wo " +
                        "LEFT JOIN PRODUCT p ON wo.PRODUCT_ID = p.PRODUCT_ID " +
                        "LEFT JOIN ORDERS o ON wo.ORDER_ID = o.ORDER_ID " +
                        "ORDER BY wo.CREATED_AT DESC";
            
            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {
                
                while (rs.next()) {
                    WorkOrderDTO workOrder = new WorkOrderDTO();
                    workOrder.setWorkOrderId(rs.getInt("WORK_ORDER_ID"));
                    workOrder.setOrderId(rs.getInt("ORDER_ID"));
                    workOrder.setProductId(rs.getInt("PRODUCT_ID"));
                    workOrder.setWorkOrderNo(rs.getString("WORK_ORDER_NO"));
                    workOrder.setWorkOrderType(rs.getString("WORK_ORDER_TYPE"));
                    workOrder.setPlannedQuantity(rs.getDouble("PLANNED_QUANTITY"));
                    workOrder.setActualQuantity(rs.getDouble("ACTUAL_QUANTITY"));
                    workOrder.setPriority(rs.getString("PRIORITY"));
                    workOrder.setStatus(rs.getString("STATUS"));
                    workOrder.setPlannedStartDate(rs.getDate("PLANNED_START_DATE"));
                    workOrder.setPlannedEndDate(rs.getDate("PLANNED_END_DATE"));
                    workOrder.setActualStartDate(rs.getDate("ACTUAL_START_DATE"));
                    workOrder.setActualEndDate(rs.getDate("ACTUAL_END_DATE"));
                    workOrder.setCreatedBy(rs.getInt("CREATED_BY"));
                    workOrder.setCreatedAt(rs.getDate("CREATED_AT"));
                    workOrder.setUpdatedAt(rs.getDate("UPDATED_AT"));
                    
                    workOrders.add(workOrder);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("작업지시 목록 조회 중 오류가 발생했습니다.", e);
        }
        
        return workOrders;
    }
    
    /**
     * 상태별 작업지시 조회
     * @param status 상태
     * @return 해당 상태의 작업지시 목록
     */
    public List<WorkOrderDTO> getWorkOrdersByStatus(String status) {
        List<WorkOrderDTO> workOrders = new ArrayList<>();
        
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
                        "WHERE wo.STATUS = ? " +
                        "ORDER BY wo.CREATED_AT DESC";
            
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, status);
                
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        WorkOrderDTO workOrder = new WorkOrderDTO();
                        workOrder.setWorkOrderId(rs.getInt("WORK_ORDER_ID"));
                        workOrder.setOrderId(rs.getInt("ORDER_ID"));
                        workOrder.setProductId(rs.getInt("PRODUCT_ID"));
                        workOrder.setWorkOrderNo(rs.getString("WORK_ORDER_NO"));
                        workOrder.setWorkOrderType(rs.getString("WORK_ORDER_TYPE"));
                        workOrder.setPlannedQuantity(rs.getDouble("PLANNED_QUANTITY"));
                        workOrder.setActualQuantity(rs.getDouble("ACTUAL_QUANTITY"));
                        workOrder.setPriority(rs.getString("PRIORITY"));
                        workOrder.setStatus(rs.getString("STATUS"));
                        workOrder.setPlannedStartDate(rs.getDate("PLANNED_START_DATE"));
                        workOrder.setPlannedEndDate(rs.getDate("PLANNED_END_DATE"));
                        workOrder.setActualStartDate(rs.getDate("ACTUAL_START_DATE"));
                        workOrder.setActualEndDate(rs.getDate("ACTUAL_END_DATE"));
                        workOrder.setCreatedBy(rs.getInt("CREATED_BY"));
                        workOrder.setCreatedAt(rs.getDate("CREATED_AT"));
                        workOrder.setUpdatedAt(rs.getDate("UPDATED_AT"));
                        
                        workOrders.add(workOrder);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("상태별 작업지시 조회 중 오류가 발생했습니다.", e);
        }
        
        return workOrders;
    }
    
    /**
     * 오늘의 작업지시 조회
     * @return 오늘의 작업지시 목록
     */
    public List<WorkOrderDTO> getTodayWorkOrders() {
        List<WorkOrderDTO> workOrders = new ArrayList<>();
        
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
                        "WHERE TRUNC(wo.PLANNED_START_DATE) = TRUNC(SYSDATE) " +
                        "ORDER BY wo.PRIORITY DESC, wo.PLANNED_START_DATE";
            
            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {
                
                while (rs.next()) {
                    WorkOrderDTO workOrder = new WorkOrderDTO();
                    workOrder.setWorkOrderId(rs.getInt("WORK_ORDER_ID"));
                    workOrder.setOrderId(rs.getInt("ORDER_ID"));
                    workOrder.setProductId(rs.getInt("PRODUCT_ID"));
                    workOrder.setWorkOrderNo(rs.getString("WORK_ORDER_NO"));
                    workOrder.setWorkOrderType(rs.getString("WORK_ORDER_TYPE"));
                    workOrder.setPlannedQuantity(rs.getDouble("PLANNED_QUANTITY"));
                    workOrder.setActualQuantity(rs.getDouble("ACTUAL_QUANTITY"));
                    workOrder.setPriority(rs.getString("PRIORITY"));
                    workOrder.setStatus(rs.getString("STATUS"));
                    workOrder.setPlannedStartDate(rs.getDate("PLANNED_START_DATE"));
                    workOrder.setPlannedEndDate(rs.getDate("PLANNED_END_DATE"));
                    workOrder.setActualStartDate(rs.getDate("ACTUAL_START_DATE"));
                    workOrder.setActualEndDate(rs.getDate("ACTUAL_END_DATE"));
                    workOrder.setCreatedBy(rs.getInt("CREATED_BY"));
                    workOrder.setCreatedAt(rs.getDate("CREATED_AT"));
                    workOrder.setUpdatedAt(rs.getDate("UPDATED_AT"));
                    
                    workOrders.add(workOrder);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("오늘의 작업지시 조회 중 오류가 발생했습니다.", e);
        }
        
        return workOrders;
    }
    
    /**
     * 작업지시 상태 업데이트
     * @param workOrderId 작업지시 ID
     * @param status 새로운 상태
     * @return 업데이트 성공 여부
     */
    public boolean updateWorkOrderStatus(int workOrderId, String status) {
        try (Connection conn = new DBManager().getConn()) {
            String sql = "UPDATE WORK_ORDER SET STATUS = ?, UPDATED_AT = SYSDATE " +
                        "WHERE WORK_ORDER_ID = ?";
            
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, status);
                pstmt.setInt(2, workOrderId);
                
                int result = pstmt.executeUpdate();
                return result > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("작업지시 상태 업데이트 중 오류가 발생했습니다.", e);
        }
    }
    
    /**
     * 작업지시 생성
     * @param workOrder 작업지시 정보
     * @return 생성된 작업지시 ID
     */
    public int createWorkOrder(WorkOrderDTO workOrder) {
        try (Connection conn = new DBManager().getConn()) {
            String sql = "INSERT INTO WORK_ORDER (WORK_ORDER_ID, ORDER_ID, PRODUCT_ID, " +
                        "WORK_ORDER_NO, WORK_ORDER_TYPE, PLANNED_QUANTITY, " +
                        "PRIORITY, STATUS, PLANNED_START_DATE, PLANNED_END_DATE, " +
                        "CREATED_BY, CREATED_AT, UPDATED_AT) " +
                        "VALUES (SEQ_WORK_ORDER_ID.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, SYSDATE)";
            
            try (PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"WORK_ORDER_ID"})) {
                pstmt.setInt(1, workOrder.getOrderId());
                pstmt.setInt(2, workOrder.getProductId());
                pstmt.setString(3, workOrder.getWorkOrderNo());
                pstmt.setString(4, workOrder.getWorkOrderType());
                pstmt.setDouble(5, workOrder.getPlannedQuantity());
                pstmt.setString(6, workOrder.getPriority());
                pstmt.setString(7, workOrder.getStatus());
                pstmt.setDate(8, workOrder.getPlannedStartDate());
                pstmt.setDate(9, workOrder.getPlannedEndDate());
                pstmt.setInt(10, workOrder.getCreatedBy());
                
                int result = pstmt.executeUpdate();
                if (result > 0) {
                    try (ResultSet rs = pstmt.getGeneratedKeys()) {
                        if (rs.next()) {
                            return rs.getInt(1);
                        }
                    }
                }
                return -1;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("작업지시 생성 중 오류가 발생했습니다.", e);
        }
    }
}
