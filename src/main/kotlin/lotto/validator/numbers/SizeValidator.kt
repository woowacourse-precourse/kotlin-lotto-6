package lotto.validator.numbers

class SizeValidator(private val size: Int = LOTTO_NUMBER_SIZE) : NumbersValidator {
    override fun validate(value: List<Int>) {
        require(value.size == size) {
            SIZE_ERROR_FORMAT.format(value)
        }
    }

    companion object {
        private const val LOTTO_NUMBER_SIZE = 6
        private const val SIZE_ERROR_FORMAT = "로또 번호 %s 는 6개여야 합니다"
    }
}