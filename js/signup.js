document.addEventListener("DOMContentLoaded", () => {
    const steps = document.querySelectorAll(".form-step");
    const nextButtons = document.querySelectorAll(".next-btn");
    const prevButtons = document.querySelectorAll(".prev-btn");
    let currentStep = 0;

    // 下一步按鈕邏輯
    nextButtons.forEach((btn) => {
        btn.addEventListener("click", () => {
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
            }
        });
    });

    // 上一步按鈕邏輯
    prevButtons.forEach((btn) => {
        btn.addEventListener("click", () => {
            steps[currentStep].classList.remove("active");
            currentStep--;
            steps[currentStep].classList.add("active");

            // 更新滑動效果
            const translateX = -(currentStep * 100);
            document.querySelector(".signup-form").style.transform = `translateX(${translateX}%)`;
        });
    });
});
