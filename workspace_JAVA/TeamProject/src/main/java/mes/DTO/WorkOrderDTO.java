package mes.DTO;

import java.sql.Date;


/**
 * 작업지시 마스터 관리 DTO
 * WORK_ORDER 테이블과 매핑
 */
public class WorkOrderDTO {
    private int workOrderId;          // 작업지시 고유 식별번호
    private int orderId;              // 주문 참조
    private int productId;            // 제품 참조
    private String workOrderNo;       // 작업지시 번호 (WO-2024-001)
    private String workOrderType;     // 작업지시 유형 (PRODUCTION/REPAIR/MAINTENANCE)
    private Double plannedQuantity;   // 계획 생산량
    private Double actualQuantity;    // 실제 생산량
    private String priority;          // 우선순위 (HIGH/NORMAL/LOW)
    private String status;            // 상태 (PLANNED/IN_PROGRESS/COMPLETED/CANCELLED)
    private Date plannedStartDate;    // 계획 시작일
    private Date plannedEndDate;      // 계획 완료일
    private Date actualStartDate;     // 실제 시작일
    private Date actualEndDate;       // 실제 완료일
    private int createdBy;            // 생성자
    private Date createdAt;           // 생성일
    private Date updatedAt;           // 수정일

    // 기본 생성자
    public WorkOrderDTO() {}

    // 전체 필드 생성자
    public WorkOrderDTO(int workOrderId, int orderId, int productId, String workOrderNo, 
                        String workOrderType, Double plannedQuantity, Double actualQuantity, 
                        String priority, String status, Date plannedStartDate, Date plannedEndDate, 
                        Date actualStartDate, Date actualEndDate, int createdBy, Date createdAt, Date updatedAt) {
        this.workOrderId = workOrderId;
        this.orderId = orderId;
        this.productId = productId;
        this.workOrderNo = workOrderNo;
        this.workOrderType = workOrderType;
        this.plannedQuantity = plannedQuantity;
        this.actualQuantity = actualQuantity;
        this.priority = priority;
        this.status = status;
        this.plannedStartDate = plannedStartDate;
        this.plannedEndDate = plannedEndDate;
        this.actualStartDate = actualStartDate;
        this.actualEndDate = actualEndDate;
        this.createdBy = createdBy;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    // Getter 메서드들
    public int getWorkOrderId() {
        return workOrderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public int getProductId() {
        return productId;
    }

    public String getWorkOrderNo() {
        return workOrderNo;
    }

    public String getWorkOrderType() {
        return workOrderType;
    }

    public Double getPlannedQuantity() {
        return plannedQuantity;
    }

    public Double getActualQuantity() {
        return actualQuantity;
    }

    public String getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    public Date getPlannedStartDate() {
        return plannedStartDate;
    }

    public Date getPlannedEndDate() {
        return plannedEndDate;
    }

    public Date getActualStartDate() {
        return actualStartDate;
    }

    public Date getActualEndDate() {
        return actualEndDate;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    // Setter 메서드들
    public void setWorkOrderId(int workOrderId) {
        this.workOrderId = workOrderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setWorkOrderNo(String workOrderNo) {
        this.workOrderNo = workOrderNo;
    }

    public void setWorkOrderType(String workOrderType) {
        this.workOrderType = workOrderType;
    }

    public void setPlannedQuantity(Double plannedQuantity) {
        this.plannedQuantity = plannedQuantity;
    }

    public void setActualQuantity(Double actualQuantity) {
        this.actualQuantity = actualQuantity;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPlannedStartDate(Date plannedStartDate) {
        this.plannedStartDate = plannedStartDate;
    }

    public void setPlannedEndDate(Date plannedEndDate) {
        this.plannedEndDate = plannedEndDate;
    }

    public void setActualStartDate(Date actualStartDate) {
        this.actualStartDate = actualStartDate;
    }

    public void setActualEndDate(Date actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "WorkOrderDTO{" +
                "workOrderId=" + workOrderId +
                ", orderId=" + orderId +
                ", productId=" + productId +
                ", workOrderNo='" + workOrderNo + '\'' +
                ", workOrderType='" + workOrderType + '\'' +
                ", plannedQuantity=" + plannedQuantity +
                ", actualQuantity=" + actualQuantity +
                ", priority='" + priority + '\'' +
                ", status='" + status + '\'' +
                ", plannedStartDate=" + plannedStartDate +
                ", plannedEndDate=" + plannedEndDate +
                ", actualStartDate=" + actualStartDate +
                ", actualEndDate=" + actualEndDate +
                ", createdBy=" + createdBy +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
