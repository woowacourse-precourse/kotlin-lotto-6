package lotto.validator.string

import lotto.validator.numbers.NumbersValidator
import lotto.validator.numbers.RangeValidator

class BonusNumberValidator(
    private val winningNumbers: List<Int>,
    private val numericValidator: StringValidator = NumericValidator(),
    private val rangeValidator: NumbersValidator = RangeValidator(),
) : StringValidator {
    override fun validate(value: String) {
        numericValidator.validate(value)
        rangeValidator.validate(listOf(value.toInt()))
        validateNotDuplicate(value)
    }

    private fun validateNotDuplicate(value: String) {
        require(winningNumbers.contains(value.toInt()).not()) {
            BONUS_NUMBER_ERROR_FORMAT.format(value, winningNumbers)
        }
    }

    companion object{
        private const val BONUS_NUMBER_ERROR_FORMAT = "보너스 번호 %s 는 당첨 번호 %s 와 중복될 수 없습니다."
    }
}