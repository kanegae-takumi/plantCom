package dto;

import java.sql.Timestamp;

public class AnswerDTO {
    private int id;
    private String content;
    private Timestamp createdAt;
    private String userAccountName;  // 回答者のアカウント名（JOIN結果）

    // Getter & Setter
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }

    public String getUserAccountName() { return userAccountName; }
    public void setUserAccountName(String userAccountName) { this.userAccountName = userAccountName; }
}
