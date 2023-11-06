package lotto.view

import camp.nextstep.edu.missionutils.Console

class Input {

    fun inputPurchaseAmount(): String {

        return Console.readLine()
    }

    fun inputWinningNumbers(): List<String> {

        return Console.readLine().split(",")

    }

    fun inputBonusNumber(): String {

        return Console.readLine()
    }
}