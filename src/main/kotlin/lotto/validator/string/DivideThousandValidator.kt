package lotto.validator.string

class DivideThousandValidator : StringValidator {
    override fun validate(value: String) {
        val digit = value.toInt()
        require(digit.canDivideThousand()) {
            DIVIDE_THOUSAND_ERROR_FORMAT.format(value)
        }
    }

    private fun Int.canDivideThousand() = (this % DIVIDE_UNIT == ZERO)

    companion object {
        private const val DIVIDE_THOUSAND_ERROR_FORMAT = "구입 금액 %s 는 1000으로 나눠져야 합니다"
        private const val DIVIDE_UNIT = 1000
        private const val ZERO = 0
    }
}