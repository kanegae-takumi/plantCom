<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>非会員TOPページ</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/html5reset-1.6.1.css" media="all" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" />
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/top.css" />
    <link
      href="https://fonts.googleapis.com/css2?family=Mochiy+Pop+One&display=swap"
      rel="stylesheet"
    />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.css"
    />
    <script src="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.js"></script>
  </head>
    <!-- ヘッダーを挿入 -->
    <!-- サブヘッダーを挿入 -->
	<jsp:include page="../inc/header.jsp" />
	
    <!-- メイン -->
    <main>
      <br />
      <!-- 左側メイン -->
      <div class="left-main">
        <!-- スライドバナー -->
        <div class="slide-banner">
          <h1>今月の花</h1>
          <div class="swiper-container">
            <!-- 追加 -->
            <div class="swiper sample-slider">
              <div class="swiper-wrapper">
                <div class="swiper-slide"><img src="${pageContext.request.contextPath}/images/nemo.jpg" /></div>
                <div class="swiper-slide"><img src="${pageContext.request.contextPath}/images/sakura.jpg" /></div>
                <div class="swiper-slide"><img src="${pageContext.request.contextPath}/images/chu.jpg" /></div>
              </div>
            </div>
            <div class="swiper-pagination"></div>
            <!-- 追加 -->
            <div class="swiper-button-prev"></div>
            <!-- 追加 -->
            <div class="swiper-button-next"></div>
            <!-- 追加 -->
          </div>
        </div>
        <!-- 販売・質問 -->
        <div class="two-button">
          <div class="two-button-container">
            <div class="sale"><a href="★">販売</a></div>
            <div class="question"><a href="★">質問</a></div>
          </div>
          <div class="form">
            <br />
            <br />
            <a href="★">ミカンの育て方について相談があります。</a>
            <p>2025.4.4</p>
            <hr />
            <a href="★">桃の育て方について相談があります。</a>
            <p>2025.4.4</p>
            <hr />
            <a href="★">檸檬の育て方について相談があります。</a>
            <p>2025.4.4</p>
            <hr />
            <a href="★">ほうれん草の育て方について相談があります。</a>
            <p>2025.4.4</p>
            <hr />
          </div>
        </div>
      </div>
      <!-- 右側：広告 -->
      <div class="right-main">
        <div class="advertisement">
          <h1>広告欄</h1>
        </div>
      </div>
      <br />
    </main>
    <!-- フッターを挿入 -->
    <jsp:include page="../inc/footer.jsp" />
    <!-- スクリプト -->
    <script src="${pageContext.request.contextPath}/js/script.js"></script>
  </body>
</html>
