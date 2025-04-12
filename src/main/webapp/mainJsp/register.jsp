<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>会員情報登録画面</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css" />
<link href="https://fonts.googleapis.com/css2?family=Mochiy+Pop+One&display=swap" rel="stylesheet" />
</head>
<body>
	<!-- ヘッダー -->
	<jsp:include page="../inc/header.jsp" />

	<main>
		<h1>会員登録フォーム</h1>
		<form action="${pageContext.request.contextPath}/registerConfirm" method="post">
		<table>
		<tr>
			<th>ユーザー名：</th>
			<td><input type="text" name="account_name" required value="${param.account_name}"></td>
			</tr>
			
			<tr>
			<th>名前：</th>
			<td><input type="text" name="name" required value="${param.name}"></td>
			</tr>
			
			<tr>
			<th>メールアドレス：</th>
			<td><input type="email" name="email" required value="${param.email}"></td>
			</tr>
			
			<tr>
			<th>パスワード：</th>
			<td><input type="password" name="password" required value="${param.password}"></td>
			</tr>
			</table>
			<input type="submit" value="確認画面へ">
		</form>
	</main>

	<!-- フッター -->
	<jsp:include page="../inc/footer.jsp" />

	<script src="${pageContext.request.contextPath}/js/script.js"></script>
</body>
</html>
