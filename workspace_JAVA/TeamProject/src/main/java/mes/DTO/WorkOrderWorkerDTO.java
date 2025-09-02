package mes.DTO;

import java.sql.Date;

/**
 * 작업지시 작업자 할당 관리 DTO
 * WORK_ORDER_WORKER 테이블과 매핑
 */
public class WorkOrderWorkerDTO {
    private int workOrderWorkerId;    // 작업지시 작업자 할당 고유 식별번호
    private int workOrderId;          // 작업지시 참조
    private int workOrderProcessId;   // 공정 참조
    private int workerId;             // 작업자 참조
    private String role;              // 역할 (OPERATOR/SUPERVISOR/INSPECTOR)
    private Date assignedDate;        // 할당일
    private Date startTime;           // 작업 시작 시간
    private Date endTime;             // 작업 완료 시간
    private String status;            // 상태 (ASSIGNED/IN_PROGRESS/COMPLETED)
    private Date createdAt;           // 생성일

    // 기본 생성자
    public WorkOrderWorkerDTO() {}

    // 전체 필드 생성자
    public WorkOrderWorkerDTO(int workOrderWorkerId, int workOrderId, int workOrderProcessId, 
                             int workerId, String role, Date assignedDate, Date startTime, 
                             Date endTime, String status, Date createdAt) {
        this.workOrderWorkerId = workOrderWorkerId;
        this.workOrderId = workOrderId;
        this.workOrderProcessId = workOrderProcessId;
        this.workerId = workerId;
        this.role = role;
        this.assignedDate = assignedDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.status = status;
        this.createdAt = createdAt;
    }

    // Getter 메서드들
    public int getWorkOrderWorkerId() {
        return workOrderWorkerId;
    }

    public int getWorkOrderId() {
        return workOrderId;
    }

    public int getWorkOrderProcessId() {
        return workOrderProcessId;
    }

    public int getWorkerId() {
        return workerId;
    }

    public String getRole() {
        return role;
    }

    public Date getAssignedDate() {
        return assignedDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public String getStatus() {
        return status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    // Setter 메서드들
    public void setWorkOrderWorkerId(int workOrderWorkerId) {
        this.workOrderWorkerId = workOrderWorkerId;
    }

    public void setWorkOrderId(int workOrderId) {
        this.workOrderId = workOrderId;
    }

    public void setWorkOrderProcessId(int workOrderProcessId) {
        this.workOrderProcessId = workOrderProcessId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAssignedDate(Date assignedDate) {
        this.assignedDate = assignedDate;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "WorkOrderWorkerDTO{" +
                "workOrderWorkerId=" + workOrderWorkerId +
                ", workOrderId=" + workOrderId +
                ", workOrderProcessId=" + workOrderProcessId +
                ", workerId=" + workerId +
                ", role='" + role + '\'' +
                ", assignedDate=" + assignedDate +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
