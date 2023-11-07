package lotto.model

import java.lang.IllegalArgumentException

class WinningNumbers(_winningNumbers: String) : Lotto(parseWinningNumbers(_winningNumbers)) {
    companion object {
        private fun parseWinningNumbers(winningNumbers: String): List<Int> {
            try {
                return winningNumbers.split(",")
                    .map { it.trim().toInt() }

            } catch (e: NumberFormatException) {
                throw IllegalArgumentException(WINNING_NUMBERS_IS_ONLY_DIGIT, e)
            }
        }

        const val WINNING_NUMBERS_IS_ONLY_DIGIT = "당첨 번호는 숫자로 구성되어야 합니다."
    }
}
