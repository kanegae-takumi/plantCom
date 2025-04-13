package dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class QuestionDTO {
    private String title;
    private String content;
    private Timestamp created_at;

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

    // フォーマット済みの日付文字列を返すメソッド（JSP用）
    public String getFormattedCreatedAt() {
        if (created_at == null) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月d日 H時mm分");
        return sdf.format(created_at);
    }
}
