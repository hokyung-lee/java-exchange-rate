function setDisplayText() {
    let selectedOption = selectedBox.options[selectedBox.selectedIndex];

    document.getElementById("selectedCurrency").innerHTML = selectedOption.value + " " + selectedOption.getAttribute("currency") + "/" + baseCurrency;
}

function validationCheck(amount) {
    if (amount == '') {
        resultTextArea.innerHTML = "<span style=\"color:red\">송금액을 입력하셔야 합니다.</span>";
        return false;
    }
    if (isNaN(amount)) {
        resultTextArea.innerHTML = "<span style=\"color:red\">송금 금액은 숫자만 입력 가능합니다.</span>";
        return false;
    }
    if (amount <= 0 || amount > 10000) {
        resultTextArea.innerHTML = "<span style=\"color:red\">송금액은 1 이상, 10000이하의 숫자를 입력하셔야 합니다.</span>";
        return false;
    }
    return true;
}