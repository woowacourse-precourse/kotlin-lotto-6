package lotto.view

import lotto.utils.Constants.PRINT_ENTER
import lotto.utils.Constants.REQUEST_BONUS_NUMBER_INPUT_MESSAGE
import lotto.utils.Constants.REQUEST_PAY_INPUT_MESSAGE
import lotto.utils.Constants.REQUEST_WINNING_NUMBER_INPUT_MESSAGE

object InputView {
    fun printPayInputMessage() {
        println(REQUEST_PAY_INPUT_MESSAGE)
    }

    fun printWinningNumberInputMessage() {
        println(PRINT_ENTER + REQUEST_WINNING_NUMBER_INPUT_MESSAGE)
    }

    fun printBonusNumberInputMessage() {
        println(PRINT_ENTER + REQUEST_BONUS_NUMBER_INPUT_MESSAGE)
    }
}