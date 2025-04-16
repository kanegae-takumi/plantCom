<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true" %>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>登録内容確認</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/css/★.css" />
  <link href="https://fonts.googleapis.com/css2?family=Mochiy+Pop+One&display=swap" rel="stylesheet" />
</head>
<body>

  <!-- ヘッダー -->
  <jsp:include page="../inc/header.jsp" />

  <main>
    <h1>登録内容の確認</h1>
    <p>以下の内容でよろしいですか？</p>

    <div>
      <p>ユーザー名：${sessionScope.account_name}</p>
      <p>名前：${sessionScope.name}</p>
      <p>メールアドレス：${sessionScope.email}</p>
      <p>パスワード：${sessionScope.password}</p>

      <p>プロフィール画像：</p>
      <img src="${pageContext.request.contextPath}/uploads/${sessionScope.profile_image}" alt="プロフィール画像" width="120">
    </div>

    <!-- 登録処理へ -->
    <form action="${pageContext.request.contextPath}/register" method="post">
      <input type="hidden" name="account_name" value="${sessionScope.account_name}" />
      <input type="hidden" name="name" value="${sessionScope.name}" />
      <input type="hidden" name="email" value="${sessionScope.email}" />
      <input type="hidden" name="password" value="${sessionScope.password}" />
      <input type="hidden" name="profile_image" value="${sessionScope.profile_image}" />
      <input type="submit" value="登録する">
    </form>

    <!-- 修正する -->
    <form action="${pageContext.request.contextPath}/mainJsp/register.jsp" method="post">
      <input type="hidden" name="account_name" value="${sessionScope.account_name}" />
      <input type="hidden" name="name" value="${sessionScope.name}" />
      <input type="hidden" name="email" value="${sessionScope.email}" />
      <input type="hidden" name="password" value="${sessionScope.password}" />
      <input type="hidden" name="profile_image" value="${sessionScope.profile_image}" />
      <input type="submit" value="修正する">
    </form>
  </main>

  <!-- フッター -->
  <jsp:include page="../inc/footer.jsp" />

  <script src="${pageContext.request.contextPath}/js/script.js"></script>
</body>
</html>
