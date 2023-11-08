package lotto.validator.numbers

class RangeValidator(private val range: IntRange = LOTTO_NUMBER_RANGE) : NumbersValidator {
    override fun validate(value: List<Int>) {
        require(value.all { it in range }) {
            RANGE_ERROR_FORMAT.format(value)
        }
    }

    companion object {
        private val LOTTO_NUMBER_RANGE = 1..45
        private const val RANGE_ERROR_FORMAT = "로또 번호 %s 는 1 ~ 45 사이여야 합니다"
    }
}