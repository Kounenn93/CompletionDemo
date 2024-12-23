$(document).ready(function () {

  $.ajax({
    url: '/orderinfo/getOrderInfo',
    method: "GET",
    success: function (data) {
      console.log(data);
      stepbyStep(data);
      orderInfo(data);
    },
    error: function (error) {
      console.error("Error fetching shop data:", error);
    }
  });

});

// 定義渲染訂單進度條 function
function stepbyStep(data){
  const order_status=data[0].order_status;
  
  switch(order_status){
    case '訂單已成立':
      break;
    case '店家已接單'  :
      $('#step2').removeClass("profileStepPassive");
      $('#step2').addClass("profileStepActive");
      break;
    case '等待自取或配送中'  :
      $('#step2').removeClass("profileStepPassive");
      $('#step2').addClass("profileStepActive");
      $('#step3').removeClass("profileStepPassive");
      $('#step3').addClass("profileStepActive");
      break;
    case '訂單完成'  :
      $("#content").html(`<h3>目前沒有未完成的訂單唷！</h3>`); 
      break;
    default:
      break;     
  }
}

//定義渲染訂單詳情
function orderInfo(data){
  const order_time= data[0].order_time;
  const order_name = data[0].order_name;
  const order_phone = data[0].order_phone;
  const order_address = data[0].order_address;
  const discount_code =data[0].discount_code;
  const subtotal = data[0].subtotal;
  const discount =data[0].discount;
  const delivery_fee = data[0].delivery_fee;
  const total_amount = data[0].total_amount;
  $('.left h4 span').html(order_time);
  $('.name span').html(order_name);
  $('.phone span').html(order_phone);
  $('.address span').html(order_address);
  $('.code span').html(discount_code);
  $('#subTotal').html(subtotal);
  $('#discount').html(discount);
  $('#deliveryFee').html(delivery_fee);
  $('#totalAmount').html(total_amount)

  for(let i = 0 ; i<data.length ; i++){     
    $('#cartContainer').append(`<li>
                  <div class="pic">
                      <img src="${data[i].item_pic_url}" alt="">
                  </div>
                  <div class="text">
                      <p class="item">品名：<span>${data[i].item_name}</span></p>
                      <p class="details"><span>${data[i].sugur_level} / ${data[i].ice_level} / $${data[i].subtotal} / ${data[i].order_count}份</span></p>
                  </div>
              </li>`)
  }
  
}