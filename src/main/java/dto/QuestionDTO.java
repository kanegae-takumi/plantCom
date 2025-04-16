package dto;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class QuestionDTO {
    private int id;
    private String title;
    private String content;
    private Timestamp created_at;
    private int userId;
    private String accountName;     // ← 投稿者名
    private String profileImage;    // ← プロフィール画像ファイル名

    // 既存のコンストラクタ
    public QuestionDTO(String title, String content, Timestamp created_at) {
        this.title = title;
        this.content = content;
        this.created_at = created_at;
    }

    // userId 対応のコンストラクタ
    public QuestionDTO(String title, String content, Timestamp created_at, int userId) {
        this.title = title;
        this.content = content;
        this.created_at = created_at;
        this.userId = userId;
    }

    // --- ゲッターとセッター ---
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

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

    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getAccountName() {
        return accountName;
    }
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getProfileImage() {
        return profileImage;
    }
    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
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
