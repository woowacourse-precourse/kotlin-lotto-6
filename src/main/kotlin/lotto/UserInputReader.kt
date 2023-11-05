package lotto

import camp.nextstep.edu.missionutils.Console
import utils.LottoPurchaseValidator
import utils.WinningNumbersValidator
import utils.createErrMsg
import java.lang.IllegalArgumentException

class UserInputReader {

    private val purchaseValidator = LottoPurchaseValidator()
    private val winningNumbersValidator = WinningNumbersValidator()

    fun getPrice(): Int {
        var userInput: String
        var isValid: Boolean
        do {
            println(ENTER_PRICE_MSG)
            userInput = Console.readLine()
            isValid = try {
                purchaseValidator.checkInputValidation(userInput)
            } catch (e: IllegalArgumentException) {
                println(createErrMsg(e.message ?: "Unknown error"))
                false
            }
        } while (!isValid)
        return userInput.toInt()
    }

    fun getWinningNumbers(): List<Int> {
        var userInput: List<String>
        var isValid: Boolean

        do {
            println(ENTER_WINNING_NUMBERS_MSG)
            userInput = Console.readLine().split(DELIMITER)
            isValid = try {
                winningNumbersValidator.checkInputValidation(userInput)
            } catch (e: IllegalArgumentException) {
                println(createErrMsg(e.message ?: "Unknown error"))
                false
            }
        } while (!isValid)
        return userInput.map { it.toInt() }
    }

    companion object {
        const val ENTER_PRICE_MSG = "구입금액을 입력해 주세요."
        const val ENTER_WINNING_NUMBERS_MSG = "\n당첨 번호를 입력해 주세요."
        const val DELIMITER = ","
    }
}