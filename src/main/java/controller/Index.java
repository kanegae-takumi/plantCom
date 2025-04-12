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
	//	Javaのシリアライズに関する一意のID（おまじないのようなものです。変更の必要は基本なし）。
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        QuestionDAO QuestionDAO = new QuestionDAO(); //質問テーブルを操作する DAO（Data Access Object）クラスのインスタンスを作成。
        List<QuestionDTO> questionList = null; //質問データを入れるためのリストを用意（初期値は null）。

        //質問一覧をDBから取得して questionList に格納。もし失敗したらエラーログを出力します。        
        try {
            questionList = QuestionDAO.getAllQuestions();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //JSPに渡すために、取得した質問リストをリクエストスコープにセットします。JSP内では ${questionList} として使えるようになります。
        request.setAttribute("questionList", questionList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/index.jsp");
        dispatcher.forward(request, response);
    }
}