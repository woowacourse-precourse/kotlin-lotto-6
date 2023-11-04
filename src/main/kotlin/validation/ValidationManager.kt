package validation

import extensions.withCommaToList

class ValidationManager {
    fun validateAmount(lottoPurchaseAmount: Int): Int =
        lottoPurchaseAmount.lessThanZero().modulusLottoPrice()


    internal fun Int.lessThanZero(): Int = require(this >= 0).let { return this }
    internal fun Int.modulusLottoPrice(): Int = require(this % LOTTO_PRICE == 0).let { return this }


    companion object {
        private const val LOTTO_PRICE = 1000
    }
}