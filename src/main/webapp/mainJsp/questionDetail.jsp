<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>質問詳細画面</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css"
	media="all" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/questionDetail.css" />
<link
	href="https://fonts.googleapis.com/css2?family=Mochiy+Pop+One&display=swap"
	rel="stylesheet" />
</head>
<body>
	<!-- ヘッダーを挿入 -->
	<jsp:include page="../inc/header.jsp" />

	<!-- メインコンテンツ -->
	<main>
		<!-- 質問内容表示 -->
		<div class="question-container">
			<div class="profile-container">
			<img
				src="${pageContext.request.contextPath}/uploads/${question.profileImage}"
				alt="プロフィール画像"
				style="width: 40px; height: 40px; border-radius: 50%; margin-right: 10px;" />
			<p>投稿者: ${question.accountName}</p>
			</div>
			<hr>
			<h2>タイトル：${question.title}</h2>
			<hr>
			<p>${question.content}</p>
			<br>
			<p>投稿日時: ${question.formattedCreatedAt}</p>
		</div>

		<!-- 回答フォーム -->
		<div class="answer-form">
			<c:if test="${not empty sessionScope.loginUser}">
				<!-- ログインしている場合のみ、回答フォームを表示 -->
				<form action="${pageContext.request.contextPath}/AnswerPostServlet"
					method="post">
					<input type="hidden" name="question_id" value="${question.id}" />
					<textarea name="content" rows="5" cols="50"
						placeholder="ここに回答を入力してください" required></textarea>
					<button class="answer-button" type="submit">回答する</button>
				</form>
			</c:if>
		</div>

		<!-- ログインしていない場合は、「ログインすると回答できます。」を表示 -->
		<c:if test="${empty sessionScope.loginUser}">
			<p>
				<a href="${pageContext.request.contextPath}/login.jsp">ログイン</a>すると回答できます。
			</p>
		</c:if>

		<!-- 回答一覧 -->
		<div class="answer-summary">
			<h3>回答一覧</h3>
			<hr>
			<c:if test="${not empty answerList}">
				<ul>
					<c:forEach var="answer" items="${answerList}">
						<li>
							<p>
								<strong>${answer.userAccountName} さんの回答:</strong>
							</p>
							<p>${answer.content}</p>
							<p>投稿日時: ${answer.createdAt}</p>
							<hr>
						</li>
					</c:forEach>
				</ul>
			</c:if>
			<c:if test="${empty answerList}">
				<p>まだ回答がありません。</p>
			</c:if>
		</div>
	</main>

	<!-- フッターを挿入 -->
	<jsp:include page="../inc/footer.jsp" />
</body>
</html>
