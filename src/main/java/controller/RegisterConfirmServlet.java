package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet("/registerConfirm")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024,
    maxFileSize = 1024 * 1024 * 5,
    maxRequestSize = 1024 * 1024 * 10
)
public class RegisterConfirmServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String account_name = request.getParameter("account_name");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (account_name == null || account_name.isEmpty()
            || name == null || name.isEmpty()
            || email == null || email.isEmpty()
            || password == null || password.isEmpty()) {

            request.setAttribute("error", "すべての項目を入力してください。");
            request.getRequestDispatcher("/mainJsp/register.jsp").forward(request, response);
            return;
        }

        String fileName = "notice-icon.png"; // デフォルト画像
        Part filePart = request.getPart("profile_image");

        if (filePart != null && filePart.getSize() > 0) {
            fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();

            // 保存先パス
            String projectPath = getServletContext().getRealPath("/"); // 実際のWebアプリケーションのパス
            String uploadDir = projectPath + "uploads"; // 保存先はwebapp/uploadsディレクトリ
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // 保存先パス
            String savePath = uploadDir + File.separator + fileName;
            filePart.write(savePath); // ファイルを保存
        }

        // セッションに情報を格納
        HttpSession session = request.getSession();
        session.setAttribute("account_name", account_name);
        session.setAttribute("name", name);
        session.setAttribute("email", email);
        session.setAttribute("password", password);
        session.setAttribute("profile_image", fileName); // プロフィール画像名をセッションに保存

        // 確認ページに転送
        request.getRequestDispatcher("/mainJsp/registerConfirm.jsp").forward(request, response);
    }
}
