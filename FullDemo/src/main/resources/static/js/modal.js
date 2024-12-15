setTimeout(() => {  // 為了等查詢是否為登入狀態的異步請求完成，才跑以下程式碼，所以設置延遲200毫秒。

    const loginBtn = document.getElementById('login-btn');
    const signupBtn = document.getElementById('signup-btn');
    const loginModal = document.getElementById('login-modal');
    const signupModal = document.getElementById('signup-modal');
    const closeBtns = document.querySelectorAll('.close-btn');
    const loginIframe = document.getElementById('login-iframe');
    const signupIframe = document.getElementById('signup-iframe');



    // 開啟登入模態框
    loginBtn.addEventListener('click', () => {
        loginModal.style.display = 'flex';  // 顯示模態框
        loginIframe.src = "./login.html";
    });

    // 開啟註冊模態框
    signupBtn.addEventListener('click', () => {
        signupModal.style.display = 'flex'; // 顯示模態框

        signupIframe.src = "./signup.html";
    });


    function closeModal() {
        loginModal.style.display = 'none';  // 隱藏登入模態框
        signupModal.style.display = 'none'; // 隱藏註冊模態框
        window.location.reload();
    }

    // 關閉模態框
    closeBtns.forEach((btn) => {
        btn.addEventListener('click', () => {
            closeModal();
        });
    });

    // 點擊模態框外部關閉
    window.addEventListener('click', (event) => {
        if (event.target === loginModal || event.target === signupModal) {
            closeModal();
        }
    });

    // 監聽來自 iframe 的訊息
    window.addEventListener('message', (event) => {
        if (event.data === 'closeIframe') {
            closeModal();
        }
    });
},200);

// // 監聽來自子頁面的訊息
// window.addEventListener('message', (event) => {
//     if (event.data.action === 'loginResponse') {
//         // 顯示提示訊息
//         alert(event.data.message);

//         // 關閉模態框
//         closeModal();

//         // 是否需要重新載入頁面
//         if (event.data.reload) {
//             window.location.reload();
//         }
//     }
// });


