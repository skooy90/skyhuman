package mes.DTO;

import java.sql.Date;

/**
 * 비밀번호 이력 관리 DTO
 * PASSWORD_HISTORY 테이블과 매핑
 */
public class PasswordHistoryDTO {
    private Long historyId;           // 이력 고유 식별번호
    private Long userId;              // 사용자 참조 번호
    private String password;          // 이전 비밀번호
    private Date changedAt;           // 변경일

    // 기본 생성자
    public PasswordHistoryDTO() {}

    // 전체 필드 생성자
    public PasswordHistoryDTO(Long historyId, Long userId, String password, Date changedAt) {
        this.historyId = historyId;
        this.userId = userId;
        this.password = password;
        this.changedAt = changedAt;
    }

    // Getter 메서드들
    public Long getHistoryId() {
        return historyId;
    }

    public Long getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public Date getChangedAt() {
        return changedAt;
    }

    // Setter 메서드들
    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setChangedAt(Date changedAt) {
        this.changedAt = changedAt;
    }

    @Override
    public String toString() {
        return "PasswordHistoryDTO{" +
                "historyId=" + historyId +
                ", userId=" + userId +
                ", password='" + password + '\'' +
                ", changedAt=" + changedAt +
                '}';
    }
}
