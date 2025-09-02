package mes.DTO;

import java.sql.Date;

/**
 * 사용자 계정 관리 DTO
 * USERS 테이블과 매핑
 */
public class UserDTO {
    private int userId;               // 사용자 고유 식별번호
    private String employeeNumber;    // 사원번호
    private String username;          // 사용자명
    private String password;          // 비밀번호
    private String role;              // 역할 (ADMIN/EMPLOYEE)
    private Integer isFirstLogin;     // 최초 로그인 여부 (1: 예, 0: 아니오)
    private Integer isActive;         // 계정 활성화 여부
    private Date createdAt;           // 생성일

    // 기본 생성자
    public UserDTO() {}

    // 전체 필드 생성자
    public UserDTO(int userId, String employeeNumber, String username, String password, 
                   String role, Integer isFirstLogin, Integer isActive, Date createdAt) {
        this.userId = userId;
        this.employeeNumber = employeeNumber;
        this.username = username;
        this.password = password;
        this.role = role;
        this.isFirstLogin = isFirstLogin;
        this.isActive = isActive;
        this.createdAt = createdAt;
    }

    // Getter 메서드들
    public int getUserId() {
        return userId;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public Integer getIsFirstLogin() {
        return isFirstLogin;
    }

    public Integer getIsActive() {
        return isActive;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    // Setter 메서드들
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setIsFirstLogin(Integer isFirstLogin) {
        this.isFirstLogin = isFirstLogin;
    }

    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", employeeNumber='" + employeeNumber + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", isFirstLogin=" + isFirstLogin +
                ", isActive=" + isActive +
                ", createdAt=" + createdAt +
                '}';
    }
}
