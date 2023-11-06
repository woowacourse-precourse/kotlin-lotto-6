package lotto.domain

import lotto.validate.validateBonus
import lotto.view.InputView.inputBonusNumber
import lotto.view.OutputView.showInputBonusNumberMessage

class LottoBonus {
    init {
        showInputBonusNumberMessage()
    }

    fun createBonusNumber(winningNumbers: List<Int>): Boolean {
        val bonus = inputBonusNumber()
        val validateBonus = validateBonus()
        validateBonus.validateBonus(bonus, winningNumbers)

        return checkBonusWithWinningNumbers(bonus, winningNumbers)
    }

    fun checkBonusWithWinningNumbers(bonus: Int, lottoList: List<Int>): Boolean {
        lottoList.forEach {
            if (it == bonus) {
                return true
            }
        }
        return false
    }


}