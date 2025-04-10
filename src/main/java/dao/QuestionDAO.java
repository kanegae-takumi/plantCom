package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.QuestionDTO;

public class QuestionDAO {

    // 質問データをデータベースに保存するメソッド
    public void saveQuestion(QuestionDTO question) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            // DB接続
            conn = DBManager.getConnection();

            // SQL文の準備
            String sql = "INSERT INTO questions (title, content) VALUES (?, ?)";
            ps = conn.prepareStatement(sql);

            // パラメータの設定
            ps.setString(1, question.getTitle());
            ps.setString(2, question.getContent());

            // SQL実行
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw e; // エラーがあれば、例外を再スロー
        } finally {
            // リソースのクローズ
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }
}
