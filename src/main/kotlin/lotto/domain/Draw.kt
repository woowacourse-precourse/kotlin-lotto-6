package lotto.domain

import lotto.domain.util.Validator

class Draw {
    private val validator = Validator()

    fun validateDrawNumber(drawNumber: String): List<Int> {
        return validator.drawNumber(drawNumber)
    }

    fun validateBonusNumber(bonusNumber: String, drawNumbers: List<Int>): Int {
        return validator.bonusNumber(bonusNumber, drawNumbers)
    }
}