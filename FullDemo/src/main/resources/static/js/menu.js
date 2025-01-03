//STEP1:先解析自己所在頁面是在哪個shopID（也就是在首頁點了哪個SHOP進來）
const shopId = new URLSearchParams(window.location.search).get("shopId");
let itemsData = {}; //定義一個itemsData容器，存放後端傳來的data，供全域使用。
$(document).ready(function () {
    //發送 AJAX 請求店家資訊
    $.ajax({
        url:'./menu/shopinfo',
        type:"GET",
        data:{shopId:shopId},
        success:function(response){
            console.log(response)
            const shop = response[0];
            $("#shopinfo").html(
                `<div class="pic">
                <img src="${shop.shopLogoUrl}" alt="">
            </div>
            <div class="text">
                <h3>${shop.shopMainName}　${shop.shopBranchName}</h3>
                <p class="comment">
                    <i class="bi-star-fill"></i>
                    <i class="bi-star-fill"></i>
                    <i class="bi-star-fill"></i>
                    <i class="bi-star-half"></i>
                    <i class="bi-star"></i>
                    3.9
                    (
                    <span class="counts">5</span>
                    )
                </p>
                <p class="info">
                    <i class="bi-geo-alt-fill"></i>
                    <span class="distance">2.3</span>km
                    ｜
                    <span class="address">${shop.shopCity}${shop.shopDist}${shop.shopAddress}</span>
                    ｜
                    <i class="bi-telephone-fill"></i>
                    <span class="phone">${shop.shopPhone}</span>
                </p>
            </div>`
            )
        },
        error:function(){
            console.log("請求失敗")
        }
    });




    // 發送 AJAX 請求獲取商品資料
    $.ajax({
        url: `/menu/${shopId}`,
        type: "GET",
        success: function (data) {
            if (data.length > 0) {
                console.log(data);
                itemsData = data;
                showMenuItems(data); //如果請求資料成功，且商品項目>0，則渲染頁面。
            } else {
                $(".right").html("<p>暫無商品</p>");
            }
        },
        error: function () {
            $(".right").html("<p>無法加載數據，請稍後再試。</p>");
        }
    });
});

//定義渲染頁面function
function showMenuItems(data) {
    // 以category分類
    const result = {};
    for (const kind of data) {
        const key = kind.itemCategory;
        if (!result[key]) {
            result[key] = [];
        }
        result[key].push(kind); //獲得1個result物件是分好組的menu
    }

    let menuLeft = `<ul>`;
    for (let k in result) {
        menuLeft += `<li>
        <h4>${k}</h4>
        <i class="bi-caret-right-fill"></i>
    </li>`
    }
    menuLeft += `</ul>`;
    const leftDiv = document.getElementById('left')
    leftDiv.innerHTML = menuLeft;

    let menuRight = '';
    for (let k in result) {
        menuRight += `<h4>${k}</h4><ul>`;

        for (let i = 0; i < result[k].length; i++) {
            menuRight += `
        
          <li class="itemBlock" data-id="${result[k][i].itemId}">
              <div class="pic">
                  <img src=${result[k][i].itemPicUrl} alt="">
              </div>
              <p class="item">${result[k][i].itemName}</p>
              <p class="price">$ <span>${result[k][i].itemPrice}</span></p>
          </li>      
        `
        }
        menuRight += '</ul>'
    }
    const rightDiv = document.getElementById('right');
    rightDiv.innerHTML = menuRight;


    //電梯導航效果  
    // 左側導航與右側內容的對應邏輯
    const leftItems = document.querySelectorAll('.menu .left ul li');
    const rightSections = document.querySelectorAll('.menu .right h4');

    // 監聽滾動事件
    document.getElementById('right').addEventListener('scroll', () => {
        let currentIndex = -1;

        // 找出目前可見的右側內容
        rightSections.forEach((section, index) => {
            const offsetTop = section.getBoundingClientRect().top - document.getElementById('right').getBoundingClientRect().top;
            if (offsetTop <= 50) {
                currentIndex = index;
            }
        });

        // 更新左側導航的選中狀態
        leftItems.forEach((item, index) => {
            if (index === currentIndex) {
                item.classList.add('active');
            } else {
                item.classList.remove('active');
            }
        });
    });

    // 點擊左側導航滾動到對應的右側內容
    leftItems.forEach((item, index) => {
        item.addEventListener('click', () => {
            rightSections[index].scrollIntoView({ behavior: 'smooth' });
        });
    });
}
