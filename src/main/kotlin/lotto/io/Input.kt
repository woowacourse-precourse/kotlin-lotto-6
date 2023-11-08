package lotto.io

import camp.nextstep.edu.missionutils.Console
import lotto.exception.ExceptionChecker

class Input(private val checker: ExceptionChecker = ExceptionChecker()) {

    fun enterPurchaseAmount(): Int {
        val purchaseAmount = Console.readLine()
        checker.checkAmount(purchaseAmount)
        return purchaseAmount.toInt()
    }

    fun enterWinningNumbers(): List<Int> {
        val winningNumbers = Console.readLine().split(",")
        checker.checkWinningNumbers(winningNumbers)
        return winningNumbers.map { it.toInt() }
    }

    fun enterBonusNumber(winningNumbers: List<Int>): Int {
        val bonusNumber = Console.readLine()
        checker.checkBonusNumber(winningNumbers, bonusNumber)

        return bonusNumber.toInt()
    }


}
