package lotto.domain.model

class Purchase(val amount: Int) {

    init {
        require(amount > ZERO) {
            PURCHASE_RANGE_ERROR
        }
        require(amount % MIN_AMOUNT_UNIT == ZERO) {
            PURCHASE_UNIT_ERROR
        }
    }

    fun getLottoCount(): Int = amount / MIN_AMOUNT_UNIT

    companion object {
        private const val MIN_AMOUNT_UNIT = 1000
        private const val ZERO = 0
        private const val PURCHASE_UNIT_ERROR = "[ERROR] 구입 금액은 ${MIN_AMOUNT_UNIT}원 단위로 입력해야 합니다."
        private const val PURCHASE_RANGE_ERROR = "[ERROR] 구입 금액은 ${ZERO}보다 커야합니다."
    }
}
