    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>★</title>
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
	<h1>会員登録フォーム</h1>
    <form action="${pageContext.request.contextPath}/register" method="post">
        名前：<input type="text" name="name" required><br>
        メールアドレス：<input type="email" name="email" required><br>
        パスワード：<input type="password" name="password" required><br>
        <input type="submit" value="登録">
    </form>
	</main>
	
	<!-- フッターを挿入 -->
    <jsp:include page="../inc/footer.jsp" />
        <!-- スクリプト -->
    <script src="${pageContext.request.contextPath}/js/script.js"></script>
  </body>
  </html>