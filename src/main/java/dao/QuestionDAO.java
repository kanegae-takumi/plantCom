package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

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
	        String sql = "INSERT INTO questions (title, content, created_at) VALUES (?, ?, ?)";
	        ps = conn.prepareStatement(sql);

	        // パラメータの設定
	        ps.setString(1, question.getTitle());
	        ps.setString(2, question.getContent());
	        
	        // TimestampをStringに変換して保存
	        ps.setString(3, new SimpleDateFormat("yyyy年M月d日 H時m分").format(question.getCreated_at()));

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
    // 質問一覧を取得するメソッド（SELECT文）
    public List<QuestionDTO> getAllQuestions() throws SQLException {
        List<QuestionDTO> questionList = new ArrayList<>();
        String sql = "SELECT title, content, created_at FROM questions ORDER BY id DESC"; // created_atを追加

        try (Connection conn = DBManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                String title = rs.getString("title");
                String content = rs.getString("content");
                Timestamp created_at = rs.getTimestamp("created_at"); // Timestamp型で取得
                QuestionDTO question = new QuestionDTO(title, content, created_at);
                questionList.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }

        return questionList;
    }
}
