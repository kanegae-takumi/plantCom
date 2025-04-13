<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- ヘッダー -->
<header>
	<div class="header-left">
		<c:choose>
			<c:when test="${not empty sessionScope.loginUser}">
				<!-- ログイン時のロゴ -->
				<a class="logo-text"
					href="${pageContext.request.contextPath}/Index">Plant.com
					Members</a>
			</c:when>
			<c:otherwise>
				<!-- 未ログイン時のロゴ -->
				<a class="logo-text" href="${pageContext.request.contextPath}/Index">Plant.com</a>
			</c:otherwise>
		</c:choose>
	</div>

	<div class="header-right">
		<c:choose>
			<c:when test="${not empty sessionScope.loginUser}">
				<!-- ログイン済みの表示 -->
				<p class="greeting">${sessionScope.loginUser.account_name}さん、こんにちは!</p>
				<a href="${pageContext.request.contextPath}/mainJsp/profile.jsp"
					class="button1">会員情報</a>
				<a href="${pageContext.request.contextPath}/logout" class="button1">ログアウト</a>
			</c:when>
			<c:otherwise>
				<!-- 未ログインの表示 -->
				<a href="${pageContext.request.contextPath}/mainJsp/register.jsp"
					class="button1">新規会員登録</a>
				<a href="${pageContext.request.contextPath}/mainJsp/login.jsp"
					class="button1">ログイン</a>
			</c:otherwise>
		</c:choose>
	</div>
</header>
<!-- サブヘッダー -->
<div class="sub-header">
	<div class="sub-header-container">
		<div class="btn-large">
			<form action="★" method="post">
				<input class="search-text" type="text" placeholder="Q&Aを探す" /><input
					class="search-button" type="submit" value="検索" />
			</form>
		</div>
		<div class="btn-small">
			<a href="">Q&A一覧</a>
		</div>
		<div class="btn-small">
			<a href="">お知らせ</a>
		</div>
		<div class="btn-medium">
			<a href="${pageContext.request.contextPath}/mainJsp/question.jsp">質問する</a>
		</div>
	</div>
</div>