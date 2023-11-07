package lotto.domain

import lotto.constants.LOTTO_SIZE
import lotto.constants.*
import lotto.ui.Input
import lotto.ui.Output

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
                return inputBonusNumber
            }catch (e:IllegalArgumentException){
                println(e.message)
                continue
            }
        } while (true)
    }

    fun validateWinningNumber(inputWinningNumber: String) {
        val winningNumber = inputWinningNumber.split(",")
        for (number in winningNumber) {
            val num = number.toInt()
            if (!isNumberInRange(num)) throw IllegalArgumentException(MESSAGE_NOT_IN_RANGE)
        }
        if (winningNumber.size != LOTTO_SIZE) throw IllegalArgumentException(MESSAGE_NOT_SIX)
        if (winningNumber.distinct().size != LOTTO_SIZE) throw IllegalArgumentException(MESSAGE_DUPLICATE_NUMBER)
    }

    fun validateBonusNumber(inputBonusNumber: Int, winningNumber: List<Int>) {
        if (!isNumberInRange(inputBonusNumber)) throw IllegalArgumentException(MESSAGE_NOT_IN_RANGE)
        if (winningNumber.contains(inputBonusNumber)) throw IllegalArgumentException(MESSAGE_CONTAIN_WINNING_NUMBER)
    }

    fun isNumberInRange(number: Int): Boolean {
        return number in 1..45
    }
}