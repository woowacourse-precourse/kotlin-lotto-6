package lotto.view

import lotto.constants.Constants
import camp.nextstep.edu.missionutils.Console

class InputView {
    fun inputBuyAmount(): String {
        println(Constants.INPUT_BUY_AMOUNT)
        return Console.readLine()
    }
}