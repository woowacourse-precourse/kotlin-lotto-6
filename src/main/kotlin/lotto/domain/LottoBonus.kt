package lotto.domain

import lotto.Lotto
import lotto.validate.validateBonus
import lotto.view.InputView.inputBonusNumber
import lotto.view.OutputView.showInputBonusNumberMessage

class LottoBonus {
    init {
        showInputBonusNumberMessage()
    }

    fun createBonusNumber(winningNumbers: MutableList<Lotto>): Boolean {
        val bonus = inputBonusNumber()
        val validateBonus = validateBonus()
        validateBonus.validateBonus(bonus, winningNumbers)

        return checkBonusWithWinningNumbers(bonus, winningNumbers)
    }

    fun checkBonusWithWinningNumbers(bonus: Int, lottoList: MutableList<Lotto>): Boolean {
        lottoList.forEach {
            if (it.getLotto().contains(bonus)) {
                return true
            }
        }
        return false
    }


}