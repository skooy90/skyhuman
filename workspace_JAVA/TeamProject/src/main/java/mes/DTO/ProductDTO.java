package mes.DTO;

import java.sql.Date;

/**
 * 제품 정보 관리 DTO
 * PRODUCT 테이블과 매핑
 */
public class ProductDTO {
    private int productId;            // 제품 고유 식별번호
    private String productName;       // 제품명
    private String productType;       // 제품 유형 (RAW/SEMI_FINISHED/FINISHED)
    private String unit;              // 단위 (kg, L, 개, g)
    private String description;       // 제품 설명

    // 기본 생성자
    public ProductDTO() {}

    // 전체 필드 생성자
    public ProductDTO(int productId, String productName, String productType, String unit, String description) {
        this.productId = productId;
        this.productName = productName;
        this.productType = productType;
        this.unit = unit;
        this.description = description;
    }

    // Getter 메서드들
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductType() {
        return productType;
    }

    public String getUnit() {
        return unit;
    }

    public String getDescription() {
        return description;
    }

    // Setter 메서드들
    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                ", unit='" + unit + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
