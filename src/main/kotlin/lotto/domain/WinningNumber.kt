package lotto.domain

import lotto.resources.Error.NOT_INT_ERROR
import lotto.resources.Error.NOT_IN_LOTTO_RANGE_ERROR
import lotto.resources.Error.WINNING_NUMBER_SIZE_ERROR
import lotto.resources.Lotto.END_NUMBER
import lotto.resources.Lotto.START_NUMBER

class WinningNumber(

) {

    fun userInputToWinningNumber(userInput: String): List<Int> {
        return userInput
            .split(",")
            .map { it.trim() }
            .also { it.numberValidation() }
            .map { it.toInt() }
    }

    private fun List<String>.numberValidation() {
        require(size == 6) {
            WINNING_NUMBER_SIZE_ERROR
        }

        require(all { number -> number.toIntOrNull() != null }) {
            NOT_INT_ERROR
        }

        require(all { number -> number.toInt() in START_NUMBER..END_NUMBER }) {
            NOT_IN_LOTTO_RANGE_ERROR
        }
    }
}