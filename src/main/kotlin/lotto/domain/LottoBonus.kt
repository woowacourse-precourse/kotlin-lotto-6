package lotto.domain

import lotto.validate.validateBonus
import lotto.view.InputView.inputBonusNumber
import lotto.view.OutputView.showInputBonusNumberMessage

class LottoBonus {
    init {
        showInputBonusNumberMessage()
    }

    fun createBonusNumber(winningNumbers: List<Int>): Int {
        val bonus = inputBonusNumber()
        val validateBonus = validateBonus()
        validateBonus.validateBonus(bonus, winningNumbers)

        return bonus
    }


}