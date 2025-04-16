package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.ReplyDTO;

public class ReplyDAO {

    // 返信を登録
    public void insertReply(ReplyDTO reply) throws SQLException {
        String sql = "INSERT INTO replies (answer_id, user_id, content) VALUES (?, ?, ?)";

        try (Connection conn = DBManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, reply.getAnswerId());
            ps.setInt(2, reply.getUserId());
            ps.setString(3, reply.getContent());

            ps.executeUpdate();

        }
    }

    // 指定した回答IDに対する返信一覧を取得
    public List<ReplyDTO> getRepliesByAnswerId(int answerId) throws SQLException {
        List<ReplyDTO> replyList = new ArrayList<>();
        String sql = "SELECT r.id, r.answer_id, r.user_id, r.content, r.created_at, u.account_name, u.profile_image " +
                     "FROM replies r " +
                     "JOIN users u ON r.user_id = u.id " +
                     "WHERE r.answer_id = ? " +
                     "ORDER BY r.created_at ASC";

        try (Connection conn = DBManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, answerId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ReplyDTO reply = new ReplyDTO();
                    reply.setId(rs.getInt("id"));
                    reply.setAnswerId(rs.getInt("answer_id"));
                    reply.setUserId(rs.getInt("user_id"));
                    reply.setContent(rs.getString("content"));
                    reply.setCreatedAt(rs.getTimestamp("created_at"));
                    reply.setUserAccountName(rs.getString("account_name"));
                    reply.setProfileImage(rs.getString("profile_image")); // 修正されたフィールド名
                    replyList.add(reply);
                }
            }
        }

        return replyList;
    }
}
