package lotto.controller

import lotto.dto.WinningAndBonusNumbers
import lotto.model.BonusNumber
import lotto.model.BuyingAmount
import lotto.model.WinningNumbers
import lotto.model.validation.WinningValidation
import lotto.util.Task
import lotto.view.InputView

class InputController(
    private val inputView: InputView
) {
    fun BuyingAmount(): BuyingAmount = BuyingAmount(inputView.buyingAmountPrompt())

    fun WinningAndBonusNumbers(): WinningAndBonusNumbers {
        val winningNumbers = WinningNumbers(inputView.winningNumbersPrompt())
        val bonusNumber = BonusNumber(inputView.bonusNumberPrompt())

        WinningValidation(winningNumbers.numbers, bonusNumber.number)

        return WinningAndBonusNumbers(winningNumbers.numbers, bonusNumber.number)
    }
}