package lotto

import camp.nextstep.edu.missionutils.Console
import java.lang.NumberFormatException

object Input {
    private fun getInput(): String {
        val input = Console.readLine().trim()
        require(input.isNotEmpty())
        return input
    }
    fun getBudget(): Int {
        val budget = getInput().toInt()
        require(budget > 0)
        require(budget % Constants.PRICE_OF_LOTTO == 0)
        return budget
    }
    fun getWinningNumber(): List<Int> {
        val winningNumbers = repeatUntilGetValidInput {
            val input = getInput()
            input.split(",").map { it.toInt() }
        }
        return winningNumbers
    }

    private fun <T>repeatUntilGetValidInput(inputFunction: () -> T): T {
        val ret: T
        while (true) {
            ret = try {
                inputFunction()
            } catch (e: Exception) {
                // TODO: error message
                continue
            }
            break
        }
        return ret
    }
}
