<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- フッター -->
    <footer>
      <p><span id="logo">@Plant.com</span> corporation</p>
    </footer>
    
<script>
  let clickCount = 0;
  let timer = null;

  document.getElementById('logo').addEventListener('click', (event) => {
    // Shiftキーが押されていなければカウントしない
    if (!event.shiftKey) {
      clickCount = 0;
      clearTimeout(timer);
      return;
    }

    clickCount++;

    if (clickCount === 3) {
      window.location.href = '<%= request.getContextPath() %>/admin/adminLogin.jsp';
    }

    clearTimeout(timer);
    timer = setTimeout(() => {
      clickCount = 0;
    }, 1000); // 1秒以内に3回クリック
  });
</script>