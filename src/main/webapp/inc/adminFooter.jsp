<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- フッター -->
    <footer>
      <p><span id="logo">@Plant.com</span> corporation</p>
    </footer>
    
    <script>
  let clickCount = 0;
  let timer = null;

  document.getElementById('logo').addEventListener('click', () => {
    clickCount++;

    // 5秒以内に3回クリックされたら admin.jsp に移動
    if (clickCount === 3) {
      window.location.href = '<%= request.getContextPath() %>/Index';
    }

    // タイマーをリセット（5秒以内に連続クリックが条件）
    clearTimeout(timer);
    timer = setTimeout(() => {
      clickCount = 0;
    }, 5000);
  });
</script>