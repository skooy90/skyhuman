package mes.DTO;

import java.sql.Date;

/**
 * 반제품→완제품 BOM 관리 DTO
 * SEMI_TO_FINISHED_BOM 테이블과 매핑
 */
public class SemiToFinishedBomDTO {
    private Long semiFinishedBomId;   // 반제품→완제품 BOM 고유 식별번호
    private Long parentId;            // 완제품 (목표)
    private Long childId;             // 반제품 (소재)
    private Double quantity;          // 필요 수량
    private Double mixingRatio;       // 배합 비율
    private Double curingTime;        // 숙성 시간
    private String packagingType;     // 포장 타입
    private Date createdAt;           // 생성일

    // 기본 생성자
    public SemiToFinishedBomDTO() {}

    // 전체 필드 생성자
    public SemiToFinishedBomDTO(Long semiFinishedBomId, Long parentId, Long childId, Double quantity, 
                                Double mixingRatio, Double curingTime, String packagingType, Date createdAt) {
        this.semiFinishedBomId = semiFinishedBomId;
        this.parentId = parentId;
        this.childId = childId;
        this.quantity = quantity;
        this.mixingRatio = mixingRatio;
        this.curingTime = curingTime;
        this.packagingType = packagingType;
        this.createdAt = createdAt;
    }

    // Getter 메서드들
    public Long getSemiFinishedBomId() {
        return semiFinishedBomId;
    }

    public Long getParentId() {
        return parentId;
    }

    public Long getChildId() {
        return childId;
    }

    public Double getQuantity() {
        return quantity;
    }

    public Double getMixingRatio() {
        return mixingRatio;
    }

    public Double getCuringTime() {
        return curingTime;
    }

    public String getPackagingType() {
        return packagingType;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    // Setter 메서드들
    public void setSemiFinishedBomId(Long semiFinishedBomId) {
        this.semiFinishedBomId = semiFinishedBomId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public void setChildId(Long childId) {
        this.childId = childId;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public void setMixingRatio(Double mixingRatio) {
        this.mixingRatio = mixingRatio;
    }

    public void setCuringTime(Double curingTime) {
        this.curingTime = curingTime;
    }

    public void setPackagingType(String packagingType) {
        this.packagingType = packagingType;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "SemiToFinishedBomDTO{" +
                "semiFinishedBomId=" + semiFinishedBomId +
                ", parentId=" + parentId +
                ", childId=" + childId +
                ", quantity=" + quantity +
                ", mixingRatio=" + mixingRatio +
                ", curingTime=" + curingTime +
                ", packagingType='" + packagingType + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
