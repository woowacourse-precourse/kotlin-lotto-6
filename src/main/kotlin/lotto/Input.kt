package lotto

import camp.nextstep.edu.missionutils.Console

object Input {
    private fun getInput(): String {
        val input = Console.readLine().trim()
        require(input.isNotEmpty())
        return input
    }
    private fun getNumberInput(): Int {
        val input = getInput()
        require(isNumeric(input))
        return input.toInt()
    }
    fun getBudget(): Int = repeatUntilGetValidInput {
        val budget = getNumberInput()
        require(budget > 0)
        require(budget % Constants.PRICE_OF_LOTTO == 0)
        budget
    }
    fun getWinningNumber(): List<Int> = repeatUntilGetValidInput {
        val input = getInput()
        input.split(",").map {
            require(isNumeric(it))
            val num = it.toInt()
            require(isValidLottoNum(num))
            num
        }
    }
    fun getBonusNumber(): Int = repeatUntilGetValidInput {
        val bonusNumber = getNumberInput()
        require(bonusNumber > 0)
        require(isValidLottoNum(bonusNumber))
        bonusNumber
    }
    private fun isValidLottoNum(num: Int): Boolean = num in Constants.MIN_LOTTO_NUMBER ..< Constants.MAX_LOTTO_NUMBER
    private fun isNumeric(string: String): Boolean = string.all { it.isDigit() }
    private fun <T>repeatUntilGetValidInput(inputFunction: () -> T): T {
        val ret: T
        while (true) {
            ret = try {
                inputFunction()
            } catch (e: Exception) {
                continue
            }
            break
        }
        return ret
    }
}
