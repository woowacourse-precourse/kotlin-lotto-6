package validation

import extensions.withCommaToList

class ValidationManager {
    fun validAmount(lottoPurchaseAmount: Int): Int =
        lottoPurchaseAmount.lessThanZero().modulusLottoPrice()

    fun validJackpotNumbers(numbers: String): ArrayList<Int> {
        val jackpotNumbers: ArrayList<Int> = arrayListOf()
        numbers.withCommaToList().forEach { number ->
            jackpotNumbers.add(number.validLottoNumber())
        }
        return jackpotNumbers.isCorrectLottoCount()
    }

    fun validBonusNumber(bonusNumber: Int, lottoNumbers: List<Int>) =
        lottoNumbers.containsBonusNumber(bonusNumber.validLottoNumber())

    internal fun Int.lessThanZero(): Int = require(this >= 0).let { return this }
    internal fun Int.modulusLottoPrice(): Int = require(this % LOTTO_PRICE == 0).let { return this }
    internal fun ArrayList<Int>.isCorrectLottoCount(): ArrayList<Int> = require(size == LOTTO_COUNT).let { return this }
    fun Int.validLottoNumber(): Int = require(this in VALID_LOTTO_NUMBER).let { return this }
    fun List<Int>.containsBonusNumber(bonusNumber: Int): Int = require(!contains(bonusNumber)).let { return bonusNumber }

    companion object {
        private const val LOTTO_PRICE = 1000
        private const val LOTTO_COUNT = 6
        private val VALID_LOTTO_NUMBER = 1..45
    }
}