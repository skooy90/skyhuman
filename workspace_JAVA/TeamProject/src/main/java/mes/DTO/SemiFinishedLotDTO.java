package mes.DTO;

import java.sql.Date;

/**
 * 반제품 LOT 관리 DTO
 * SEMI_FINISHED_LOT 테이블과 매핑
 */
public class SemiFinishedLotDTO {
    private int semiLotId;            // 반제품 LOT 고유 식별번호
    private int productId;            // 반제품 제품 참조
    private Double quantity;          // 수량
    private String unit;              // 단위 (kg, L)
    private String processStep;       // 공정 단계
    private String status;            // 상태
    private Date createdAt;           // 생성일

    // 기본 생성자
    public SemiFinishedLotDTO() {}

    // 전체 필드 생성자
    public SemiFinishedLotDTO(int semiLotId, int productId, Double quantity, String unit, 
                              String processStep, String status, Date createdAt) {
        this.semiLotId = semiLotId;
        this.productId = productId;
        this.quantity = quantity;
        this.unit = unit;
        this.processStep = processStep;
        this.status = status;
        this.createdAt = createdAt;
    }

    // Getter 메서드들
    public int getSemiLotId() {
        return semiLotId;
    }

    public int getProductId() {
        return productId;
    }

    public Double getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    public String getProcessStep() {
        return processStep;
    }

    public String getStatus() {
        return status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    // Setter 메서드들
    public void setSemiLotId(int semiLotId) {
        this.semiLotId = semiLotId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setProcessStep(String processStep) {
        this.processStep = processStep;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "SemiFinishedLotDTO{" +
                "semiLotId=" + semiLotId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                ", processStep='" + processStep + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
