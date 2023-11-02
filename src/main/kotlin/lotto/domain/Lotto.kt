package lotto.domain

import lotto.constant.ErrorMessage

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == WINNING_NUMBERS_SIZE) { ErrorMessage.NOT_SIX_WINNING_NUMBER.message }
    }

    fun toLottoNumbersResult(): String {
        return numbers.toString()
    }

    fun compareWinningNumbers(winningNumbers: WinningNumbers): Int {
        var sameWinningNumberCount = 0
        winningNumbers.convertToInt().forEach {
            if (numbers.contains(it)) sameWinningNumberCount++
        }
        return sameWinningNumberCount
    }

    fun compareBonusNumber(bonusNumber: BonusNumber): Int =
        if (numbers.contains(bonusNumber.loadBonusNumber())) CONTAIN_BONUS_NUMBER else NOT_CONTAIN_BONUS_NUMBER

    companion object {
        private const val WINNING_NUMBERS_SIZE = 6
        private const val CONTAIN_BONUS_NUMBER = 1
        private const val NOT_CONTAIN_BONUS_NUMBER = 0
    }
}
