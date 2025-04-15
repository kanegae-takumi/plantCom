package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.QuestionDTO;

public class SearchQuestionDAO {

    // キーワードで質問を検索するメソッド
    public List<QuestionDTO> searchByKeyword(String keyword) {
        List<QuestionDTO> resultList = new ArrayList<>();

        String sql = "SELECT id, title, content, created_at FROM questions " +
                     "WHERE title LIKE ? OR content LIKE ? " +
                     "ORDER BY created_at DESC";

        try (Connection conn = DBManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            String likeKeyword = "%" + keyword + "%";
            pstmt.setString(1, likeKeyword);
            pstmt.setString(2, likeKeyword);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    QuestionDTO q = new QuestionDTO(
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getTimestamp("created_at")
                    );
                    q.setId(rs.getInt("id"));
                    resultList.add(q);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }
}
