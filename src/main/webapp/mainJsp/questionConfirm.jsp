    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>質問内容確認画面</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/questionConfirm.css" />
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
	<div class="container">
	<h1>質問内容の確認</h1>
  <form action="${pageContext.request.contextPath}/submitQuestion" method="post">
    <table>
      <tr>
        <th>タイトル</th>
        <td>${title}</td>
      </tr>
      <tr>
        <th>質問本文</th>
        <td><pre>${content}</pre></td>
      </tr>
    </table>
	<br>
    <!-- hiddenで次に渡す -->
    <input type="hidden" name="title" value="${title}">
    <input type="hidden" name="content" value="${content}">

    <input class="button3" type="button" value="戻る" onclick="history.back()">
    <input class="button3"type="submit" value="送信">
  </form>
  <br>
  </div>
	</main>
	
	<!-- フッターを挿入 -->
    <jsp:include page="../inc/footer.jsp" />
        <!-- スクリプト -->
    <script src="${pageContext.request.contextPath}/js/script.js"></script>
  </body>
  </html>