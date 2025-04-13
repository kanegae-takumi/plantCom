    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>ログインページ</title>
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
	    <h2>ログインページ</h2>

    <!-- エラーメッセージがあれば表示 -->
    <c:if test="${not empty errorMessage}">
        <p style="color: red;">${errorMessage}</p>
    </c:if>

    <!-- ログインフォーム -->
    <form action="${pageContext.request.contextPath}/login" method="post">
        <label for="email">メールアドレス:</label><br>
        <input type="email" name="email" id="email" required><br><br>

        <label for="password">パスワード:</label><br>
        <input type="password" name="password" id="password" required><br><br>

        <button type="submit">ログイン</button>
    </form>

    <br>
    <a href="${pageContext.request.contextPath}/register.jsp">新規会員登録はこちら</a>
	</main>
	
	<!-- フッターを挿入 -->
    <jsp:include page="../inc/footer.jsp" />
        <!-- スクリプト -->
    <script src="${pageContext.request.contextPath}/js/script.js"></script>
  </body>
  </html>