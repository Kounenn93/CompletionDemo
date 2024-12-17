$(document).ready(function () {

  // 發送 AJAX 請求
  $.ajax({
      url: '/shops',
      method: "GET",
      success: function (data) {
        // console.log(data); //測試有沒有抓到數據用
          // 分類數據
          const drinkShops = data.filter(shop => shop.shopType === "飲料");
          const foodShops = data.filter(shop => shop.shopType === "食物");

          // 渲染數據到飲料推薦區
          const $drinkList = $("#drink-list");
          drinkShops.forEach(shop => {
              const $li = createShopListItem(shop);
              $drinkList.append($li);
          });

          // 渲染數據到食物推薦區
          const $foodList = $("#food-list");
          foodShops.forEach(shop => {
              const $li = createShopListItem(shop);
              $foodList.append($li);
          });
      },
      error: function (error) {
          console.error("Error fetching shop data:", error);
      }
  });

  //定義渲染店家列表function
  function createShopListItem(shop) {
      const $li = $(`
          <li>
              <a href="./menu.html?shopId=${shop.shopId}">
                  <div class="pic">
                      <img src="${shop.shopCoverUrl}" alt="${shop.shopMainName}">
                  </div>
                  <div class="txt">
                      <div class="shopinfo">
                          <h4>${shop.shopMainName} 
                              <span>${shop.shopBranchName}</span>
                          </h4>
                          <strong>免運</strong>
                      </div>
                      <p>營業時間：<span>10:00-22:00</span> | 
                          <i class="iconfont material-icons-outlined">near_me</i>
                          <u>3km</u>
                      </p>
                  </div>
              </a>
              <div class="cover">
                  <a href="./menu.html?shopId=${shop.shopId}">
                      <p>外送門檻</p>
                      <p>2公里以內200元</p>
                      <p>3公里以內300元</p>
                      <p>4公里以內400元</p>
                  </a>
              </div>
          </li>
      `);
      return $li;
  }
});