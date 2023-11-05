package lotto.domain

import lotto.constant.ErrorMessage

class WinningNumbers(numbers: List<Int>) {
    private var winningNumbers: List<Int>? = null

    init {
        validateWinningNumbers(numbers)
        winningNumbers = numbers
    }

    fun getWinningNumbers() = winningNumbers

    private fun validateWinningNumbers(numbers: List<Int>) {
        validateWinningNumbersSize(numbers)
        validateWinningNumbersDuplicate(numbers)
        validateWinningNumbersRange(numbers)
    }

    private fun validateWinningNumbersRange(numbers: List<Int>) {
        if (!numbers.all { it in WINNING_NUMBER_START..WINNING_NUMBER_END }) {
            throw IllegalStateException(ErrorMessage.NOT_NUMBER_RANGE_WINNING_NUMBER.message)
        }
    }

    private fun validateWinningNumbersDuplicate(numbers: List<Int>) {
        if (numbers.size != numbers.distinct().size) {
            throw IllegalStateException(ErrorMessage.NOT_DUPLICATED_WINNING_NUMBER.message)
        }
    }

    private fun validateWinningNumbersSize(numbers: List<Int>) {
        if (numbers!!.size != WINNING_NUMBER_SIZE) {
            throw IllegalStateException(ErrorMessage.NOT_SIX_WINNING_NUMBER.message)
        }
    }

    companion object {
        private const val WINNING_NUMBER_SIZE = 6
        private const val WINNING_NUMBER_START = 1
        private const val WINNING_NUMBER_END = 45
    }
}