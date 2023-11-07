package lotto.validator.numbers

class DuplicatedValidator : NumbersValidator {
    override fun validate(value: List<Int>) {
        require(value.distinct().size == value.size) {
            DUPLICATED_ERROR_FORMAT.format(value)
        }
    }

    companion object {
        private const val DUPLICATED_ERROR_FORMAT = "로또 번호 %s 는 중복되면 안됩니다"
    }
}