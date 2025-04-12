package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/registerConfirm")
public class RegisterConfirmServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String account_name = request.getParameter("account_name");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // 入力チェック（任意）
        if (account_name == null || account_name.isEmpty()
            || name == null || name.isEmpty()
            || email == null || email.isEmpty()
            || password == null || password.isEmpty()) {

            request.setAttribute("error", "すべての項目を入力してください。");
            request.getRequestDispatcher("/mainJsp/register.jsp").forward(request, response);
            return;
        }

        HttpSession session = request.getSession();
        session.setAttribute("account_name", account_name);
        session.setAttribute("name", name);
        session.setAttribute("email", email);
        session.setAttribute("password", password);

        request.getRequestDispatcher("/mainJsp/registerConfirm.jsp").forward(request, response);
    }
}
