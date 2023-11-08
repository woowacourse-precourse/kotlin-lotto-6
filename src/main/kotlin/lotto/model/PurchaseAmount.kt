package lotto.model

class PurchaseAmount(val amount: Int) {

    val lottoCnt: Int = amount / 1_000

    init {
        checkRange()
        checkUnit()
    }

    private fun checkRange() {
        require(amount in MIN_AMOUNT..MAX_AMOUNT) {throw IllegalArgumentException(OVER_MAX)}
    }

    private fun checkUnit() {
        require(amount % MIN_AMOUNT == 0) {throw IllegalArgumentException(WRONG_UNIT)}
    }

    companion object {
        private const val MIN_AMOUNT = 1_000
        private const val MAX_AMOUNT = 100_000

        private const val OVER_MAX = "구입 금액은 ${MIN_AMOUNT}원 ~ ${MAX_AMOUNT}원 사이입니다."
        private const val WRONG_UNIT = "구입 금액은 ${MIN_AMOUNT}원 단위여야 합니다."
    }
}