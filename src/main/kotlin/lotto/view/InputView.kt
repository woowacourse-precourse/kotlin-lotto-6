package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.Constants.INPUT_ENTER_BONUS_NUMBERS_MESSAGE
import lotto.Constants.INPUT_ENTER_WINNING_NUMBERS_MESSAGE
import lotto.Constants.INPUT_PURCHASE_AMOUNT_MESSAGE

class InputView {

    fun purchaseAmountMessage(): String {
        println(INPUT_PURCHASE_AMOUNT_MESSAGE)
        return Console.readLine()
    }

    fun enterWinningNumbersMessage(): String {
        println("\n" + INPUT_ENTER_WINNING_NUMBERS_MESSAGE)
        return Console.readLine()
    }

    fun enterBonusNumbersMessage(): String {
        println("\n" + INPUT_ENTER_BONUS_NUMBERS_MESSAGE)
        return Console.readLine()
    }
}