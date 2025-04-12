package controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.UserDAO;
import dto.UserDTO;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	//文字化け防止    	
        request.setCharacterEncoding("UTF-8");

        //フォームから送られてきた値をそれぞれ取得
        String account_name = request.getParameter("account_name");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        //入力された情報を基にUserDTO(データ転送オブジェクト）を作成
        //DTOは、データを１つのオブジェクトにまとめてやり取りをするためのもの        
        UserDTO user = new UserDTO(account_name, name, email, password);
        //データベース操作を行うUserDAOのインスタンスを作成        
        UserDAO dao = new UserDAO();

        try {
            dao.insertUser(user); //DAOクラスのinsertUser()メソッドを使って、ユーザー情報をデータベースに登録
            request.setAttribute("message", "登録が完了しました！");
            request.getRequestDispatcher("/mainJsp/registerComplete.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("message", "登録に失敗しました。");
            request.getRequestDispatcher("/mainJsp/error.jsp").forward(request, response);
        }
    }
}


