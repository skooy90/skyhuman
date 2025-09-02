package mes.DTO;

import java.sql.Date;

/**
 * 작업지시 자재 할당 관리 DTO
 * WORK_ORDER_MATERIAL 테이블과 매핑
 */
public class WorkOrderMaterialDTO {
    private int workOrderMaterialId;  // 작업지시 자재 할당 고유 식별번호
    private int workOrderId;          // 작업지시 참조
    private int workOrderProcessId;   // 공정 참조
    private int productId;            // 자재 제품 참조
    private String materialType;      // 자재 유형 (RAW/SEMI_FINISHED)
    private int lotId;                // LOT 참조 (RAW_LOT_ID 또는 SEMI_LOT_ID)
    private Double plannedQuantity;   // 계획 사용량
    private Double actualQuantity;    // 실제 사용량
    private String unit;              // 단위
    private String status;            // 상태 (PLANNED/ISSUED/USED/RETURNED)
    private Date issueDate;           // 자재 출고일
    private Date createdAt;           // 생성일

    // 기본 생성자
    public WorkOrderMaterialDTO() {}

    // 전체 필드 생성자
    public WorkOrderMaterialDTO(int workOrderMaterialId, int workOrderId, int workOrderProcessId, 
                               int productId, String materialType, int lotId, Double plannedQuantity, 
                               Double actualQuantity, String unit, String status, Date issueDate, Date createdAt) {
        this.workOrderMaterialId = workOrderMaterialId;
        this.workOrderId = workOrderId;
        this.workOrderProcessId = workOrderProcessId;
        this.productId = productId;
        this.materialType = materialType;
        this.lotId = lotId;
        this.plannedQuantity = plannedQuantity;
        this.actualQuantity = actualQuantity;
        this.unit = unit;
        this.status = status;
        this.issueDate = issueDate;
        this.createdAt = createdAt;
    }

    // Getter 메서드들
    public int getWorkOrderMaterialId() {
        return workOrderMaterialId;
    }

    public int getWorkOrderId() {
        return workOrderId;
    }

    public int getWorkOrderProcessId() {
        return workOrderProcessId;
    }

    public int getProductId() {
        return productId;
    }

    public String getMaterialType() {
        return materialType;
    }

    public int getLotId() {
        return lotId;
    }

    public Double getPlannedQuantity() {
        return plannedQuantity;
    }

    public Double getActualQuantity() {
        return actualQuantity;
    }

    public String getUnit() {
        return unit;
    }

    public String getStatus() {
        return status;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    // Setter 메서드들
    public void setWorkOrderMaterialId(int workOrderMaterialId) {
        this.workOrderMaterialId = workOrderMaterialId;
    }

    public void setWorkOrderId(int workOrderId) {
        this.workOrderId = workOrderId;
    }

    public void setWorkOrderProcessId(int workOrderProcessId) {
        this.workOrderProcessId = workOrderProcessId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public void setLotId(int lotId) {
        this.lotId = lotId;
    }

    public void setPlannedQuantity(Double plannedQuantity) {
        this.plannedQuantity = plannedQuantity;
    }

    public void setActualQuantity(Double actualQuantity) {
        this.actualQuantity = actualQuantity;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "WorkOrderMaterialDTO{" +
                "workOrderMaterialId=" + workOrderMaterialId +
                ", workOrderId=" + workOrderId +
                ", workOrderProcessId=" + workOrderProcessId +
                ", productId=" + productId +
                ", materialType='" + materialType + '\'' +
                ", lotId=" + lotId +
                ", plannedQuantity=" + plannedQuantity +
                ", actualQuantity=" + actualQuantity +
                ", unit='" + unit + '\'' +
                ", status='" + status + '\'' +
                ", issueDate=" + issueDate +
                ", createdAt=" + createdAt +
                '}';
    }
}
