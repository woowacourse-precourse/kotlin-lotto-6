package lotto

import camp.nextstep.edu.missionutils.Console

class InputManager {
    private val exceptionManager = ExceptionManager()
    var number: String = ""
    var nums: List<String> = listOf()
    fun inputMoney(): Int {
        return try {
            println(PRINT_INPUT_MONEY)
            val money = Console.readLine().trim()
            exceptionManager.moneyException(money)
            return money.toInt()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            inputMoney()
        }

    }

    fun inputWinningNumber(): List<Int> {
        return try {
            println(PRINT_INPUT_WINNING_NUMBER)
            nums = Console.readLine().split(DELIMITER)
            exceptionManager.winningNumberException(nums)
            println()

            return nums.map { it.toInt() }
        } catch (e: IllegalArgumentException) {
            println(e.message)
            inputWinningNumber()
        }

    }

    fun inputBonusNumber(): Int {
        return try {
            println(PRINT_INPUT_BONUS_NUMBER)
            number = Console.readLine().trim()
            exceptionManager.bonusNumberException(Pair(nums, number))
            println()

            return number.toInt()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            inputBonusNumber()
        }

    }

    companion object {

        private const val DELIMITER = ","
        private const val PRINT_INPUT_MONEY = "구입금액을 입력해 주세요."
        private const val PRINT_INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요."
        private const val PRINT_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요."
    }
}