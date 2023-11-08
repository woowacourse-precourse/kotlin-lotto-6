package lotto.validator

import lotto.domain.Lotto.Companion.SINGLE_LOTTO_PRICE

class Validator {

    private fun validateNumber(money: String) {
        require(money.toIntOrNull() != null) { NOT_NUMBER_ERROR }
    }

    private fun validateThousandMoney(money: Int) {
        require(money % SINGLE_LOTTO_PRICE == 0) { THOUSAND_UNIT_ERROR }
    }

    private fun validateZeroOrNegative(money: Int) {
        require(money > 0) { ZERO_NEGATIVE_ERROR }
    }

    companion object {
        private const val NOT_NUMBER_ERROR = "숫자만 입력할 수 있습니다."
        private const val THOUSAND_UNIT_ERROR = "1000원 단위의 금액만 입력할 수 있습니다."
        internal const val ZERO_NEGATIVE_ERROR = "1000원 단위의 양수의 금액만 입력할 수 있습니다."
    }
}