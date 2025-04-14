
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>会員情報ページ</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css"
	media="all" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/★.css" />
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
	<c:choose>
    <c:when test="${not empty sessionScope.loginUser}">
        <h1>会員情報</h1>
        <p><strong>アカウント名:</strong> ${sessionScope.loginUser.account_name}</p>
        <p><strong>氏名:</strong> ${sessionScope.loginUser.name}</p>
        <p><strong>メールアドレス:</strong> ${sessionScope.loginUser.email}</p>
    </c:when>

    <c:otherwise>
        <c:redirect url="login.jsp" />
    </c:otherwise>
</c:choose>
	</main>

	<!-- フッターを挿入 -->
	<jsp:include page="../inc/footer.jsp" />
	<!-- スクリプト -->
	<script src="${pageContext.request.contextPath}/js/script.js"></script>
</body>
</html>