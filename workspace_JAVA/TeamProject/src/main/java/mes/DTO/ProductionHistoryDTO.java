package mes.DTO;

import java.sql.Date;

/**
 * 생산 이력 관리 DTO
 * PRODUCTION_HISTORY 테이블과 매핑
 */
public class ProductionHistoryDTO {
    private int historyId;            // 이력 고유 식별번호
    private int rawLotId;             // 원자재 LOT 참조
    private int semiLotId;            // 반제품 LOT 참조
    private int finishedLotId;        // 완제품 LOT 참조
    private String stepName;          // 공정 단계명
    private Date startTime;           // 시작 시간
    private Date endTime;             // 종료 시간
    private String operator;          // 작업자
    private String status;            // 상태

    // 기본 생성자
    public ProductionHistoryDTO() {}

    // 전체 필드 생성자
    public ProductionHistoryDTO(int historyId, int rawLotId, int semiLotId, int finishedLotId, 
                               String stepName, Date startTime, Date endTime, String operator, String status) {
        this.historyId = historyId;
        this.rawLotId = rawLotId;
        this.semiLotId = semiLotId;
        this.finishedLotId = finishedLotId;
        this.stepName = stepName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.operator = operator;
        this.status = status;
    }

    // Getter 메서드들
    public int getHistoryId() {
        return historyId;
    }

    public int getRawLotId() {
        return rawLotId;
    }

    public int getSemiLotId() {
        return semiLotId;
    }

    public int getFinishedLotId() {
        return finishedLotId;
    }

    public String getStepName() {
        return stepName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public String getOperator() {
        return operator;
    }

    public String getStatus() {
        return status;
    }

    // Setter 메서드들
    public void setHistoryId(int historyId) {
        this.historyId = historyId;
    }

    public void setRawLotId(int rawLotId) {
        this.rawLotId = rawLotId;
    }

    public void setSemiLotId(int semiLotId) {
        this.semiLotId = semiLotId;
    }

    public void setFinishedLotId(int finishedLotId) {
        this.finishedLotId = finishedLotId;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ProductionHistoryDTO{" +
                "historyId=" + historyId +
                ", rawLotId=" + rawLotId +
                ", semiLotId=" + semiLotId +
                ", finishedLotId=" + finishedLotId +
                ", stepName='" + stepName + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", operator='" + operator + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
