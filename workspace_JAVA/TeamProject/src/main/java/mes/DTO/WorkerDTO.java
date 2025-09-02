package mes.DTO;

import java.sql.Date;

/**
 * 작업자 관리 DTO
 * WORKERS 테이블과 매핑
 */
public class WorkerDTO {
    private int workerId;             // 작업자 고유 식별번호
    private int userId;               // 사용자 계정 참조 번호
    private String workerName;        // 작업자명
    private String currentProcess;    // 현재 담당 공정
    private String skillLevel;        // 숙련도 (BEGINNER/INTERMEDIATE/EXPERT)
    private String workShift;         // 근무조 (DAY/NIGHT)
    private Date createdAt;           // 생성일

    // 기본 생성자
    public WorkerDTO() {}

    // 전체 필드 생성자
    public WorkerDTO(int workerId, int userId, String workerName, String currentProcess, 
                     String skillLevel, String workShift, Date createdAt) {
        this.workerId = workerId;
        this.userId = userId;
        this.workerName = workerName;
        this.currentProcess = currentProcess;
        this.skillLevel = skillLevel;
        this.workShift = workShift;
        this.createdAt = createdAt;
    }

    // Getter 메서드들
    public int getWorkerId() {
        return workerId;
    }

    public int getUserId() {
        return userId;
    }

    public String getWorkerName() {
        return workerName;
    }

    public String getCurrentProcess() {
        return currentProcess;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public String getWorkShift() {
        return workShift;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    // Setter 메서드들
    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public void setCurrentProcess(String currentProcess) {
        this.currentProcess = currentProcess;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    public void setWorkShift(String workShift) {
        this.workShift = workShift;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "WorkerDTO{" +
                "workerId=" + workerId +
                ", userId=" + userId +
                ", workerName='" + workerName + '\'' +
                ", currentProcess='" + currentProcess + '\'' +
                ", skillLevel='" + skillLevel + '\'' +
                ", workShift='" + workShift + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
