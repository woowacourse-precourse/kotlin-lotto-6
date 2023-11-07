package lotto

import camp.nextstep.edu.missionutils.Console

private const val LOTTO_UNIT = 1000

class Player {

    fun inputPurchaseAmount(): Int {
        val amount = Console.readLine().toInt()
        validatePurchaseAmount(amount)
        return amount
    }

    fun calculateLottoGenerateCount(amount: Int): Int {
        return amount / LOTTO_UNIT
    }

    private fun validatePurchaseAmount(amount: Int) {
        require(amount % LOTTO_UNIT == 0) { throw IllegalArgumentException(PURCHASE_AMOUNT_UNIT_ERROR) }
    }

    companion object {
        const val PURCHASE_AMOUNT_UNIT_ERROR = "[ERROR] 1,000원 단위로 입력해야 합니다."
    }

}