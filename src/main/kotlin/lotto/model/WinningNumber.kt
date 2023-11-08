package lotto.model

import lotto.util.isInLottoNumberRange
import lotto.util.isUnique
import lotto.util.lottoNumberRange

class WinningNumber(
    private val normalNumbers: List<Int>,
    private val bonusNumber: Int
) {
    init {
        validate(normalNumbers, bonusNumber)
    }

    fun check(lotto: Lotto): Winning {
        val totalNumbers = normalNumbers + bonusNumber
        val matchCount = totalNumbers.count { it in lotto }
        val correctBonus = bonusNumber in lotto

        return Winning.create(matchCount, correctBonus)
    }

    companion object {
        private const val NORMAL_NUMBERS_SIZE = 6

        fun validate(normalNumbers: List<Int>) {
            require(normalNumbers.isUnique()) { Message.DuplicatedError }
            require(normalNumbers.size == NORMAL_NUMBERS_SIZE) {
                val errorMessage = Message.NormalWinningNumberSizeError
                errorMessage.format(NORMAL_NUMBERS_SIZE)
            }
            require(normalNumbers.isInLottoNumberRange()) {
                val errorMessage = Message.WinningNumberRangeError
                errorMessage.format(lottoNumberRange.first, lottoNumberRange.last)
            }
        }

        fun validate(normalNumbers: List<Int>, bonusNumber: Int) {
            validate(normalNumbers)
            require((normalNumbers + bonusNumber).isUnique()) {
                Message.DuplicatedWithNormalWinningNumberError
            }
            require(bonusNumber.isInLottoNumberRange()) {
                val errorMessage = Message.WinningNumberRangeError
                errorMessage.format(lottoNumberRange.first, lottoNumberRange.last)
            }
        }
    }
}
