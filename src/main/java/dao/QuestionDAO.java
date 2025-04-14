package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.QuestionDTO;

public class QuestionDAO {

    // 質問データをデータベースに保存するメソッド（新仕様：user_idも保存）
    public void saveQuestion(QuestionDTO question) throws SQLException {
        String sql = "INSERT INTO questions (title, content, created_at, user_id) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, question.getTitle());
            ps.setString(2, question.getContent());
            ps.setTimestamp(3, question.getCreated_at());
            ps.setInt(4, question.getUserId()); // ← 追加部分

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    // 質問一覧を取得するメソッド
    public List<QuestionDTO> getAllQuestions() throws SQLException {
        List<QuestionDTO> questionList = new ArrayList<>();
        String sql = "SELECT id, title, content, created_at, user_id FROM questions ORDER BY id DESC";

        try (Connection conn = DBManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                QuestionDTO question = new QuestionDTO(
                    rs.getString("title"),
                    rs.getString("content"),
                    rs.getTimestamp("created_at"),
                    rs.getInt("user_id") // ← 追加
                );
                question.setId(rs.getInt("id"));
                questionList.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return questionList;
    }

    // IDで質問を検索して取得するメソッド
    public QuestionDTO findById(int id) {
        QuestionDTO question = null;
        String sql = "SELECT id, title, content, created_at, user_id FROM questions WHERE id = ?";

        try (Connection conn = DBManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    question = new QuestionDTO(
                        rs.getString("title"),
                        rs.getString("content"),
                        rs.getTimestamp("created_at"),
                        rs.getInt("user_id") // ← 追加
                    );
                    question.setId(rs.getInt("id"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return question;
    }
}