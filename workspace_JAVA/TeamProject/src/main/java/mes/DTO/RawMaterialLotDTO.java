package mes.DTO;

import java.sql.Date;

/**
 * 원자재 LOT 관리 DTO
 * RAW_MATERIAL_LOT 테이블과 매핑
 */
public class RawMaterialLotDTO {
    private int rawLotId;             // 원자재 LOT 고유 식별번호
    private int productId;            // 원자재 제품 참조
    private Double quantity;          // 수량
    private String unit;              // 단위 (kg, L, g)
    private String supplier;          // 공급업체
    private Date expiryDate;          // 유통기한
    private String status;            // 상태
    private Date createdAt;           // 생성일

    // 기본 생성자
    public RawMaterialLotDTO() {}

    // 전체 필드 생성자
    public RawMaterialLotDTO(int rawLotId, int productId, Double quantity, String unit, 
                            String supplier, Date expiryDate, String status, Date createdAt) {
        this.rawLotId = rawLotId;
        this.productId = productId;
        this.quantity = quantity;
        this.unit = unit;
        this.supplier = supplier;
        this.expiryDate = expiryDate;
        this.status = status;
        this.createdAt = createdAt;
    }

    // Getter 메서드들
    public int getRawLotId() {
        return rawLotId;
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

    public String getSupplier() {
        return supplier;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public String getStatus() {
        return status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    // Setter 메서드들
    public void setRawLotId(int rawLotId) {
        this.rawLotId = rawLotId;
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

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "RawMaterialLotDTO{" +
                "rawLotId=" + rawLotId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", unit='" + unit + '\'' +
                ", supplier='" + supplier + '\'' +
                ", expiryDate=" + expiryDate +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
