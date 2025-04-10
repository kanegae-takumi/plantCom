
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>エラーページ</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css"
	media="all" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/error.css" />
<link
	href="https://fonts.googleapis.com/css2?family=Mochiy+Pop+One&display=swap"
	rel="stylesheet" />
</head>
<body>
	<!-- ヘッダーを挿入 -->
	<!-- サブヘッダーを挿入 -->
	<jsp:include page="../inc/header.jsp" />

	<!-- メインコンテンツ -->
	<main>
		<h1>エラーが発生しました</h1>
		<p>${message}</p>
		<a href="${pageContext.request.contextPath}/mainJsp/index.jsp">ホームに戻る</a>
	</main>

	<!-- フッターを挿入 -->
	<jsp:include page="../inc/footer.jsp" />
	<!-- スクリプト -->
	<script src="${pageContext.request.contextPath}/js/script.js"></script>
</body>
</html>