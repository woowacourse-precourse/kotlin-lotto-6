package lotto.models

import lotto.utils.Extensions.withCommas

class Purchase(private val amount: Int) {

    init {
        require(isValidAmount()) { AMOUNT_UNIT_ERROR_MESSAGE.format(AMOUNT_UNIT.withCommas()) }
    }

    fun getAmount() = amount

    private fun isValidAmount() = amount >= AMOUNT_UNIT && amount % AMOUNT_UNIT == 0

    companion object {
        const val AMOUNT_UNIT = 1000
        const val AMOUNT_UNIT_ERROR_MESSAGE = "구매 금액은 %s원 단위이어야 합니다."
    }
}