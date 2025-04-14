    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>質問詳細画面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/★.css" />
    <link
      href="https://fonts.googleapis.com/css2?family=Mochiy+Pop+One&display=swap"
      rel="stylesheet"
    />
  </head>
  <body>
    <!-- ヘッダーを挿入 -->
    <!-- サブヘッダーを挿入 -->
	<jsp:include page="../inc/header.jsp" />
	
	<!-- メインコンテンツ -->
	<main>
	<h2>${question.title}</h2>
<p>${question.content}</p>
<p>投稿日時: ${question.formattedCreatedAt}</p>

  <!-- 回答フォーム -->
  <c:if test="${not empty sessionScope.loginUser}">
    <form action="${pageContext.request.contextPath}/AnswerPostServlet" method="post">
      <input type="hidden" name="question_id" value="${question.id}" />
      <textarea name="content" rows="5" cols="50" placeholder="ここに回答を入力してください" required></textarea><br>
      <button type="submit">回答する</button>
    </form>
  </c:if>
  <c:if test="${empty sessionScope.loginUser}">
    <p><a href="${pageContext.request.contextPath}/login.jsp">ログイン</a>すると回答できます。</p>
  </c:if>

  <!-- 回答一覧（ここは後でStep4で実装） -->
	</main>
	
	<!-- フッターを挿入 -->
    <jsp:include page="../inc/footer.jsp" />
        <!-- スクリプト -->
    <script src="${pageContext.request.contextPath}/js/script.js"></script>
  </body>
  </html>