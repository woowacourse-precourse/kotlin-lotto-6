package lotto.validator

class InputMoneyValidator() {
    fun validate(inputMoney: String) {
        requireNumericString(inputMoney)
        requireAmountDivisibleBy1000(inputMoney)
    }

    private fun requireNumericString(money: String) {
        require(money.all { it.isDigit() }) { "[ERROR] 숫자가 아닌 다른 형식을 입력할 수 없습니다." }
    }

    private fun requireAmountDivisibleBy1000(money: String) {
        require(money.toInt() % 1000 == 0) { "[ERROR] 1000으로 나누어 떨어지는 금액 입력해야 합니다." }
    }
}