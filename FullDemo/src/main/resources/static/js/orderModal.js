setTimeout(() => {  // 為了等查詢是否為登入狀態的異步請求完成，才跑以下程式碼，所以設置延遲200毫秒。

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
      });
    });
  } else {
    console.log('沒有找到 .itemBlock 元素');
  }

  //渲染orderModal function
  function innerOrderModal(block) {
    const clickId = parseInt(block.closest("li").getAttribute("data-id"));
    const targetItem = itemsData.find(item => item.itemId === clickId);
    const itemPicUrl = targetItem.itemPicUrl;
    const itemName = targetItem.itemName;
    const itemPrice = targetItem.itemPrice;
    const itemPic = document.getElementsByClassName('itemPic')[0];
    itemPic.innerHTML = `<img src="${itemPicUrl}" alt="">`
    const itemNameAndPrice = document.getElementsByClassName('itemNameAndPrice')[0];
    itemNameAndPrice.innerHTML = `<h2>${itemName}</h2>
                    <h3>單價：$ <span>${itemPrice}</span></h3>`
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
    console.log('數量已重置');
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



  //   // 監聽來自 iframe 的訊息
  //   window.addEventListener('message', (event) => {
  //       if (event.data === 'closeIframe') {
  //           closeModal();
  //       }
  //   });
}, 200);