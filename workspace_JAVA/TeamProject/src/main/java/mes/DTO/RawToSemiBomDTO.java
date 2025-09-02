package mes.DTO;

import java.sql.Date;

/**
 * 원자재→반제품 BOM 관리 DTO
 * RAW_TO_SEMI_BOM 테이블과 매핑
 */
public class RawToSemiBomDTO {
    private Long rawSemiBomId;       // 원자재→반제품 BOM 고유 식별번호
    private Long parentId;            // 반제품 (목표)
    private Long childId;             // 원자재 (소재)
    private Double quantity;          // 필요 수량
    private Double processTemp;       // 공정 온도
    private Double processTime;       // 공정 시간
    private String equipment;         // 사용 설비
    private Date createdAt;           // 생성일

    // 기본 생성자
    public RawToSemiBomDTO() {}

    // 전체 필드 생성자
    public RawToSemiBomDTO(Long rawSemiBomId, Long parentId, Long childId, Double quantity, 
                           Double processTemp, Double processTime, String equipment, Date createdAt) {
        this.rawSemiBomId = rawSemiBomId;
        this.parentId = parentId;
        this.childId = childId;
        this.quantity = quantity;
        this.processTemp = processTemp;
        this.processTime = processTime;
        this.equipment = equipment;
        this.createdAt = createdAt;
    }

    // Getter 메서드들
    public Long getRawSemiBomId() {
        return rawSemiBomId;
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

    public Double getProcessTemp() {
        return processTemp;
    }

    public Double getProcessTime() {
        return processTime;
    }

    public String getEquipment() {
        return equipment;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    // Setter 메서드들
    public void setRawSemiBomId(Long rawSemiBomId) {
        this.rawSemiBomId = rawSemiBomId;
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

    public void setProcessTemp(Double processTemp) {
        this.processTemp = processTemp;
    }

    public void setProcessTime(Double processTime) {
        this.processTime = processTime;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "RawToSemiBomDTO{" +
                "rawSemiBomId=" + rawSemiBomId +
                ", parentId=" + parentId +
                ", childId=" + childId +
                ", quantity=" + quantity +
                ", processTemp=" + processTemp +
                ", processTime=" + processTime +
                ", equipment='" + equipment + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
