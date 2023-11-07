package lotto

import camp.nextstep.edu.missionutils.Console


class InputView {

    fun inputPurchaseAmount(): String {
        val amount = Console.readLine()
        Amount(amount)
        return amount
    }

    fun inputWinningNumber(): String {
        val winningNumber = Console.readLine()
        WinningNumber(winningNumber)
        return winningNumber
    }

}