//渲染購物車、送出訂單邏輯
$(document).ready(function () {
  //先取得存放在localStorage的購物車內容
  let cart = JSON.parse(localStorage.getItem("cart")) || []; //JSON.parse將JSON格式的字串轉成JSON格式的陣列 
  console.log(cart);
  renderCart(cart);
  costCal(cart);
  removeItem(cart);
  shopcartSubmit(cart);
});

//定義渲染購物車function
function renderCart(cart) {
  $("#cartContainer").empty();
  if (cart.length != 0) {
    cart.forEach((item, index) => {
      $("#cartContainer").append(`
          <li>
              <div class="pic">
                  <img src="${item.itemPicUrl}" alt="">
              </div>
              <div class="text">
                  <p class="item">品名：<span>${item.itemName}</span></p>
                  <p class="details"><span>${item.sugarLevel} / ${item.iceLevel} / ${item.itemCount}份 / $ ${item.subtal}</span></p>
                  <p class="trash" data-index="${index}"><i class="bi-trash3"></i></p>
              </div>
          </li>
      `);
    });
  }
  else {
    $("#cartContainer").append(`<br><br><h4 style="margin-top: 10px; color: gray;">購物車內沒有商品，快去噹菜吧！</h4>`)
  }
}

//定義刪除購物車內容function
function removeItem(cart) {
  $("#cartContainer").on("click", ".trash", function () {
    const index = $(this).data("index");
    cart.splice(index, 1);
    localStorage.setItem("cart", JSON.stringify(cart));
    renderCart(cart);
    costCal(cart)
    console.log(cart);
  });
}

//定義金額計算與渲染（暫不考慮折扣及運費計算）
//此處的金額計算僅用於網頁即時顯示，應再送至後端查驗
//查驗方式:後端取得商品ID及數量後，向資料庫調出金額，進行驗算，如果加總金額不對，返回錯誤訊息給前端，讓其訂單無法成立。
function costCal(cart) {
  let sum = 0;
  if (cart.length !== 0) {
    cart.forEach((item) => {
      sum += item.subtal;
    })
  }
  $('.checkout p:first span').html(sum);
  $('.total p:first span').html(sum);
}

//送出購物車
function shopcartSubmit(cart) {
  $('#shopcartSubmit').click(function () {
    const orderInfo = {
      orderName: $('#orderName').val(),
      orderPhone: $('#orderPhone').val(),
      orderAddress: $('#orderAddress').val(),
      discountCode: $('#discountCode').val()
    }

    const costInfo = {
      subTotal: parseInt($('#subTotal').text(),10),
      discount: parseInt($('#discount').text(),10),
      deliveryFee: parseInt($('#deliveryFee').text(),10),
      totalAmount: parseInt($('#totalAmount').text(),10)
    }
    // console.log(cart);
    // console.log(orderInfo);
    console.log(costInfo);
    // console.log(JSON.stringify({ cart, orderInfo, costInfo }));
    $.ajax({
      url: '/shopcart/ordersubmit', // 後端的 URL
      method: 'POST',
      contentType: 'application/json',
      data: JSON.stringify({ cart, orderInfo, costInfo }), // 將資料序列化成 JSON 格式
      success: function (response) {
        console.log("Order successfully sent:", response);
        alert(response);
        if(response==="成功建立訂單！"){
          window.location.href = "/";
          localStorage.clear();
        }
      },
      error: function (err) {
        console.error("Error sending order:", err);
        alert("訂單送出失敗，請重試！");
      }
    });

  })
}

