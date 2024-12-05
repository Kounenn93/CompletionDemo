

// 監聽城市下拉選單的變更事件
document.getElementById("city").addEventListener("change", function () {
  const selectedCity = this.value; // 獲取選中的縣市
  const distSelect = document.getElementById("dist"); // 鄉鎮市區下拉選單
  distSelect.innerHTML = ""; // 清空鄉鎮市區的內容

  // 根據選中的縣市生成對應的區域選項
  if (cityDistricts[selectedCity]) {
      cityDistricts[selectedCity].forEach(district => {
          const option = document.createElement("option");
          option.value = district;
          option.textContent = district;
          distSelect.appendChild(option);
      });
  } else {
      // 若未找到對應區域，顯示 "Choose..."
      const defaultOption = document.createElement("option");
      defaultOption.value = "";
      defaultOption.textContent = "選擇鄉鎮市區";
      distSelect.appendChild(defaultOption);
  }
});