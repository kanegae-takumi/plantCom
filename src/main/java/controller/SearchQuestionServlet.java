package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.SearchQuestionDAO;
import dto.QuestionDTO;

@WebServlet("/SearchQuestionServlet")
public class SearchQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String keyword = request.getParameter("keyword");

		// 質問DAOから検索結果を取得
		SearchQuestionDAO dao = new SearchQuestionDAO();
		List<QuestionDTO> resultList = dao.searchByKeyword(keyword);

		// 結果とキーワードをリクエストスコープに保存
		request.setAttribute("keyword", keyword);
		request.setAttribute("resultList", resultList);

		// JSPへフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/mainJsp/searchResult.jsp");
		dispatcher.forward(request, response);
	}
}

