package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.AnswerDTO;
import dto.ReplyDTO;

public class AnswerDAO {

    // 回答を登録する
    public void insertAnswer(int questionId, int userId, String content) {
        String sql = "INSERT INTO answers (question_id, user_id, content) VALUES (?, ?, ?)";

        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, questionId);
            stmt.setInt(2, userId);
            stmt.setString(3, content);

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 指定された質問に対するすべての回答を取得する（返信付き）
    public List<AnswerDTO> getAnswersByQuestionId(int questionId) {
        List<AnswerDTO> answerList = new ArrayList<>();
        String sql = "SELECT a.id, a.content, a.created_at, u.account_name, u.profile_image " + // 修正部分
                     "FROM answers a " +
                     "JOIN users u ON a.user_id = u.id " +
                     "WHERE a.question_id = ? " +
                     "ORDER BY a.created_at ASC";

        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, questionId);
            ResultSet rs = stmt.executeQuery();

            ReplyDAO replyDAO = new ReplyDAO(); // 返信取得用

            while (rs.next()) {
                AnswerDTO answer = new AnswerDTO();
                int answerId = rs.getInt("id");

                answer.setId(answerId);
                answer.setContent(rs.getString("content"));
                answer.setCreatedAt(rs.getTimestamp("created_at"));
                answer.setUserAccountName(rs.getString("account_name"));
                answer.setProfileImage(rs.getString("profile_image")); // 修正部分

                // この回答に紐づく返信を取得
                List<ReplyDTO> replyList = replyDAO.getRepliesByAnswerId(answerId);
                answer.setReplyList(replyList);

                answerList.add(answer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return answerList;
    }
}
