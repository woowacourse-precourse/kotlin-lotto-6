package ui

import camp.nextstep.edu.missionutils.Console
import utils.BonusNumberValidator
import utils.LottoPurchaseValidator
import utils.WinningNumbersValidator
import utils.createErrMsg
import java.lang.IllegalArgumentException

class UserInputReader {

    private val purchaseValidator = LottoPurchaseValidator()
    private val winningNumbersValidator = WinningNumbersValidator()
    private val bonusNumberValidator = BonusNumberValidator()

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
            println(ENTER_WINNING_NUM_MSG)
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

    fun getBonusNumber(winningNumbers: List<Int>): Int {
        var isValid: Boolean
        var userInput: String
        do {
            println(ENTER_BONUS_NUM_MSG)
            userInput = Console.readLine()
            isValid = try {
                bonusNumberValidator.checkInputValidation(userInput, winningNumbers)
            } catch (e: IllegalArgumentException) {
                println(createErrMsg(e.message ?: "Unknown error"))
                false
            }
        } while (!isValid)
        return userInput.toInt()
    }

    companion object {
        const val ENTER_PRICE_MSG = "구입금액을 입력해 주세요."
        const val ENTER_WINNING_NUM_MSG = "\n당첨 번호를 입력해 주세요."
        const val DELIMITER = ","
        const val ENTER_BONUS_NUM_MSG = "\n보너스 번호를 입력해 주세요."
    }
}