package mes.DTO;

import java.sql.Date;

/**
 * 원자재→반제품 BOM LOT 관리 DTO
 * RAW_SEMI_BOM_LOT 테이블과 매핑
 */
public class RawSemiBomLotDTO {
    private Long rawSemiBomLotId;    // 원자재→반제품 BOM_LOT 고유 식별번호
    private Long rawSemiBomId;       // BOM 참조
    private Long rawLotId;            // 원자재 LOT 참조
    private Long semiLotId;           // 반제품 LOT 참조
    private Double plannedQuantity;   // 계획 수량
    private Double actualQuantity;    // 실제 사용 수량
    private Double variance;          // 차이 (실제-계획)
    private Date createdAt;           // 생성일

    // 기본 생성자
    public RawSemiBomLotDTO() {}

    // 전체 필드 생성자
    public RawSemiBomLotDTO(Long rawSemiBomLotId, Long rawSemiBomId, Long rawLotId, Long semiLotId, 
                            Double plannedQuantity, Double actualQuantity, Double variance, Date createdAt) {
        this.rawSemiBomLotId = rawSemiBomLotId;
        this.rawSemiBomId = rawSemiBomId;
        this.rawLotId = rawLotId;
        this.semiLotId = semiLotId;
        this.plannedQuantity = plannedQuantity;
        this.actualQuantity = actualQuantity;
        this.variance = variance;
        this.createdAt = createdAt;
    }

    // Getter 메서드들
    public Long getRawSemiBomLotId() {
        return rawSemiBomLotId;
    }

    public Long getRawSemiBomId() {
        return rawSemiBomId;
    }

    public Long getRawLotId() {
        return rawLotId;
    }

    public Long getSemiLotId() {
        return semiLotId;
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
    public void setRawSemiBomLotId(Long rawSemiBomLotId) {
        this.rawSemiBomLotId = rawSemiBomLotId;
    }

    public void setRawSemiBomId(Long rawSemiBomId) {
        this.rawSemiBomId = rawSemiBomId;
    }

    public void setRawLotId(Long rawLotId) {
        this.rawLotId = rawLotId;
    }

    public void setSemiLotId(Long semiLotId) {
        this.semiLotId = semiLotId;
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
        return "RawSemiBomLotDTO{" +
                "rawSemiBomLotId=" + rawSemiBomLotId +
                ", rawSemiBomId=" + rawSemiBomId +
                ", rawLotId=" + rawLotId +
                ", semiLotId=" + semiLotId +
                ", plannedQuantity=" + plannedQuantity +
                ", actualQuantity=" + actualQuantity +
                ", variance=" + variance +
                ", createdAt=" + createdAt +
                '}';
    }
}
