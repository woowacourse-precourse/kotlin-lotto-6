package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.model.isAmountInThousand
import lotto.model.isDigit

class InputView {
    fun inputPurchaseAmount() {
        val amount = Console.readLine()
        amount.isDigit()
        amount.isAmountInThousand()
    }
}