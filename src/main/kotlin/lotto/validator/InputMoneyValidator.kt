package lotto.validator

class InputMoneyValidator {
    fun validate(inputMoney: String) {
        val moneyAmount = parseToInt(inputMoney)
        requireAmountDivisibleBy1000(moneyAmount)
    }

    private fun parseToInt(inputMoney: String): Int {
        return try {
            inputMoney.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(INVALID_INPUT_MONEY_FORMAT_ERROR_MESSAGE)
        }
    }

    private fun requireAmountDivisibleBy1000(moneyAmount: Int) {
        require(moneyAmount % 1000 == 0) { NOT_DIVISIBLE_BY_THOUSAND_ERROR_MESSAGE }
    }

    companion object {
        private const val INVALID_INPUT_MONEY_FORMAT_ERROR_MESSAGE = "[ERROR] 숫자가 아닌 다른 형식을 입력할 수 없습니다."
        private const val NOT_DIVISIBLE_BY_THOUSAND_ERROR_MESSAGE = "[ERROR] 1000으로 나누어 떨어지는 금액 입력해야 합니다."
    }
}