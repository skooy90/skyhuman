package mes.DTO;

import java.sql.Date;

/**
 * 완제품 LOT 관리 DTO
 * FINISHED_PRODUCT_LOT 테이블과 매핑
 */
public class FinishedProductLotDTO {
    private int finishedLotId;        // 완제품 LOT 고유 식별번호
    private int productId;            // 완제품 제품 참조
    private Integer quantity;         // 수량 (개수)
    private String qcStatus;          // 품질검사 상태
    private String inspector;         // 검사자
    private String status;            // 상태
    private Date createdAt;           // 생성일

    // 기본 생성자
    public FinishedProductLotDTO() {}

    // 전체 필드 생성자
    public FinishedProductLotDTO(int finishedLotId, int productId, Integer quantity, 
                                String qcStatus, String inspector, String status, Date createdAt) {
        this.finishedLotId = finishedLotId;
        this.productId = productId;
        this.quantity = quantity;
        this.qcStatus = qcStatus;
        this.inspector = inspector;
        this.status = status;
        this.createdAt = createdAt;
    }

    // Getter 메서드들
    public int getFinishedLotId() {
        return finishedLotId;
    }

    public int getProductId() {
        return productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public String getQcStatus() {
        return qcStatus;
    }

    public String getInspector() {
        return inspector;
    }

    public String getStatus() {
        return status;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    // Setter 메서드들
    public void setFinishedLotId(int finishedLotId) {
        this.finishedLotId = finishedLotId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setQcStatus(String qcStatus) {
        this.qcStatus = qcStatus;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "FinishedProductLotDTO{" +
                "finishedLotId=" + finishedLotId +
                ", productId=" + productId +
                ", quantity=" + quantity +
                ", qcStatus='" + qcStatus + '\'' +
                ", inspector='" + inspector + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
