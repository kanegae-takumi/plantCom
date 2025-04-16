package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.AnswerDAO;
import dto.LoginUserDTO;

@WebServlet("/AnswerPostServlet")
public class AnswerPostServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        // 質問IDを取得（パラメータが存在しない場合の処理を追加）
        String questionIdParam = request.getParameter("question_id");
        if (questionIdParam == null || questionIdParam.isEmpty()) {
            response.sendRedirect("error.jsp"); // エラーページにリダイレクト
            return;
        }

        int questionId = Integer.parseInt(questionIdParam);

        // 内容を取得（空でないことをチェック）
        String content = request.getParameter("content");
        if (content == null || content.trim().isEmpty()) {
            request.setAttribute("errorMessage", "回答内容を入力してください。");
            request.getRequestDispatcher("/questionDetail.jsp?id=" + questionId).forward(request, response);
            return;
        }

        // ログインユーザーの情報を取得
        LoginUserDTO loginUser = (LoginUserDTO) request.getSession().getAttribute("loginUser");
        if (loginUser == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        // 回答の登録処理
        int userId = loginUser.getId();
        AnswerDAO dao = new AnswerDAO();
        dao.insertAnswer(questionId, userId, content);

        // 質問詳細ページにリダイレクト
        response.sendRedirect(request.getContextPath() + "/QuestionDetail?id=" + questionId);
    }
}
