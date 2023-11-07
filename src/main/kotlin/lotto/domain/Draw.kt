package lotto.domain

import lotto.domain.util.Validator

class Draw {
    private val validator = Validator()

    fun validateDrawNumber(drawNumber: String): List<Int> =
        validator.drawNumber(drawNumber)

    fun validateBonusNumber(bonusNumber: String, drawNumbers: List<Int>): Int =
        validator.bonusNumber(bonusNumber, drawNumbers)
}