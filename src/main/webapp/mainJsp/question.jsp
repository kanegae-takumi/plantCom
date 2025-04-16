    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>質問投稿画面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/question.css" />
    <link
      href="https://fonts.googleapis.com/css2?family=Mochiy+Pop+One&display=swap"
      rel="stylesheet"
    />
  </head>
  <body>
      <!-- ヘッダーを挿入 -->
    <!-- サブヘッダーを挿入 -->
	<jsp:include page="../inc/header.jsp" />
    <br />
    <main>
      <h1>&nbsp&nbsp質問投稿</h1>
      <hr />
      <form
        action="${pageContext.request.contextPath}/QuestionConfirmServlet"
        method="post"
        onsubmit="return validateForm()"
      >
        <table>
          <tr>
            <th>タイトル</th>
            <td>
              <input
                type="text"
                name="title"
                id="title"
                style="width: 100%"
                required
              />
            </td>
          </tr>
          <tr>
            <th>質問本文</th>
            <td>
              <textarea
                name="content"
                id="content"
                rows="15"
                cols="40"
                style="width: 100%"
              ></textarea>
            </td>
          </tr>
        </table>
        <input
          type="button"
          class="button3"
          value="ホームに戻る"
          onclick="location.href='${pageContext.request.contextPath}/Index'"
        />
        <input class="button4" type="submit" value="確認" />
      </form>
      <br>
    </main>
    	    <!-- フッターを挿入 -->
    <jsp:include page="../inc/footer.jsp" />
    <!-- スクリプト -->
    <script src="${pageContext.request.contextPath}/js/script.js"></script>
  </body>
</html>
