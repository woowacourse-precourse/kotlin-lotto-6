package lotto.validator.string

import lotto.validator.numbers.DuplicatedValidator
import lotto.validator.numbers.NumbersValidator
import lotto.validator.numbers.RangeValidator
import lotto.validator.numbers.SizeValidator

class WinningNumbersValidator(
    private val numericValidator: StringValidator = NumericValidator(),
    private val sizeValidator: NumbersValidator = SizeValidator(),
    private val duplicatedValidator: NumbersValidator = DuplicatedValidator(),
    private val rangeValidator: NumbersValidator = RangeValidator()
) : StringValidator {
    override fun validate(value: String) {
        validateContainsComma(value)
        val numbers = value.validateAndConvertToNumbers()
        sizeValidator.validate(numbers)
        duplicatedValidator.validate(numbers)
        rangeValidator.validate(numbers)
    }

    private fun String.validateAndConvertToNumbers() = split(DELIMITER)
        .map { it.trim() }
        .onEach { numericValidator.validate(it) }
        .map { it.toInt() }

    private fun validateContainsComma(value: String) {
        require(value.contains(DELIMITER)) {
            COMMA_ERROR_MESSAGE
        }
    }

    companion object {
        private const val DELIMITER = ","
        private const val COMMA_ERROR_MESSAGE = "쉼표(,)로 숫자를 구분해주세요."
    }
}