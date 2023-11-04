package validation

class ValidationManager {
    fun validateAmount(lottoPurchaseAmount: String): Int =
        lottoPurchaseAmount.toValidNumber().lessThanZero().modulusLottoPrice()

    internal fun String.toValidNumber(): Int = require(toIntOrNull() != null).let { return this.toInt() }
    internal fun Int.lessThanZero(): Int = require(this >= 0).let { return this }
    internal fun Int.modulusLottoPrice(): Int = require(this % LOTTO_PRICE == 0).let { return this }


    companion object {
        private const val LOTTO_PRICE = 1000
    }
}