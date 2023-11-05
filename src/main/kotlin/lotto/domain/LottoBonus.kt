package lotto.domain

import lotto.validate.validateBonus
import lotto.view.InputView.inputBonusNumber
import lotto.view.OutputView.showInputBonusNumberMessage

class LottoBonus {
    init {
        showInputBonusNumberMessage()
    }

    fun createBonusNumber(winningNumbers: List<Int>) {
        val bonus = inputBonusNumber()
        val validateBonus = validateBonus()
        return validateBonus.validateBonus(bonus, winningNumbers)
    }


}