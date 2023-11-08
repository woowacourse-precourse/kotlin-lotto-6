package lotto

class Amount(private val amount: String) {

    init {
        require(isNumber()) { "$ERROR $INPUT_ONLY_NUMBER" }
        require(isBelowZero()) { "$ERROR $INPUT_ONLY_MORE_THAN_ZERO" }
        require(isDivideThousandUnit()) { "$ERROR $INPUT_ONLY_UNIT_OF_THOUSAND" }
    }

    private fun isNumber(): Boolean {
        return amount.all { it.isDigit() }
    }

    private fun isBelowZero(): Boolean {
        val value = amount.toIntOrNull()
        return value != null && value > 0
    }

    private fun isDivideThousandUnit(): Boolean {
        val value = amount.toInt() % PRICE_LOTTO
        return value == 0
    }

    companion object {
        const val ERROR = "[ERROR]"
        const val INPUT_ONLY_NUMBER = "숫자만 입력하세요."
        const val INPUT_ONLY_MORE_THAN_ZERO = "구입 금액으로 0 이하의 숫자는 입력할 수 없습니다."
        const val INPUT_ONLY_UNIT_OF_THOUSAND = "구입 금액은 1000원 단위로 나누어 떨어지는 수여야 합니다."
        const val PRICE_LOTTO = 1000
    }

}