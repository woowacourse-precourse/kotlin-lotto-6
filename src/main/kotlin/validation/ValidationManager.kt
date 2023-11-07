package validation

import extensions.toPurchaseLottoCount
import extensions.withCommaToList
import model.PurchaseLottoInfo

class ValidationManager {
    fun validAmount(lottoPurchaseAmount: Int): PurchaseLottoInfo {
        val amount = lottoPurchaseAmount.lessThanZero().modulusLottoPrice()
        return PurchaseLottoInfo(amount = amount, lottoCount = amount.toPurchaseLottoCount())
    }

    fun validJackpotNumbers(numbers: String): ArrayList<Int> {
        val jackpotNumbers: ArrayList<Int> = arrayListOf()
        numbers.withCommaToList().forEach { number ->
            jackpotNumbers.add(number.validLottoNumber())
        }
        return jackpotNumbers.isCorrectLottoCount()
    }

    fun validBonusNumber(bonusNumber: Int, jackpotNumbers: List<Int>) =
        jackpotNumbers.containBonusNumber(bonusNumber.validLottoNumber())

    internal fun Int.lessThanZero(): Int = require(this >= 0).let { return this }
    internal fun Int.modulusLottoPrice(): Int = require(this % LOTTO_PRICE == 0).let { return this }
    internal fun ArrayList<Int>.isCorrectLottoCount(): ArrayList<Int> = require(size == LOTTO_COUNT).let { return this }
    internal fun Int.validLottoNumber(): Int = require(this in VALID_LOTTO_NUMBER).let { return this }
    internal fun List<Int>.containBonusNumber(bonusNumber: Int): Int = require(!contains(bonusNumber)).let { return bonusNumber }

    companion object {
        private const val LOTTO_PRICE = 1000
        private const val LOTTO_COUNT = 6
        private val VALID_LOTTO_NUMBER = 1..45
    }
}