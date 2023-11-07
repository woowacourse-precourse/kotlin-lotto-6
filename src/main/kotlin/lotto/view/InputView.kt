package lotto.view

import camp.nextstep.edu.missionutils.Console
import util.Validator.validateBonusNumber
import util.Validator.validatePurchaseAmount
import util.Validator.validateWinningNumbers

class InputView {
    fun inputPurchaseAmount(): Int {
        val purchaseAmount = Console.readLine()
        return validatePurchaseAmount(purchaseAmount)
    }

    fun inputWinningNumbers(): List<Int> {
        val winningNumbers = Console.readLine()
        return validateWinningNumbers(winningNumbers)
    }

    fun inputBonusNumber(winningNumbers: List<Int>): Int {
        val bonusNumber = Console.readLine()
        return validateBonusNumber(bonusNumber, winningNumbers)
    }
}