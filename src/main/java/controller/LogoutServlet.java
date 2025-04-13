package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LogoutServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // セッションを取得して破棄
        HttpSession session = request.getSession(false); // セッションがなければ null
        if (session != null) {
            session.invalidate(); // セッションを無効化
        }

        // トップページへリダイレクト（任意で変更）
        response.sendRedirect(request.getContextPath() + "/Index");
    }

    // POSTでもログアウトできるようにしておくとより丁寧
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response); // POSTもGETと同様の処理にする
    }
}

