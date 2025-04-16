<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	href="${pageContext.request.contextPath}/css/profile.css" />
<link
	href="https://fonts.googleapis.com/css2?family=Mochiy+Pop+One&display=swap"
	rel="stylesheet" />
</head>
<body>
	<!-- ヘッダーを挿入 -->
	<jsp:include page="../inc/header.jsp" />

	<!-- メインコンテンツ -->
	<main>
		<div class="register-inf">
			<c:choose>
				<c:when test="${not empty sessionScope.loginUser}">
					<h1>会員情報</h1>
					
					<!-- プロフィール画像の表示 -->
					<p>プロフィール画像：</p>
					<c:choose>
						<c:when test="${not empty sessionScope.loginUser.profile_image}">
							<img src="${pageContext.request.contextPath}/uploads/${sessionScope.loginUser.profile_image}" 
								alt="プロフィール画像" width="150" height="150" />
						</c:when>
						<c:otherwise>
							<img src="${pageContext.request.contextPath}/uploads/notice-icon.png" 
								alt="デフォルト画像" width="150" height="150" />
						</c:otherwise>
					</c:choose>

					<p><strong>アカウント名:</strong> ${sessionScope.loginUser.account_name}</p>
					<p><strong>氏名:</strong> ${sessionScope.loginUser.name}</p>
					<p><strong>メールアドレス:</strong> ${sessionScope.loginUser.email}</p>
					
				</c:when>
				<c:otherwise>
					<c:redirect url="login.jsp" />
				</c:otherwise>
			</c:choose>
		</div>
	</main>

	<!-- フッターを挿入 -->
	<jsp:include page="../inc/footer.jsp" />
	<!-- スクリプト -->
	<script src="${pageContext.request.contextPath}/js/script.js"></script>
</body>
</html>
