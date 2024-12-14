const beforeLogin = `<button id="login-btn" type="button" class="login">登入</button>
                    <button id="signup-btn" type="button" class="signup">註冊</button>`;
const afterLogin = `<a href="./shopcart.html"> <i class="bi-cart3"></i></a>
                    <a href=""><i class="bi-bell"></i></a>
                    <a href=""><i class="bi-list"></i></a>`;


$(document).ready(function() {
    const $userFunction = $('.user_function'); // jQuery選取user_function類
    console.log("User function element:", $userFunction);

  $.ajax({
      url: '/checkSession',
      method: 'GET',
      success: function(response) {
          if (response.loggedIn) {
            $userFunction.html(afterLogin); //JQuery的插入標籤語法（與JS的innerHTML不同!!!）
              console.log("User is logged in:", response.user);
              
              

          } else {
              console.log("User is not logged in.");
              $userFunction.html(beforeLogin);
          }
      },
      error: function(err) {
          console.error("Error checking session:", err);
      }
  });
});




// <!-- 登入註冊區 -->
//                 <div class="log_sign ">
                    // <button id="login-btn" type="button" class="login">登入</button>
                    // <button id="signup-btn" type="button" class="signup">註冊</button>
//                 </div>

// <!-- 使用者功能區 -->
//                 <div class="user_function">
                    // <a href="./shopcart.html"> <i class="bi-cart3"></i></a>
                    // <a href=""><i class="bi-bell"></i></a>
                    // <a href=""><i class="bi-list"></i></a>
//                 </div>