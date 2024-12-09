document.addEventListener("DOMContentLoaded", () => {

  document.getElementsByTagName("input")[0].focus();

});


//實現按Esc關閉（邏輯:先傳訊息給父頁面[即index.html]，讓父頁面去執行關閉模態框）
document.addEventListener('keydown', (event) => {
  if (event.key === 'Escape') {
      // 傳送關閉訊息給父頁面
      window.parent.postMessage('closeIframe', '*');
  }
});