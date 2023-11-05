package lotto

import camp.nextstep.edu.missionutils.Console
import utils.LottoPurchaseValidator
import utils.createErrMsg
import java.lang.IllegalArgumentException

class UserInputReader {

    private val purchaseValidator = LottoPurchaseValidator()

    fun getPrice(): Int {
        var input: String
        var isValid: Boolean
        do {
            println(ENTER_PRICE_MSG)
            input = Console.readLine()
            isValid = try {
                purchaseValidator.checkInputValidation(input)
            } catch (e: IllegalArgumentException) {
                println(createErrMsg(e.message ?: "Unknown error"))
                false
            }
        } while (!isValid)
        return input.toInt()
    }

    companion object {
        const val ENTER_PRICE_MSG = "구입금액을 입력해 주세요."
    }
}