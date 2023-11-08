package lotto.domain

import lotto.constants.LOTTO_SIZE
import lotto.constants.*
import lotto.ui.Input
import lotto.ui.Output
import kotlin.NumberFormatException

class WinningNumberGenerator {
    fun inputWinningNumber(): List<Int> {
        Output.printWinningNumbers()
        do {
            try {
                val inputWinningNumber = Input.inputWinningNumber()
                validateWinningNumber(inputWinningNumber)
                return inputWinningNumber.split(",").map { it.toInt() }
            } catch (e: IllegalArgumentException) {
                println(e.message)
                continue
            }
        } while (true)
    }

    fun inputBonusNumber(winningNumber: List<Int>): Int {
        Output.printBonusNumbers()
        do {
            try {
                val inputBonusNumber = Input.inputBonusNumber()
                validateBonusNumber(inputBonusNumber, winningNumber)
                return inputBonusNumber.toInt()
            } catch (e: IllegalArgumentException) {
                println(e.message)
                continue
            }
        } while (true)
    }

    fun validateWinningNumber(inputWinningNumber: String) {
        val winningNumber = inputWinningNumber.split(",")
        for (number in winningNumber) {
            try {
                val num = number.toInt()
                if (!isNumberInRange(num)) throw IllegalArgumentException(MESSAGE_NOT_IN_RANGE)
            } catch (e: NumberFormatException) {
                throw NumberFormatException(MESSAGE_ONLY_NUMBER)
            }
        }
        if (winningNumber.size != LOTTO_SIZE) throw IllegalArgumentException(MESSAGE_NOT_SIX)
        if (winningNumber.distinct().size != LOTTO_SIZE) throw IllegalArgumentException(
            MESSAGE_DUPLICATE_NUMBER
        )
    }

    fun validateBonusNumber(inputBonusNumber: String, winningNumber: List<Int>) {
        try {
            val bonusNumber = inputBonusNumber.toInt()
            if (!isNumberInRange(bonusNumber)) throw IllegalArgumentException(MESSAGE_NOT_IN_RANGE)
            if (winningNumber.contains(bonusNumber)) throw IllegalArgumentException(
                MESSAGE_CONTAIN_WINNING_NUMBER
            )
        } catch (e: NumberFormatException) {
            throw NumberFormatException(MESSAGE_ONLY_NUMBER)
        }
    }

    fun isNumberInRange(number: Int): Boolean {
        return number in 1..45
    }
}