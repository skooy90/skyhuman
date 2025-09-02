package mes.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import mes.DTO.WorkerDTO;
import util.DBManager;

/**
 * 작업자 관련 데이터 접근 객체
 * MES 시스템의 작업자 관리, 현황 조회 등을 담당
 */
public class WorkerDAO {
    
    /**
     * 모든 작업자 목록 조회
     * @return 작업자 목록
     */
    public List<WorkerDTO> getAllWorkers() {
        List<WorkerDTO> workers = new ArrayList<>();
        
        try (Connection conn = new DBManager().getConn()) {
            String sql = "SELECT w.WORKER_ID, w.USER_ID, w.WORKER_NAME, " +
                        "w.CURRENT_PROCESS, w.SKILL_LEVEL, w.WORK_SHIFT, w.CREATED_AT, " +
                        "u.USERNAME, u.ROLE " +
                        "FROM WORKERS w " +
                        "LEFT JOIN USERS u ON w.USER_ID = u.USER_ID " +
                        "ORDER BY w.WORKER_NAME";
            
            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {
                
                while (rs.next()) {
                    WorkerDTO worker = new WorkerDTO();
                    worker.setWorkerId(rs.getInt("WORKER_ID"));
                    worker.setUserId(rs.getInt("USER_ID"));
                    worker.setWorkerName(rs.getString("WORKER_NAME"));
                    worker.setCurrentProcess(rs.getString("CURRENT_PROCESS"));
                    worker.setSkillLevel(rs.getString("SKILL_LEVEL"));
                    worker.setWorkShift(rs.getString("WORK_SHIFT"));
                    worker.setCreatedAt(rs.getDate("CREATED_AT"));
                    
                    workers.add(worker);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("작업자 목록 조회 중 오류가 발생했습니다.", e);
        }
        
        return workers;
    }
    
    /**
     * 공정별 작업자 조회
     * @param processName 공정명
     * @return 해당 공정의 작업자 목록
     */
    public List<WorkerDTO> getWorkersByProcess(String processName) {
        List<WorkerDTO> workers = new ArrayList<>();
        
        try (Connection conn = new DBManager().getConn()) {
            String sql = "SELECT w.WORKER_ID, w.USER_ID, w.WORKER_NAME, " +
                        "w.CURRENT_PROCESS, w.SKILL_LEVEL, w.WORK_SHIFT, w.CREATED_AT " +
                        "FROM WORKERS w " +
                        "WHERE w.CURRENT_PROCESS = ? " +
                        "ORDER BY w.SKILL_LEVEL DESC, w.WORKER_NAME";
            
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, processName);
                
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        WorkerDTO worker = new WorkerDTO();
                        worker.setWorkerId(rs.getInt("WORKER_ID"));
                        worker.setUserId(rs.getInt("USER_ID"));
                        worker.setWorkerName(rs.getString("WORKER_NAME"));
                        worker.setCurrentProcess(rs.getString("CURRENT_PROCESS"));
                        worker.setSkillLevel(rs.getString("SKILL_LEVEL"));
                        worker.setWorkShift(rs.getString("WORK_SHIFT"));
                        worker.setCreatedAt(rs.getDate("CREATED_AT"));
                        
                        workers.add(worker);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("공정별 작업자 조회 중 오류가 발생했습니다.", e);
        }
        
        return workers;
    }
    
    /**
     * 숙련도별 작업자 조회
     * @param skillLevel 숙련도
     * @return 해당 숙련도의 작업자 목록
     */
    public List<WorkerDTO> getWorkersBySkillLevel(String skillLevel) {
        List<WorkerDTO> workers = new ArrayList<>();
        
        try (Connection conn = new DBManager().getConn()) {
            String sql = "SELECT w.WORKER_ID, w.USER_ID, w.WORKER_NAME, " +
                        "w.CURRENT_PROCESS, w.SKILL_LEVEL, w.WORK_SHIFT, w.CREATED_AT " +
                        "FROM WORKERS w " +
                        "WHERE w.SKILL_LEVEL = ? " +
                        "ORDER BY w.WORKER_NAME";
            
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, skillLevel);
                
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        WorkerDTO worker = new WorkerDTO();
                        worker.setWorkerId(rs.getInt("WORKER_ID"));
                        worker.setUserId(rs.getInt("USER_ID"));
                        worker.setWorkerName(rs.getString("WORKER_NAME"));
                        worker.setCurrentProcess(rs.getString("CURRENT_PROCESS"));
                        worker.setSkillLevel(rs.getString("SKILL_LEVEL"));
                        worker.setWorkShift(rs.getString("WORK_SHIFT"));
                        worker.setCreatedAt(rs.getDate("CREATED_AT"));
                        
                        workers.add(worker);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("숙련도별 작업자 조회 중 오류가 발생했습니다.", e);
        }
        
        return workers;
    }
    
    /**
     * 근무조별 작업자 조회
     * @param workShift 근무조
     * @return 해당 근무조의 작업자 목록
     */
    public List<WorkerDTO> getWorkersByShift(String workShift) {
        List<WorkerDTO> workers = new ArrayList<>();
        
        try (Connection conn = new DBManager().getConn()) {
            String sql = "SELECT w.WORKER_ID, w.USER_ID, w.WORKER_NAME, " +
                        "w.CURRENT_PROCESS, w.SKILL_LEVEL, w.WORK_SHIFT, w.CREATED_AT " +
                        "FROM WORKERS w " +
                        "WHERE w.WORK_SHIFT = ? " +
                        "ORDER BY w.WORKER_NAME";
            
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, workShift);
                
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        WorkerDTO worker = new WorkerDTO();
                        worker.setWorkerId(rs.getInt("WORKER_ID"));
                        worker.setUserId(rs.getInt("USER_ID"));
                        worker.setWorkerName(rs.getString("WORKER_NAME"));
                        worker.setCurrentProcess(rs.getString("CURRENT_PROCESS"));
                        worker.setSkillLevel(rs.getString("SKILL_LEVEL"));
                        worker.setWorkShift(rs.getString("WORK_SHIFT"));
                        worker.setCreatedAt(rs.getDate("CREATED_AT"));
                        
                        workers.add(worker);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("근무조별 작업자 조회 중 오류가 발생했습니다.", e);
        }
        
        return workers;
    }
    
    /**
     * 작업자 현재 공정 업데이트
     * @param workerId 작업자 ID
     * @param currentProcess 새로운 공정
     * @return 업데이트 성공 여부
     */
    public boolean updateWorkerProcess(int workerId, String currentProcess) {
        try (Connection conn = new DBManager().getConn()) {
            String sql = "UPDATE WORKERS SET CURRENT_PROCESS = ? " +
                        "WHERE WORKER_ID = ?";
            
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, currentProcess);
                pstmt.setInt(2, workerId);
                
                int result = pstmt.executeUpdate();
                return result > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("작업자 공정 업데이트 중 오류가 발생했습니다.", e);
        }
    }
    
    /**
     * 작업자 숙련도 업데이트
     * @param workerId 작업자 ID
     * @param skillLevel 새로운 숙련도
     * @return 업데이트 성공 여부
     */
    public boolean updateWorkerSkillLevel(int workerId, String skillLevel) {
        try (Connection conn = new DBManager().getConn()) {
            String sql = "UPDATE WORKERS SET SKILL_LEVEL = ? " +
                        "WHERE WORKER_ID = ?";
            
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, skillLevel);
                pstmt.setInt(2, workerId);
                
                int result = pstmt.executeUpdate();
                return result > 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("작업자 숙련도 업데이트 중 오류가 발생했습니다.", e);
        }
    }
    
    /**
     * 작업자 생성
     * @param worker 작업자 정보
     * @return 생성된 작업자 ID
     */
    public int createWorker(WorkerDTO worker) {
        try (Connection conn = new DBManager().getConn()) {
            String sql = "INSERT INTO WORKERS (WORKER_ID, USER_ID, WORKER_NAME, " +
                        "CURRENT_PROCESS, SKILL_LEVEL, WORK_SHIFT, CREATED_AT) " +
                        "VALUES (SEQ_WORKER_ID.NEXTVAL, ?, ?, ?, ?, ?, SYSDATE)";
            
            try (PreparedStatement pstmt = conn.prepareStatement(sql, new String[]{"WORKER_ID"})) {
                pstmt.setInt(1, worker.getUserId());
                pstmt.setString(2, worker.getWorkerName());
                pstmt.setString(3, worker.getCurrentProcess());
                pstmt.setString(4, worker.getSkillLevel());
                pstmt.setString(5, worker.getWorkShift());
                
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
            throw new RuntimeException("작업자 생성 중 오류가 발생했습니다.", e);
        }
    }
}
