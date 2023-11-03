package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.model.isAmountInThousand

class InputView {
    fun inputPurchaseAmount() {
        val amount = Console.readLine()
        amount.isAmountInThousand()
    }
}