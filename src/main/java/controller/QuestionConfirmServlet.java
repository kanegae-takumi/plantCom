package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/QuestionConfirmServlet")
public class QuestionConfirmServlet extends HttpServlet {
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      
    request.setCharacterEncoding("UTF-8");

    String title = request.getParameter("title");
    String content = request.getParameter("content");

    request.setAttribute("title", title);
    request.setAttribute("content", content);

    RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/questionConfirm.jsp");
    dispatcher.forward(request, response);
  }
}