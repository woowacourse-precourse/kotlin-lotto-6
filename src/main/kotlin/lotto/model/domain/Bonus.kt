package lotto.model.domain

import lotto.util.Validator.validateIsUnique
import lotto.util.Validator.validateRange

class Bonus(val number: Int, private val winningNumbers: Lotto) {
    init {
        validateRange(number)
        validateBonusIsUnique()
    }

    private fun validateBonusIsUnique() {
        val mergedNumbers = winningNumbers.toAscendingNumbers() + number
        validateIsUnique(mergedNumbers)
    }
}