package lotto.validator

import lotto.domain.Lotto.Companion.SINGLE_LOTTO_PRICE

class Validator (number : Int){

    init {
        validateNumber(number)
        validateThousandMoney(number)
        validateZeroOrNegative(number)
        validateTooManyLotto(number)
    }

    private fun validateNumber(money: Int) {
        require(money.toString().toIntOrNull() != null) { NOT_NUMBER_ERROR }
    }

    private fun validateThousandMoney(money: Int) {
        require(money % SINGLE_LOTTO_PRICE == 0) { THOUSAND_UNIT_ERROR }
    }

    private fun validateZeroOrNegative(money: Int) {
        require(money > 0) { ZERO_NEGATIVE_ERROR }
    }

    private fun validateTooManyLotto (money: Int) {
        require(money < MAX_MONEY) {TOO_MANY_LOTTO_ERROR}
    }

    companion object {
        private const val NOT_NUMBER_ERROR = "숫자만 입력할 수 있습니다."
        private const val THOUSAND_UNIT_ERROR = "1000원 단위의 금액만 입력할 수 있습니다."
        private const val ZERO_NEGATIVE_ERROR = "1000원 단위의 양수의 금액만 입력할 수 있습니다."
        private const val MAX_MONEY = 50000
        private const val TOO_MANY_LOTTO_ERROR = "로또는 한번에 최대 50개까지 구매 가능합니다."
    }
}