package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.Constants.Companion.INPUT_PURCHASE_AMOUNT_MESSAGE

class InputView {

    fun inputPurchaseAmountMessage(): String {
        println(INPUT_PURCHASE_AMOUNT_MESSAGE)
        return Console.readLine()
    }
}