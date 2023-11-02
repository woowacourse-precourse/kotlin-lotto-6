package lotto.domain

import lotto.constant.ErrorMessage

class WinningNumbers(private val winningNumbers: List<String>) {
    init {
        validateWinningNumbers()
    }

    fun convertToInt() = winningNumbers.map { it.toInt() }.toList()

    private fun validateWinningNumbers() {
        validateWinningNumbersSize()
        validateWinningNumbersDuplicate()
        validateWinningNumbersRange()
    }

    private fun validateWinningNumbersRange() {
        val intWinningNumbers = winningNumbers.map { it.toInt() }.toList()
        if (!intWinningNumbers.all { it in WINNING_NUMBER_START..WINNING_NUMBER_END }) {
            throw IllegalStateException(ErrorMessage.NOT_NUMBER_RANGE_WINNING_NUMBER.message)
        }
    }

    private fun validateWinningNumbersDuplicate() {
        val distinctWinningNumbers = winningNumbers.distinct()
        if (distinctWinningNumbers.size != winningNumbers.size) {
            throw IllegalStateException(ErrorMessage.NOT_DUPLICATED_WINNING_NUMBER.message)
        }
    }

    private fun validateWinningNumbersSize() {
        if (winningNumbers.size != WINNING_NUMBER_SIZE) {
            throw IllegalStateException(ErrorMessage.NOT_SIX_WINNING_NUMBER.message)
        }
    }

    companion object {
        private const val WINNING_NUMBER_SIZE = 6
        private const val WINNING_NUMBER_START = 1
        private const val WINNING_NUMBER_END = 45
    }
}