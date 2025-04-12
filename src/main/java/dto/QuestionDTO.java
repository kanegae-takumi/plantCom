package dto;

import java.sql.Timestamp;

public class QuestionDTO {

    private String title;
    private String content;
    private Timestamp created_at;  // Timestamp 型に変更

    // コンストラクタ
    public QuestionDTO(String title, String content, Timestamp created_at) {
        this.title = title;
        this.content = content;
        this.created_at = created_at;
    }

    // ゲッターとセッター
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
}
