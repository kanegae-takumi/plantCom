package dto;

import java.sql.Timestamp;
import java.util.List;

public class AnswerDTO {
    private int id;
    private String content;
    private Timestamp createdAt;
    private String userAccountName; // 回答者のアカウント名（JOIN結果）
    private String profileImage;    // 回答者のプロフィール画像（JOIN結果）

    private List<ReplyDTO> replyList; // この回答に紐づく返信一覧

    // --- Getter & Setter ---
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }

    public String getUserAccountName() { return userAccountName; }
    public void setUserAccountName(String userAccountName) { this.userAccountName = userAccountName; }

    public String getProfileImage() { return profileImage; }
    public void setProfileImage(String profileImage) { this.profileImage = profileImage; }

    public List<ReplyDTO> getReplyList() { return replyList; }
    public void setReplyList(List<ReplyDTO> replyList) { this.replyList = replyList; }
}
