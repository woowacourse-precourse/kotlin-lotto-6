package validation

import extensions.withCommaToList

class ValidationManager {
    fun validAmount(lottoPurchaseAmount: Int): Int =
        lottoPurchaseAmount.lessThanZero().modulusLottoPrice()

    fun validJackpotNumbers(numbers: String): List<Int> {
        val jackpotNumbers: ArrayList<Int> = arrayListOf()
        numbers.withCommaToList().forEach { number ->
            jackpotNumbers.add(number.validLottoNumber())
        }
        return jackpotNumbers.isCorrectLottoCount()
    }

    fun validBonusNumber(number: Int) = number.validLottoNumber()

    internal fun Int.lessThanZero(): Int = require(this >= 0).let { return this }
    internal fun Int.modulusLottoPrice(): Int = require(this % LOTTO_PRICE == 0).let { return this }
    internal fun List<Int>.isCorrectLottoCount(): List<Int> = require(size == LOTTO_COUNT).let { return this }
    fun Int.validLottoNumber(): Int = require(this in VALID_LOTTO_NUMBER).let { return this }

    companion object {
        private const val LOTTO_PRICE = 1000
        private const val LOTTO_COUNT = 6
        private val VALID_LOTTO_NUMBER = 1..45
    }
}