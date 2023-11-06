package lotto.model

import lotto.requireAndReturn
import lotto.toValidInt
import lotto.validPositiveNumber

class PaymentAmount private constructor(money: Int) {

    val purchase: Int = money / LOTTO_PRICE

    companion object {
        private const val LOTTO_PRICE = 1000

        fun from(input: String): PaymentAmount {
            val money = input.toValidInt()
                .validPositiveNumber()
                .validLottoPrice()
            return PaymentAmount(money)
        }

        private fun Int.validLottoPrice(): Int = requireAndReturn(this % LOTTO_PRICE == 0, Error.Invalid.message)
    }

    internal enum class Error(val message: String) {
        Invalid("1000원 단위의 금액만 입력해주세요.")
    }
}