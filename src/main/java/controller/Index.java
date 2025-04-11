package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.QuestionDAO;
import dto.QuestionDTO;

@WebServlet("/Index")
public class Index extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDAO QuestionDAO = new QuestionDAO();
        List<QuestionDTO> questionList = null;

        try {
            questionList = QuestionDAO.getAllQuestions();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("questionList", questionList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/index.jsp");
        dispatcher.forward(request, response);
    }
}