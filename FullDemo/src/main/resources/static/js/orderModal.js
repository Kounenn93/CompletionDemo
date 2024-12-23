

setTimeout(() => {  // 為了等查詢是否為登入狀態的異步請求完成，才跑以下程式碼，所以設置延遲200毫秒。
// localStorage.clear(); //刪除localStorage內容物，測試用
  const itemBlock = document.querySelectorAll('.itemBlock');
  const orderModal = document.getElementById('orderModal');
  const closeButton = document.getElementById('closeButton');
  const orderModalContainer = document.querySelector('.orderModalContainer');

  if (itemBlock.length > 0) {
    itemBlock.forEach(block => {
      // 添加事件監聽
      block.addEventListener('click', () => {
        innerOrderModal(block);//渲染orderModal頁面         
        orderModal.style.display = 'flex';  // 顯示模態框

        // 初始化購物車:查看localStorage內有沒有購物車，沒有就給一個空Array。
        //每次操作加入購物車前都應該初始化一次，確保購物車是最新的狀態。
        let cart = JSON.parse(localStorage.getItem("cart")) || []; //JSON.parse將JSON格式的字串轉成JSON格式的陣列
        //加入購物車的function
        addCart(cart);

      });
    });
  } else {
    console.log('沒有找到 .itemBlock 元素');
  }

  //定義加入購物車的function
  function addCart(cart) {
    document.getElementById('canOrder').addEventListener('click', () => {
      // 取得圖片 URL
      const itemPicUrl = document.querySelector('.itemPic img').getAttribute('src');

      // 取得產品ID、產品名稱、單價等資料
      const itemId = document.querySelector('.itemNameAndPrice span').innerText;
      const itemName = document.querySelector('.itemNameAndPrice h2').innerText; //.innerText用在取得該元素中「已渲染」的文字內容
      const itemPrice = parseInt(document.querySelector('.itemNameAndPrice h3 span').innerText);

      // 取得糖度與冰量
      const sugarLevel = document.querySelector('input[name="sugarLevel"]:checked').value;
      const iceLevel = document.querySelector('input[name="iceLevel"]:checked').value;

      // 取得數量
      const itemCount = parseInt(document.querySelector('.countNumber').value);

      // 計算小計價格
      const subtal = itemCount * itemPrice;

      // 組成一個訂單物件
      const orderItem = {        
        shopId: shopId,
        itemPicUrl: itemPicUrl,
        itemId : itemId,
        itemName: itemName,
        sugarLevel: sugarLevel,
        iceLevel: iceLevel,
        itemCount: itemCount,
        subtal: subtal
      };

      // 將訂單物件加入 cart 陣列
      cart.push(orderItem);

      //將cart陣列寫入localStorage，localStorage只能存字串，所以要先將cart陣列用JSON.stringify方法轉成字串
      localStorage.setItem("cart", JSON.stringify(cart));

      // 測試：輸出訂單列表到控制台
      console.log("訂單已更新:", cart);

      // 關閉模態框
      closeOrderModal();
    });
  }

  //渲染orderModal function
  function innerOrderModal(block) {
    const clickId = parseInt(block.closest("li").getAttribute("data-id"));
    const targetItem = itemsData.find(item => item.itemId === clickId);
    const itemPicUrl = targetItem.itemPicUrl;
    const itemName = targetItem.itemName;
    const itemPrice = targetItem.itemPrice;
    //插入圖片
    const itemPic = document.getElementsByClassName('itemPic')[0];
    itemPic.innerHTML = `<img src="${itemPicUrl}" alt="">`
    //插入品名與單價
    const itemNameAndPrice = document.getElementsByClassName('itemNameAndPrice')[0];
    itemNameAndPrice.innerHTML = 
    `
    <span style="display:none;">${clickId}</span>
    <h2>${itemName}</h2>
    <h3>單價：$ <span>${itemPrice}</span></h3>
    `
    //插入送出按鈕，須先監聽是否為登入狀態
    const submitButton = document.getElementById("submitButton");
    if (loggedIn == true) {
      submitButton.innerHTML = `<button type="button" id='canOrder'>加入購物車</button>`
    }
    else {
      submitButton.innerHTML = `<button type="button" id='cannotOrder' disabled style="background-color:silver; cursor: default;">請先登入</button>`
    }

  }

  //orderModal加減功能區
  let num = 1; // 全域變數，初始數量設為 1

  $('.count').each(function () {
    const $container = $(this); // 當前的 count 容器
    const $minusButton = $container.find('.button-count:first-child'); // 減號按鈕
    const $plusButton = $container.find('.button-count:last-child'); // 加號按鈕
    const $input = $container.find('.countNumber'); // 輸入框

    // 初始化輸入框數值
    $input.val(num);

    // 減號按鈕事件
    $minusButton.click(function () {
      if (num > 1) {
        num--;
        updateUI();
      }
    });

    // 加號按鈕事件
    $plusButton.click(function () {
      if (num < 10) {
        num++;
        updateUI();
      }
    });

    // 更新 UI 和按鈕狀態
    function updateUI() {
      $input.val(num);
      $minusButton.prop('disabled', num <= 1);
      $plusButton.prop('disabled', num >= 10);
      console.log(`目前數量: ${num}`); // 可用於金額計算
    }
  });

  // 重置數量的函數（供其他邏輯使用）
  function resetCount() {
    num = 1; // 重設數量
    $('.countNumber').val(num);
    $('.button-count:first-child').prop('disabled', true);
    $('.button-count:last-child').prop('disabled', false);
    // console.log('數量已重置');
  }

  //關閉orderModal邏輯
  function closeOrderModal() {
    orderModalContainer.scrollTo(0, 0);
    resetCount();
    orderModal.style.display = 'none';
  }

  //點擊右上角x關閉orderModal
  closeButton.addEventListener('click', () => {
    closeOrderModal();
  });

  //點擊orderModal外部關閉orderModal
  window.addEventListener('click', (event) => {
    if (event.target === orderModal) {
      closeOrderModal();
    }
  });

  //監聽如按下Esc，則關閉orderModal
  document.addEventListener('keydown', (event) => {
    if (event.key === 'Escape') {
      closeOrderModal();
    }
  });

}, 200);