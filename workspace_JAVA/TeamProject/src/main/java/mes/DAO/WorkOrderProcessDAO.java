package mes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mes.DTO.WorkOrderProcessDTO;
import util.DBManager;

/**
 * 공정별 작업지시 상세 데이터 접근 객체
 * MES 시스템의 공정 진행상황, 공정별 상세 정보 등을 담당
 */
public class WorkOrderProcessDAO {
    
    /**
     * 모든 공정별 작업지시 조회
     * @return 공정별 작업지시 목록
     */
    public List<WorkOrderProcessDTO> getAllWorkOrderProcesses() {
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
                        "ORDER BY wop.WORK_ORDER_ID, wop.PROCESS_SEQUENCE";
            
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
            throw new RuntimeException("공정별 작업지시 목록 조회 중 오류가 발생했습니다.", e);
        }
        
        return processes;
    }
    
    /**
     * 작업지시별 공정 목록 조회
     * @param workOrderId 작업지시 ID
     * @return 해당 작업지시의 공정 목록
     */
    public List<WorkOrderProcessDTO> getProcessesByWorkOrder(int workOrderId) {
        List<WorkOrderProcessDTO> processes = new ArrayList<>();
        
        try (Connection conn = new DBManager().getConn()) {
            String sql = "SELECT wop.WORK_ORDER_PROCESS_ID, wop.WORK_ORDER_ID, " +
                        "wop.PROCESS_SEQUENCE, wop.PROCESS_NAME, wop.PROCESS_CODE, " +
                        "wop.PLANNED_QUANTITY, wop.ACTUAL_QUANTITY, wop.STANDARD_TIME, " +
                        "wop.ACTUAL_TIME, wop.EQUIPMENT_ID, wop.EQUIPMENT_NAME, " +
                        "wop.PROCESS_PARAMETERS, wop.STATUS, wop.START_TIME, " +
                        "wop.END_TIME, wop.CREATED_AT " +
                        "FROM WORK_ORDER_PROCESS wop " +
                        "WHERE wop.WORK_ORDER_ID = ? " +
                        "ORDER BY wop.PROCESS_SEQUENCE";
            
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, workOrderId);
                
                try (ResultSet rs = pstmt.executeQuery()) {
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
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("작업지시별 공정 목록 조회 중 오류가 발생했습니다.", e);
        }
        
        return processes;
    }
    
    /**
     * 공정 상태 업데이트
     * @param workOrderProcessId 공정별 작업지시 ID
     * @param status 새로운 상태
     * @return 업데이트 성공 여부
     */
    public boolean updateProcessStatus(int workOrderProcessId, String status) {
        try (Connection conn = new DBManager().getConn()) {
            String sql = "UPDATE WORK_ORDER_PROCESS SET STATUS = ? " +
                        "WHERE WORK_ORDER_PROCESS_ID = ?";
            
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, status);
                pstmt.setInt(2, workOrderProcessId);
                
                int result = pstmt.executeUpdate();
                return result > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("공정 상태 업데이트 중 오류가 발생했습니다.", e);
        }
    }
    
    /**
     * 공정 시작 시간 업데이트
     * @param workOrderProcessId 공정별 작업지시 ID
     * @return 업데이트 성공 여부
     */
    public boolean startProcess(int workOrderProcessId) {
        try (Connection conn = new DBManager().getConn()) {
            String sql = "UPDATE WORK_ORDER_PROCESS SET STATUS = 'IN_PROGRESS', START_TIME = SYSDATE " +
                        "WHERE WORK_ORDER_PROCESS_ID = ?";
            
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, workOrderProcessId);
                
                int result = pstmt.executeUpdate();
                return result > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("공정 시작 시간 업데이트 중 오류가 발생했습니다.", e);
        }
    }
    
    /**
     * 공정 완료 시간 업데이트
     * @param workOrderProcessId 공정별 작업지시 ID
     * @param actualQuantity 실제 수량
     * @param actualTime 실제 소요 시간
     * @return 업데이트 성공 여부
     */
    public boolean completeProcess(int workOrderProcessId, Double actualQuantity, Double actualTime) {
        try (Connection conn = new DBManager().getConn()) {
            String sql = "UPDATE WORK_ORDER_PROCESS SET STATUS = 'COMPLETED', END_TIME = SYSDATE, " +
                        "ACTUAL_QUANTITY = ?, ACTUAL_TIME = ? " +
                        "WHERE WORK_ORDER_PROCESS_ID = ?";
            
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setDouble(1, actualQuantity);
                pstmt.setDouble(2, actualTime);
                pstmt.setInt(3, workOrderProcessId);
                
                int result = pstmt.executeUpdate();
                return result > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("공정 완료 시간 업데이트 중 오류가 발생했습니다.", e);
        }
    }
    
    /**
     * 공정별 작업지시 생성
     * @param process 공정별 작업지시 정보
     * @return 생성된 공정별 작업지시 ID
     */
    public int createWorkOrderProcess(WorkOrderProcessDTO process) {
        try (Connection conn = new DBManager().getConn()) {
            String sql = "INSERT INTO WORK_ORDER_PROCESS (WORK_ORDER_PROCESS_ID, WORK_ORDER_ID, " +
                        "PROCESS_SEQUENCE, PROCESS_NAME, PROCESS_CODE, PLANNED_QUANTITY, " +
                        "STANDARD_TIME, EQUIPMENT_ID, EQUIPMENT_NAME, STATUS, CREATED_AT) " +
                        "VALUES (SEQ_WORK_ORDER_PROCESS_ID.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE)";
            
            try (PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"WORK_ORDER_PROCESS_ID"})) {
                pstmt.setInt(1, process.getWorkOrderId());
                pstmt.setInt(2, process.getProcessSequence());
                pstmt.setString(3, process.getProcessName());
                pstmt.setString(4, process.getProcessCode());
                pstmt.setDouble(5, process.getPlannedQuantity());
                pstmt.setDouble(6, process.getStandardTime());
                pstmt.setString(7, process.getEquipmentId());
                pstmt.setString(8, process.getEquipmentName());
                pstmt.setString(9, process.getStatus());
                
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
            throw new RuntimeException("공정별 작업지시 생성 중 오류가 발생했습니다.", e);
        }
    }
}
