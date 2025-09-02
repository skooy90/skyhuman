package mes.DTO;

import java.sql.Date;

/**
 * 반제품→완제품 BOM LOT 관리 DTO
 * SEMI_FINISHED_BOM_LOT 테이블과 매핑
 */
public class SemiFinishedBomLotDTO {
    private Long semiFinishedBomLotId; // 반제품→완제품 BOM_LOT 고유 식별번호
    private Long semiFinishedBomId;    // BOM 참조
    private Long semiLotId;            // 반제품 LOT 참조
    private Long finishedLotId;        // 완제품 LOT 참조
    private Double plannedQuantity;    // 계획 수량
    private Double actualQuantity;     // 실제 사용 수량
    private Double variance;           // 차이 (실제-계획)
    private Date createdAt;            // 생성일

    // 기본 생성자
    public SemiFinishedBomLotDTO() {}

    // 전체 필드 생성자
    public SemiFinishedBomLotDTO(Long semiFinishedBomLotId, Long semiFinishedBomId, Long semiLotId, Long finishedLotId, 
                                 Double plannedQuantity, Double actualQuantity, Double variance, Date createdAt) {
        this.semiFinishedBomLotId = semiFinishedBomLotId;
        this.semiFinishedBomId = semiFinishedBomId;
        this.semiLotId = semiLotId;
        this.finishedLotId = finishedLotId;
        this.plannedQuantity = plannedQuantity;
        this.actualQuantity = actualQuantity;
        this.variance = variance;
        this.createdAt = createdAt;
    }

    // Getter 메서드들
    public Long getSemiFinishedBomLotId() {
        return semiFinishedBomLotId;
    }

    public Long getSemiFinishedBomId() {
        return semiFinishedBomId;
    }

    public Long getSemiLotId() {
        return semiLotId;
    }

    public Long getFinishedLotId() {
        return finishedLotId;
    }

    public Double getPlannedQuantity() {
        return plannedQuantity;
    }

    public Double getActualQuantity() {
        return actualQuantity;
    }

    public Double getVariance() {
        return variance;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    // Setter 메서드들
    public void setSemiFinishedBomLotId(Long semiFinishedBomLotId) {
        this.semiFinishedBomLotId = semiFinishedBomLotId;
    }

    public void setSemiFinishedBomId(Long semiFinishedBomId) {
        this.semiFinishedBomId = semiFinishedBomId;
    }

    public void setSemiLotId(Long semiLotId) {
        this.semiLotId = semiLotId;
    }

    public void setFinishedLotId(Long finishedLotId) {
        this.finishedLotId = finishedLotId;
    }

    public void setPlannedQuantity(Double plannedQuantity) {
        this.plannedQuantity = plannedQuantity;
    }

    public void setActualQuantity(Double actualQuantity) {
        this.actualQuantity = actualQuantity;
    }

    public void setVariance(Double variance) {
        this.variance = variance;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "SemiFinishedBomLotDTO{" +
                "semiFinishedBomLotId=" + semiFinishedBomLotId +
                ", semiFinishedBomId=" + semiFinishedBomId +
                ", semiLotId=" + semiLotId +
                ", finishedLotId=" + finishedLotId +
                ", plannedQuantity=" + plannedQuantity +
                ", actualQuantity=" + actualQuantity +
                ", variance=" + variance +
                ", createdAt=" + createdAt +
                '}';
    }
}
