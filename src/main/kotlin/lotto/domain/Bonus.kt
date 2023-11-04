package lotto.domain

import lotto.utils.Messages
import lotto.view.InputView.inputBonusNumber
import lotto.view.OutputView.showInputBonusNumberMessage

class Bonus {
    init {
        showInputBonusNumberMessage()
    }

    fun createBonusNumber(winningNumbers: List<Int>) {
        val bonus = inputBonusNumber()
        validateDuplicateBonusNumber(bonus, winningNumbers)
    }

    private fun validateDuplicateBonusNumber(bonus: Int, winningNumbers: List<Int>) {
        require(!winningNumbers.contains(bonus)) {
            "${Messages.ERROR_MESSAGE} ${Messages.MY_NUMBERS_DUPLICATED_MESSAGE}"
        }
    }
}