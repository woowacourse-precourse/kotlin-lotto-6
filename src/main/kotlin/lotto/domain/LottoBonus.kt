package lotto.domain

import lotto.validate.ValidateBonus
import lotto.view.InputView.inputBonusNumber

class LottoBonus {
    fun createBonusNumber(winningNumbers: List<Int>): Int {
        val bonus = inputBonusNumber()
        val validateBonus = ValidateBonus()
        validateBonus.validateBonus(bonus, winningNumbers)

        return bonus
    }
}