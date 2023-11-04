package lotto

import lotto.Constants.Companion.ERROR_DUPLICATE_WINNING_AND_BONUS_NUMBER_MESSAGE
import lotto.model.Bonus
import lotto.model.Lotto

class Validator {
    fun checkForDuplicates(lotto: Lotto, bonus: Bonus) {
        require(!lotto.getNumber.contains(bonus.getBonusNumber)){ERROR_DUPLICATE_WINNING_AND_BONUS_NUMBER_MESSAGE}
    }
}