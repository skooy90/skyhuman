package mes.DTO;

/**
 * 고객 정보 관리 DTO
 * CUSTOMER 테이블과 매핑
 */
public class CustomerDTO {
    private int customerId;           // 고객 고유 식별번호
    private String name;              // 고객명
    private String contact;           // 연락처
    private String address;           // 주소

    // 기본 생성자
    public CustomerDTO() {}

    // 전체 필드 생성자
    public CustomerDTO(int customerId, String name, String contact, String address) {
        this.customerId = customerId;
        this.name = name;
        this.contact = contact;
        this.address = address;
    }

    // Getter 메서드들
    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getAddress() {
        return address;
    }

    // Setter 메서드들
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
