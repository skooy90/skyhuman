package mes.DTO;

import java.sql.Date;

/**
 * 주문 관리 DTO
 * ORDERS 테이블과 매핑
 */
public class OrderDTO {
    private int orderId;              // 주문 고유 식별번호
    private int customerId;           // 고객 참조 번호
    private int productId;            // 제품 참조 번호
    private int finishedLotId;        // 완제품 LOT 참조
    private Integer quantity;         // 주문 수량
    private Date orderDate;           // 주문일
    private String status;            // 주문 상태

    // 기본 생성자
    public OrderDTO() {}

    // 전체 필드 생성자
    public OrderDTO(int orderId, int customerId, int productId, int finishedLotId, 
                    Integer quantity, Date orderDate, String status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.productId = productId;
        this.finishedLotId = finishedLotId;
        this.quantity = quantity;
        this.orderDate = orderDate;
        this.status = status;
    }

    // Getter 메서드들
    public int getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getProductId() {
        return productId;
    }

    public int getFinishedLotId() {
        return finishedLotId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public String getStatus() {
        return status;
    }

    // Setter 메서드들
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setFinishedLotId(int finishedLotId) {
        this.finishedLotId = finishedLotId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", productId=" + productId +
                ", finishedLotId=" + finishedLotId +
                ", quantity=" + quantity +
                ", orderDate=" + orderDate +
                ", status='" + status + '\'' +
                '}';
    }
}
