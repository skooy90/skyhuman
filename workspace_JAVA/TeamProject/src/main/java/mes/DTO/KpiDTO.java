package mes.DTO;

import java.sql.Date;

/**
 * KPI(핵심 성과 지표) 관리 DTO
 * KPI 테이블과 매핑
 */
public class KpiDTO {
    private Long kpiId;               // KPI 고유 식별번호
    private Long productId;           // 제품별 KPI
    private String kpiName;           // KPI 지표명
    private String kpiType;           // KPI 유형 (PRODUCTIVITY/QUALITY/EFFICIENCY)
    private Integer targetValue;      // 목표값
    private Integer actualValue;      // 실제값
    private Date measureDate;         // 측정일

    // 기본 생성자
    public KpiDTO() {}

    // 전체 필드 생성자
    public KpiDTO(Long kpiId, Long productId, String kpiName, String kpiType, 
                  Integer targetValue, Integer actualValue, Date measureDate) {
        this.kpiId = kpiId;
        this.productId = productId;
        this.kpiName = kpiName;
        this.kpiType = kpiType;
        this.targetValue = targetValue;
        this.actualValue = actualValue;
        this.measureDate = measureDate;
    }

    // Getter 메서드들
    public Long getKpiId() {
        return kpiId;
    }

    public Long getProductId() {
        return productId;
    }

    public String getKpiName() {
        return kpiName;
    }

    public String getKpiType() {
        return kpiType;
    }

    public Integer getTargetValue() {
        return targetValue;
    }

    public Integer getActualValue() {
        return actualValue;
    }

    public Date getMeasureDate() {
        return measureDate;
    }

    // Setter 메서드들
    public void setKpiId(Long kpiId) {
        this.kpiId = kpiId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setKpiName(String kpiName) {
        this.kpiName = kpiName;
    }

    public void setKpiType(String kpiType) {
        this.kpiType = kpiType;
    }

    public void setTargetValue(Integer targetValue) {
        this.targetValue = targetValue;
    }

    public void setActualValue(Integer actualValue) {
        this.actualValue = actualValue;
    }

    public void setMeasureDate(Date measureDate) {
        this.measureDate = measureDate;
    }

    @Override
    public String toString() {
        return "KpiDTO{" +
                "kpiId=" + kpiId +
                ", productId=" + productId +
                ", kpiName='" + kpiName + '\'' +
                ", kpiType='" + kpiType + '\'' +
                ", targetValue=" + targetValue +
                ", actualValue=" + actualValue +
                ", measureDate=" + measureDate +
                '}';
    }
}
