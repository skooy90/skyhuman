package mes.DTO;

import java.sql.Date;

/**
 * 공정별 작업지시 상세 관리 DTO
 * WORK_ORDER_PROCESS 테이블과 매핑
 */
public class WorkOrderProcessDTO {
    private int workOrderProcessId;   // 공정별 작업지시 상세 고유 식별번호
    private int workOrderId;          // 작업지시 참조
    private Integer processSequence;  // 공정 순서 (1, 2, 3...)
    private String processName;       // 공정명 (오이 추출, 비누 베이스 혼합, 성형 등)
    private String processCode;       // 공정 코드 (EXTRACT, MIX, FORM, DRY, QC)
    private Double plannedQuantity;   // 공정별 계획 수량
    private Double actualQuantity;    // 공정별 실제 수량
    private Double standardTime;      // 표준 작업 시간 (분)
    private Double actualTime;        // 실제 작업 시간 (분)
    private String equipmentId;       // 사용 설비 ID
    private String equipmentName;     // 사용 설비명
    private String processParameters; // 공정 파라미터 (JSON 형태로 온도, 압력 등)
    private String status;            // 공정 상태 (PLANNED/IN_PROGRESS/COMPLETED/ON_HOLD)
    private Date startTime;           // 공정 시작 시간
    private Date endTime;             // 공정 완료 시간
    private Date createdAt;           // 생성일

    // 기본 생성자
    public WorkOrderProcessDTO() {}

    // 전체 필드 생성자
    public WorkOrderProcessDTO(int workOrderProcessId, int workOrderId, Integer processSequence, 
                              String processName, String processCode, Double plannedQuantity, Double actualQuantity, 
                              Double standardTime, Double actualTime, String equipmentId, String equipmentName, 
                              String processParameters, String status, Date startTime, Date endTime, Date createdAt) {
        this.workOrderProcessId = workOrderProcessId;
        this.workOrderId = workOrderId;
        this.processSequence = processSequence;
        this.processName = processName;
        this.processCode = processCode;
        this.plannedQuantity = plannedQuantity;
        this.actualQuantity = actualQuantity;
        this.standardTime = standardTime;
        this.actualTime = actualTime;
        this.equipmentId = equipmentId;
        this.equipmentName = equipmentName;
        this.processParameters = processParameters;
        this.status = status;
        this.startTime = startTime;
        this.endTime = endTime;
        this.createdAt = createdAt;
    }

    // Getter 메서드들
    public int getWorkOrderProcessId() {
        return workOrderProcessId;
    }

    public int getWorkOrderId() {
        return workOrderId;
    }

    public Integer getProcessSequence() {
        return processSequence;
    }

    public String getProcessName() {
        return processName;
    }

    public String getProcessCode() {
        return processCode;
    }

    public Double getPlannedQuantity() {
        return plannedQuantity;
    }

    public Double getActualQuantity() {
        return actualQuantity;
    }

    public Double getStandardTime() {
        return standardTime;
    }

    public Double getActualTime() {
        return actualTime;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public String getProcessParameters() {
        return processParameters;
    }

    public String getStatus() {
        return status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    // Setter 메서드들
    public void setWorkOrderProcessId(int workOrderProcessId) {
        this.workOrderProcessId = workOrderProcessId;
    }

    public void setWorkOrderId(int workOrderId) {
        this.workOrderId = workOrderId;
    }

    public void setProcessSequence(Integer processSequence) {
        this.processSequence = processSequence;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public void setProcessCode(String processCode) {
        this.processCode = processCode;
    }

    public void setPlannedQuantity(Double plannedQuantity) {
        this.plannedQuantity = plannedQuantity;
    }

    public void setActualQuantity(Double actualQuantity) {
        this.actualQuantity = actualQuantity;
    }

    public void setStandardTime(Double standardTime) {
        this.standardTime = standardTime;
    }

    public void setActualTime(Double actualTime) {
        this.actualTime = actualTime;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public void setProcessParameters(String processParameters) {
        this.processParameters = processParameters;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "WorkOrderProcessDTO{" +
                "workOrderProcessId=" + workOrderProcessId +
                ", workOrderId=" + workOrderId +
                ", processSequence=" + processSequence +
                ", processName='" + processName + '\'' +
                ", processCode='" + processCode + '\'' +
                ", plannedQuantity=" + plannedQuantity +
                ", actualQuantity=" + actualQuantity +
                ", standardTime=" + standardTime +
                ", actualTime=" + actualTime +
                ", equipmentId='" + equipmentId + '\'' +
                ", equipmentName='" + equipmentName + '\'' +
                ", processParameters='" + processParameters + '\'' +
                ", status='" + status + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", createdAt=" + createdAt +
                '}';
    }
}
