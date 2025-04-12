<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- ヘッダー -->
<header>
	<div class="header-left">
		<a class="logo-text" href="${pageContext.request.contextPath}/Index">Plant.com</a>
	</div>
	<div class="header-right">
		<a href="${pageContext.request.contextPath}/mainJsp/register.jsp" class="button1">新規会員登録</a>
		<p class="button1">ログイン</p>
	</div>
</header>
<!-- サブヘッダー -->
<div class="sub-header">
	<div class="sub-header-container">
		<div class="btn-large">
			<form action="★" method="post">
				<input class="search-text" type="text" placeholder="Q&Aを探す"/><input
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