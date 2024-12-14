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


$('#loginForm').on('submit', function(e) {
  e.preventDefault(); // 防止表單預設提交行為
  $.ajax({
    url: '/login_request',
    method: 'POST',
    data: $(this).serialize(), // 序列化表單數據
    success: function(data) {
          alert(data.message)
          window.parent.postMessage('closeIframe', '*');
    },
    error: function(err) {
        console.error(err);
    }
  });
});





// async function handleLogin(event) {

//   const formData = new FormData(event.target);
//   const data = Object.fromEntries(formData.entries());

//   const response = await fetch('/login_request', {
//       method: 'POST',
//       headers: { 'Content-Type': 'application/json' },
//       body: JSON.stringify(data),
//   });

//   const result = await response.json();

//   // 發送訊息給父頁面
//   window.parent.postMessage({ action: 'loginResponse', message: result.message, reload: result.status === 'success' }, '*');
// }