package lotto.model.validator

class PaymentValidator : Validator<PaymentValidation> {

    override fun validate(data: PaymentValidation) {
        data.apply {
            validateNumber(costInput)
            validateOverflow(costInput)
            val cost = costInput.toInt()
            validateLottoPrice(cost, lottPrice)
        }
    }

    private fun validateNumber(input: String) {
        require(input.toBigIntegerOrNull() != null) { NOT_NUMBER_ERROR }
    }

    private fun validateLottoPrice(cost: Int, lottoPrice: Int) {
        require(cost % lottoPrice == 0) { INVALID_MONEY_ERROR }
    }

    private fun validateOverflow(input: String) {
        val cost = input.toBigInteger()
        require(cost <= MAX_LOTTO_PURCHASE.toBigInteger()) { OVERFLOW_ERROR }
    }

    companion object {
        private const val MAX_LOTTO_PURCHASE = 100000
        private const val INVALID_MONEY_ERROR = "1000원 단위의 금액만 입력할 수 있습니다."
        private const val NOT_NUMBER_ERROR = "문자는 입력할 수 없습니다."
        internal const val OVERFLOW_ERROR = "로또는 최대 100,000원까지만 구매할 수 있습니다."
    }

}

data class PaymentValidation(val costInput: String, val lottPrice: Int)