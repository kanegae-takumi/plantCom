package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.QuestionDAO;
import dto.LoginUserDTO; // ← ログイン時に使っているユーザー情報のDTO名に合わせてください
import dto.QuestionDTO;

@WebServlet("/submitQuestion")
public class SubmitQuestionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SubmitQuestionServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // フォームから送信されたデータを取得
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        Timestamp created_at = new Timestamp(System.currentTimeMillis());

        // セッションからログインユーザー情報を取得
        HttpSession session = request.getSession();
        LoginUserDTO loginUser = (LoginUserDTO) session.getAttribute("loginUser");

        if (loginUser == null) {
            // ログインしていない場合、エラーページへ
            request.setAttribute("message", "ログイン情報が見つかりません。再ログインしてください。");
            request.getRequestDispatcher("/mainJsp/error.jsp").forward(request, response);
            return;
        }

        int userId = loginUser.getId(); // ← loginUserDTO に getId() がある想定

        // DTO作成（新仕様：userId含む）
        QuestionDTO question = new QuestionDTO(title, content, created_at, userId);

        // DAO処理
        QuestionDAO dao = new QuestionDAO();
        try {
            dao.saveQuestion(question);
            request.setAttribute("message", "質問が正常に登録されました！");
            request.setAttribute("question", question);
            request.getRequestDispatcher("/mainJsp/questionComplete.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "データベースに保存できませんでした。");
            request.getRequestDispatcher("/mainJsp/error.jsp").forward(request, response);
        }
    }
}