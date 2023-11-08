package lotto.validator.string

class NumericValidator : StringValidator {
    override fun validate(value: String) {
        require(value.all { it.isDigit() }) {
            NUMERIC_ERROR_FORMAT.format(value)
        }
    }

    companion object {
        private const val NUMERIC_ERROR_FORMAT = "문자열 %s 은 숫자여야 합니다"
    }
}