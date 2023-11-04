package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun inputPurchaseAmount(): String {
        return Console.readLine()
    }

    fun inputWinningNumbers(): String {
        return Console.readLine()
    }

    fun inputBonusNumber(): String {
        return Console.readLine()
    }
}