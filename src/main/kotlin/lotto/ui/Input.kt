package lotto.ui

import camp.nextstep.edu.missionutils.Console

object Input {
    fun inputPurchaseAmount(): String {
        return Console.readLine()
    }

    fun inputWinningNumber(): String {
        return Console.readLine()
    }

    fun inputBonusNumber(): String {
        return Console.readLine()
    }
}