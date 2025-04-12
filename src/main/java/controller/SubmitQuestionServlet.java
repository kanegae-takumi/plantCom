package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.QuestionDAO;
import dto.QuestionDTO;

// 他のインポートコード

@WebServlet("/submitQuestion")
public class SubmitQuestionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * コンストラクタ
     */
    public SubmitQuestionServlet() {
        super();
    }

    /**
     * POSTリクエスト処理
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // フォームから送信されたデータを取得
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        // 現在の日時を取得してTimestampに変換
        Timestamp created_at = new Timestamp(System.currentTimeMillis());

        // DTOの作成
        QuestionDTO question = new QuestionDTO(title, content, created_at);

        // DAOを使ってデータベースに保存
        QuestionDAO dao = new QuestionDAO();
        try {
            dao.saveQuestion(question); // 質問をデータベースに保存
            // 成功したら結果ページに転送
            request.setAttribute("message", "質問が正常に登録されました！");
            request.setAttribute("question", question);
            // 完了ページにフォワード
            request.getRequestDispatcher("/mainJsp/questionComplete.jsp").forward(request, response);
        } catch (SQLException e) {
            // エラーメッセージをリクエストにセット
            request.setAttribute("message", "データベースに保存できませんでした。");
            // エラーページに転送
            request.getRequestDispatcher("/mainJsp/error.jsp").forward(request, response);
        }
    }
}
