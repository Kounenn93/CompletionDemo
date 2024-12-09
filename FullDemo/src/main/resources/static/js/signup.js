document.addEventListener("DOMContentLoaded", () => {
    const steps = document.querySelectorAll(".form-step");
    const buttons = document.querySelectorAll(".next-btn");
    const submit_button = document.querySelector("#submit_button")
    let currentStep = 0;
    document.getElementsByTagName("input")[currentStep].focus();



    // 下一步按鈕邏輯
    function nextStep() {
        const inputs = steps[currentStep].querySelectorAll("input");
        let isValid = true;

        // 檢查所有輸入欄位
        inputs.forEach((input) => {
            const errorMessage = input.parentElement.querySelector(".error-message");
            if (input.value.trim() === "") {
                isValid = false;
                if (errorMessage) {
                    errorMessage.textContent = `請填入${input.previousElementSibling.textContent}`;
                    errorMessage.style.display = "block";
                }
            } else {
                if (errorMessage) {
                    errorMessage.textContent = "";
                    errorMessage.style.display = "none";
                }
            }
        });

        if (isValid) {
            steps[currentStep].classList.remove("active");
            currentStep++;
            steps[currentStep].classList.add("active");           


            // 更新滑動效果
            const translateX = -(currentStep * 100);
            document.querySelector(".signup-form").style.transform = `translateX(${translateX}%)`;
            
            setTimeout(() => {
                const nextInputs = steps[currentStep].querySelectorAll("input");
                if (nextInputs.length > 0) {
                    nextInputs[0].focus(); // 聚焦到下一步的第一個輸入框
                }
            }, 400);

        }

    }
    // 監聽下一步的按鈕點擊
    buttons.forEach((btn) => {
        btn.addEventListener("click", nextStep);
    });

    //定義送出function
    function submit() { document.querySelector(".signup-form").submit() };

    //監聽註冊的按鈕點擊
    submit_button.addEventListener("click", submit);

    // 監聽鍵盤 Enter 鍵
    document.addEventListener("keydown", (event) => {
        // 如果按下的是 Enter 鍵
        if (event.key === "Enter") {
            const activeInputs = steps[currentStep].querySelectorAll("input");

            // 檢查是否正在編輯的輸入欄位中
            if (document.activeElement.tagName === "INPUT" && Array.from(activeInputs).includes(document.activeElement)) {
                event.preventDefault(); // 阻止預設的 Enter 行為（例如提交表單）
                
                
                if (currentStep != 5) {
                    nextStep(); // 執行下一步                    
                }
                else {
                    submit()
                }
            }
        }
    });

    // 上一步按鈕邏輯
    // prevButtons.forEach((btn) => {
    //     btn.addEventListener("click", () => {
    //         steps[currentStep].classList.remove("active");
    //         currentStep--;
    //         steps[currentStep].classList.add("active");

    //         // 更新滑動效果
    //         const translateX = -(currentStep * 100);
    //         document.querySelector(".signup-form").style.transform = `translateX(${translateX}%)`;
    //     });
    // });

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



});
// 偵測按鍵事件
document.addEventListener('keydown', (event) => {
    if (event.key === 'Escape') {
        // 傳送關閉訊息給父頁面
        window.parent.postMessage('closeIframe', '*');
    }
});