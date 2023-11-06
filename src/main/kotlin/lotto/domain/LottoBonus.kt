package lotto.domain

import lotto.validate.ValidateBonus
import lotto.view.InputView.inputBonusNumber
import lotto.view.OutputView.showInputBonusNumberMessage

class LottoBonus {
    init {
        showInputBonusNumberMessage()
    }

    fun createBonusNumber(userWinningNumbers: List<Int>): Int {
        val bonusNumber = inputBonusNumber()
        val validateBonus = ValidateBonus()
        validateBonus.validateBonus(bonusNumber, userWinningNumbers)

        return bonusNumber
    }
}