const swiper = new Swiper('.sample-slider', {
  loop: true, //ループ
  autoplay: {
    //自動再生
    delay: 3000,
  },
  pagination: {
    //ページネーション（ドット）
    el: '.swiper-pagination',
  },
  navigation: {
    //ナビゲーション（矢印）
    nextEl: '.swiper-button-next',
    prevEl: '.swiper-button-prev',
  },
});

// 入力チェック
function validateForm() {
  const content = document.getElementById('content').value;
  if (content.length < 5) {
    alert('本文は5文字以上入力してください！');
    return false; // フォーム送信を止める
  }
  return true; // OKなら送信
}
