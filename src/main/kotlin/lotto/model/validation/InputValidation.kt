package lotto.model.validation

import lotto.model.LottoNumValidation

class InputValidation {
    fun validateLottoPurchaseAmount(amount: Int) {
        isLottoPurchaseAmountDivisibleByThousand(amount)
        isLottoPurchaseAmountNotZero(amount)
        isLottoPurchaseAmountNotPositive(amount)
    }

    private fun isLottoPurchaseAmountDivisibleByThousand(amount: Int) {
        require(amount % DIVISION_NUM == 0) { DIVISION_BY_THOUSAND_ERROR }
    }

    private fun isLottoPurchaseAmountNotZero(amount: Int) {
        require(amount != 0) { INPUT_ZERO_AMOUNT_ERROR }
    }

    private fun isLottoPurchaseAmountNotPositive(amount: Int) {
        require(amount > 0) { INPUT_NEGATIVE_AMOUNT_ERROR }
    }

    fun validateInputLottoNum(inputNumbers: String) {
        var trimmedInputNum = trimInput(inputNumbers)
        validateCommaSeparatedNumbers(trimmedInputNum)
    }

    private fun trimInput(input: String): String {
        return input.trim()
    }

    private fun validateCommaSeparatedNumbers(inputNumbers: String) {
        val numbersRegex = Regex("^(\\d+,)*\\d+$")

        require(numbersRegex.matches(inputNumbers)) { SEPARATE_BY_COMMA_ERROR }
    }

    companion object {
        private const val DIVISION_NUM = 1000
        const val DIVISION_BY_THOUSAND_ERROR = "[ERROR] 로또는 ${DIVISION_NUM}원 단위로 구매 가능합니다."
        const val INPUT_ZERO_AMOUNT_ERROR = "[ERROR] 로또 구매 금액으로 0을 입력할 수 없습니다."
        const val INPUT_NEGATIVE_AMOUNT_ERROR = "[ERROR] 로또 구매 금액으로 음수를 입력할 수 없습니다."

        const val SEPARATE_BY_COMMA_ERROR = "로또 당첨 숫자는 쉼표(,)로 구분되어야 합니다."
    }
}