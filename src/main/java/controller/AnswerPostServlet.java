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

        int questionId = Integer.parseInt(request.getParameter("question_id"));
        String content = request.getParameter("content");

        LoginUserDTO loginUser = (LoginUserDTO) request.getSession().getAttribute("loginUser");
        if (loginUser == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        int userId = loginUser.getId();

        AnswerDAO dao = new AnswerDAO();
        dao.insertAnswer(questionId, userId, content);

        response.sendRedirect("QuestionDetailServlet?id=" + questionId);
    }
}
