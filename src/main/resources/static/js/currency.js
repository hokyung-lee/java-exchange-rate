let selectedBox = document.getElementById("currencyData");
let calcButton = document.getElementById("calc");
let resultTextArea = document.getElementById("resultArea");

selectedBox.addEventListener('change', (event) => {
    setDisplayText();
});

calcButton.addEventListener('click', (event) => {
    let inputAmount = document.getElementById("inputAmount").value;

    if (!validationCheck(inputAmount)) {
        return;
    }

    let selectedOption = selectedBox.options[selectedBox.selectedIndex];
    let total = inputAmount * selectedOption.value;
    resultTextArea.innerHTML = "수취금액은 " + total + " " + selectedOption.getAttribute("currency") + " 입니다.";
});

// init
setDisplayText();