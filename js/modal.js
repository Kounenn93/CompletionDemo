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
});

// 開啟註冊模態框
signupBtn.addEventListener('click', () => {
    signupModal.style.display = 'flex'; // 顯示模態框

    signupIframe.src = "./signup.html";  
});


// 關閉模態框
closeBtns.forEach((btn) => {
    btn.addEventListener('click', () => {
        loginModal.style.display = 'none';  // 隱藏登入模態框
        signupModal.style.display = 'none'; // 隱藏註冊模態框
    });
});

// 點擊模態框外部關閉
window.addEventListener('click', (event) => {
    if (event.target === loginModal || event.target === signupModal) {
        loginModal.style.display = 'none';
        signupModal.style.display = 'none';
    }
});

// window.addEventListener('keydown', (event) => {
//     while (event.key === "Esc") {
//         if (event.target === loginModal || event.target === signupModal) {
//             loginModal.style.display = 'none';
//             signupModal.style.display = 'none';
//         }
//     }
    
// });