package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.Amount
import lotto.lottonumber.BonusNumber
import lotto.lottonumber.WinningNumber


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

    fun inputBonusNumber(winningNumbers: List<Int>): String {
        val bonusNumber = Console.readLine()
        BonusNumber(bonusNumber, winningNumbers)
        return bonusNumber
    }

}