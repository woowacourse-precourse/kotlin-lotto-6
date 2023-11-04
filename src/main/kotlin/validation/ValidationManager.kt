package validation

import extensions.withCommaToList

class ValidationManager {
    fun validateAmount(lottoPurchaseAmount: Int): Int =
        lottoPurchaseAmount.lessThanZero().modulusLottoPrice()

    fun validateJackpotNumbers(numbers: String): List<Int> {
        val jackpotNumbers: ArrayList<Int> = arrayListOf()
        numbers.withCommaToList().forEach { number ->
            jackpotNumbers.add(number.isValidLottoNumber())
        }
        return jackpotNumbers.isCorrectLottoCount()
    }

    internal fun Int.lessThanZero(): Int = require(this >= 0).let { return this }
    internal fun Int.modulusLottoPrice(): Int = require(this % LOTTO_PRICE == 0).let { return this }
    internal fun String.toValidNumber(): Int = require(toIntOrNull() != null).let { return this.toInt() }
    internal fun List<Int>.isCorrectLottoCount(): List<Int> = require(size == LOTTO_COUNT).let { return this }
    fun Int.isValidLottoNumber(): Int = require(this in VALID_LOTTO_NUMBER).let { return this }


    companion object {
        private const val LOTTO_PRICE = 1000
        private const val LOTTO_COUNT = 6
        private val VALID_LOTTO_NUMBER = 1..45
    }
}