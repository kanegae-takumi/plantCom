package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.QuestionDAO;
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

        // パラメータ取得
        String idStr = request.getParameter("id");
        int id = Integer.parseInt(idStr);

        // 質問情報をDBから取得（DAOなどを使う）
        QuestionDAO dao = new QuestionDAO();
        QuestionDTO question = dao.findById(id);

        // リクエストにセットしてJSPへ
        request.setAttribute("question", question);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/questionDetail.jsp");
        dispatcher.forward(request, response);
    }
}
