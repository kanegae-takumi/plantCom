package controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import dao.LoginUserDAO;
import dto.LoginUserDTO;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        LoginUserDAO dao = new LoginUserDAO();
        LoginUserDTO user = null;

        try {
            user = dao.login(email, password); // ログインチェック

            if (user != null) {
                // 認証成功：セッションにユーザー情報を保存
                HttpSession session = request.getSession();
                session.setAttribute("loginUser", user);

                // ログイン後のページへリダイレクト
                response.sendRedirect(request.getContextPath() + "/Index");
            } else {
                // 認証失敗
                request.setAttribute("errorMessage", "メールアドレスまたはパスワードが違います。");
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "データベースエラーが発生しました。");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}
