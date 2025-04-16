package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.AnswerDAO;
import dao.QuestionDAO;
import dto.AnswerDTO;
import dto.QuestionDTO;

@WebServlet("/QuestionDetail")
public class QuestionDetail extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("loginUser") == null) {
            response.sendRedirect(request.getContextPath() + "/mainJsp/login.jsp");
            return;
        }

        // パラメータ取得と検証
        String idStr = request.getParameter("id");
        if (idStr == null || idStr.isEmpty()) {
            request.setAttribute("errorMessage", "質問IDが不正です。");
            request.getRequestDispatcher("/mainJsp/error.jsp").forward(request, response);
            return;
        }

        int id;
        try {
            id = Integer.parseInt(idStr);
        } catch (NumberFormatException e) {
            request.setAttribute("errorMessage", "質問IDが不正な形式です。");
            request.getRequestDispatcher("/mainJsp/error.jsp").forward(request, response);
            return;
        }

        // 質問情報をDBから取得
        QuestionDAO dao = new QuestionDAO();
        QuestionDTO question = dao.findById(id);
        if (question == null) {
            request.setAttribute("errorMessage", "指定された質問は存在しません。");
            request.getRequestDispatcher("/mainJsp/error.jsp").forward(request, response);
            return;
        }
        request.setAttribute("question", question);

        // 回答一覧を取得
        AnswerDAO answerDao = new AnswerDAO();
        List<AnswerDTO> answerList = answerDao.getAnswersByQuestionId(id);
        request.setAttribute("answerList", answerList);

        // JSPへフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/questionDetail.jsp");
        dispatcher.forward(request, response);
    }
}

