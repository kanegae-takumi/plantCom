package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.ReplyDAO;
import dto.LoginUserDTO; // ← 修正ポイント
import dto.ReplyDTO;

@WebServlet("/ReplyPostServlet")
public class ReplyPostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            // 文字化け防止
            request.setCharacterEncoding("UTF-8");

            // ログインユーザー確認
            Object loginUserObj = request.getSession().getAttribute("loginUser");
            if (loginUserObj == null) {
                response.sendRedirect(request.getContextPath() + "/login.jsp");
                return;
            }

            LoginUserDTO loginUser = (LoginUserDTO) loginUserObj; // ← 修正ポイント
            int userId = loginUser.getId(); // 取得したLoginUserDTOからIDを取得

            // 入力値取得
            String answerIdStr = request.getParameter("answer_id");
            String content = request.getParameter("content");

            if (answerIdStr == null || content == null || content.trim().isEmpty()) {
                response.sendRedirect(request.getContextPath() + "/errorPage.jsp"); // エラーページにリダイレクト
                return;
            }

            int answerId = Integer.parseInt(answerIdStr);

            // DTOに詰める
            ReplyDTO reply = new ReplyDTO();
            reply.setAnswerId(answerId);
            reply.setUserId(userId);
            reply.setContent(content);

            // DAOでDBに登録
            ReplyDAO dao = new ReplyDAO();
            dao.insertReply(reply);

            // 元の質問詳細画面にリダイレクト
            String questionId = request.getParameter("question_id");  // hiddenで渡す必要あり
            response.sendRedirect(request.getContextPath() + "/QuestionDetail?id=" + questionId);
        } catch (Exception e) {
            // 例外をログに出力
            e.printStackTrace();  // スタックトレースをコンソールに表示
            request.setAttribute("errorMessage", "エラーが発生しました。もう一度お試しください。");
            request.getRequestDispatcher("/mainJsp/error.jsp").forward(request, response);  // エラーページに遷移
        }
    }
}
