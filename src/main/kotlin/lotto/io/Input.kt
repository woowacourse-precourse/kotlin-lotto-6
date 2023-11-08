package lotto.io

import camp.nextstep.edu.missionutils.Console
import lotto.Constants
import lotto.ErrorMessage
import lotto.ErrorMessage.BONUS_NUMBER_INTERSECTED
import lotto.ErrorMessage.BUDGET_NOT_DIVIDED
import lotto.ErrorMessage.BUDGET_UNDER_ZERO
import lotto.ErrorMessage.EMPTY_INPUT
import lotto.ErrorMessage.INVALID_LOTTO_RANGE
import lotto.ErrorMessage.INVALID_NUMBER
import lotto.ErrorMessage.LACK_OF_NUMBER
import lotto.ErrorMessage.WINNING_NUMBER_INTERSECTED
import java.lang.IllegalArgumentException

object Input {
    private fun getInput(): String {
        val input = Console.readLine().trim()
        require(input.isNotEmpty()) { ErrorMessage.print(EMPTY_INPUT) }
        return input
    }
    private fun getNumberInput(): Int {
        val input = getInput()
        require(isNumeric(input)) { ErrorMessage.print(INVALID_NUMBER) }
        return input.toInt()
    }
    fun getBudget(): Int = repeatUntilGetValidInput {
        val budget = getNumberInput()
        require(budget > 0) { ErrorMessage.print(BUDGET_UNDER_ZERO) }
        require(budget % Constants.PRICE_OF_LOTTO == 0) { ErrorMessage.print(BUDGET_NOT_DIVIDED) }
        budget
    }
    fun getWinningNumber(): List<Int> = repeatUntilGetValidInput {
        val input = getInput()
        val splitted = input.split(",")
        require(splitted.size == Constants.LOTTO_COUNT) { ErrorMessage.print(LACK_OF_NUMBER) }
        val winningNumber = splitted.map {
            require(isNumeric(it)) { ErrorMessage.print(INVALID_NUMBER) }
            val num = it.toInt()
            require(isValidLottoNum(num)) { ErrorMessage.print(INVALID_LOTTO_RANGE) }
            num
        }
        require(winningNumber.toSet().size == Constants.LOTTO_COUNT) { ErrorMessage.print(WINNING_NUMBER_INTERSECTED) }
        winningNumber
    }
    fun getBonusNumber(winningNumber: List<Int>): Int = repeatUntilGetValidInput {
        val bonusNumber = getNumberInput()
        require(bonusNumber > 0)
        require(isValidLottoNum(bonusNumber)) { ErrorMessage.print(INVALID_LOTTO_RANGE) }
        require(!winningNumber.contains(bonusNumber)) { ErrorMessage.print(BONUS_NUMBER_INTERSECTED) }
        bonusNumber
    }
    private fun isValidLottoNum(num: Int): Boolean = num in Constants.MIN_LOTTO_NUMBER..Constants.MAX_LOTTO_NUMBER
    private fun isNumeric(string: String): Boolean = string.all { it.isDigit() }
    private fun <T>repeatUntilGetValidInput(inputFunction: () -> T): T {
        val ret: T
        while (true) {
            ret = try {
                inputFunction()
            } catch (e: IllegalArgumentException) {
                continue
            }
            break
        }
        return ret
    }
}
